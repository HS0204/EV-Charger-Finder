package com.hanseul.ev_booking_sys.model.dto;

public record StationResponseDto(
        Long id,
        String name,
        double latitude,
        double longitude,
        boolean available
) {}
