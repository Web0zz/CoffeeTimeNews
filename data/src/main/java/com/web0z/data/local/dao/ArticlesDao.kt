package com.web0z.data.local.dao

import androidx.room.*
import com.web0z.data.local.entity.ArticleEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticlesDao {
    @Query("SELECT * FROM articles WHERE id = :id")
    fun getArticleById(id: String): Flow<ArticleEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addArticle(articles: List<ArticleEntity>)
}