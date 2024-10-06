package com.ighorosipov.test_02102024.feature.messages.domain.repository

import com.ighorosipov.test_02102024.feature.messages.domain.model.Message
import com.ighorosipov.test_02102024.utils.Resource

interface MessageRepository {

    suspend fun sendMessage(message: Message): Resource<Unit>

    suspend fun getMessages(): Resource<List<Message>>

}