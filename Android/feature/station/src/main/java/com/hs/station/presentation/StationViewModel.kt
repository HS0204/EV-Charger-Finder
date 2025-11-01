package com.hs.station.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hs.model.Station
import com.hs.station.domain.GetStationDetailUseCase
import com.hs.station.domain.GetStationsUseCase
import com.hs.ui.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StationViewModel @Inject constructor(
    private val getStations: GetStationsUseCase,
    private val getStationDetail: GetStationDetailUseCase
) : ViewModel() {
    private val _stationsUiState = MutableStateFlow<UiState<List<Station>?>>(UiState.Loading)
    val stationsUiState = _stationsUiState.asStateFlow()

    private val _stationDetailUiState = MutableStateFlow<UiState<Station?>>(UiState.Loading)
    val stationDetailUiState = _stationDetailUiState.asStateFlow()

    fun loadStations() {
        viewModelScope.launch {
            getStations()
                .map { UiState.Success(it) }
                .onStart { _stationsUiState.value = UiState.Loading }
                .catch { _stationsUiState.value = UiState.Error("Failed to load stations") }
                .collect { _stationsUiState.value = it }
        }
    }

    fun loadStationDetail(id: Long) {
        viewModelScope.launch {
            getStationDetail(id)
                .map { UiState.Success(it) }
                .onStart { _stationDetailUiState.value = UiState.Loading }
                .catch { _stationDetailUiState.value = UiState.Error("Failed to load station detail") }
                .collect { _stationDetailUiState.value = it }
        }
    }

}
