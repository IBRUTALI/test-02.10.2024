package com.ighorosipov.test_02102024.feature.devices.domain.use_case

import com.ighorosipov.test_02102024.feature.devices.domain.FilterTag
import com.ighorosipov.test_02102024.feature.devices.domain.model.Device
import javax.inject.Inject

class FilterDevicesUseCase @Inject constructor() {

    operator fun invoke(devices: List<Device>, filterTag: FilterTag): List<Device> {
        return devices.filter { it.status == filterTag.title }
    }

}