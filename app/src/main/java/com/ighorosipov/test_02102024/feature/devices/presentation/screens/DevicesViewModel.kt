package com.ighorosipov.test_02102024.feature.devices.presentation.screens

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ighorosipov.test_02102024.di.IODispatcher
import com.ighorosipov.test_02102024.feature.devices.domain.FilterTag
import com.ighorosipov.test_02102024.feature.devices.domain.model.Device
import com.ighorosipov.test_02102024.feature.devices.domain.use_case.FilterDevicesUseCase
import com.ighorosipov.test_02102024.feature.devices.domain.use_case.GetDevicesUseCase
import com.ighorosipov.test_02102024.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DevicesViewModel @Inject constructor(
    private val getDevicesUseCase: GetDevicesUseCase,
    private val filterDevicesUseCase: FilterDevicesUseCase,
    @IODispatcher
    private val dispatcher: CoroutineDispatcher,
) : ViewModel() {

    val state = MutableStateFlow(DevicesScreenState())

    init {
        getDevices()
    }

    fun onEvent(event: DevicesScreenEvent) {
        when (event) {
            is DevicesScreenEvent.FilterDevices -> {
                filterDevices(event.filterTag)
            }

            is DevicesScreenEvent.GetSelectedDeviceDescription -> {
                getGetSelectedDeviceDescription(event.device)
            }
        }
    }

    private fun getDevices() {
        viewModelScope.launch(dispatcher) {
            getDevicesUseCase().collect { resource ->
                when (resource) {
                    is Resource.Error -> {}
                    is Resource.Loading -> {}
                    is Resource.Success -> {
                        state.value = state.value.copy(devices = resource.data ?: emptyList())
                    }
                }
            }
        }
    }

    private fun filterDevices(filterTag: FilterTag) {
        viewModelScope.launch {
            state.value = state.value.copy(filterTag = filterTag)
            state.value = state.value.copy(
                filteredDevices = filterDevicesUseCase(
                    devices = state.value.devices,
                    filterTag = state.value.filterTag
                )
            )
        }
    }

    private fun getGetSelectedDeviceDescription(selectedDevice: Device) {
        state.value = if (selectedDevice == state.value.selectedDevice) state.value.copy(selectedDevice = null)
        else state.value.copy(selectedDevice = selectedDevice)
    }
}