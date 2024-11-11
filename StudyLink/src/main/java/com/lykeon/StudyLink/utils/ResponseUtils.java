package com.lykeon.StudyLink.utils;

import org.springframework.http.HttpStatus;

import com.lykeon.StudyLink.response.DefaultResponse;

public class ResponseUtils {

    public static <T> DefaultResponse<T> createSuccessResponse(T data, String message) {
        return new DefaultResponse<>(data, "200", message, HttpStatus.OK);
    }

    public static DefaultResponse<Object> createErrorResponse(String code, String message, HttpStatus status) {
        return new DefaultResponse<>(code, message, status);
    }
}
