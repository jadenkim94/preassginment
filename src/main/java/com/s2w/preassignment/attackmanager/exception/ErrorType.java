package com.s2w.preassignment.attackmanager.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorType {

    NOT_FOUND_SEED_ID(HttpStatus.BAD_REQUEST,  "SEED_ID 가 존재하지 않습니다."),
    INVALID_SEED_ID_LENGTH(HttpStatus.BAD_REQUEST, "잘못된 SEED_ID가 생성 되었습니다. 관리자에게 문의 부탁드립니다."),
    INVALID_SEED_ID_PREFIX(HttpStatus.BAD_REQUEST, "잘못된 SEED_ID가 생성 되었습니다. 관리자에게 문의 부탁드립니다."),
    INVALID_IP_ADDRESS(HttpStatus.BAD_REQUEST,"잘못된 Ipv4 주소입니다.");

    private final HttpStatus httpStatus;
    private final String message;
    ErrorType(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
