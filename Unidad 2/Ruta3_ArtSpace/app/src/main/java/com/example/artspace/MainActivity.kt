package com.example.artspace

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ViewContainer()
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ViewContainer() {
    Scaffold (
        topBar = { Toolbar() },
        content = { ArtInfoSpace() }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar() {
    TopAppBar(
        colors = topAppBarColors(
            containerColor = colorResource(R.color.gray)
        ),
        title = {
            Row (
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 15.dp)
            ){
                Text(
                    text = stringResource(R.string.art_space),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    )
}

@Composable
fun ArtInfoSpace() {
    var currentIndex by remember { mutableStateOf(0) }

    // Muy a tener en cuenta cuando se quieran reflejar listas estaticas de informacion
    val artList = listOf(
        ArtInfo(
            imageRes = R.drawable.golden,
            descriptionRes = R.string.info_golden,
            authorRes = R.string.autor_golden
        ),
        ArtInfo(
            imageRes = R.drawable.bahia,
            descriptionRes = R.string.info_bahia,
            authorRes = R.string.autor_bahia
        ),
        ArtInfo(
            imageRes = R.drawable.bridge,
            descriptionRes = R.string.info_bridge,
            authorRes = R.string.autor_bridge
        ),
        ArtInfo(
            imageRes = R.drawable.rialto,
            descriptionRes = R.string.info_rialto,
            authorRes = R.string.autor_rialto
        )
    )

    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(top = 150.dp, bottom = 60.dp)
        ) {
            Image(
                painter = painterResource(artList[currentIndex].imageRes),
                contentDescription = null,
                modifier = Modifier
                    .size(350.dp)
            )
            Text(
                text = stringResource(artList[currentIndex].descriptionRes),
                textAlign = TextAlign.Left,
                fontStyle = FontStyle.Italic,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(top = 125.dp)
                    .fillMaxWidth(0.7f)
                    .background(colorResource(R.color.gray))
            )
            Text(
                text = stringResource(artList[currentIndex].authorRes),
                textAlign = TextAlign.Left,
                fontSize = 15.sp,
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .background(colorResource(R.color.gray))
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(bottom = 10.dp)
        ) {
            Button(
                onClick = {
                    currentIndex = if (currentIndex - 1 < 0) artList.size - 1
                    else currentIndex - 1
                },
                colors = ButtonDefaults.buttonColors(colorResource(R.color.blue)),
                modifier = Modifier
                    .padding(start = 25.dp)
                    .fillMaxWidth(0.4f)
            ) {
                Text(text = stringResource(R.string.previous))
            }
            Button(
                onClick = {
                    currentIndex = (currentIndex + 1) % artList.size
                },
                colors = ButtonDefaults.buttonColors(colorResource(R.color.blue)),
                modifier = Modifier
                    .padding(start = 50.dp, end = 25.dp)
                    .fillMaxWidth()
            ) {
                Text(text = stringResource(R.string.next))
            }
        }
    }
}

// Recordar los data class de cara a las lista mutables, para no repetir codigo
data class ArtInfo(
    @DrawableRes val imageRes: Int,
    @StringRes val descriptionRes: Int,
    @StringRes val authorRes: Int
)


@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        ViewContainer()
    }
}