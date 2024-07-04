package com.example.artspace

import androidx.annotation.DrawableRes

data class Art(
    @DrawableRes val image: Int,
    val artist: String,
    val title: String,
    val year: String
)

fun getSamples() =
    listOf(
        Art(
            image = R.drawable.arnolfini,
            artist = "Ян ван Эйк",
            title = "Портрет четы Арнольфини",
            year = "1434"
        ),
        Art(
            image = R.drawable.venera,
            artist = "Сандро Боттичелли",
            title = "Рождение Венеры",
            year = "1482-1486"
        ),
        Art(
            image = R.drawable.vechery,
            artist = "Леонардо Да Винчи",
            title = "Тайная вечеря",
            year = "1495-1498"
        ),
        Art(
            image = R.drawable.adam,
            artist = "Микеланджело Буонарроти",
            title = "Сотворение Адама",
            year = "1511-1512"
        ),
        Art(
            image = R.drawable.madonna,
            artist = "Рафаэль Санти",
            title = "Сикстинская мадонна",
            year = "1513"
        ),
        Art(
            image = R.drawable.ohotniki,
            artist = "Питер Брейгель-старший",
            title = "Охотники на снегу",
            year = "1565"
        ),
        Art(
            image = R.drawable.dozor,
            artist = "Рембрандт Харменс ван Рейн",
            title = "Ночной дозор",
            year = "1642"
        ),
        Art(image = R.drawable.meniny, artist = "Диего Веласкес", title = "Менины", year = "1656"),
        Art(
            image = R.drawable.serezka,
            artist = "Ян Вермеер",
            title = "Девушка с жемчужной сережкой",
            year = "1665"
        ),
        Art(
            image = R.drawable.pompei,
            artist = "Карл Брюллов",
            title = "Последний день Помпеи",
            year = "1830-е"
        ),
    )