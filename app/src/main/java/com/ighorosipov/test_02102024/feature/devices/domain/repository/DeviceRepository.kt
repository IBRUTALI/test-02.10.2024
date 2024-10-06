package com.ighorosipov.test_02102024.feature.devices.domain.repository

import com.ighorosipov.test_02102024.feature.devices.domain.model.Device
import com.ighorosipov.test_02102024.utils.Resource

interface DeviceRepository {

    suspend fun getDevices(): Resource<List<Device>>

}