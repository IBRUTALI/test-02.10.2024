package com.ighorosipov.test_02102024.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.ighorosipov.test_02102024.ui.theme.Typography

@Composable
fun ButtonSecondary(
    modifier: Modifier = Modifier,
    title: String,
    isSelected: Boolean = false,
    onClick: () -> Unit,
) {
    val (background, text, border) = if(isSelected) {
        listOf(
            MaterialTheme.colorScheme.surface,
            MaterialTheme.colorScheme.onTertiary,
            MaterialTheme.colorScheme.surface
        )
    } else {
        listOf(
            MaterialTheme.colorScheme.secondary,
            MaterialTheme.colorScheme.primary,
            MaterialTheme.colorScheme.primary
        )
    }
    Button(
        modifier = modifier
            .padding(2.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = background
        ),
        shape = CircleShape,
        border = BorderStroke(1.dp, border),
        onClick = {
            onClick()
        }
    ) {
        Text(
            text = title,
            color = text,
            style = Typography.bodyLarge
        )
    }
}