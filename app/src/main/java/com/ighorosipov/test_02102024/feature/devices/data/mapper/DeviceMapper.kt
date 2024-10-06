package com.ighorosipov.test_02102024.feature.devices.data.mapper

import com.ighorosipov.test_02102024.feature.devices.data.dto.model.DeviceDto
import com.ighorosipov.test_02102024.feature.devices.domain.model.Device

class DeviceMapper {
    fun dataToDomain(deviceDto: DeviceDto): Device {
        return Device(
            mac = deviceDto.mac,
            name = deviceDto.name,
            status = deviceDto.status,
            subscription = deviceDto.subscription,
            type = deviceDto.type
        )
    }
}