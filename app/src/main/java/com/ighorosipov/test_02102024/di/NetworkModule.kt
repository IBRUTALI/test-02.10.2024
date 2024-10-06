package com.ighorosipov.test_02102024.di

import android.content.Context
import com.ighorosipov.test_02102024.feature.devices.data.dto.LocalJsonInterceptor
import com.ighorosipov.test_02102024.feature.devices.data.dto.TestApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface NetworkModule {

    companion object {

        @Provides
        @Singleton
        fun provideTestService(okHttpClient: OkHttpClient): TestApi {
            return Retrofit.Builder()
                .baseUrl("https://mock.local/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create()
        }

        @Provides
        @Singleton
        fun provideOkhttpClient(context: Context): OkHttpClient {
            val client = OkHttpClient.Builder()
                .addInterceptor(LocalJsonInterceptor(context))
            return client.build()
        }

    }

}