package com.s2w.preassignment.attackmanager.domain;

import com.s2w.preassignment.attackmanager.domain.util.SeedIdCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SeedIdCreatorTest {

    @Test
    @DisplayName("seed id 의 prefix 는 seed_ 이다.")
    void seedIdPrefix() {
        String createdId = SeedIdCreator.createId();
        assertThat(createdId).startsWith("seed_");
    }

    @Test
    @DisplayName("seed id 의 총 길이는 15 이다.")
    void seedIdLength() {
        String createdId = SeedIdCreator.createId();
        assertThat(createdId.length()).isEqualTo(15);
    }
}