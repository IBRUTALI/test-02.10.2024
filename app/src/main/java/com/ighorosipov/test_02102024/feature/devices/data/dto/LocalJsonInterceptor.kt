package com.ighorosipov.test_02102024.feature.devices.data.dto

import android.content.Context
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody

class LocalJsonInterceptor(private val context: Context) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val jsonFile = "mock.json"
        val inputStream = context.assets.open(jsonFile)
        val jsonString = inputStream.bufferedReader().use { it.readText() }
        return Response.Builder()
            .code(200)
            .message("OK")
            .request(chain.request())
            .protocol(okhttp3.Protocol.HTTP_1_0)
            .body(jsonString.toResponseBody("application/json".toMediaType()))
            .addHeader("content-type", "application/json")
            .build()
    }
}