/*
 * Copyright 2010-2019 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.fir.builder

import com.intellij.psi.PsiElement
import com.intellij.psi.tree.IElementType
import org.jetbrains.kotlin.KtNodeTypes
import org.jetbrains.kotlin.fir.FirReference
import org.jetbrains.kotlin.fir.FirSession
import org.jetbrains.kotlin.fir.declarations.FirNamedDeclaration
import org.jetbrains.kotlin.fir.declarations.impl.FirVariableImpl
import org.jetbrains.kotlin.fir.expressions.*
import org.jetbrains.kotlin.fir.expressions.impl.*
import org.jetbrains.kotlin.fir.references.FirErrorMemberReference
import org.jetbrains.kotlin.fir.references.FirSimpleMemberReference
import org.jetbrains.kotlin.fir.types.FirType
import org.jetbrains.kotlin.fir.types.impl.FirImplicitTypeImpl
import org.jetbrains.kotlin.ir.expressions.IrConstKind
import org.jetbrains.kotlin.lexer.KtTokens
import org.jetbrains.kotlin.name.Name
import org.jetbrains.kotlin.psi.*
import org.jetbrains.kotlin.types.expressions.OperatorConventions

internal fun String.parseCharacter(): Char? {
    // Strip the quotes
    if (length < 2 || this[0] != '\'' || this[length - 1] != '\'') {
        return null
    }
    val text = substring(1, length - 1) // now there're no quotes

    if (text.isEmpty()) {
        return null
    }

    return if (text[0] != '\\') {
        // No escape
        if (text.length == 1) {
            text[0]
        } else {
            null
        }
    } else {
        escapedStringToCharacter(text)
    }
}

internal fun escapedStringToCharacter(text: String): Char? {
    assert(text.isNotEmpty() && text[0] == '\\') {
        "Only escaped sequences must be passed to this routine: $text"
    }

    // Escape
    val escape = text.substring(1) // strip the slash
    when (escape.length) {
        0 -> {
            // bare slash
            return null
        }
        1 -> {
            // one-char escape
            return translateEscape(escape[0]) ?: return null
        }
        5 -> {
            // unicode escape
            if (escape[0] == 'u') {
                try {
                    val intValue = Integer.valueOf(escape.substring(1), 16)
                    return intValue.toInt().toChar()
                } catch (e: NumberFormatException) {
                    // Will be reported below
                }
            }
        }
    }
    return null
}

internal fun translateEscape(c: Char): Char? =
    when (c) {
        't' -> '\t'
        'b' -> '\b'
        'n' -> '\n'
        'r' -> '\r'
        '\'' -> '\''
        '\"' -> '\"'
        '\\' -> '\\'
        '$' -> '$'
        else -> null
    }

internal fun generateConstantExpressionByLiteral(session: FirSession, expression: KtConstantExpression): FirExpression {
    val type = expression.node.elementType
    val text: String = expression.text
    return when (type) {
        KtNodeTypes.INTEGER_CONSTANT ->
            if (text.last() == 'l' || text.last() == 'L') {
                FirConstExpressionImpl(
                    session, expression, IrConstKind.Long, text.dropLast(1).toLongOrNull(), "Incorrect long: $text"
                )
            } else {
                // TODO: support byte / short
                FirConstExpressionImpl(session, expression, IrConstKind.Int, text.toIntOrNull(), "Incorrect int: $text")
            }
        KtNodeTypes.FLOAT_CONSTANT ->
            if (text.last() == 'f' || text.last() == 'F') {
                FirConstExpressionImpl(
                    session, expression, IrConstKind.Float, text.dropLast(1).toFloatOrNull(), "Incorrect float: $text"
                )
            } else {
                FirConstExpressionImpl(
                    session, expression, IrConstKind.Double, text.toDoubleOrNull(), "Incorrect double: $text"
                )
            }
        KtNodeTypes.CHARACTER_CONSTANT ->
            FirConstExpressionImpl(
                session, expression, IrConstKind.Char, text.parseCharacter(), "Incorrect character: $text"
            )
        KtNodeTypes.BOOLEAN_CONSTANT ->
            FirConstExpressionImpl(session, expression, IrConstKind.Boolean, text.toBoolean())
        KtNodeTypes.NULL ->
            FirConstExpressionImpl(session, expression, IrConstKind.Null, null)
        else ->
            throw AssertionError("Unknown literal type: $type, $text")
    }

}

internal fun IElementType.toBinaryName(): Name? {
    return OperatorConventions.BINARY_OPERATION_NAMES[this]
}

internal fun IElementType.toUnaryName(): Name? {
    return OperatorConventions.UNARY_OPERATION_NAMES[this]
}

internal fun IElementType.toFirOperation(): FirOperation =
    when (this) {
        KtTokens.LT -> FirOperation.LT
        KtTokens.GT -> FirOperation.GT
        KtTokens.LTEQ -> FirOperation.LT_EQ
        KtTokens.GTEQ -> FirOperation.GT_EQ
        KtTokens.EQEQ -> FirOperation.EQ
        KtTokens.EXCLEQ -> FirOperation.NOT_EQ
        KtTokens.EQEQEQ -> FirOperation.IDENTITY
        KtTokens.EXCLEQEQEQ -> FirOperation.NOT_IDENTITY
        KtTokens.ANDAND -> FirOperation.AND
        KtTokens.OROR -> FirOperation.OR
        KtTokens.IN_KEYWORD -> FirOperation.IN
        KtTokens.NOT_IN -> FirOperation.NOT_IN
        KtTokens.RANGE -> FirOperation.RANGE

        KtTokens.EQ -> FirOperation.ASSIGN
        KtTokens.PLUSEQ -> FirOperation.PLUS_ASSIGN
        KtTokens.MINUSEQ -> FirOperation.MINUS_ASSIGN
        KtTokens.MULTEQ -> FirOperation.TIMES_ASSIGN
        KtTokens.DIVEQ -> FirOperation.DIV_ASSIGN
        KtTokens.PERCEQ -> FirOperation.REM_ASSIGN

        KtTokens.AS_KEYWORD -> FirOperation.AS
        KtTokens.AS_SAFE -> FirOperation.SAFE_AS

        else -> throw AssertionError(this.toString())
    }

internal fun FirExpression.generateNotNullOrOther(other: FirExpression, caseId: String): FirWhenExpression {
    val subjectName = Name.special("<$caseId>")
    val subjectVariable = generateTemporaryVariable(session, psi, subjectName, this)
    val subjectExpression = FirWhenSubjectExpression(session, psi)
    return FirWhenExpressionImpl(
        session, psi, this, subjectVariable
    ).apply {
        branches += FirWhenBranchImpl(
            session, psi,
            FirOperatorCallImpl(session, psi, FirOperation.NOT_EQ).apply {
                arguments += subjectExpression
                arguments += FirConstExpressionImpl(session, psi, IrConstKind.Null, null)
            },
            FirSingleExpressionBlock(
                session,
                generatePropertyGet(session, psi, subjectName)
            )
        )
        branches += FirWhenBranchImpl(
            session, other.psi, FirElseIfTrueCondition(session, psi),
            FirSingleExpressionBlock(session, other)
        )
    }
}

internal fun generateIncrementOrDecrementBlock(
    session: FirSession,
    baseExpression: KtUnaryExpression,
    argument: KtSimpleNameExpression?,
    callName: Name,
    prefix: Boolean
): FirExpression {
    if (argument == null) return FirErrorExpressionImpl(session, argument, "Inc/dec without operand")
    return FirBlockImpl(session, baseExpression).apply {
        val tempName = Name.special("<unary>")
        val argumentName = argument.getReferencedNameAsName()
        statements += generateTemporaryVariable(session, baseExpression, tempName, generatePropertyGet(session, argument, argumentName))
        statements += FirPropertySetImpl(
            session, baseExpression,
            FirFunctionCallImpl(session, baseExpression).apply {
                this.calleeReference = FirSimpleMemberReference(session, baseExpression.operationReference, callName)
                this.arguments += generatePropertyGet(session, baseExpression, tempName)
            },
            FirOperation.ASSIGN
        ).apply {
            this.calleeReference = FirSimpleMemberReference(session, argument, argumentName)
        }
        statements += generatePropertyGet(session, baseExpression, if (prefix) argumentName else tempName)
    }
}

internal fun generatePropertyGet(session: FirSession, psi: PsiElement?, name: Name): FirPropertyGet =
    FirPropertyGetImpl(session, psi).apply {
        calleeReference = FirSimpleMemberReference(session, psi, name)
    }

internal fun generateDestructuringBlock(
    session: FirSession,
    multiDeclaration: KtDestructuringDeclaration,
    container: FirNamedDeclaration,
    toFirOrImplicitType: KtTypeReference?.() -> FirType
): FirExpression {
    return FirBlockImpl(session, multiDeclaration).apply {
        if (container is FirVariable) {
            statements += container
        }
        val isVar = multiDeclaration.isVar
        for ((index, entry) in multiDeclaration.entries.withIndex()) {
            statements += FirVariableImpl(
                session, entry, entry.nameAsSafeName,
                entry.typeReference.toFirOrImplicitType(), isVar,
                FirComponentCallImpl(session, entry, index + 1).apply {
                    arguments += generatePropertyGet(session, entry, container.name)
                }
            )
        }
    }
}

internal fun generateTemporaryVariable(
    session: FirSession, psi: PsiElement?, name: Name, initializer: FirExpression
): FirVariable = FirVariableImpl(session, psi, name, FirImplicitTypeImpl(session, psi), false, initializer)

internal fun generateTemporaryVariable(
    session: FirSession, psi: PsiElement?, specialName: String, initializer: FirExpression
): FirVariable = generateTemporaryVariable(session, psi, Name.special("<$specialName>"), initializer)

private fun FirModifiableMemberAccess.initializeLValue(
    session: FirSession,
    left: KtExpression?,
    convertQualified: KtQualifiedExpression.() -> FirMemberAccess?
): FirReference {
    return when (left) {
        is KtSimpleNameExpression -> {
            FirSimpleMemberReference(session, left.getReferencedNameElement(), left.getReferencedNameAsName())
        }
        is KtQualifiedExpression -> {
            val firMemberAccess = left.convertQualified()
            if (firMemberAccess != null) {
                explicitReceiver = firMemberAccess.explicitReceiver
                safe = firMemberAccess.safe
                firMemberAccess.calleeReference
            } else {
                FirErrorMemberReference(session, left, "Unsupported qualified LValue: ${left.text}")
            }
        }
        else -> {
            // TODO: etc.
            FirErrorMemberReference(session, left, "Unsupported LValue: ${left?.javaClass}")
        }
    }
}

internal fun KtExpression?.generateSet(
    session: FirSession,
    psi: PsiElement?,
    value: FirExpression,
    operation: FirOperation,
    convert: KtExpression.() -> FirExpression
): FirExpression {
    if (this is KtArrayAccessExpression) {
        val arrayExpression = this.arrayExpression
        val arraySet = FirArraySetImpl(session, psi, value, operation).apply {
            for (indexExpression in indexExpressions) {
                arguments += indexExpression.convert()
            }
        }
        if (arrayExpression is KtSimpleNameExpression) {
            return arraySet.apply {
                calleeReference = initializeLValue(session, arrayExpression) { convert() as? FirMemberAccess }
            }
        }
        return FirBlockImpl(session, arrayExpression).apply {
            val name = Name.special("<array-set>")
            val firTemp = generateTemporaryVariable(
                session, arrayExpression, name,
                arrayExpression?.convert() ?: FirErrorExpressionImpl(session, arrayExpression, "No array expression")
            )
            statements += firTemp
            statements += arraySet.apply { calleeReference = FirSimpleMemberReference(session, arrayExpression, name) }
        }
    }
    return FirPropertySetImpl(session, psi, value, operation).apply {
        calleeReference = initializeLValue(session, this@generateSet) { convert() as? FirMemberAccess }
    }
}