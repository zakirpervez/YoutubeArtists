package com.valuelabs.youtubeartists.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class YoutubeSearchResponseModel(
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
data class Id(
	@field:SerializedName("kind")
	val kind: String? = null,

	@field:SerializedName("videoId")
	val videoId: String? = null
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

	@field:SerializedName("kind")
	val kind: String? = null,

	@field:SerializedName("etag")
	val etag: String? = null,

	@field:SerializedName("id")
	val id: Id? = null
) : Parcelable
