package com.ighorosipov.test_02102024.feature.devices.presentation.screens

import com.ighorosipov.test_02102024.feature.devices.domain.FilterTag
import com.ighorosipov.test_02102024.feature.devices.domain.model.Device

sealed class DevicesScreenEvent {
    data class FilterDevices(val filterTag: FilterTag): DevicesScreenEvent()
    data class GetSelectedDeviceDescription(val device: Device): DevicesScreenEvent()
}