/*
 * Copyright 2010-2019 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license 
 * that can be found in the license/LICENSE.txt file.
 */
package org.jetbrains.kotlin.fir.visitors

import org.jetbrains.kotlin.fir.*
import org.jetbrains.kotlin.fir.declarations.*
import org.jetbrains.kotlin.fir.declarations.impl.*
import org.jetbrains.kotlin.fir.expressions.*
import org.jetbrains.kotlin.fir.expressions.impl.*
import org.jetbrains.kotlin.fir.types.*


/** This file generated by :compiler:fir:tree:generateVisitors. DO NOT MODIFY MANUALLY! */
abstract class FirVisitorVoid : FirVisitor<Unit, Nothing?>() {
    abstract fun visitElement(element: FirElement)

    open fun visitCatch(catch: FirCatch) {
        visitElement(catch, null)
    }

    open fun visitDeclaration(declaration: FirDeclaration) {
        visitElement(declaration, null)
    }

    open fun visitCallableMember(callableMember: FirCallableMember) {
        visitDeclaration(callableMember, null)
    }

    open fun visitDeclarationWithBody(declarationWithBody: FirDeclarationWithBody) {
        visitDeclaration(declarationWithBody, null)
    }

    open fun visitAnonymousInitializer(anonymousInitializer: FirAnonymousInitializer) {
        visitDeclarationWithBody(anonymousInitializer, null)
    }

    open fun visitFunction(function: FirFunction) {
        visitDeclarationWithBody(function, null)
    }

    open fun visitAnonymousFunction(anonymousFunction: FirAnonymousFunction) {
        visitFunction(anonymousFunction, null)
    }

    open fun visitConstructor(constructor: FirConstructor) {
        visitFunction(constructor, null)
    }

    open fun visitModifiableFunction(modifiableFunction: FirModifiableFunction) {
        visitFunction(modifiableFunction, null)
    }

    open fun visitNamedFunction(namedFunction: FirNamedFunction) {
        visitFunction(namedFunction, null)
    }

    open fun visitPropertyAccessor(propertyAccessor: FirPropertyAccessor) {
        visitFunction(propertyAccessor, null)
    }

    open fun visitErrorDeclaration(errorDeclaration: FirErrorDeclaration) {
        visitDeclaration(errorDeclaration, null)
    }

    open fun visitNamedDeclaration(namedDeclaration: FirNamedDeclaration) {
        visitDeclaration(namedDeclaration, null)
    }

    open fun visitMemberDeclaration(memberDeclaration: FirMemberDeclaration) {
        visitNamedDeclaration(memberDeclaration, null)
    }

    open fun visitRegularClass(regularClass: FirRegularClass) {
        visitMemberDeclaration(regularClass, null)
    }

    open fun visitEnumEntry(enumEntry: FirEnumEntry) {
        visitRegularClass(enumEntry, null)
    }

    open fun visitTypeAlias(typeAlias: FirTypeAlias) {
        visitMemberDeclaration(typeAlias, null)
    }

    open fun visitTypeParameter(typeParameter: FirTypeParameter) {
        visitNamedDeclaration(typeParameter, null)
    }

    open fun visitProperty(property: FirProperty) {
        visitDeclaration(property, null)
    }

    open fun visitTypedDeclaration(typedDeclaration: FirTypedDeclaration) {
        visitDeclaration(typedDeclaration, null)
    }

    open fun visitValueParameter(valueParameter: FirValueParameter) {
        visitDeclaration(valueParameter, null)
    }

    open fun visitVariable(variable: FirVariable) {
        visitDeclaration(variable, null)
    }

    open fun visitDeclarationStatus(declarationStatus: FirDeclarationStatus) {
        visitElement(declarationStatus, null)
    }

    open fun visitResolvedDeclarationStatus(resolvedDeclarationStatus: FirResolvedDeclarationStatus) {
        visitDeclarationStatus(resolvedDeclarationStatus, null)
    }

    open fun visitImport(import: FirImport) {
        visitElement(import, null)
    }

    open fun visitResolvedImport(resolvedImport: FirResolvedImport) {
        visitImport(resolvedImport, null)
    }

    open fun visitLabel(label: FirLabel) {
        visitElement(label, null)
    }

    open fun visitPackageFragment(packageFragment: FirPackageFragment) {
        visitElement(packageFragment, null)
    }

    open fun visitFile(file: FirFile) {
        visitPackageFragment(file, null)
    }

