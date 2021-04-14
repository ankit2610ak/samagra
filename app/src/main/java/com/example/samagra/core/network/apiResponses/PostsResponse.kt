package com.example.samagra.core.network.apiResponses

import com.squareup.moshi.Json

data class PostsResponse(

	@Json(name="PostsResponse")
	val postsResponse: List<PostsResponseItem?>? = null
)

data class PostsResponseItem(

	@Json(name="id")
	val id: Int? = null,

	@Json(name="title")
	val title: String? = null,

	@Json(name="body")
	val body: String? = null,

	@Json(name="userId")
	val userId: Int? = null
)
