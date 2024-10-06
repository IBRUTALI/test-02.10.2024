package com.ighorosipov.test_02102024.core.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ighorosipov.test_02102024.feature.messages.data.db.model.MessageEntity

@Database(
    entities = [MessageEntity::class],
    version = 1,
    exportSchema = false
)
abstract class TestDatabase: RoomDatabase() {

    abstract val testDao: TestDao

    companion object {
        fun getDB(context: Context): TestDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                TestDatabase::class.java,
                DATABASE_NAME
            ).build()
        }

        private const val DATABASE_NAME = "test_db"
    }


}