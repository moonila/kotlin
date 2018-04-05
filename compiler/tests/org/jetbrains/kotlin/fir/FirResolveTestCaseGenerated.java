/*
 * Copyright 2010-2018 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.fir;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.JUnit3RunnerWithInners;
import org.jetbrains.kotlin.test.KotlinTestUtils;
import org.jetbrains.kotlin.test.TargetBackend;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.TestsPackage}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("compiler/testData/fir/resolve")
@TestDataPath("$PROJECT_ROOT")
@RunWith(JUnit3RunnerWithInners.class)
public class FirResolveTestCaseGenerated extends AbstractFirResolveTestCase {
    private void runTest(String testDataFilePath) throws Exception {
        KotlinTestUtils.runTest(this::doTest, TargetBackend.ANY, testDataFilePath);
    }

    public void testAllFilesPresentInResolve() throws Exception {
        KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("compiler/testData/fir/resolve"), Pattern.compile("^([^.]+)\\.kt$"), TargetBackend.ANY, true, "stdlib");
    }

    @TestMetadata("derivedClass.kt")
    public void testDerivedClass() throws Exception {
        runTest("compiler/testData/fir/resolve/derivedClass.kt");
    }

    @TestMetadata("enum.kt")
    public void testEnum() throws Exception {
        runTest("compiler/testData/fir/resolve/enum.kt");
    }

    @TestMetadata("F.kt")
    public void testF() throws Exception {
        runTest("compiler/testData/fir/resolve/F.kt");
    }

    @TestMetadata("ft.kt")
    public void testFt() throws Exception {
        runTest("compiler/testData/fir/resolve/ft.kt");
    }

    @TestMetadata("functionTypes.kt")
    public void testFunctionTypes() throws Exception {
        runTest("compiler/testData/fir/resolve/functionTypes.kt");
    }

    @TestMetadata("genericFunctions.kt")
    public void testGenericFunctions() throws Exception {
        runTest("compiler/testData/fir/resolve/genericFunctions.kt");
    }

    @TestMetadata("nestedClass.kt")
    public void testNestedClass() throws Exception {
        runTest("compiler/testData/fir/resolve/nestedClass.kt");
    }

    @TestMetadata("NestedOfAliasedType.kt")
    public void testNestedOfAliasedType() throws Exception {
        runTest("compiler/testData/fir/resolve/NestedOfAliasedType.kt");
    }

    @TestMetadata("NestedSuperType.kt")
    public void testNestedSuperType() throws Exception {
        runTest("compiler/testData/fir/resolve/NestedSuperType.kt");
    }

    @TestMetadata("simpleClass.kt")
    public void testSimpleClass() throws Exception {
        runTest("compiler/testData/fir/resolve/simpleClass.kt");
    }

    @TestMetadata("simpleTypeAlias.kt")
    public void testSimpleTypeAlias() throws Exception {
        runTest("compiler/testData/fir/resolve/simpleTypeAlias.kt");
    }

    @TestMetadata("treeSet.kt")
    public void testTreeSet() throws Exception {
        runTest("compiler/testData/fir/resolve/treeSet.kt");
    }

    @TestMetadata("TwoDeclarationsInSameFile.kt")
    public void testTwoDeclarationsInSameFile() throws Exception {
        runTest("compiler/testData/fir/resolve/TwoDeclarationsInSameFile.kt");
    }

    @TestMetadata("typeAliasWithGeneric.kt")
    public void testTypeAliasWithGeneric() throws Exception {
        runTest("compiler/testData/fir/resolve/typeAliasWithGeneric.kt");
    }

    @TestMetadata("typeParameterVsNested.kt")
    public void testTypeParameterVsNested() throws Exception {
        runTest("compiler/testData/fir/resolve/typeParameterVsNested.kt");
    }

    @TestMetadata("compiler/testData/fir/resolve/builtins")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class Builtins extends AbstractFirResolveTestCase {
        private void runTest(String testDataFilePath) throws Exception {
            KotlinTestUtils.runTest(this::doTest, TargetBackend.ANY, testDataFilePath);
        }

        public void testAllFilesPresentInBuiltins() throws Exception {
            KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("compiler/testData/fir/resolve/builtins"), Pattern.compile("^([^.]+)\\.kt$"), TargetBackend.ANY, true);
        }

        @TestMetadata("lists.kt")
        public void testLists() throws Exception {
            runTest("compiler/testData/fir/resolve/builtins/lists.kt");
        }
    }

    @TestMetadata("compiler/testData/fir/resolve/multifile")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class Multifile extends AbstractFirResolveTestCase {
        private void runTest(String testDataFilePath) throws Exception {
            KotlinTestUtils.runTest(this::doTest, TargetBackend.ANY, testDataFilePath);
        }

        public void testAllFilesPresentInMultifile() throws Exception {
            KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("compiler/testData/fir/resolve/multifile"), Pattern.compile("^([^.]+)\\.kt$"), TargetBackend.ANY, true);
        }

        @TestMetadata("Annotations.kt")
        public void testAnnotations() throws Exception {
            runTest("compiler/testData/fir/resolve/multifile/Annotations.kt");
        }

        @TestMetadata("NestedSuperType.kt")
        public void testNestedSuperType() throws Exception {
            runTest("compiler/testData/fir/resolve/multifile/NestedSuperType.kt");
        }

        @TestMetadata("sealedStarImport.kt")
        public void testSealedStarImport() throws Exception {
            runTest("compiler/testData/fir/resolve/multifile/sealedStarImport.kt");
        }

        @TestMetadata("simpleAliasedImport.kt")
        public void testSimpleAliasedImport() throws Exception {
            runTest("compiler/testData/fir/resolve/multifile/simpleAliasedImport.kt");
        }

        @TestMetadata("simpleImport.kt")
        public void testSimpleImport() throws Exception {
            runTest("compiler/testData/fir/resolve/multifile/simpleImport.kt");
        }

        @TestMetadata("simpleImportNested.kt")
        public void testSimpleImportNested() throws Exception {
            runTest("compiler/testData/fir/resolve/multifile/simpleImportNested.kt");
        }

        @TestMetadata("simpleImportOuter.kt")
        public void testSimpleImportOuter() throws Exception {
            runTest("compiler/testData/fir/resolve/multifile/simpleImportOuter.kt");
        }

        @TestMetadata("simpleStarImport.kt")
        public void testSimpleStarImport() throws Exception {
            runTest("compiler/testData/fir/resolve/multifile/simpleStarImport.kt");
        }

        @TestMetadata("TypeAliasExpansion.kt")
        public void testTypeAliasExpansion() throws Exception {
            runTest("compiler/testData/fir/resolve/multifile/TypeAliasExpansion.kt");
        }
    }
}
