package com.hs.settings

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.hs.navigation.TopLevelDestination

fun registerSettingsGraph(): NavGraphBuilder.() -> Unit = {
    composable(route = TopLevelDestination.SETTINGS.route) {
        SettingsScreen()
    }
}