package com.ighorosipov.test_02102024.feature.messages.data.mapper

import com.ighorosipov.test_02102024.feature.messages.data.db.model.MessageEntity
import com.ighorosipov.test_02102024.feature.messages.domain.model.Message

class MessageMapper {
    fun entityToDomain(messageEntity: MessageEntity): Message {
        return Message(
            id = messageEntity.id,
            time = messageEntity.time,
            date = messageEntity.date,
            recipient = messageEntity.recipient,
            text = messageEntity.text
        )
    }
    fun domainToEntity(message: Message): MessageEntity {
        return MessageEntity(
            id = message.id,
            time = message.time,
            date = message.date,
            recipient = message.recipient,
            text = message.text
        )
    }
}