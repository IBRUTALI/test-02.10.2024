package com.ighorosipov.test_02102024.feature.messages.presentation.screens

import com.ighorosipov.test_02102024.feature.messages.domain.model.Message

sealed class MessagesScreenEvent {
    data object SendMessage : MessagesScreenEvent()
    data class ChangeRecipientField(val recipient: String) : MessagesScreenEvent()
    data class ChangeTextField(val text: String) : MessagesScreenEvent()
}