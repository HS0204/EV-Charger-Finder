package com.hanseul.ev_booking_sys.service;

import com.hanseul.ev_booking_sys.model.entity.Station;
import com.hanseul.ev_booking_sys.repository.StationRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StationService {
    private final StationRepository repository;

    // 충전소 id로 조회
    public Station getStationById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Station Not Found with id " + id));
    }

    // 내 위치 기준 충전소 조회
    public List<Station> getStations(double lat, double lon, double radiusKm) {
        return repository.findAll().stream()
                .filter(s -> distanceKm(lat, lon, s.getLatitude(), s.getLongitude()) <= radiusKm)
                .toList();
    }

    private double distanceKm(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371;
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c;
    }
}
