package com.ighorosipov.test_02102024.di

import com.ighorosipov.test_02102024.feature.messages.data.repository.MessageRepositoryImpl
import com.ighorosipov.test_02102024.feature.messages.domain.repository.MessageRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface MessagesRepository {

    @Binds
    @Singleton
    fun bindMessageRepository(
        messageRepositoryImpl: MessageRepositoryImpl
    ): MessageRepository

}