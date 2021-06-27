package com.web0z.coffeetimenews.ui.util

import com.web0z.coffeetimenews.R

val ArticleList = listOf(
    ExArticle(
        R.drawable.elonmusk,
        "Is Elon Musk An \"Alien\"? 1",
        "Micheal Rust"
    ),ExArticle(
        R.drawable.elonmusk,
        "Is Elon Musk An \"Alien\"? 2",
        "Micheal Rust"
    ),ExArticle(
        R.drawable.elonmusk,
        "Is Elon Musk An \"Alien\"? 3",
        "Micheal Rust"
    ),ExArticle(
        R.drawable.elonmusk,
        "Is Elon Musk An \"Alien\"? 4",
        "Micheal Rust"
    ),ExArticle(
        R.drawable.elonmusk,
        "Is Elon Musk An \"Alien\"? 5",
        "Micheal Rust"
    ),ExArticle(
        R.drawable.elonmusk,
        "Is Elon Musk An \"Alien\"? 6",
        "Micheal Rust"
    )
)
val ArticleList2 = listOf(
    ExArticle(
        R.drawable.elon2,
        "Is Elon Musk An \"Alien\"? 1",
        "Micheal Rust"
    ),ExArticle(
        R.drawable.elon2,
        "Is Elon Musk An \"Alien\"? 2",
        "Micheal Rust"
    ),ExArticle(
        R.drawable.elon2,
        "Is Elon Musk An \"Alien\"? 3",
        "Micheal Rust"
    ),ExArticle(
        R.drawable.elon2,
        "Is Elon Musk An \"Alien\"? 4",
        "Micheal Rust"
    ),ExArticle(
        R.drawable.elon2,
        "Is Elon Musk An \"Alien\"? 5",
        "Micheal Rust"
    ),ExArticle(
        R.drawable.elon2,
        "Is Elon Musk An \"Alien\"? 6",
        "Micheal Rust"
    )
)

data class ExArticle(
    val poster: Int,
    val title: String,
    val author: String,
    var date: String = "June 22",
    var section: String = "Science",
    var articleDetail: String = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In pellentesque quisque sed facilisis vitae, mauris pretium, odio bibendum. Semper risus arcu adipiscing varius. Porta purus diam diam sed. Quis sit sed adipiscing sed egestas dui bibendum risus. Praesent adipiscing non facilisis integer in. Varius fusce est dictum id dolor aliquam lorem. Nunc malesuada lorem facilisi semper elit tempus velit.\n" +
            "\n" +
            "Urna orci molestie vestibulum, orci, mauris duis aliquam, fringilla id. Arcu, morbi eleifend tortor feugiat. Auctor risus, facilisis id auctor ornare proin et vitae orci. Turpis diam gravida non quis." +"Lorem ipsum dolor sit amet, consectetur adipiscing elit. In pellentesque quisque sed facilisis vitae, mauris pretium, odio bibendum. Semper risus arcu adipiscing varius. Porta purus diam diam sed. Quis sit sed adipiscing sed egestas dui bibendum risus. Praesent adipiscing non facilisis integer in. Varius fusce est dictum id dolor aliquam lorem. Nunc malesuada lorem facilisi semper elit tempus velit.\n" +
            "\n" +
            "Urna orci molestie vestibulum, orci, mauris duis aliquam, fringilla id. Arcu, morbi eleifend tortor feugiat. Auctor risus, facilisis id auctor ornare proin et vitae orci. Turpis diam gravida non quis." +
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In pellentesque quisque sed facilisis vitae, mauris pretium, odio bibendum. Semper risus arcu adipiscing varius. Porta purus diam diam sed. Quis sit sed adipiscing sed egestas dui bibendum risus. Praesent adipiscing non facilisis integer in. Varius fusce est dictum id dolor aliquam lorem. Nunc malesuada lorem facilisi semper elit tempus velit.\n" +
            "\n" +
            "Urna orci molestie vestibulum, orci, mauris duis aliquam, fringilla id. Arcu, morbi eleifend tortor feugiat. Auctor risus, facilisis id auctor ornare proin et vitae orci. Turpis diam gravida non quis." +
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In pellentesque quisque sed facilisis vitae, mauris pretium, odio bibendum. Semper risus arcu adipiscing varius. Porta purus diam diam sed. Quis sit sed adipiscing sed egestas dui bibendum risus. Praesent adipiscing non facilisis integer in. Varius fusce est dictum id dolor aliquam lorem. Nunc malesuada lorem facilisi semper elit tempus velit.\n" +
            "\n" +
            "Urna orci molestie vestibulum, orci, mauris duis aliquam, fringilla id. Arcu, morbi eleifend tortor feugiat. Auctor risus, facilisis id auctor ornare proin et vitae orci. Turpis diam gravida non quis." +
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In pellentesque quisque sed facilisis vitae, mauris pretium, odio bibendum. Semper risus arcu adipiscing varius. Porta purus diam diam sed. Quis sit sed adipiscing sed egestas dui bibendum risus. Praesent adipiscing non facilisis integer in. Varius fusce est dictum id dolor aliquam lorem. Nunc malesuada lorem facilisi semper elit tempus velit.\n" +
            "\n" +
            "Urna orci molestie vestibulum, orci, mauris duis aliquam, fringilla id. Arcu, morbi eleifend tortor feugiat. Auctor risus, facilisis id auctor ornare proin et vitae orci. Turpis diam gravida non quis."

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