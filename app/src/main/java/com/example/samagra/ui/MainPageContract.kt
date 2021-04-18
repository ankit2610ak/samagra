package com.example.samagra.ui

import com.example.samagra.core.network.DataResponse
import com.example.samagra.core.network.apiResponses.CommentsResponse
import com.example.samagra.core.network.apiResponses.PhotosResponse
import com.example.samagra.core.network.apiResponses.PostsResponse
import com.example.samagra.core.network.apiResponses.TodosResponse

interface MainPageContract {
    fun getComments(dataResponse: DataResponse<CommentsResponse>)

    fun getPhotos(dataResponse: DataResponse<PhotosResponse>)

    fun getTodos(dataResponse: DataResponse<TodosResponse>)

    fun getPosts(dataResponse: DataResponse<PostsResponse>)
}
