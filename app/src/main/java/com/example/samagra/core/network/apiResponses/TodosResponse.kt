package com.example.samagra.core.network.apiResponses

import com.squareup.moshi.Json

data class TodosResponse(

	@Json(name="TodosResponse")
	val todosResponse: List<TodosResponseItem?>? = null
)

data class TodosResponseItem(

	@Json(name="id")
	val id: Int? = null,

	@Json(name="completed")
	val completed: Boolean? = null,

	@Json(name="title")
	val title: String? = null,

	@Json(name="userId")
	val userId: Int? = null
)
