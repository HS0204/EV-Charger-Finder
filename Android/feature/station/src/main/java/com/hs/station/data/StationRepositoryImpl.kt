package com.hs.station.data

import com.hs.model.Station
import com.hs.network.service.StationApiService
import com.hs.station.domain.StationRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StationRepositoryImpl @Inject constructor(
    private val api: StationApiService
) : StationRepository {
    override fun getStations(): Flow<List<Station>?> = flow {
        val response = api.getStations()
        if (response.isSuccess) {
            emit(response.data)
        } else {
            throw Exception("API Error: ${response.message}")
        }
    }

    override fun getStationDetail(id: Long): Flow<Station?> = flow {
        val response = api.getStation(id)
        if (response.isSuccess) {
            emit(response.data)
        } else {
            throw Exception("API Error: ${response.message}")
        }
    }
}