package com.example.app30dias.model

import com.example.app30dias.R
import com.example.app30dias.data.Films

object FilmsRepository {
    val films = listOf(
        Films(
            day = R.string.day01,
            nameFilm = R.string.film01,
            directorFilm = R.string.director01,
            descriptionFilm = R.string.description01,
            imageFilm = R.drawable.image01
        )
    )
}