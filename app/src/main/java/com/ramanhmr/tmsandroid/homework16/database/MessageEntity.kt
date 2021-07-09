package com.ramanhmr.tmsandroid.homework16.database

import androidx.room.Entity

@Entity(tableName = "messages_table", primaryKeys = ["text", "time"])
data class MessageEntity(
    val text: String,
    val time: String
)