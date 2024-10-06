package com.ighorosipov.test_02102024.di

import android.content.Context
import com.ighorosipov.test_02102024.core.room.TestDao
import com.ighorosipov.test_02102024.core.room.TestDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    companion object {
        @Singleton
        @Provides
        fun provideTestDatabase(context: Context): TestDatabase {
            return TestDatabase.getDB(context)
        }

        @Singleton
        @Provides
        fun provideTestDao(testDatabase: TestDatabase): TestDao {
            return testDatabase.testDao
        }

    }

}