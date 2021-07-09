package com.ramanhmr.tmsandroid.homework16.database

import com.ramanhmr.tmsandroid.homework16.Message
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MessageRepository(
    private val messageDao: MessageDao
) {
    fun getMessageListFlow(): Flow<List<Message>> = messageDao.getMessageList().map {
        it.map { messageEntity ->
            Message(messageEntity.text, messageEntity.time)
        }
    }

    suspend fun addMessage(message: Message) {
        messageDao.addMessage(message.entity())
    }

    suspend fun deleteMessage(message: Message) {
        messageDao.deleteMessage(message.entity())
    }

    private fun Message.entity() = MessageEntity(this.text, this.time)
}