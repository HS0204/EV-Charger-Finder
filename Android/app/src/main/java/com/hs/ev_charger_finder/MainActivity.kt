package com.hs.ev_charger_finder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hs.ev_charger_finder.ui.theme.EVChargerFinderTheme
import com.hs.station.presentation.StationListScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EVChargerFinderTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    NavHost(navController, startDestination = "stations") {
                        composable("stations") {
                            StationListScreen(onStationClick = { id ->
                                navController.navigate("station_detail/$id")
                            })
                        }
//                        composable(
//                            "station_detail/{id}",
//                            arguments = listOf(navArgument("id") { type = NavType.LongType })
//                        ) { backStackEntry ->
//                            val id = backStackEntry.arguments?.getLong("id") ?: 0L
//                            StationDetailScreen(stationId = id)
//                        }
                    }
                }
            }
        }
    }
}