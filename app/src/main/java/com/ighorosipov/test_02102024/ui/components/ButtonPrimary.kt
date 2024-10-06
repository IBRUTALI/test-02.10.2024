package com.ighorosipov.test_02102024.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.ighorosipov.test_02102024.ui.theme.Typography

@Composable
fun ButtonPrimary(
    modifier: Modifier = Modifier,
    title: String,
    isActive: Boolean = true,
    onClick: () -> Unit
) {
    val (background, text) = if(isActive) {
        listOf(
            MaterialTheme.colorScheme.primary,
            MaterialTheme.colorScheme.onPrimary
        )
    } else {
        listOf(
            MaterialTheme.colorScheme.secondary,
            MaterialTheme.colorScheme.onSecondary
        )
    }
    Button(
        modifier = modifier
            .padding(10.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = background
        ),
        shape = CircleShape,
        enabled = isActive,
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