package com.ighorosipov.test_02102024.feature.messages.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ighorosipov.test_02102024.R
import com.ighorosipov.test_02102024.feature.messages.domain.model.Message
import com.ighorosipov.test_02102024.ui.theme.Typography

@Composable
fun MessageItem(
    modifier: Modifier = Modifier,
    index: Int,
    message: Message,
    isExpanded: Boolean = false,
    onClick: () -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(CircleShape)
            .clickable {
                onClick()
            }
            .border(1.dp, MaterialTheme.colorScheme.primary, CircleShape)
            .padding(10.dp)

    ) {
        val displayText = if (isExpanded) message.text else {
            if (message.text.length > 10) {
                "${message.text.substring(0, 10)}..."
            } else {
                message.text
            }
        }
        Row(modifier = modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .size(30.dp)
                    .align(Alignment.CenterVertically)
                    .background(color = MaterialTheme.colorScheme.primary, shape = CircleShape)
            ) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = "$index",
                    color = MaterialTheme.colorScheme.secondary,
                    style = Typography.bodyLarge
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10))
                    .background(MaterialTheme.colorScheme.secondary)
            ) {
                Text(
                    text = "${stringResource(id = R.string.recipient)}: ${message.recipient}",
                    color = MaterialTheme.colorScheme.onSecondary,
                    style = Typography.bodySmall
                )
                Text(
                    text = displayText,
                    color = MaterialTheme.colorScheme.onSecondary,
                    style = Typography.titleMedium
                )
                Text(
                    text = "${stringResource(id = R.string.date)}: ${message.time} ${message.date}",
                    color = MaterialTheme.colorScheme.onSecondary,
                    style = Typography.bodySmall
                )
            }

        }
    }
}
