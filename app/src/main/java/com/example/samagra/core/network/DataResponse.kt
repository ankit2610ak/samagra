package com.example.samagra.core.network

interface DataResponse<in T> {
  fun onSuccess(response: T)
  fun onError(error: String)
}