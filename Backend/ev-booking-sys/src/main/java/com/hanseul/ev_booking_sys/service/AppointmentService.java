package com.hanseul.ev_booking_sys.service;

import com.hanseul.ev_booking_sys.model.dto.AppointmentMapper;
import com.hanseul.ev_booking_sys.model.dto.AppointmentResponseDto;
import com.hanseul.ev_booking_sys.model.entity.Appointment;
import com.hanseul.ev_booking_sys.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AppointmentService {
    private final AppointmentRepository repository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.repository = appointmentRepository;
    }

    // 예약 조회
    public List<AppointmentResponseDto> findAllAppointments(String name, String chargerType, String sortOrder) {
        Specification<Appointment> spec = Specification.unrestricted();

        if (name != null && !name.isEmpty()) {
            spec = spec.and(((root, query, cb) ->
                    cb.equal(root.get("customerName"), name)));
        }

        if (chargerType != null && !chargerType.isEmpty()) {
            spec = spec.and(((root, query, cb) ->
                    cb.equal(root.get("chargerType"), chargerType)));
        }

        Sort sort = sortOrder.equalsIgnoreCase("desc")
                ? Sort.by("appointmentDate").descending()
                : Sort.by("appointmentDate").ascending();

//        List<Appointment> entities = repository.findAll();
        List<Appointment> entities = repository.findAll(spec, sort);
        return entities.stream()
                .map(AppointmentResponseDto::fromEntity)
                .collect(Collectors.toList());
    }

    // 단일 ID로 조회
    public Optional<AppointmentResponseDto> findAppointmentById(Long id) {
        return repository.findById(id)
                .map(AppointmentResponseDto::fromEntity);
    }

    // 예약 생성
    public AppointmentResponseDto createAppointment(AppointmentMapper createDto) {
        Appointment newAppointment = createDto.toEntity();
        Appointment savedEntity = repository.save(newAppointment);
        return AppointmentResponseDto.fromEntity(savedEntity);
    }

    // 예약 삭제
    public void deleteAppointment(Long id) {
        repository.deleteById(id);
    }
}
