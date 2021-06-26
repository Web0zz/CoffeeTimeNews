package com.web0z.core.model

data class Article(
    val id: String,
    val title: String,
    val body: String,
    val writer: String,
    val article_category: String,
    val publish_time: String,
    val writer_image: String,
    val article_image: String
)
