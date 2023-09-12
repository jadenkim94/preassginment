package com.s2w.preassignment.attackmanager.domain.type;

import com.s2w.preassignment.attackmanager.exception.ApplicationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class Ipv4Test {

    @Test
    @DisplayName("IPv4 포맷이면 정상 생성")
    void ipv4_format() {
        String ipv4 = new String("255.0.0.1");
        assertDoesNotThrow(() -> {Ipv4.createIpv4(ipv4);});
    }

    @ParameterizedTest
    @ValueSource(strings = {"3333.333.12.23", "256.256.256.256"})
    @DisplayName("IPv4 포맷이 아니면 에러이다")
    void wrong_format(String wrongIp) {
        assertThatThrownBy(() -> Ipv4.createIpv4(wrongIp)).isInstanceOf(ApplicationException.class);
    }

}