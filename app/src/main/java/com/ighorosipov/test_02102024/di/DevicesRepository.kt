package com.ighorosipov.test_02102024.di

import com.ighorosipov.test_02102024.feature.devices.data.repository.DeviceRepositoryImpl
import com.ighorosipov.test_02102024.feature.devices.domain.repository.DeviceRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DevicesRepository {

    @Binds
    @Singleton
    fun bindDeviceRepository(
        deviceRepositoryImpl: DeviceRepositoryImpl
    ): DeviceRepository

}