package com.s2w.preassignment.attackmanager.presentation.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
    private final T data;
    private final String message;

    private ApiResponse(T data, String message) {
        this.data = data;
        this.message = message;
    }

    public static <T> ApiResponse of(T data) {
        return new ApiResponse(data, null);
    }

    public static <T> ApiResponse of(T data, String message) {
        return new ApiResponse(data, message);
    }
}
