package com.hs.station.domain

import javax.inject.Inject

class GetStationsUseCase @Inject constructor(
    private val repository: StationRepository
) {
    operator fun invoke() = repository.getStations()
}