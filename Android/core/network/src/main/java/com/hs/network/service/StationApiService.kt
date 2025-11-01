package com.hs.network.service

import com.hs.model.ApiResponse
import com.hs.model.Station
import retrofit2.http.GET
import retrofit2.http.Path

interface StationApiService {
    @GET("stations")
    suspend fun getStations(): ApiResponse<List<Station>?>

    @GET("stations/{id}")
    suspend fun getStation(
        @Path("id") id: Long
    ): ApiResponse<Station?>
}