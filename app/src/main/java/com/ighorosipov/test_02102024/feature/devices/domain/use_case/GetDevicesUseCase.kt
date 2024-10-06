package com.ighorosipov.test_02102024.feature.devices.domain.use_case

import com.ighorosipov.test_02102024.feature.devices.domain.model.Device
import com.ighorosipov.test_02102024.feature.devices.domain.repository.DeviceRepository
import com.ighorosipov.test_02102024.utils.Resource
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetDevicesUseCase @Inject constructor(
    private val repository: DeviceRepository
) {

    operator fun invoke() = flow<Resource<List<Device>>> {
        emit(Resource.Loading())
        emit(repository.getDevices())
    }

}