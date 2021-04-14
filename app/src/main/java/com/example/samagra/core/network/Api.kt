package com.example.samagra.core.network

import com.example.samagra.core.network.apiResponses.CommentsResponse
import com.example.samagra.core.network.apiResponses.PhotosResponse
import com.example.samagra.core.network.apiResponses.PostsResponse
import com.example.samagra.core.network.apiResponses.TodosResponse
import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @GET(UrlConstants.COMMENTS)
    fun getComments(): Call<CommentsResponse>

    @GET(UrlConstants.PHOTOS)
    fun getPhotos(): Call<PhotosResponse>

    @GET(UrlConstants.TODOS)
    fun getTodos(): Call<TodosResponse>

    @GET(UrlConstants.POSTS)
    fun getPosts(): Call<PostsResponse>

}