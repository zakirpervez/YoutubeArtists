package com.valuelabs.youtubeartists.network

import com.ofroad.android.app.exceptions.ApiException
import retrofit2.Response

abstract class SafeApiRequest {
    @Throws(ApiException::class, NullPointerException::class)
    suspend fun <T> apiRequest(call: suspend () -> Response<T>): T {
        val response = call.invoke()
        if (response.isSuccessful) {
            return response.body() ?: throw NullPointerException()
        } else {
            val errorMessage = response.errorBody()?.string()
                ?: "API failure due to ${response.code()}"
            throw ApiException(errorMessage, response.code())
        }
    }
}