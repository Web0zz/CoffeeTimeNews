package com.web0z.data.remote.util

import com.web0z.core.utils.fromJson
import retrofit2.Response

/**
 * Retrofit only gives generic response body when status is Successful.
 * This extension will also parse error body and will give generic response.
 */
inline fun <reified T> Response<T>.getResponse(): T {
    val responseBody = body()
    return if (this.isSuccessful && responseBody != null) {
        responseBody
    } else {
        fromJson<T>(errorBody()!!.string())!!
    }
}
