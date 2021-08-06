package com.web0z.data.remote.model

import com.web0z.core.model.Article

data class ArticlesResponse(
    override val status: Int,
    override val message: String,
    val articles: List<Article> = emptyList()
) : BaseResponse
