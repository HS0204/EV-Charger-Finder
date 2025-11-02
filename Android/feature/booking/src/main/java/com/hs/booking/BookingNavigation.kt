package com.hs.booking

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.hs.navigation.TopLevelDestination

fun registerBookingGraph(): NavGraphBuilder.() -> Unit = {
    composable(route = TopLevelDestination.BOOKING.route) {
        BookingScreen()
    }
}