package com.hanseul.ev_booking_sys.repository;

import com.hanseul.ev_booking_sys.model.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepository extends JpaRepository<Station, Long> { }
