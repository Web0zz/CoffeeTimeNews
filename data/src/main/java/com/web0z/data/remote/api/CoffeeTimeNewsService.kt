package com.web0z.data.remote.api

import com.web0z.data.remote.Constant.API_TOKEN
import com.web0z.data.remote.model.ArticlesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path


interface CoffeeTimeNewsService {
    @Headers(API_TOKEN)
    @GET("/article/{category}")
    suspend fun getArticlesByCategory(
        @Path("category") category: String
    ): Response<ArticlesResponse>
}