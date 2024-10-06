package com.ighorosipov.test_02102024.feature.devices.domain.model

data class Device(
    val mac: String,
    val name: String,
    val status: String,
    val subscription: String,
    val type: String
)