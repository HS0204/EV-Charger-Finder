package com.hs.station.domain

import javax.inject.Inject

class GetStationDetailUseCase @Inject constructor(
    private val repository: StationRepository
) {
    operator fun invoke(id: Long) = repository.getStationDetail(id)
}