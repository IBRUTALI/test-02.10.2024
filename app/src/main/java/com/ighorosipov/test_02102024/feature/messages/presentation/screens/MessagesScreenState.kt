package com.ighorosipov.test_02102024.feature.messages.presentation.screens

import com.ighorosipov.test_02102024.feature.messages.domain.model.Message

data class MessagesScreenState(
    val messages: List<Message> = emptyList(),
    val messageRecipient: String = "",
    val messageText: String = "",
)
