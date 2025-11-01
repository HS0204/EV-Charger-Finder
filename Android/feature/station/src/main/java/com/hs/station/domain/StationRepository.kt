package com.hs.station.domain

import com.hs.model.Station
import kotlinx.coroutines.flow.Flow

interface StationRepository {
    fun getStations(): Flow<List<Station>?>
    fun getStationDetail(id: Long): Flow<Station?>
}