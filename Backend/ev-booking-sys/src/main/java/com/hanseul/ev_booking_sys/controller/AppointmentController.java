package com.hanseul.ev_booking_sys.controller;

import com.hanseul.ev_booking_sys.model.dto.AppointmentMapper;
import com.hanseul.ev_booking_sys.model.dto.AppointmentResponseDto;
import com.hanseul.ev_booking_sys.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
public class AppointmentController {
    private final AppointmentService service;

    // 모든 예약 조회
    @GetMapping
    public ResponseEntity<List<AppointmentResponseDto>> getAppointments(
            @RequestParam(required = false) String customerName,
            @RequestParam(required = false) String chargerType,
            @RequestParam(required = false, defaultValue = "asc") String sortOrder
    ) {
        List<AppointmentResponseDto> data = service.findAllAppointments(customerName, chargerType, sortOrder);
        return ResponseEntity.ok(data);
    }

    // id로 예약 조회
    @GetMapping("/{id}")
    public ResponseEntity<AppointmentResponseDto> getAppointmentById(@PathVariable Long id) {
        Optional<AppointmentResponseDto> dtoOptional = service.findAppointmentById(id);
        return dtoOptional
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 예약 생성
    @PostMapping
    public ResponseEntity<AppointmentResponseDto> createAppointment(
            @RequestBody AppointmentMapper appointment
    ) {
        AppointmentResponseDto response = service.createAppointment(appointment);
        return ResponseEntity.status(200).body(response);
    }

    // 특정 예약 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id) {
        service.deleteAppointment(id);
        return ResponseEntity.noContent().build();
    }
}
