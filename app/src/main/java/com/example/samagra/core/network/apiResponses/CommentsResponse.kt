package com.example.samagra.core.network.apiResponses

import com.squareup.moshi.Json

data class CommentsResponse(

	@Json(name="CommentsResponse")
	val commentsResponse: List<CommentsResponseItem?>? = null
)

data class CommentsResponseItem(

	@Json(name="name")
	val name: String? = null,

	@Json(name="postId")
	val postId: Int? = null,

	@Json(name="id")
	val id: Int? = null,

	@Json(name="body")
	val body: String? = null,

	@Json(name="email")
	val email: String? = null
)