    open fun visitReference(reference: FirReference) {
        visitElement(reference, null)
    }

    open fun visitMemberReference(memberReference: FirMemberReference) {
        visitReference(memberReference, null)
    }

    open fun visitThisReference(thisReference: FirThisReference) {
        visitReference(thisReference, null)
    }

    open fun visitStatement(statement: FirStatement) {
        visitElement(statement, null)
    }

    open fun visitClass(klass: FirClass) {
        visitStatement(klass, null)
    }

    open fun visitAnonymousObject(anonymousObject: FirAnonymousObject) {
        visitClass(anonymousObject, null)
    }

    open fun visitModifiableClass(modifiableClass: FirModifiableClass) {
        visitClass(modifiableClass, null)
    }

    open fun visitExpression(expression: FirExpression) {
        visitStatement(expression, null)
    }

    open fun visitBlock(block: FirBlock) {
        visitExpression(block, null)
    }

    open fun visitCall(call: FirCall) {
        visitExpression(call, null)
    }

    open fun visitAnnotationCall(annotationCall: FirAnnotationCall) {
        visitCall(annotationCall, null)
    }

    open fun visitArrayGetCall(arrayGetCall: FirArrayGetCall) {
        visitCall(arrayGetCall, null)
    }

    open fun visitArraySet(arraySet: FirArraySet) {
        visitCall(arraySet, null)
    }

    open fun visitComponentCall(componentCall: FirComponentCall) {
        visitCall(componentCall, null)
    }

    open fun visitDelegatedConstructorCall(delegatedConstructorCall: FirDelegatedConstructorCall) {
        visitCall(delegatedConstructorCall, null)
    }

    open fun visitFunctionCall(functionCall: FirFunctionCall) {
        visitCall(functionCall, null)
    }

    open fun visitOperatorCall(operatorCall: FirOperatorCall) {
        visitCall(operatorCall, null)
    }

    open fun visitTypeOperatorCall(typeOperatorCall: FirTypeOperatorCall) {
        visitOperatorCall(typeOperatorCall, null)
    }

    open fun <T> visitConstExpression(constExpression: FirConstExpression<T>) {
        visitExpression(constExpression, null)
    }

    open fun visitErrorExpression(errorExpression: FirErrorExpression) {
        visitExpression(errorExpression, null)
    }

    open fun <E : FirTargetElement> visitJump(jump: FirJump<E>) {
        visitExpression(jump, null)
    }

    open fun visitBreakStatement(breakStatement: FirBreakStatement) {
        visitJump(breakStatement, null)
    }

    open fun visitContinueStatement(continueStatement: FirContinueStatement) {
        visitJump(continueStatement, null)
    }

    open fun visitReturnStatement(returnStatement: FirReturnStatement) {
        visitJump(returnStatement, null)
    }

    open fun visitMemberAccess(memberAccess: FirMemberAccess) {
        visitExpression(memberAccess, null)
    }

    open fun visitModifiableMemberAccess(modifiableMemberAccess: FirModifiableMemberAccess) {
        visitMemberAccess(modifiableMemberAccess, null)
    }

    open fun visitPropertyGet(propertyGet: FirPropertyGet) {
        visitMemberAccess(propertyGet, null)
    }

    open fun visitSet(set: FirSet) {
        visitMemberAccess(set, null)
    }

    open fun visitPropertySet(propertySet: FirPropertySet) {
        visitSet(propertySet, null)
    }

    open fun visitThrowExpression(throwExpression: FirThrowExpression) {
        visitExpression(throwExpression, null)
    }

    open fun visitTryExpression(tryExpression: FirTryExpression) {
        visitExpression(tryExpression, null)
    }

    open fun visitWhenExpression(whenExpression: FirWhenExpression) {
        visitExpression(whenExpression, null)
    }

    open fun visitLoop(loop: FirLoop) {
        visitStatement(loop, null)
    }

    open fun visitDoWhileLoop(doWhileLoop: FirDoWhileLoop) {
        visitLoop(doWhileLoop, null)
    }

    open fun visitWhileLoop(whileLoop: FirWhileLoop) {
        visitLoop(whileLoop, null)
    }

    open fun visitTargetElement(targetElement: FirTargetElement) {
        visitElement(targetElement, null)
    }

    open fun visitLabeledElement(labeledElement: FirLabeledElement) {
        visitTargetElement(labeledElement, null)
    }

    open fun visitType(type: FirType) {
        visitElement(type, null)
    }

