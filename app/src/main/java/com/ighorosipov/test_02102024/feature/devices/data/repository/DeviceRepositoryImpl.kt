package com.ighorosipov.test_02102024.feature.devices.data.repository

import com.ighorosipov.test_02102024.feature.devices.data.dto.TestApi
import com.ighorosipov.test_02102024.feature.devices.data.mapper.DeviceMapper
import com.ighorosipov.test_02102024.feature.devices.domain.model.Device
import com.ighorosipov.test_02102024.feature.devices.domain.repository.DeviceRepository
import com.ighorosipov.test_02102024.utils.Resource
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class DeviceRepositoryImpl @Inject constructor(
    private val api: TestApi,
) : DeviceRepository {
    override suspend fun getDevices(): Resource<List<Device>> {
        return try {
            val devices = api.getDevices().map {
                DeviceMapper().dataToDomain(it)
            }
            Resource.Success(data = devices)
        } catch (e: HttpException) {
            Resource.Error(message = "Ошибка сети")
        } catch (e: IOException) {
            Resource.Error(message = "Нет интернета")
        } catch (e: Exception) {
            Resource.Error(message = "Неизвестная ошибка")
        }
    }
}