package com.ighorosipov.test_02102024.feature.devices.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.ighorosipov.test_02102024.R
import com.ighorosipov.test_02102024.feature.devices.domain.model.Device
import com.ighorosipov.test_02102024.ui.theme.Typography

@Composable
fun DeviceDescription(
    modifier: Modifier = Modifier,
    device: Device
) {
    val context = LocalContext.current
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = device.name,
            color = MaterialTheme.colorScheme.onBackground,
            style = Typography.bodyLarge
        )
        Text(
            text = "${context.resources.getString(R.string.type)}: ${device.type}",
            color = MaterialTheme.colorScheme.onBackground,
            style = Typography.bodyLarge
        )
        Text(
            text = "${context.resources.getString(R.string.status)}: ${device.status}",
            color = MaterialTheme.colorScheme.onBackground,
            style = Typography.bodyLarge
        )
        Text(
            text = "${context.resources.getString(R.string.mac)}: ${device.mac}",
            color = MaterialTheme.colorScheme.onBackground,
            style = Typography.bodyLarge
        )
        Text(
            text = "${context.resources.getString(R.string.subscriptions)}: ${device.subscription}",
            color = MaterialTheme.colorScheme.onBackground,
            style = Typography.bodyLarge
        )
    }
}