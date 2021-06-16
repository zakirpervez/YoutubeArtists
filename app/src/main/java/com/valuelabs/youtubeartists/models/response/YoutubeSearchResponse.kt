package com.valuelabs.youtubeartists.models.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class YoutubeSearchResponse(

    @field:SerializedName("regionCode")
    val regionCode: String? = null,

    @field:SerializedName("kind")
    val kind: String? = null,

    @field:SerializedName("nextPageToken")
    val nextPageToken: String? = null,

    @field:SerializedName("pageInfo")
    val pageInfo: PageInfo? = null,

    @field:SerializedName("etag")
    val etag: String? = null,

    @field:SerializedName("items")
    val items: List<VideoItem?>? = null
) : Parcelable

@Parcelize
data class PageInfo(

    @field:SerializedName("totalResults")
    val totalResults: Int? = null,

    @field:SerializedName("resultsPerPage")
    val resultsPerPage: Int? = null
) : Parcelable

@Parcelize
data class VideoItem(

    @field:SerializedName("snippet")
    val snippet: Snippet? = null,

    @field:SerializedName("kind")
    val kind: String? = null,

    @field:SerializedName("etag")
    val etag: String? = null,

    @field:SerializedName("id")
    val id: Id? = null
) : Parcelable

@Parcelize
data class JsonMemberDefault(

    @field:SerializedName("width")
    val width: Int? = null,

    @field:SerializedName("url")
    val url: String? = null,

    @field:SerializedName("height")
    val height: Int? = null
) : Parcelable

@Parcelize
data class Id(

    @field:SerializedName("kind")
    val kind: String? = null,

    @field:SerializedName("videoId")
    val videoId: String? = null
) : Parcelable

@Parcelize
data class Medium(

    @field:SerializedName("width")
    val width: Int? = null,

    @field:SerializedName("url")
    val url: String? = null,

    @field:SerializedName("height")
    val height: Int? = null
) : Parcelable

@Parcelize
data class High(

    @field:SerializedName("width")
    val width: Int? = null,

    @field:SerializedName("url")
    val url: String? = null,

    @field:SerializedName("height")
    val height: Int? = null
) : Parcelable

@Parcelize
data class Snippet(

    @field:SerializedName("publishTime")
    val publishTime: String? = null,

    @field:SerializedName("publishedAt")
    val publishedAt: String? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("thumbnails")
    val thumbnails: Thumbnails? = null,

    @field:SerializedName("channelId")
    val channelId: String? = null,

    @field:SerializedName("channelTitle")
    val channelTitle: String? = null,

    @field:SerializedName("liveBroadcastContent")
    val liveBroadcastContent: String? = null
) : Parcelable

@Parcelize
data class Thumbnails(

    @field:SerializedName("default")
    val jsonMemberDefault: JsonMemberDefault? = null,

    @field:SerializedName("high")
    val high: High? = null,

    @field:SerializedName("medium")
    val medium: Medium? = null
) : Parcelable
