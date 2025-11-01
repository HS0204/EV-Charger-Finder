package com.hanseul.ev_booking_sys.model.dto;

import com.hanseul.ev_booking_sys.model.entity.Station;

public class StationMapper {
    public static StationResponseDto toDto(Station s) {
        return new StationResponseDto(
                s.getId(),
                s.getName(),
                s.getLatitude(),
                s.getLongitude(),
                s.isAvailable()
        );
    }
}
