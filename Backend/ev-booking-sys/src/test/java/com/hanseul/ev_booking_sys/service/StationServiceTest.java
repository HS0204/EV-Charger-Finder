package com.hanseul.ev_booking_sys.service;

import com.hanseul.ev_booking_sys.model.entity.Station;
import com.hanseul.ev_booking_sys.repository.StationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StationServiceTest {

    @Mock
    private StationRepository repository;

    @InjectMocks
    private StationService service;

    @Test
    @DisplayName("return stations when try to retrieve with station id")
    void getStationById_success() {
        var station = new Station();
        station.setId(1L);
        station.setName("Test Station");

        when(repository.findById(station.getId())).thenReturn(Optional.of(station));

        var result = service.getStationById(station.getId());

        assertThat(result.getName()).isEqualTo("Test Station");
        verify(repository, times(1)).findById(station.getId());
    }

    @Test
    @DisplayName("if try to retrieve station with not exist id, return EntityNotFoundException")
    void getStationById_notFound() {
        when(repository.findById(999L)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> service.getStationById(999L))
                .isInstanceOf(EntityNotFoundException.class)
                .hasMessageContaining("Station with id 999 not found");
    }
}