package com.web0z.coffeetimenews.ui.view

sealed class Screen(
    val route: String, val name: String
) {
    object Splash : Screen("splash", "Splash")
    object Home : Screen("home", "Home")
    object Error : Screen("error/{errorMessage}", "Error Message") {
        fun route(errorMessage: String) = "error/$errorMessage"

        const val ARG_ERROR_MESSAGE: String = "errorMessage"
    }

    object Detail : Screen("detail/{articleId}", "Article detail") {
        fun route(articleId: String) = "detail/$articleId"

        const val ARG_ARTICLE_ID: String = "articleId"
    }
}
