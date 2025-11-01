package com.hanseul.ev_booking_sys.model.dto;

import com.hanseul.ev_booking_sys.exception.ResponseCode;

import java.time.LocalDateTime;

public record ApiResponse<T>(
        int code,
        String message,
        T data,
        LocalDateTime timeStamp
) {
    public static <T> ApiResponse<T> success(ResponseCode code, T data) {
        return new ApiResponse<>(code.getCode(), code.getMessage(), data, LocalDateTime.now());
    }

    public static <T> ApiResponse<T> error(ResponseCode code, String detail) {
        return new ApiResponse<>(code.getCode(), detail, null, LocalDateTime.now());
    }
}
