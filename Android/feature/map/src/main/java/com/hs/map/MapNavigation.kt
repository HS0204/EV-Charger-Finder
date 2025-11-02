package com.hs.map

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.hs.navigation.TopLevelDestination

fun registerMapGraph(): NavGraphBuilder.() -> Unit = {
    composable(route = TopLevelDestination.MAP.route) {
        MapScreen()
    }
}