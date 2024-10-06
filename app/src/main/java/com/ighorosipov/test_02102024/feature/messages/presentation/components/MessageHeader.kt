package com.ighorosipov.test_02102024.feature.messages.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.ighorosipov.test_02102024.R
import com.ighorosipov.test_02102024.ui.theme.Typography

@Composable
fun MessageHeader(
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    Row(modifier = modifier.fillMaxWidth()) {
        Text(
            modifier = Modifier.weight(1f),
            text = context.resources.getString(R.string.numeration),
            color = MaterialTheme.colorScheme.onTertiary,
            style = Typography.bodyLarge
        )
        Text(
            modifier = Modifier.weight(1f),
            text = context.resources.getString(R.string.time),
            color = MaterialTheme.colorScheme.onTertiary,
            style = Typography.bodyLarge
        )
        Text(
            modifier = Modifier.weight(1f),
            text = context.resources.getString(R.string.date),
            color = MaterialTheme.colorScheme.onTertiary,
            style = Typography.bodyLarge
        )
        Text(
            modifier = Modifier.weight(1f),
            text = context.resources.getString(R.string.recipient),
            color = MaterialTheme.colorScheme.onTertiary,
            style = Typography.bodyLarge
        )
        Text(
            modifier = Modifier.weight(1f),
            text = context.resources.getString(R.string.text),
            color = MaterialTheme.colorScheme.onTertiary,
            style = Typography.bodyLarge
        )
    }
}