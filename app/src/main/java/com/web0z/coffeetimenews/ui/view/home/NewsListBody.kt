package com.web0z.coffeetimenews.ui.view.home

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import coil.compose.LocalImageLoader
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.google.accompanist.coil.rememberCoilPainter
import com.google.accompanist.imageloading.LoadPainterDefaults
import com.google.accompanist.pager.ExperimentalPagerApi
import com.web0z.coffeetimenews.R
import com.web0z.coffeetimenews.ui.theme.CoffeeTimeNewsTheme
import com.web0z.coffeetimenews.ui.view.Screen
import com.web0z.coffeetimenews.ui.theme.CoffeeTimeNewsTypography
import com.web0z.coffeetimenews.ui.theme.lightBrown2
import com.web0z.coffeetimenews.ui.viewmodel.HomeViewModel
import com.web0z.core.model.Category
import com.web0z.core.model.Article

@ExperimentalPagerApi
@Composable
fun NewsListBody(
    modifier: Modifier,
    viewModel: HomeViewModel,
    onCategorySelected: (Category) -> Unit,
    navController: NavController
) {
    val articlesState = viewModel.state.collectAsState(initial = null).value

    if(articlesState != null) {
        when {
            articlesState.initialLoad || articlesState.loading -> {
                // TODO loading state will come
            }
            articlesState.hasError -> {
                navController.navigate(
                    Screen.Error.route(
                        articlesState.error ?: stringResource(id = R.string.default_error_message)
                    )
                )
            }
            else -> {
                NewsCategoryTabs(
                    articlesState.data!!.selectedHomeCategory,
                    modifier,
                    onCategorySelected
                )

                // TODO will change with lazyColumn
                NewsList(
                    navController,
                    articlesState.data.articlesList
                )
            }
        }
    }
}

@Composable
private fun NewsList(
    navController: NavController,
    articles: List<Article>
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 310.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        articles.forEach { article ->
            ArticleListContent(
                modifier = Modifier
                    .width(375.dp)
                    .height(97.dp)
                    .shadow(4.dp)
                    .align(Alignment.CenterHorizontally),
                article = article,
                navController = navController
            )
        }
    }
}

@Composable
private fun NewsCategoryTabs(
    selectedCategory: Category,
    modifier: Modifier,
    onCategorySelected: (Category) -> Unit
) {
    val selectedIndex = selectedCategory.ordinal

    val categoryTabIndicator = @Composable { tabPositions: List<TabPosition> ->
        Spacer(
            modifier = Modifier
                .tabIndicatorOffset(tabPositions[selectedIndex])
                .height(2.dp)
                .background(MaterialTheme.colors.onPrimary)
        )
    }


    ScrollableTabRow(
        selectedTabIndex = selectedIndex,
        indicator = categoryTabIndicator,
        modifier = modifier,
        backgroundColor = MaterialTheme.colors.primary,
        edgePadding = 15.dp,
    ) {
        Category.values().forEachIndexed { index, category ->
            Tab(
                selected = index == selectedIndex,
                onClick = { onCategorySelected(category) }
            ) {
                Text(
                    text = category.name,
                    style = CoffeeTimeNewsTypography.subtitle1,
                    color = when (selectedIndex == index) {
                        true -> MaterialTheme.colors.onPrimary.copy(alpha = 0.95f)
                        else -> MaterialTheme.colors.onPrimary.copy(alpha = 0.6f)
                    },
                    modifier = Modifier.padding(bottom = 10.dp)
                )
            }
        }
    }
}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun ArticleListContent(
    modifier: Modifier,
    article: Article,
    navController: NavController
) {
    Box(
        modifier = modifier
            .clickable(
                onClick = {
                    navController.navigate(Screen.Detail.route(article.id))
                }
            )
    ) {
        Card(
            shape = RoundedCornerShape(4.dp),
            backgroundColor = MaterialTheme.colors.primaryVariant,
            border = BorderStroke(0.5.dp, lightBrown2),
            modifier = Modifier
                .fillMaxSize()
        ) {
            Row {
                Image(
                    painter = rememberImagePainter(
                        data = article.article_image,
                        imageLoader = LocalImageLoader.current,
                        builder = {
                            if (true == true) this.crossfade(LoadPainterDefaults.FadeInTransitionDuration)
                            placeholder(0)
                        }
                    ),
                    contentDescription = null,
                    modifier = Modifier
                        .width(140.dp)
                        .height(97.dp),
                    contentScale = ContentScale.Crop
                )
                Column(
                    modifier = Modifier
                        .padding(start = 12.dp)
                ) {
                    Text(
                        text = article.article_category,
                        style = CoffeeTimeNewsTypography.caption,
                        color = MaterialTheme.colors.onPrimary.copy(alpha = 0.6f),
                        modifier = Modifier.padding(top = 12.dp)
                    )
                    Text(
                        text = article.title,
                        style = CoffeeTimeNewsTypography.body2,
                        color = MaterialTheme.colors.onPrimary,
                        modifier = Modifier.height(42.dp)
                    )
                    Text(
                        text = "${article.writer}  |  ${article.publish_time}",
                        style = CoffeeTimeNewsTypography.overline,
                        color = MaterialTheme.colors.onPrimary.copy(alpha = 0.75f),
                        modifier = Modifier.padding(top = 3.dp)
                    )
                }
            }
        }
    }
}
