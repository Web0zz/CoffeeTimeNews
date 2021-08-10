package com.web0z.core.repository

import com.web0z.core.model.Article
import kotlinx.coroutines.flow.Flow
import javax.inject.Singleton

@Singleton
interface CoffeeTimeNewsRepository {

    /**
     *  Returns a article
     *
     *  @param articleId a article ID.
     */
    fun getArticleById(articleId: String): Flow<Article>

    /**
     *  Returns article by Id
     *
     *  @param articleId a article ID.
     */
    suspend fun getArticleByIdFromApi(articleId: String): Flow<ResponseResult<Article>>

    /**
     *  Returns article list
     *
     *  @param article_category a article category.
     */
    suspend fun getArticleByCategory(article_category: String): Flow<ResponseResult<List<Article>>>
}