    open fun visitDelegatedType(delegatedType: FirDelegatedType) {
        visitType(delegatedType, null)
    }

    open fun visitErrorType(errorType: FirErrorType) {
        visitType(errorType, null)
    }

    open fun visitImplicitType(implicitType: FirImplicitType) {
        visitType(implicitType, null)
    }

    open fun visitTypeWithNullability(typeWithNullability: FirTypeWithNullability) {
        visitType(typeWithNullability, null)
    }

    open fun visitDynamicType(dynamicType: FirDynamicType) {
        visitTypeWithNullability(dynamicType, null)
    }

    open fun visitFunctionType(functionType: FirFunctionType) {
        visitTypeWithNullability(functionType, null)
    }

    open fun visitResolvedType(resolvedType: FirResolvedType) {
        visitTypeWithNullability(resolvedType, null)
    }

    open fun visitResolvedFunctionType(resolvedFunctionType: FirResolvedFunctionType) {
        visitResolvedType(resolvedFunctionType, null)
    }

    open fun visitUserType(userType: FirUserType) {
        visitTypeWithNullability(userType, null)
    }

    open fun visitTypeProjection(typeProjection: FirTypeProjection) {
        visitElement(typeProjection, null)
    }

    open fun visitStarProjection(starProjection: FirStarProjection) {
        visitTypeProjection(starProjection, null)
    }

    open fun visitTypeProjectionWithVariance(typeProjectionWithVariance: FirTypeProjectionWithVariance) {
        visitTypeProjection(typeProjectionWithVariance, null)
    }

    open fun visitWhenBranch(whenBranch: FirWhenBranch) {
        visitElement(whenBranch, null)
    }

    final override fun visitAnnotationCall(annotationCall: FirAnnotationCall, data: Nothing?) {
        visitAnnotationCall(annotationCall)
    }

    final override fun visitAnonymousFunction(anonymousFunction: FirAnonymousFunction, data: Nothing?) {
        visitAnonymousFunction(anonymousFunction)
    }

    final override fun visitAnonymousInitializer(anonymousInitializer: FirAnonymousInitializer, data: Nothing?) {
        visitAnonymousInitializer(anonymousInitializer)
    }

    final override fun visitAnonymousObject(anonymousObject: FirAnonymousObject, data: Nothing?) {
        visitAnonymousObject(anonymousObject)
    }

    final override fun visitArrayGetCall(arrayGetCall: FirArrayGetCall, data: Nothing?) {
        visitArrayGetCall(arrayGetCall)
    }

    final override fun visitArraySet(arraySet: FirArraySet, data: Nothing?) {
        visitArraySet(arraySet)
    }

    final override fun visitBlock(block: FirBlock, data: Nothing?) {
        visitBlock(block)
    }

    final override fun visitBreakStatement(breakStatement: FirBreakStatement, data: Nothing?) {
        visitBreakStatement(breakStatement)
    }

    final override fun visitCall(call: FirCall, data: Nothing?) {
        visitCall(call)
    }

    final override fun visitCallableMember(callableMember: FirCallableMember, data: Nothing?) {
        visitCallableMember(callableMember)
    }

    final override fun visitCatch(catch: FirCatch, data: Nothing?) {
        visitCatch(catch)
    }

    final override fun visitClass(klass: FirClass, data: Nothing?) {
        visitClass(klass)
    }

    final override fun visitComponentCall(componentCall: FirComponentCall, data: Nothing?) {
        visitComponentCall(componentCall)
    }

    final override fun <T> visitConstExpression(constExpression: FirConstExpression<T>, data: Nothing?) {
        visitConstExpression(constExpression)
    }

    final override fun visitConstructor(constructor: FirConstructor, data: Nothing?) {
        visitConstructor(constructor)
    }

    final override fun visitContinueStatement(continueStatement: FirContinueStatement, data: Nothing?) {
        visitContinueStatement(continueStatement)
    }

    final override fun visitDeclaration(declaration: FirDeclaration, data: Nothing?) {
        visitDeclaration(declaration)
    }

    final override fun visitDeclarationStatus(declarationStatus: FirDeclarationStatus, data: Nothing?) {
        visitDeclarationStatus(declarationStatus)
    }

    final override fun visitDeclarationWithBody(declarationWithBody: FirDeclarationWithBody, data: Nothing?) {
        visitDeclarationWithBody(declarationWithBody)
    }

