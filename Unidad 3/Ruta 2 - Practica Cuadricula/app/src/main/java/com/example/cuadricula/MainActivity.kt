package com.example.cuadricula

import android.os.Build
import android.os.Bundle
import android.os.ext.SdkExtensions
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cuadricula.data.DataSource
import com.example.cuadricula.model.Topic

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CuadriculaApp()
        }
    }
}

@Composable
fun CuadriculaCard(cuadricula: Topic, modifier: Modifier = Modifier) {
    Card(modifier = Modifier
        .height(78.dp)
        .padding(4.dp)) {
        Row {
            Image(
                painter = painterResource(cuadricula.imageResourceId),
                contentDescription = stringResource(cuadricula.stringResourceId),
                modifier = Modifier
                    .width(68.dp),
                contentScale = ContentScale.Crop
            )
            Column {
                Text(
                    text = stringResource(cuadricula.stringResourceId),
                    modifier = Modifier.padding(
                        start = 16.dp,
                        top = 16.dp,
                        end = 16.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
                Row (modifier = Modifier
                    .padding(top = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center){
                    Image(painter = painterResource(
                        id = R.drawable.puntos),
                        contentDescription = null,
                        modifier = Modifier
                            .height(30.dp)
                            .width(30.dp)
                            .padding(start = 16.dp)
                    )
                    Text(
                        text = cuadricula.numberResource.toString(),
                        modifier = Modifier
                            .padding(start = 8.dp),
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            }
        }
    }
}

@Composable
fun TopicList(cuadriculaList: List<Topic>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        GridCells.Fixed(2)
    ){
        items(cuadriculaList) {cuadricula ->
            CuadriculaCard(
                cuadricula = cuadricula,
                modifier = Modifier)
        }
    }
}

@Composable
fun CuadriculaApp() {
    val layaoutDirection = LocalLayoutDirection.current
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(
                start = WindowInsets.safeDrawing
                    .asPaddingValues()
                    .calculateStartPadding(layaoutDirection),
                end = WindowInsets.safeDrawing
                    .asPaddingValues()
                    .calculateEndPadding(layaoutDirection)
            ),
    ) {
        TopicList(cuadriculaList = DataSource.topics)
    }
}

@Preview(showBackground = true,
    showSystemUi = true)
@Composable
fun GreetingPreview() {
    CuadriculaApp()
}