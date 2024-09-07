package com.example.app30dias.screen

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.app30dias.R
import com.example.app30dias.data.Films
import com.example.app30dias.model.FilmsRepository

@Composable
fun MainApp(){
    Scaffold (
        topBar = {
            TopAppBar()
        }
    ){
            it ->
        LazyColumn(contentPadding = it) {
            items(FilmsRepository.films.reversed()) {
                FilmCard(films = it)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(
    modifier: Modifier = Modifier
){
    val color = MaterialTheme.colorScheme.tertiaryContainer
    CenterAlignedTopAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = color),
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = color
        ),
        title = {
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
            ){
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.labelLarge
                )
                Text(
                    text = stringResource(R.string._30_dias_30_peliculas),
                    style = MaterialTheme.typography.titleLarge,
                )
            }
        }
    )
}

@Composable
fun FilmCard (
    films: Films,
) {
    var expanded by remember { mutableStateOf(false) }
    val color = MaterialTheme.colorScheme.outlineVariant
    Card (modifier = Modifier
        .padding(16.dp)){
        Column (modifier = Modifier
            .background(color = color)
        ){
            FilmTitle(
                day = films.day,
                nameFilm = films.nameFilm)
            FilmImage(
                imageFilm = films.imageFilm,
                expanded = expanded,
                onClick = {expanded = !expanded}
            )
        }
        if (expanded) {
            FilmInfoAdition(
                directorFilm = films.directorFilm,
                descriptionFilm = films.descriptionFilm)
        }
    }
}

@Composable
fun FilmImage(
    @DrawableRes imageFilm: Int,
    expanded: Boolean,
    onClick: () -> Unit,
) {
    Column (
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Image(
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .clickable { onClick() },
            painter = painterResource(imageFilm),
            contentDescription = null
        )
    }
}

@Composable
fun FilmTitle(
    @StringRes day: Int,
    @StringRes nameFilm: Int,
) {
    Column (
        modifier = Modifier
            .padding(16.dp)
    ){
        Text(
            text = stringResource(day),
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Left
        )
        Spacer(modifier = Modifier
            .size(8.dp))
        Text(
            text = stringResource(nameFilm),
            style = MaterialTheme.typography.labelMedium,
            textAlign = TextAlign.Left
        )
    }
}

@Composable
fun FilmInfoAdition(
    @StringRes directorFilm: Int,
    @StringRes descriptionFilm: Int,
) {
    Column (
        modifier = Modifier
            .padding(16.dp)
    ){
        Row {
            Text(
                text = stringResource(R.string.posicion),
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Left)
            Text(
                text = stringResource(directorFilm),
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Left
            )
        }
        Spacer(modifier = Modifier
            .size(8.dp))
        Text(
            text = stringResource(descriptionFilm),
            style = MaterialTheme.typography.labelSmall,
            textAlign = TextAlign.Left
        )
    }
}

@Preview(showBackground = true,
    showSystemUi = true)
@Composable
fun GreetingPreview() {
    MainApp()
}