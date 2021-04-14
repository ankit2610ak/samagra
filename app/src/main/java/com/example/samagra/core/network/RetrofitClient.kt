package com.example.samagra.core.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit.SECONDS

object RetrofitClient {

  private const val CONNECT_TIMEOUT = 15L
  private const val READ_TIMEOUT = 15L
  private lateinit var retrofit: Retrofit


  fun getRetrofitClient(
    baseUrl: String, adapters: MutableList<Any>
  ): Retrofit {
    if (!RetrofitClient::retrofit.isInitialized) {
      val loggingInterceptor = HttpLoggingInterceptor()
      val moshiBuilder = Moshi.Builder().add(com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory())
      val type = Types.newParameterizedType(Map::class.java, String::class.java,
          Any::class.javaObjectType)
      adapters.forEach {
        moshiBuilder.add(it)
      }
      val moshi = moshiBuilder.build()
      val mapAdapter = moshi.adapter<Map<String, String>>(type)
      adapters.add(mapAdapter)
      val client = OkHttpClient.Builder()
          .connectTimeout(CONNECT_TIMEOUT, SECONDS)
          .readTimeout(READ_TIMEOUT, SECONDS)
          .addInterceptor(loggingInterceptor)
          .build()

      retrofit = Retrofit.Builder().baseUrl(baseUrl)
          .addConverterFactory(MoshiConverterFactory.create(moshi)).client(client).build()
    }
    return retrofit
  }
}