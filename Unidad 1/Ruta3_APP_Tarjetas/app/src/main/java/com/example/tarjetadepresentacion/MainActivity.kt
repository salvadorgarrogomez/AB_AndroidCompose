package com.example.tarjetadepresentacion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.tarjetadepresentacion.ui.theme.TarjetaDePresentacionTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TarjetaDePresentacionTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFD2E7D2)
                ) {
                    centralImage(name = "Salvador Garro Gómez",
                        title = "Android Developer Extraordinary"
                    )
                    bottonText(
                        telefono = "+11 (123) 444 555 666",
                        web = "@AndroidDev",
                        email = "jen.doe@android.com"
                    )
                }
            }
        }
    }
}

@Composable
fun centralText (name:String, title: String, modifier: Modifier = Modifier) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = name,
            fontSize = 45.sp,
            fontStyle = FontStyle.Normal,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            lineHeight = 1.em
        )
        Text(
            text = title,
            color = Color(0xFF187A1A),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            lineHeight = 1.em
        )
    }
}

@Composable
fun centralImage (name:String, title: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.logo)
    Box(
        modifier = Modifier.padding(top = 200.dp)
    ){
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(15.dp)
        ){
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .background(Color(0xFF0B4E4E)))
            centralText(name = name,
                title = title
            )
        }
    }
}

@Composable
fun bottonText (telefono: String, web: String, email: String, modifier: Modifier = Modifier) {
    Box (
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 20.dp, end = 20.dp, bottom = 20.dp)
    ){
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(15.dp)
                .fillMaxWidth()
        ){
            Row (
                modifier = modifier.padding(2.dp)
            ){
                Icon(
                    Icons.Rounded.Call,
                    contentDescription = telefono,
                    modifier = modifier.padding(end = 5.dp, start = 45.dp)
                )
                Text(
                    text = telefono,
                    modifier = Modifier.fillMaxWidth()
                        .padding(end = 40.dp),
                    textAlign = TextAlign.Left,
                    lineHeight = 1.em
                )
            }
            Row (
                modifier = modifier.padding(2.dp)
            ){
                Icon(
                    Icons.Rounded.Share,
                    contentDescription = web,
                    modifier = modifier.padding(end = 5.dp, start = 45.dp)
                )
                Text(
                    text = web,
                    modifier = Modifier.fillMaxWidth()
                        .padding(end = 40.dp),
                    textAlign = TextAlign.Left,
                    lineHeight = 1.em
                )
            }
            Row (
                modifier = modifier.padding(2.dp)
            ){
                Icon(
                    Icons.Rounded.Email,
                    contentDescription = email,
                    modifier = modifier.padding(end = 5.dp, start = 45.dp)
                )
                Text(
                    text = email,
                    modifier = Modifier.fillMaxWidth()
                        .padding(end = 40.dp),
                    textAlign = TextAlign.Left,
                    lineHeight = 1.em
                )
            }
        }
    }
}



@Preview(showBackground = true,
    showSystemUi = true)
@Composable
fun GreetingPreview() {
    TarjetaDePresentacionTheme {
        centralImage(
            name = "Salvador Garro Gómez",
            title = "Android Developer Extraordinary"
        )
        bottonText(
            telefono = "+34 (123) 444 555 666",
            web = "@salva_93",
            email = "salva.garro@android.com"
        )
    }
}