package com.hs.ev_charger_finder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.rememberNavController
import com.hs.ev_charger_finder.navigation.AppNavHost
import com.hs.ev_charger_finder.navigation.NavigationState
import com.hs.ev_charger_finder.navigation.rememberNavigationState
import com.hs.navigation.TopLevelDestination
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { EVApp() }
    }
}

@Composable
fun EVApp() {
    val navController = rememberNavController()
    val navState = rememberNavigationState(navController)

    Scaffold(
        bottomBar = { BottomBar(navState) }
    ) { padding ->
        AppNavHost(
            navController = navState.navController,
            startRoute = TopLevelDestination.MAP.route
        )
    }
}

@Composable
fun BottomBar(navigationState: NavigationState) {
    NavigationBar {
        listOf(
            TopLevelDestination.MAP to Icons.Filled.Map,
            TopLevelDestination.BOOKING to Icons.Filled.Book,
            TopLevelDestination.STATION_LIST to Icons.Filled.Search,
            TopLevelDestination.SETTINGS to Icons.Filled.Settings,
        ).forEach { (dest, icon) ->
            val selected = navigationState.currentRoute == dest.route
            NavigationBarItem(
                selected = selected,
                onClick = { navigationState.navigateTo(dest.route) },
                icon = { Icon(icon, contentDescription = null) },
                label = { Text(text = stringResource(dest.labelRes)) }
            )
        }
    }
}