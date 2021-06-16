package com.valuelabs.youtubeartists.network

import com.valuelabs.youtubeartists.models.YoutubeSearchRequestModel
import com.valuelabs.youtubeartists.models.YoutubeSearchResponseModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(private val remoteDataSource: RemoteDataSource) {
    suspend fun getYoutubeSearchResult(requestModel: YoutubeSearchRequestModel): YoutubeSearchResponseModel =
        remoteDataSource.getYoutubeSearchResult(requestModel)
}