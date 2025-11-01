package com.hanseul.ev_booking_sys.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long stationId;
    @NotNull
    private Long userId;

    private String customerName;
    private String chargerType;

    private LocalDate appointmentDate;

    @Enumerated(EnumType.STRING)
    private BookingStatus status = BookingStatus.PENDING;
}
