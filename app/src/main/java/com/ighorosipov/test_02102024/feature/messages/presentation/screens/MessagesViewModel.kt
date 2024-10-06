package com.ighorosipov.test_02102024.feature.messages.presentation.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ighorosipov.test_02102024.di.IODispatcher
import com.ighorosipov.test_02102024.feature.messages.domain.model.Message
import com.ighorosipov.test_02102024.feature.messages.domain.use_case.GetMessagesUseCase
import com.ighorosipov.test_02102024.feature.messages.domain.use_case.SendMessageUseCase
import com.ighorosipov.test_02102024.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class MessagesViewModel @Inject constructor(
    private val getMessagesUseCase: GetMessagesUseCase,
    private val sendMessageUseCase: SendMessageUseCase,
    @IODispatcher
    private val dispatcher: CoroutineDispatcher,
) : ViewModel() {

    val state = MutableStateFlow(MessagesScreenState())

    init {
        getMessages()
    }

    fun onEvent(event: MessagesScreenEvent) {
        when (event) {
            is MessagesScreenEvent.SendMessage -> {
                sendMessage()
            }

            is MessagesScreenEvent.ChangeRecipientField -> {
                state.value = state.value.copy(messageRecipient = event.recipient)
            }

            is MessagesScreenEvent.ChangeTextField -> {
                state.value = state.value.copy(messageText = event.text)
            }
        }
    }

    private fun getMessages() {
        viewModelScope.launch(dispatcher) {
            getMessagesUseCase().collect { resource ->
                when (resource) {
                    is Resource.Error -> {}
                    is Resource.Loading -> {}
                    is Resource.Success -> {
                        state.value = state.value.copy(messages = resource.data ?: emptyList())
                    }
                }
            }
        }
    }

    private fun addMessageToMessages(message: Message) {
        state.value = state.value.copy(messages = state.value.messages + message)
    }

    private fun sendMessage() {
        viewModelScope.launch(dispatcher) {
            val currentDate = Date()
            val timeFormatter = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
            val dateFormatter = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
            val formattedTime = timeFormatter.format(currentDate)
            val formattedDate = dateFormatter.format(currentDate)
            val message = Message(
                time = formattedTime,
                date = formattedDate,
                recipient = state.value.messageRecipient,
                text = state.value.messageText
            )
            sendMessageUseCase(message).collect { resource ->
                when (resource) {
                    is Resource.Error -> {}
                    is Resource.Loading -> {}
                    is Resource.Success -> {
                        addMessageToMessages(message)
                    }
                }
            }
        }
    }

}