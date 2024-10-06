package com.ighorosipov.test_02102024.feature.devices.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ighorosipov.test_02102024.feature.devices.domain.model.Device
import com.ighorosipov.test_02102024.ui.theme.Typography

@Composable
fun DeviceItem(
    modifier: Modifier = Modifier,
    device: Device,
    onClick: () -> Unit,
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            },
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            modifier = Modifier.weight(1f),
            text = device.name,
            color = MaterialTheme.colorScheme.primary,
            style = Typography.bodyLarge
        )
        Text(
            modifier = Modifier.weight(1f),
            text = device.type,
            color = MaterialTheme.colorScheme.primary,
            style = Typography.bodyLarge
        )
        Text(
            modifier = Modifier.weight(1f),
            text = device.status,
            color = MaterialTheme.colorScheme.tertiary,
            style = Typography.bodyLarge
        )
    }

}