package com.example.samagra.core.network


object ApiClient {

  private var withToken: Api? = null

  private val adapters: MutableList<Any> = mutableListOf()

  fun getApiClient(baseUrl: String): Api {
    if (withToken == null) {
      withToken = RetrofitClient.getRetrofitClient(
        baseUrl,
        adapters
      ).create(Api::class.java)
      return withToken!!
    }
    return withToken!!
  }

}