package com.web0z.coffeetimenews.ui.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import coil.annotation.ExperimentalCoilApi
import com.google.accompanist.pager.ExperimentalPagerApi
import com.web0z.coffeetimenews.ui.view.Screen
import com.web0z.coffeetimenews.ui.view.article.ArticleDetail
import com.web0z.coffeetimenews.ui.view.article.articleDetailViewModel
import com.web0z.coffeetimenews.ui.view.error.ErrorPage
import com.web0z.coffeetimenews.ui.view.home.HomeScreen
import com.web0z.coffeetimenews.ui.view.splash.SplashScreen
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi

const val COFFEE_NAV_HOST_ROUTE = "coffee-main-route"

@ExperimentalFoundationApi
@ExperimentalPagerApi
@ExperimentalCoilApi
@ExperimentalCoroutinesApi
@InternalCoroutinesApi
@Composable
fun CoffeeTimeNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route,
        route = COFFEE_NAV_HOST_ROUTE
    ) {
        composable(Screen.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(Screen.Home.route) {
            HomeScreen(
                navController = navController,
                viewModel = hiltViewModel()
            )
        }
        composable(
            Screen.Detail.route,
            arguments = listOf(
                navArgument(Screen.Detail.ARG_ARTICLE_ID) { type = NavType.StringType }
            )
        ) {
            val articleId = requireNotNull(it.arguments?.getString(Screen.Detail.ARG_ARTICLE_ID))
            ArticleDetail(
                navController = navController,
                articleDetailViewModel(articleId)
            )
        }
        composable(
            Screen.Error.route,
            arguments = listOf(
                navArgument(Screen.Error.ARG_ERROR_MESSAGE) { type = NavType.StringType }
            )
        ) {
            val errorMessage =
                requireNotNull(it.arguments?.getString(Screen.Error.ARG_ERROR_MESSAGE))
            ErrorPage(
                errorMessage = errorMessage,
                navController = navController
            )
        }
    }
}

