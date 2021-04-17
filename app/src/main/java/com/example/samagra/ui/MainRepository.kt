package com.example.samagra.ui

import com.example.samagra.core.network.ApiResponse
import com.example.samagra.core.network.DataResponse
import com.example.samagra.core.network.apiResponses.CommentsResponse
import com.example.samagra.core.network.apiResponses.PhotosResponse
import com.example.samagra.core.network.apiResponses.PostsResponse
import com.example.samagra.core.network.apiResponses.TodosResponse
import com.example.samagra.core.network.feature.SamagraDataContract

class MainRepository(private val samagraDataContract: SamagraDataContract) : MainPageContract {
    override fun getComments(dataResponse: DataResponse<CommentsResponse>) {
        samagraDataContract.getComments(object : ApiResponse<CommentsResponse> {
            override fun onSuccess(response: CommentsResponse) {
                dataResponse.onSuccess(response)
            }

            override fun onError(error: String) {
                dataResponse.onError(error)
            }

        })
    }

    override fun getPhotos(dataResponse: DataResponse<PhotosResponse>) {
        samagraDataContract.getPhotos(object : ApiResponse<PhotosResponse> {
            override fun onSuccess(response: PhotosResponse) {
                dataResponse.onSuccess(response)
            }

            override fun onError(error: String) {
                dataResponse.onError(error)
            }

        })
    }

    override fun getTodos(dataResponse: DataResponse<TodosResponse>) {
        samagraDataContract.getTodos(object : ApiResponse<TodosResponse> {
            override fun onSuccess(response: TodosResponse) {
                dataResponse.onSuccess(response)
            }

            override fun onError(error: String) {
                dataResponse.onError(error)
            }

        })
    }

    override fun getPosts(dataResponse: DataResponse<PostsResponse>) {
        samagraDataContract.getPosts(object : ApiResponse<PostsResponse> {
            override fun onSuccess(response: PostsResponse) {
                dataResponse.onSuccess(response)
            }

            override fun onError(error: String) {
                dataResponse.onError(error)
            }

        })
    }
}