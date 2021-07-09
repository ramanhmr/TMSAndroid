package com.ramanhmr.tmsandroid.homework16.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface MessageDao {

    @Query("SELECT * FROM messages_table")
    fun getMessageList(): Flow<List<MessageEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addMessage(message: MessageEntity)

    @Delete
    suspend fun deleteMessage(message: MessageEntity)
}