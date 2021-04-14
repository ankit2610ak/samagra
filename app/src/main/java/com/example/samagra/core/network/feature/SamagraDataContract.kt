package com.example.samagra.core.network.feature

import com.example.samagra.core.network.ApiResponse
import com.example.samagra.core.network.apiResponses.CommentsResponse
import com.example.samagra.core.network.apiResponses.PhotosResponse
import com.example.samagra.core.network.apiResponses.PostsResponse
import com.example.samagra.core.network.apiResponses.TodosResponse

interface SamagraDataContract {

    fun getComments(apiResponse: ApiResponse<CommentsResponse>)

    fun getPhotos(apiResponse: ApiResponse<PhotosResponse>)

    fun getTodos(apiResponse: ApiResponse<TodosResponse>)

    fun getPosts(apiResponse: ApiResponse<PostsResponse>)
}