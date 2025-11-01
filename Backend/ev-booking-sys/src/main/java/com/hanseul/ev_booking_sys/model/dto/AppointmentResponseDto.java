package com.hanseul.ev_booking_sys.model.dto;

import com.hanseul.ev_booking_sys.model.entity.Appointment;

import java.time.LocalDate;

public record AppointmentResponseDto(
        Long id,
        String customerName,
        String chargerType,
        LocalDate appointmentDate
) {
    public static AppointmentResponseDto fromEntity(Appointment entity) {
        return new AppointmentResponseDto(
                entity.getId(),
                entity.getCustomerName(),
                entity.getChargerType(),
                entity.getAppointmentDate()
        );
    }
}
