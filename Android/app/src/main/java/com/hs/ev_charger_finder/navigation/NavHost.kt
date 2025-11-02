package com.hs.ev_charger_finder.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.hs.booking.registerBookingGraph
import com.hs.map.registerMapGraph
import com.hs.navigation.TopLevelDestination
import com.hs.settings.registerSettingsGraph
import com.hs.station.registerStationGraph

@Composable
fun AppNavHost(
    navController: NavHostController,
    startRoute: String = TopLevelDestination.MAP.route
) {
    NavHost(navController = navController, startDestination = startRoute) {
        registerMapGraph()()
        registerBookingGraph()()
        registerStationGraph()()
        registerSettingsGraph()()
    }
}