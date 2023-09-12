package com.s2w.preassignment.attackmanager.application;

import com.s2w.preassignment.attackmanager.config.TestConfiguration;
import com.s2w.preassignment.attackmanager.exception.ApplicationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SeedIdValidatorTest {
    @Test
    @DisplayName("존재하지 않는 seed_id 를 조회하는 경우 에러이다.")
    void notFoundSeedId() {
        AnnotationConfigApplicationContext testApplicationContext = new AnnotationConfigApplicationContext(TestConfiguration.class);
        SeedIdValidator seedIdValidator = new SeedIdValidator();
        seedIdValidator.setApplicationContext(testApplicationContext);

        assertThatThrownBy(() ->
                SeedIdValidator.validateExistSeed("seed_id"))
                .isInstanceOf(ApplicationException.class);
    }
}