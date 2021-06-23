package com.web0z.coffeetimenews.ui.home

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.web0z.coffeetimenews.ui.theme.CoffeeTimeNewsTypography
import com.web0z.coffeetimenews.ui.theme.lightBrown2
import com.web0z.coffeetimenews.ui.util.ArticleList
import com.web0z.coffeetimenews.ui.util.Category

@ExperimentalPagerApi
@Composable
fun NewsListBody(
    modifier: Modifier,
    sectionList: List<Category>,
    selectedCategory: Category,
    onCategorySelected: (Category) -> Unit,
    navigateToArticle: (String) -> Unit
) {
    NewsCategoryTabs(sectionList, selectedCategory, modifier, onCategorySelected)

    // TODO will change with lazyColumn
    NewsList(navigateToArticle)
}

@Composable
private fun NewsList(navigateToArticle: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 310.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        ArticleList.forEach { article ->
            ArticleListContent(
                modifier = Modifier
                    .width(375.dp)
                    .height(97.dp)
                    .shadow(4.dp)
                    .align(Alignment.CenterHorizontally),
                article = article,
                navigateToArticle = navigateToArticle
            )
        }
    }
}

@Composable
private fun NewsCategoryTabs(
    sectionList: List<Category>,
    selectedCategory: Category,
    modifier: Modifier,
    onCategorySelected: (Category) -> Unit
) {
    val selectedIndex = sectionList.indexOfFirst { it == selectedCategory }

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
        // TODO function will taken from viewmodel later
        sectionList.forEachIndexed { index, category ->
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

@Composable
fun ArticleListContent(
    modifier: Modifier,
    article: Article,
    navigateToArticle: (String) -> Unit
) {
    Box(
        // TODO click fun will replace with model data id
        modifier = modifier
            .clickable(onClick = {navigateToArticle(article.title)})
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
                    painter = painterResource(id = article.poster),
                    contentDescription = null,
                    modifier = Modifier
                        .width(140.dp)
                        .height(97.dp),
                    contentScale = ContentScale.FillHeight
                )
                Column(
                    modifier = Modifier
                        .padding(start = 12.dp)
                ) {
                    Text(
                        text = article.section,
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
                        text = "${article.author}  |  ${article.date}",
                        style = CoffeeTimeNewsTypography.overline,
                        color = MaterialTheme.colors.onPrimary.copy(alpha = 0.75f),
                        modifier = Modifier.padding(top = 3.dp)
                    )
                }
            }
        }
    }
}
