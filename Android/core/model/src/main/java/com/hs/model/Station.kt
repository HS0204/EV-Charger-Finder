package com.hs.model

data class Station(
    val id: Long,
    val name: String,
    val latitude: Double,
    val longitude: Double,
    val available: Boolean
)
