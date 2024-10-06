package com.ighorosipov.test_02102024.core.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ighorosipov.test_02102024.feature.messages.data.db.model.MessageEntity

@Dao
interface TestDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMessage(messageEntity: MessageEntity)

    @Query("SELECT * FROM message")
    suspend fun getMessages(): List<MessageEntity>

}