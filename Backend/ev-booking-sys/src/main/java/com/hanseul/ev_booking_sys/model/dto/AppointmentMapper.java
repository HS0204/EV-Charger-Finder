package com.hanseul.ev_booking_sys.model.dto;

import com.hanseul.ev_booking_sys.model.entity.Appointment;
import com.hanseul.ev_booking_sys.util.DateUtils;

import java.time.LocalDate;

public record AppointmentMapper(
        String customerName,
        String chargerType,
        String appointmentDate
) {
    public Appointment toEntity() {
        Appointment entity = new Appointment();
        entity.setCustomerName(customerName);
        entity.setChargerType(chargerType);
        LocalDate convertedDate = DateUtils.convertStringToLocalDate(appointmentDate);
        entity.setAppointmentDate(convertedDate);
        return entity;
    }
}
