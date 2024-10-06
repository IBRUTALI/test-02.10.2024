package com.ighorosipov.test_02102024.feature.devices.data.dto.model


import com.google.gson.annotations.SerializedName

data class DeviceDto(
    @SerializedName("Mac")
    val mac: String,
    @SerializedName("Name")
    val name: String,
    @SerializedName("Status")
    val status: String,
    @SerializedName("Subscription")
    val subscription: String,
    @SerializedName("Type")
    val type: String
)