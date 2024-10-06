package com.ighorosipov.test_02102024.feature.messages.domain.model

data class Message(
    val id: Int = 0,
    val time: String,
    val date: String,
    val recipient: String,
    val text: String,
)
