package com.hs.navigation

import androidx.annotation.StringRes

enum class TopLevelDestination(
    val route: String,
    @StringRes val labelRes: Int
) {
    MAP("map", R.string.map),
    BOOKING("booking", R.string.booking),
    STATION_LIST("station_list", R.string.station_list),
    SETTINGS("settings", R.string.settings)
}