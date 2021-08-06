package com.web0z.repository

import com.web0z.core.model.Article
import com.web0z.core.repository.CoffeeTimeNewsRepository
import com.web0z.core.repository.ResponseResult
import com.web0z.data.local.dao.ArticlesDao
import com.web0z.data.local.entity.ArticleEntity
import com.web0z.data.remote.api.CoffeeTimeNewsService
import com.web0z.data.remote.util.getResponse
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class CoffeeTimeNewsRepositoryImpl @Inject constructor(
    private val articleService: CoffeeTimeNewsService,
    private val articlesDao: ArticlesDao
) : CoffeeTimeNewsRepository {

    override fun getArticleById(articleId: String): Flow<Article> = articlesDao.getArticleById(articleId)
        .map {
            Article(it.id,
                it.title,
                it.body,
                it.writer,
                it.article_category,
                it.publish_time,
                it.writer_image,
                it.article_image
            )
        }

    override suspend fun getArticleByCategory(article_category: String): Flow<ResponseResult<List<Article>>> = flow {
        val articleResponse = articleService.getArticlesByCategory(article_category).getResponse()

        val state = when (articleResponse.status) {
            200 -> {
                insertArticle(articleResponse.articles)
                ResponseResult.success(articleResponse.articles)
            }
            else -> ResponseResult.error(articleResponse.message)
        }

        emit(state)
    }.catch { emit(ResponseResult.error("Can't request")) }

    private suspend fun insertArticle(articles: List<Article>) {
        articlesDao.addArticle(
            articles.map {
                ArticleEntity(it.id,
                    it.title,
                    it.body,
                    it.writer,
                    it.article_category,
                    it.publish_time,
                    it.writer_image,
                    it.article_image
                )
            }
        )
    }
}