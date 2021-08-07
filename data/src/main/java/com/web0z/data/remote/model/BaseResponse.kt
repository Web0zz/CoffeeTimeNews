package com.web0z.data.remote.model

interface BaseResponse {
    val status: State
    val message: String
}

enum class State {
    SUCCESS, NOT_FOUND, FAILED
}