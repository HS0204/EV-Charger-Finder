package com.hs.station

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.hs.navigation.TopLevelDestination

fun registerStationGraph(): NavGraphBuilder.() -> Unit = {
    composable(route = TopLevelDestination.STATION_LIST.route) { StationListScreen() }
}