    final override fun visitDelegatedConstructorCall(delegatedConstructorCall: FirDelegatedConstructorCall, data: Nothing?) {
        visitDelegatedConstructorCall(delegatedConstructorCall)
    }

    final override fun visitDelegatedType(delegatedType: FirDelegatedType, data: Nothing?) {
        visitDelegatedType(delegatedType)
    }

    final override fun visitDoWhileLoop(doWhileLoop: FirDoWhileLoop, data: Nothing?) {
        visitDoWhileLoop(doWhileLoop)
    }

    final override fun visitDynamicType(dynamicType: FirDynamicType, data: Nothing?) {
        visitDynamicType(dynamicType)
    }

    final override fun visitEnumEntry(enumEntry: FirEnumEntry, data: Nothing?) {
        visitEnumEntry(enumEntry)
    }

    final override fun visitErrorDeclaration(errorDeclaration: FirErrorDeclaration, data: Nothing?) {
        visitErrorDeclaration(errorDeclaration)
    }

    final override fun visitErrorExpression(errorExpression: FirErrorExpression, data: Nothing?) {
        visitErrorExpression(errorExpression)
    }

    final override fun visitErrorType(errorType: FirErrorType, data: Nothing?) {
        visitErrorType(errorType)
    }

    final override fun visitExpression(expression: FirExpression, data: Nothing?) {
        visitExpression(expression)
    }

    final override fun visitFile(file: FirFile, data: Nothing?) {
        visitFile(file)
    }

    final override fun visitFunction(function: FirFunction, data: Nothing?) {
        visitFunction(function)
    }

    final override fun visitFunctionCall(functionCall: FirFunctionCall, data: Nothing?) {
        visitFunctionCall(functionCall)
    }

    final override fun visitFunctionType(functionType: FirFunctionType, data: Nothing?) {
        visitFunctionType(functionType)
    }

    final override fun visitImplicitType(implicitType: FirImplicitType, data: Nothing?) {
        visitImplicitType(implicitType)
    }

    final override fun visitImport(import: FirImport, data: Nothing?) {
        visitImport(import)
    }

    final override fun <E : FirTargetElement> visitJump(jump: FirJump<E>, data: Nothing?) {
        visitJump(jump)
    }

    final override fun visitLabel(label: FirLabel, data: Nothing?) {
        visitLabel(label)
    }

    final override fun visitLabeledElement(labeledElement: FirLabeledElement, data: Nothing?) {
        visitLabeledElement(labeledElement)
    }

    final override fun visitLoop(loop: FirLoop, data: Nothing?) {
        visitLoop(loop)
    }

    final override fun visitMemberAccess(memberAccess: FirMemberAccess, data: Nothing?) {
        visitMemberAccess(memberAccess)
    }

    final override fun visitMemberDeclaration(memberDeclaration: FirMemberDeclaration, data: Nothing?) {
        visitMemberDeclaration(memberDeclaration)
    }

    final override fun visitMemberReference(memberReference: FirMemberReference, data: Nothing?) {
        visitMemberReference(memberReference)
    }

    final override fun visitModifiableClass(modifiableClass: FirModifiableClass, data: Nothing?) {
        visitModifiableClass(modifiableClass)
    }

    final override fun visitModifiableFunction(modifiableFunction: FirModifiableFunction, data: Nothing?) {
        visitModifiableFunction(modifiableFunction)
    }

    final override fun visitModifiableMemberAccess(modifiableMemberAccess: FirModifiableMemberAccess, data: Nothing?) {
        visitModifiableMemberAccess(modifiableMemberAccess)
    }

    final override fun visitNamedDeclaration(namedDeclaration: FirNamedDeclaration, data: Nothing?) {
        visitNamedDeclaration(namedDeclaration)
    }

    final override fun visitNamedFunction(namedFunction: FirNamedFunction, data: Nothing?) {
        visitNamedFunction(namedFunction)
    }

    final override fun visitOperatorCall(operatorCall: FirOperatorCall, data: Nothing?) {
        visitOperatorCall(operatorCall)
    }

    final override fun visitPackageFragment(packageFragment: FirPackageFragment, data: Nothing?) {
        visitPackageFragment(packageFragment)
    }

    final override fun visitProperty(property: FirProperty, data: Nothing?) {
        visitProperty(property)
    }

    final override fun visitPropertyAccessor(propertyAccessor: FirPropertyAccessor, data: Nothing?) {
        visitPropertyAccessor(propertyAccessor)
    }

