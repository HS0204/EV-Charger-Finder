package com.hs.model

data class Appointment(
    val id: Long,
    val stationId: Long,
    val userId: Long,
    val appointmentAt: String,
    val status: String
)
