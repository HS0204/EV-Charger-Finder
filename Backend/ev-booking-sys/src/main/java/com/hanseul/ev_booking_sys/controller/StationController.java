package com.hanseul.ev_booking_sys.controller;

import com.hanseul.ev_booking_sys.exception.ResponseCode;
import com.hanseul.ev_booking_sys.model.dto.ApiResponse;
import com.hanseul.ev_booking_sys.model.dto.StationMapper;
import com.hanseul.ev_booking_sys.model.dto.StationResponseDto;
import com.hanseul.ev_booking_sys.service.StationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/api/stations")
@RequiredArgsConstructor
public class StationController {
    private final StationService service;
    private final StationService stationService;

    // GET /api/stations/near?lat=37.5665&lon=126.9780&radius=10
    @GetMapping("/near")
    public ResponseEntity<ApiResponse<List<StationResponseDto>>> getStations(
            @RequestParam double lat,
            @RequestParam double lon,
            @RequestParam(required = false, defaultValue = "10") double radiusKm
    ) {
        var stations = service.getStations(lat, lon, radiusKm).stream()
                .map(StationMapper::toDto)
                .toList();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.success(ResponseCode.SUCCESS, stations));
    }

    // GET /api/stations/1
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<StationResponseDto>> getStationById(@PathVariable Long id) {
        var station = StationMapper.toDto(stationService.getStationById(id));
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.success(ResponseCode.SUCCESS, station));
    }
}
