package com.hanseul.ev_booking_sys.exception;

import org.springframework.http.HttpStatus;

public enum ResponseCode {
    SUCCESS(HttpStatus.OK, 200, "Success"),
    INVALID_PARAMETER(HttpStatus.BAD_REQUEST, 400, "Invalid request parameter"),
    NOT_FOUND(HttpStatus.NOT_FOUND, 404, "Station not found"),
    INTERNAL_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, 500, "Unexpected server error");

    private final HttpStatus status;
    private final int code;
    private final String message;

    ResponseCode(HttpStatus status, int code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
