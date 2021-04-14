package com.example.samagra.core.network

interface ApiResponse<in T>{
    fun onSuccess(response: T)
    fun onError(error: String)
}
