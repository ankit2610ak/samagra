package com.example.samagra.core.network

import android.util.Log
import com.example.samagra.R.drawable
import com.example.samagra.core.network.NetworkError.MALFORMED_JSON_CODE
import com.example.samagra.core.network.NetworkError.NO_INTERNET_CODE
import com.example.samagra.core.network.NetworkError.NULL_RESPONSE_CODE
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.squareup.moshi.JsonDataException
import com.squareup.moshi.Moshi
import retrofit2.Call
import retrofit2.Response
import java.io.IOException


object NetworkErrorTransformer : Throwable() {
  private val moshi = Moshi.Builder().build()
  private val adapter = moshi.adapter(ApiError::class.java)
  private val phpErrorAdapter = moshi.adapter(ApiErrorPhp::class.java)

  /**
   * returns a standardized error, as either
   * Null response error - response from the api is null
   * No Internet error
   * Malformed Json error - expected and actual contract of the api mismatches
   * Unknown error - when the error is unknown to this function and has not been handled yet
   *
   * @param t the error thrown by the onFailure method of retrofit 2
   */
  fun <R> getStandardizedError(t: Throwable?, call: Call<R>? = null): StandardizedError {
    Log.d("Network Error", "API", t)
    val url = call?.request()?.url()?.url()?.toURI()?.toASCIIString()

    if (t == null) {
      return getNullResponseError(url)
    }
    return when (t) {
      is IOException -> getNoInternetError(t, url)
      is JsonDataException -> getMalformedJsonException(t, url)
      else -> getUnknownError(t, url)

    }
  }

  private fun getDefaultIcon(code: Int): Int{
    return when(code){
      204 -> drawable.ic_no_data_core
      else -> drawable.placeholder_no_internet
    }
  }

  /**
   * returns a standardized error, handles the case when the api got a response from the server which
   * does not have a 2xx code
   * @param response response received from the api by the onSuccess method of the retrofit 2
   */
  fun <T : Any?> getStandardizedError(response: Response<T>?): StandardizedError {
    if (response == null) {
      return getNullResponseError(null)
    } else {
      val code = response.code()
      val url = response.raw()?.request()?.url()?.url()?.toURI()?.toASCIIString()
      val developerError = response.errorBody()?.string()


      val displayError = if (developerError != null) {
        try {
          val error = adapter.fromJson(developerError)
          if(error?.errorMessage == null){
            val errorPhp = phpErrorAdapter.fromJson(developerError)
            "${(errorPhp?.error?.message)}"
          }else{
            (error.errorMessage)
          }

        }
        catch (e: Exception) {
          getDefaultMessage(code)
        }
      } else
        getDefaultMessage(code)

      return StandardizedError(code, developerError.toString(),
              displayError,
              getDefaultIcon(code), url)
    }

  }

  private fun getDefaultMessage(code: Int): String {
    return when (code) {
      204 -> "Oops!! Looks like we don't seem to have anything related to your query right now"
      403 -> "Oops!! Looks like we don't seem to have anything related to your query right now"
      in 400..499 -> "Oops!! Looks like something is missing here."
      in 500..599 -> "Our servers are getting married please try again later."
      else -> {
        "Something went wrong"
      }
    }
  }

  /**
   * creates a standardized error in case of no internet connection
   */
  private fun getNoInternetError(t: Throwable, url: String?): StandardizedError {

    return StandardizedError(NO_INTERNET_CODE, t.localizedMessage
            ?: "",
            "Oops!! Looks " +
                    "like you are " +
                    "not " +
                    "connected to the internet", drawable.placeholder_no_internet, url)

  }

  /**
   * creates a standardized error in case of null response from the api
   */
  private fun getNullResponseError(url: String?): StandardizedError {
    return StandardizedError(NULL_RESPONSE_CODE, "Response is null",
            "Oops!! Looks like something " +
                    "is missing here.", drawable.ic_no_data_core, url)
  }

  /**
   * creates a standardized error in case of unknown error, an error not handled by this transformer
   */
  private fun getUnknownError(t: Throwable, url: String?): StandardizedError {
    return StandardizedError(
      NetworkError.UNKNOWN_ERROR_CODE,
            t.localizedMessage ?: "",
            "Something went wrong", drawable.placeholder_no_internet, url)
  }

  /**
   * creates a standardized error in case of mismatch between actual and expected contract of the api
   */
  fun getMalformedJsonException(t: Throwable?, url: String? = null): StandardizedError {
    return StandardizedError(MALFORMED_JSON_CODE, t?.localizedMessage
            ?: "Malformed JSON",
            "Something looks wrong!! Hold on, we are fixing it. " +
                    "Please try after sometime",
            drawable.placeholder_no_internet, url)
  }
}

object NetworkError {
  const val NULL_RESPONSE_CODE = 1
  const val NO_INTERNET_CODE = 2
  const val MALFORMED_JSON_CODE = 4
  const val UNKNOWN_ERROR_CODE = 3
  const val DEEPLINK_CODE = 5

}

@JsonClass(generateAdapter = true)
class ApiError(@Json(name = "errorMessage") val errorMessage: String,
               @Json(name = "errorCode") val errorCode: Int) {
}

@JsonClass(generateAdapter = true)
data class ApiErrorPhp(

        @Json(name="error")
        val error: Error? = null
)