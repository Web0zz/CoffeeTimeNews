package com.web0z.data.remote.model

import com.web0z.core.model.Article

data class ArticlesResponse(
    override val status: State,
    override val message: String,
    val articles: List<Article> = emptyList()
) : BaseResponse

data class ArticleResponse(
    override val status: State,
    override val message: String,
    val article: Article? = null
) : BaseResponse
