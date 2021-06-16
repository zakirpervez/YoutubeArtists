package com.valuelabs.youtubeartists.network

import com.valuelabs.youtubeartists.models.YoutubeSearchResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RestService {
    @GET("search")
    suspend fun getYoutubeSearchResult(
        @Query(KEY_PARAM) apiKey: String,
        @Query(Q_PARAM) query: String,
        @Query(MAX_RESULT_PARAM) maxResult: Int,
        @Query(PART_PARAM) part: String,
    ): Response<YoutubeSearchResponseModel>

    companion object {
        private const val KEY_PARAM = "key"
        private const val Q_PARAM = "q"
        private const val MAX_RESULT_PARAM = "maxResults"
        private const val PART_PARAM = "part"
    }
}