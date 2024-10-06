package com.ighorosipov.test_02102024.feature.messages.data.repository

import com.ighorosipov.test_02102024.core.room.TestDao
import com.ighorosipov.test_02102024.feature.messages.data.mapper.MessageMapper
import com.ighorosipov.test_02102024.feature.messages.domain.model.Message
import com.ighorosipov.test_02102024.feature.messages.domain.repository.MessageRepository
import com.ighorosipov.test_02102024.utils.Resource
import java.io.IOException
import javax.inject.Inject

class MessageRepositoryImpl @Inject constructor(
    private val dao: TestDao,
) : MessageRepository {

    override suspend fun sendMessage(message: Message): Resource<Unit> {
        return try {
            dao.insertMessage(MessageMapper().domainToEntity(message))
            Resource.Success(Unit)
        } catch (e: IOException) {
            Resource.Error(message = e.localizedMessage ?: "An unexpected error occurred")
        }
    }

    override suspend fun getMessages(): Resource<List<Message>> {
        return try {
            val messages = dao.getMessages().map {
                MessageMapper().entityToDomain(it)
            }
            Resource.Success(data = messages)
        } catch (e: IOException) {
            Resource.Error(message = e.localizedMessage ?: "An unexpected error occurred")
        }
    }

}