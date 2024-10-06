package com.ighorosipov.test_02102024.feature.messages.domain.use_case

import com.ighorosipov.test_02102024.feature.messages.domain.model.Message
import com.ighorosipov.test_02102024.feature.messages.domain.repository.MessageRepository
import com.ighorosipov.test_02102024.utils.Resource
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SendMessageUseCase @Inject constructor(
    private val repository: MessageRepository
) {

    operator fun invoke(message: Message) = flow<Resource<Unit>> {
        emit(Resource.Loading())
        emit(repository.sendMessage(message))
    }

}