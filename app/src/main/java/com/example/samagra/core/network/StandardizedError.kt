package com.example.samagra.core.network

import android.util.Log

data class StandardizedError(val responseCode: Int, val developerError: String,
                             val displayError: String, val icon: Int? = null, val url: String? = "") : Throwable(
        developerError) {


    init {
        val exceptionAttibutes = HashMap<String, Any>()
        exceptionAttibutes["response_code"] = responseCode
        exceptionAttibutes["developer_error"] = developerError
        exceptionAttibutes["display_error"] = displayError
        val msg = "$developerError in $url"
        if (url != null)
            exceptionAttibutes.put("url_data", url)
        Log.d(StandardizedError::class.java.simpleName, msg)
    }

    class HandledException(msg: String) : Exception(msg)
}