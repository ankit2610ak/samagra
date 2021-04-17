package com.example.samagra.core.network.feature

import com.example.samagra.core.network.apiV1networkRequest
import com.example.samagra.core.network.ApiResponse
import com.example.samagra.core.network.apiResponses.CommentsResponse
import com.example.samagra.core.network.apiResponses.PhotosResponse
import com.example.samagra.core.network.apiResponses.PostsResponse
import com.example.samagra.core.network.apiResponses.TodosResponse

class SamagraApiService : SamagraDataContract {

    override fun getComments(apiResponse: ApiResponse<CommentsResponse>) {
        apiV1networkRequest(apiResponse) {
            getComments()
        }
    }

    override fun getPhotos(apiResponse: ApiResponse<PhotosResponse>) {
        apiV1networkRequest(apiResponse) {
            getPhotos()
        }
    }

    override fun getTodos(apiResponse: ApiResponse<TodosResponse>) {
        apiV1networkRequest(apiResponse) {
            getTodos()
        }
    }

    override fun getPosts(apiResponse: ApiResponse<PostsResponse>) {
        apiV1networkRequest(apiResponse) {
            getPosts()
        }
    }
}