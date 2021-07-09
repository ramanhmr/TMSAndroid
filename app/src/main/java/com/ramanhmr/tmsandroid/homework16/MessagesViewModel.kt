package com.ramanhmr.tmsandroid.homework16

import androidx.lifecycle.*
import com.ramanhmr.tmsandroid.homework16.database.MessageRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class MessagesViewModel(private val messageRepository: MessageRepository) : ViewModel() {
    val messagesLiveData: LiveData<List<Message>> =
        messageRepository.getMessageListFlow().asLiveData()

    fun addMessageToDatabase(text: String) {
        val message =
            Message(
                text,
                SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.ROOT).format(System.currentTimeMillis())
            )
        viewModelScope.launch(Dispatchers.IO) {
            messageRepository.addMessage(message)
        }
    }

    fun deleteMessageFromDatabase(message: Message) {
        viewModelScope.launch {
            messageRepository.deleteMessage(message)
        }
    }
}

class MessagesViewModelFactory(private val messageRepository: MessageRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MessagesViewModel(messageRepository) as T
    }
}