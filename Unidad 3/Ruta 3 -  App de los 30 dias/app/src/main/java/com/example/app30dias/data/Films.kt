package com.example.app30dias.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Films(
    @StringRes val day: Int,
    @StringRes val nameFilm: Int,
    @StringRes val directorFilm: Int,
    @StringRes val descriptionFilm: Int,
    @DrawableRes val imageFilm: Int
)
