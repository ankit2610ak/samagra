package com.example.samagra.core.network.apiResponses

import com.squareup.moshi.Json

data class PhotosResponse(

	@Json(name="PhotosResponse")
	val photosResponse: List<PhotosResponseItem?>? = null
)

data class PhotosResponseItem(

	@Json(name="albumId")
	val albumId: Int? = null,

	@Json(name="id")
	val id: Int? = null,

	@Json(name="title")
	val title: String? = null,

	@Json(name="url")
	val url: String? = null,

	@Json(name="thumbnailUrl")
	val thumbnailUrl: String? = null
)
