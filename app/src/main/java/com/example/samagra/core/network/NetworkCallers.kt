package com.example.apps10x.core.network

import com.example.samagra.core.network.Api
import com.example.samagra.core.network.ApiClient
import com.example.samagra.core.network.ApiResponse
import retrofit2.Call
import retrofit2.Callback

fun <W> apiV1networkRequest(apiResponse: ApiResponse<W>?, apiMethod: Api.() -> Call<W>) {

  val wmgV1Api = ApiClient.getApiClient(getBaseUrl())
  makeApiCall(apiResponse, wmgV1Api, {
    (this).apiMethod()
  })
}

fun <T, W> makeApiCall(apiResponse: ApiResponse<W>?, apiClient: T, apiMethod: T.() -> Call<W>) {
  makeApiCall(apiClient, apiResponse) {
    apiMethod()
  }
}

private fun <R, T> makeApiCall(
  apiClient: T,
  apiResponse: ApiResponse<R>?,
  networkFunction: T.() -> Call<R>
) {
  apiClient.networkFunction().enqueue(object : Callback<R> {
    override fun onFailure(call: Call<R>, t: Throwable) {
      apiResponse?.onError("network error")
    }

    override fun onResponse(call: Call<R>, response: retrofit2.Response<R>) {
      val body = response.body()
      if (response.isSuccessful && body != null) {
        apiResponse?.onSuccess(body)
      } else {
        apiResponse?.onError("error")
      }
    }
  })
}


fun getBaseUrl(): String {
  return "https://jsonplaceholder.typicode.com"
}
