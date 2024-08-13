package com.example.cuadrante

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cuadrante.ui.theme.CuadranteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CuadranteTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    allCuandrantes(
                        textText = "Text composable",
                        text_1_Text = "Displays text and follows the recommended Material Design guidelines.",
                        textImage = "Image composable",
                        text_1_Image = "Creates a composable that lays out and draws a given Painter class object.",
                        textRow = "Row composable",
                        text_1_Row = "A layout composable that places its children in a horizontal sequence.",
                        textColumn = "Column composable",
                        text_1_Column = "A layout composable that places its children in a vertical sequence.",
                    )
                }
            }
        }
    }
}

@Composable
fun cuadranteText (textText: String, text_1_Text: String, modifier: Modifier = Modifier) {

    Row (
        modifier = modifier
            .fillMaxWidth(0.5f)
            .fillMaxHeight(0.5f)
            .background(Color(0xFFEADDFF))
    ){
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize().padding(top = 140.dp)
        ){
            Text(
                text = textText,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp),
            )
            Text(
                text = text_1_Text,
                textAlign = TextAlign.Justify
            )
        }
    }
}

@Composable
fun cuadranteImage (textImage: String, text_1_Image: String, modifier: Modifier = Modifier) {

    Row (
        modifier = Modifier
            .fillMaxHeight(0.5f)
            .background(Color(0xFFD0BCFF))
    ){
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize().padding(top = 140.dp)
        ){
            Text(
                text = textImage,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Text(
                text = text_1_Image,
                textAlign = TextAlign.Justify
            )
        }
    }
}


@Composable
fun cuadranteRow (textRow: String, text_1_Row: String, modifier: Modifier = Modifier) {

    Row (
        modifier = Modifier
            .fillMaxWidth(0.5f)
            .fillMaxSize()
            .background(Color(0xFFB69DF8))
    ){
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize().padding(top = 140.dp)
        ){
            Text(
                text = textRow,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)

            )
            Text(
                text = text_1_Row,
                textAlign = TextAlign.Justify

            )
        }
    }
}

@Composable
fun cuadranteColumn (textColumn: String, text_1_Column: String, modifier: Modifier = Modifier) {
    Row (
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF6EDFF))
    ){
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize().padding(top = 140.dp)
        ){
            Text(
                text = textColumn,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Text(
                text = text_1_Column,
                textAlign = TextAlign.Justify
            )
        }
    }
}

@Composable
fun allCuandrantes (textText: String, text_1_Text: String, textImage: String, text_1_Image: String,
                    textRow: String, text_1_Row: String, textColumn: String, text_1_Column: String, modifier: Modifier = Modifier) {
    Box (
        modifier = Modifier
    )
    {
        Column {
            Row {
                cuadranteText(
                    textText = textText,
                    text_1_Text = text_1_Text,
                )
                cuadranteImage(
                    textImage = textImage,
                    text_1_Image = text_1_Image,
                )
            }
            Row {
                cuadranteRow(
                    textRow = textRow,
                    text_1_Row = text_1_Row,
                )
                cuadranteColumn(
                    textColumn = textColumn,
                    text_1_Column = text_1_Column,
                )
            }
        }
    }
}


@Preview(showBackground = true,
    showSystemUi = true)
@Composable
fun GreetingPreview() {
    CuadranteTheme {
        allCuandrantes(
            textText = "Text composable",
            text_1_Text = "Displays text and follows the recommended Material Design guidelines.",
            textImage = "Image composable",
            text_1_Image = "Creates a composable that lays out and draws a given Painter class object.",
            textRow = "Row composable",
            text_1_Row = "A layout composable that places its children in a horizontal sequence.",
            textColumn = "Column composable",
            text_1_Column = "A layout composable that places its children in a vertical sequence.",
        )
    }
}