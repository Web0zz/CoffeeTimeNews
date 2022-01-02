package com.web0z.data.remote.model

interface BaseResponse {
    val status: State
    val message: String
}

// TODO will be used in api response function
enum class State {
    SUCCESS, NOT_FOUND, FAILED, UNAUTHORIZED
}