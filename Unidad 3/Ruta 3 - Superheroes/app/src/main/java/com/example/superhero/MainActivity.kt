package com.example.superhero

import android.graphics.Paint.Align
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.example.superhero.data.Hero
import com.example.superhero.model.HeroesRepository.heroes
import com.example.superhero.ui.theme.SuperHeroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HeroApp()
        }
    }
}

@Composable
fun HeroApp() {
    Scaffold (
        topBar = {
            TopAppBar()
        }
    ){
            it ->
        LazyColumn(contentPadding = it) {
            items(heroes) {
                SuperItem(hero = it,
                    modifier = Modifier
                        .padding())
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = {
        Text(
            text = stringResource(R.string.app_name),
            style = MaterialTheme.typography.displayLarge
        )
    })
}

@Composable
fun SuperItem(
    hero: Hero,
    modifier: Modifier = Modifier
) {
    val color = MaterialTheme.colorScheme.inversePrimary
    Card(modifier = modifier
        .padding(8.dp)){
        Column (modifier = Modifier
            .background(color = color)){
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ){
                SuperInfo(hero.nameRes, hero.descriptionRes)
                ImageSuper(hero.imageRes)
            }
        }
    }
}

@Composable
fun SuperInfo(
    @StringRes nameRes: Int,
    @StringRes descriptionRes: Int,
    modifier: Modifier = Modifier
) {
    Column (modifier = modifier
        .height(72.dp)
        .width(275.dp)
        .padding(end = 16.dp)){
        Text(
            text = stringResource(nameRes),
            textAlign = TextAlign.Left,
            style = MaterialTheme.typography.headlineSmall
        )
        Text(
            text = stringResource(descriptionRes),
            textAlign = TextAlign.Left,
            style = MaterialTheme.typography.bodyLarge,
            lineHeight = 1.em
        )
    }
}

@Composable
fun ImageSuper(
    @DrawableRes imageRes: Int,
    modifier: Modifier = Modifier
) {
    Box {
        Image(
            modifier = Modifier
                .size(72.dp),
            contentScale = ContentScale.Crop,
            painter = painterResource(imageRes),
            contentDescription = null
        )
    }
}

@Preview(showBackground = true,
    showSystemUi = true)
@Composable
fun GreetingPreview() {
    HeroApp()
}