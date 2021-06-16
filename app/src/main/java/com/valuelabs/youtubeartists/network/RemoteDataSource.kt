package com.valuelabs.youtubeartists.network

import com.valuelabs.youtubeartists.models.YoutubeSearchRequestModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val restService: RestService) :
    SafeApiRequest() {
    suspend fun getYoutubeSearchResult(requestModel: YoutubeSearchRequestModel) = apiRequest {
        restService.getYoutubeSearchResult(
            requestModel.apiKey,
            requestModel.query,
            requestModel.maxResult,
            requestModel.part
        )
    }
}