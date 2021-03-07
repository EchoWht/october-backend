package com.blskye.october;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {

        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("com.blskye.october");

        noClasses()
            .that()
                .resideInAnyPackage("com.blskye.october.service..")
            .or()
                .resideInAnyPackage("com.blskye.october.repository..")
            .should().dependOnClassesThat()
                .resideInAnyPackage("..com.blskye.october.web..")
        .because("Services and repositories should not depend on web layer")
        .check(importedClasses);
    }
}