    final override fun visitPropertyGet(propertyGet: FirPropertyGet, data: Nothing?) {
        visitPropertyGet(propertyGet)
    }

    final override fun visitPropertySet(propertySet: FirPropertySet, data: Nothing?) {
        visitPropertySet(propertySet)
    }

    final override fun visitReference(reference: FirReference, data: Nothing?) {
        visitReference(reference)
    }

    final override fun visitRegularClass(regularClass: FirRegularClass, data: Nothing?) {
        visitRegularClass(regularClass)
    }

    final override fun visitResolvedDeclarationStatus(resolvedDeclarationStatus: FirResolvedDeclarationStatus, data: Nothing?) {
        visitResolvedDeclarationStatus(resolvedDeclarationStatus)
    }

    final override fun visitResolvedFunctionType(resolvedFunctionType: FirResolvedFunctionType, data: Nothing?) {
        visitResolvedFunctionType(resolvedFunctionType)
    }

    final override fun visitResolvedImport(resolvedImport: FirResolvedImport, data: Nothing?) {
        visitResolvedImport(resolvedImport)
    }

    final override fun visitResolvedType(resolvedType: FirResolvedType, data: Nothing?) {
        visitResolvedType(resolvedType)
    }

    final override fun visitReturnStatement(returnStatement: FirReturnStatement, data: Nothing?) {
        visitReturnStatement(returnStatement)
    }

    final override fun visitSet(set: FirSet, data: Nothing?) {
        visitSet(set)
    }

    final override fun visitStarProjection(starProjection: FirStarProjection, data: Nothing?) {
        visitStarProjection(starProjection)
    }

    final override fun visitStatement(statement: FirStatement, data: Nothing?) {
        visitStatement(statement)
    }

    final override fun visitTargetElement(targetElement: FirTargetElement, data: Nothing?) {
        visitTargetElement(targetElement)
    }

    final override fun visitThisReference(thisReference: FirThisReference, data: Nothing?) {
        visitThisReference(thisReference)
    }

    final override fun visitThrowExpression(throwExpression: FirThrowExpression, data: Nothing?) {
        visitThrowExpression(throwExpression)
    }

    final override fun visitTryExpression(tryExpression: FirTryExpression, data: Nothing?) {
        visitTryExpression(tryExpression)
    }

    final override fun visitType(type: FirType, data: Nothing?) {
        visitType(type)
    }

    final override fun visitTypeAlias(typeAlias: FirTypeAlias, data: Nothing?) {
        visitTypeAlias(typeAlias)
    }

    final override fun visitTypeOperatorCall(typeOperatorCall: FirTypeOperatorCall, data: Nothing?) {
        visitTypeOperatorCall(typeOperatorCall)
    }

    final override fun visitTypeParameter(typeParameter: FirTypeParameter, data: Nothing?) {
        visitTypeParameter(typeParameter)
    }

    final override fun visitTypeProjection(typeProjection: FirTypeProjection, data: Nothing?) {
        visitTypeProjection(typeProjection)
    }

    final override fun visitTypeProjectionWithVariance(typeProjectionWithVariance: FirTypeProjectionWithVariance, data: Nothing?) {
        visitTypeProjectionWithVariance(typeProjectionWithVariance)
    }

    final override fun visitTypeWithNullability(typeWithNullability: FirTypeWithNullability, data: Nothing?) {
        visitTypeWithNullability(typeWithNullability)
    }

    final override fun visitTypedDeclaration(typedDeclaration: FirTypedDeclaration, data: Nothing?) {
        visitTypedDeclaration(typedDeclaration)
    }

    final override fun visitUserType(userType: FirUserType, data: Nothing?) {
        visitUserType(userType)
    }

    final override fun visitValueParameter(valueParameter: FirValueParameter, data: Nothing?) {
        visitValueParameter(valueParameter)
    }

    final override fun visitVariable(variable: FirVariable, data: Nothing?) {
        visitVariable(variable)
    }

    final override fun visitWhenBranch(whenBranch: FirWhenBranch, data: Nothing?) {
        visitWhenBranch(whenBranch)
    }

    final override fun visitWhenExpression(whenExpression: FirWhenExpression, data: Nothing?) {
        visitWhenExpression(whenExpression)
    }

    final override fun visitWhileLoop(whileLoop: FirWhileLoop, data: Nothing?) {
        visitWhileLoop(whileLoop)
    }

    final override fun visitElement(element: FirElement, data: Nothing?) {
        visitElement(element)
    }

}
