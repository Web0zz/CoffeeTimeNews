package com.web0z.coffeetimenews.ui.util

import com.web0z.coffeetimenews.R
import com.web0z.coffeetimenews.ui.home.Article

val ArticleList = listOf(
    Article(
        R.drawable.elonmusk,
        "Is Elon Musk An \"Alien\"? 1",
        "Micheal Rust"
    ),Article(
        R.drawable.elonmusk,
        "Is Elon Musk An \"Alien\"? 2",
        "Micheal Rust"
    ),Article(
        R.drawable.elonmusk,
        "Is Elon Musk An \"Alien\"? 3",
        "Micheal Rust"
    ),Article(
        R.drawable.elonmusk,
        "Is Elon Musk An \"Alien\"? 4",
        "Micheal Rust"
    ),Article(
        R.drawable.elonmusk,
        "Is Elon Musk An \"Alien\"? 5",
        "Micheal Rust"
    ),Article(
        R.drawable.elonmusk,
        "Is Elon Musk An \"Alien\"? 6",
        "Micheal Rust"
    )
)
val ArticleList2 = listOf(
    Article(
        R.drawable.elon2,
        "Is Elon Musk An \"Alien\"? 1",
        "Micheal Rust"
    ),Article(
        R.drawable.elon2,
        "Is Elon Musk An \"Alien\"? 2",
        "Micheal Rust"
    ),Article(
        R.drawable.elon2,
        "Is Elon Musk An \"Alien\"? 3",
        "Micheal Rust"
    ),Article(
        R.drawable.elon2,
        "Is Elon Musk An \"Alien\"? 4",
        "Micheal Rust"
    ),Article(
        R.drawable.elon2,
        "Is Elon Musk An \"Alien\"? 5",
        "Micheal Rust"
    ),Article(
        R.drawable.elon2,
        "Is Elon Musk An \"Alien\"? 6",
        "Micheal Rust"
    )
)

data class Category(
    val id: Int = 0,
    val name: String
)

val CategoryList = listOf(
    Category(id = 1, "Today"),
    Category(id = 1, "Science"),
    Category(id = 1, "History"),
    Category(id = 1, "Politics"),
    Category(id = 1, "Health"),
)

val SectionList = listOf(
    "Today",
    "Science",
    "History",
    "Politics",
    "Health"
)