package com.ighorosipov.test_02102024.feature.devices.data.dto

import com.ighorosipov.test_02102024.feature.devices.data.dto.model.DeviceDto
import retrofit2.http.GET

interface TestApi {

    @GET("mock/api")
    suspend fun getDevices(): List<DeviceDto>

}