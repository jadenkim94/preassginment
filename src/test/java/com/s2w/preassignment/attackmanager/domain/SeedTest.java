package com.s2w.preassignment.attackmanager.domain;

import com.s2w.preassignment.attackmanager.domain.type.Ipv4;
import com.s2w.preassignment.attackmanager.domain.util.SeedIdCreator;
import com.s2w.preassignment.attackmanager.exception.ApplicationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class SeedTest {
    @Test
    @DisplayName("seed_id 가 15글자가 아니면 에러이다.")
    void wrong_seed_id_length() {
        assertThatThrownBy(() ->
                Seed.builder()
                        .seedId("adf")
                        .name("seed")
                        .build())
                .isInstanceOf(ApplicationException.class);
    }

    @Test
    @DisplayName("seed_id 가 seed_ 로 시작하지 않으면 에러이다.")
    void wrong_seed_id_prefix() {
        assertThatThrownBy(() ->
                Seed.builder()
                        .seedId("wrong_1dnkw12f")
                        .name("seed")
                        .build())
                .isInstanceOf(ApplicationException.class);
    }

    @Test
    @DisplayName("Seed 정상 생성")
    void seed_creator() {
        assertDoesNotThrow(() -> {
            Seed.builder()
                    .seedId(SeedIdCreator.createId())
                    .build();
            });
    }


}