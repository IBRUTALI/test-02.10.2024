package com.ighorosipov.test_02102024.feature.devices.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ighorosipov.test_02102024.feature.devices.domain.FilterTag
import com.ighorosipov.test_02102024.feature.devices.presentation.components.DeviceDescription
import com.ighorosipov.test_02102024.feature.devices.presentation.components.DeviceHeader
import com.ighorosipov.test_02102024.feature.devices.presentation.components.DeviceItem
import com.ighorosipov.test_02102024.ui.components.ButtonSecondary
import com.ighorosipov.test_02102024.ui.components.animation.AnimateContent

@Composable
fun DevicesScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: DevicesViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        Column(modifier = Modifier.weight(1f)) {
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            ) {
                items(FilterTag.entries.toTypedArray()) { filterTag ->
                    ButtonSecondary(
                        title = filterTag.name,
                        isSelected = filterTag == state.filterTag
                    ) {
                        viewModel.onEvent(event = DevicesScreenEvent.FilterDevices(filterTag))
                    }
                }
            }
            HorizontalDivider(
                modifier = Modifier.padding(vertical = 5.dp),
                color = MaterialTheme.colorScheme.tertiary
            )
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            ) {
                item { DeviceHeader() }
                items(
                    if (state.filterTag == FilterTag.ALL) state.devices else state.filteredDevices
                ) { device ->
                    DeviceItem(device = device) {
                        viewModel.onEvent(
                            event = DevicesScreenEvent.GetSelectedDeviceDescription(device)
                        )
                    }
                }
            }
        }
        AnimateContent(show = state.selectedDevice != null) {
            Column(
                modifier = Modifier.height(IntrinsicSize.Min)
            ) {
                HorizontalDivider(
                    modifier = Modifier.padding(bottom = 5.dp),
                    color = MaterialTheme.colorScheme.tertiary
                )
                state.selectedDevice?.let { selectedDevice ->
                    DeviceDescription(
                        modifier = Modifier.padding(horizontal = 5.dp),
                        device = selectedDevice
                    )
                }
            }
        }
    }
}
