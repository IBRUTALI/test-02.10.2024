package com.ighorosipov.test_02102024.feature.messages.domain.use_case

import com.ighorosipov.test_02102024.feature.messages.domain.model.Message
import com.ighorosipov.test_02102024.feature.messages.domain.repository.MessageRepository
import com.ighorosipov.test_02102024.utils.Resource
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetMessagesUseCase @Inject constructor(
    private val repository: MessageRepository,
) {

    operator fun invoke() = flow<Resource<List<Message>>> {
        emit(Resource.Loading())
        emit(repository.getMessages())
    }

}