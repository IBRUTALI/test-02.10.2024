package com.ighorosipov.test_02102024.feature.messages.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ighorosipov.test_02102024.R
import com.ighorosipov.test_02102024.feature.messages.presentation.components.MessageItem
import com.ighorosipov.test_02102024.ui.components.BaseEditField
import com.ighorosipov.test_02102024.ui.components.ButtonPrimary
import com.ighorosipov.test_02102024.ui.components.animation.AnimateContent
import com.ighorosipov.test_02102024.ui.theme.Typography

@Composable
fun MessagesScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: MessagesViewModel = hiltViewModel(),
) {
    val context = LocalContext.current
    val state by viewModel.state.collectAsState()
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        if (state.messages.isNotEmpty()) {
            AnimateContent(
                modifier = Modifier.weight(1f),
                show = state.messages.isNotEmpty()
            ) {
                Column {
                    Text(
                        modifier = Modifier.padding(horizontal = 5.dp),
                        style = Typography.titleLarge,
                        text = context.resources.getString(R.string.sent)
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 5.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                    ) {
                        itemsIndexed(state.messages) { i, message ->
                            var isExpanded by remember { mutableStateOf(false) }
                            MessageItem(
                                index = i,
                                message = message,
                                isExpanded = isExpanded,
                                onClick = {
                                    isExpanded = !isExpanded
                                }
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(2.dp))
            }
        }
        Column(
            modifier = Modifier
                .height(IntrinsicSize.Min)
                .padding(horizontal = 5.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            if(state.messages.isNotEmpty()) {
                HorizontalDivider(
                    modifier = Modifier.padding(bottom = 5.dp),
                    color = MaterialTheme.colorScheme.tertiary
                )
            }
            Text(
                text = context.resources.getString(R.string.send_message),
                color = MaterialTheme.colorScheme.onBackground,
                style = Typography.titleLarge
            )
            BaseEditField(
                inputValue = state.messageRecipient,
                placeholder = stringResource(id = R.string.recipient),
                keyboardType = KeyboardType.Text,
                onValueChange = {
                    viewModel.onEvent(event = MessagesScreenEvent.ChangeRecipientField(it))
                }
            )
            BaseEditField(
                inputValue = state.messageText,
                placeholder = stringResource(id = R.string.text),
                keyboardType = KeyboardType.Text,
                onValueChange = {
                    viewModel.onEvent(event = MessagesScreenEvent.ChangeTextField(it))
                }
            )
            ButtonPrimary(
                title = context.resources.getString(R.string.send),
                isActive = state.messageText.isNotBlank() && state.messageRecipient.isNotBlank()
            ) {
                viewModel.onEvent(event = MessagesScreenEvent.SendMessage)
            }
        }
    }
}