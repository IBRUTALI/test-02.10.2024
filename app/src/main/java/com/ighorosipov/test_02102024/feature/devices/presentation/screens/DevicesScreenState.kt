package com.ighorosipov.test_02102024.feature.devices.presentation.screens

import com.ighorosipov.test_02102024.feature.devices.domain.FilterTag
import com.ighorosipov.test_02102024.feature.devices.domain.model.Device

data class DevicesScreenState(
    val devices: List<Device> = emptyList(),
    val filteredDevices: List<Device> = emptyList(),
    val filterTag: FilterTag = FilterTag.ALL,
    val selectedDevice: Device? = null,
)