package com.valuelabs.youtubeartists.models

data class YoutubeSearchRequestModel(val apiKey: String, val query: String, val maxResult: Int)