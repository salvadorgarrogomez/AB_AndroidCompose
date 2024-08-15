package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    lemonadeProcess()
                }
            }
        }
    }
}

@Composable
fun lemonadeProcess(modifier: Modifier = Modifier
    .fillMaxSize()
    .wrapContentSize(Alignment.Center)){
    var changeImage by remember {mutableStateOf(1)}

    var clickCount by remember { mutableStateOf(0) }
    val requiredClicks = remember { (2..4).random() }

    val onClick = {
        clickCount++
        if (clickCount >= requiredClicks) {
            changeImage = 3
            clickCount = 0 // Reset the click count if you want to repeat the process
        }
    }

    Surface (
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ){
        when (changeImage) {
            1 -> {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ){

                    Image(
                        painter = painterResource(R.drawable.lemon_tree),
                        contentDescription = stringResource(R.string.lemon_tree),
                        modifier = Modifier
                            .clip(RoundedCornerShape(25.dp))
                            .border(2.dp, Color(0xFF69CDD8))
                            .wrapContentSize()
                            .clickable { changeImage = 2 }
                            .background(Color(0xFF96F5CC))
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = stringResource(R.string.lemon_tree_description),
                        fontSize = 18.sp)
                }
            }
            2 -> {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ){
                    Image(
                        painter = painterResource(R.drawable.lemon_squeeze),
                        contentDescription = stringResource(R.string.lemon),
                        modifier = Modifier
                            .clip(RoundedCornerShape(25.dp))
                            .border(2.dp, Color(0xFF69CDD8))
                            .wrapContentSize()
                            .clickable { onClick() }
                            .background(Color(0xFF96F5CC))
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = stringResource(R.string.lemon_description),
                        fontSize = 18.sp)
                }
            }
            3 -> {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ){
                    Image(
                        painter = painterResource(R.drawable.lemon_drink),
                        contentDescription = stringResource(R.string.glass_of_lemonade_description),
                        modifier = Modifier
                            .clip(RoundedCornerShape(25.dp))
                            .border(2.dp, Color(0xFF69CDD8))
                            .wrapContentSize()
                            .clickable { changeImage = 4 }
                            .background(Color(0xFF96F5CC))
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = stringResource(R.string.glass_of_lemonade_description),
                        fontSize = 18.sp)
                }
            }
            4 -> {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ){
                    Image(
                        painter = painterResource(R.drawable.lemon_restart),
                        contentDescription = stringResource(R.string.empty_glass_description),
                        modifier = Modifier
                            .clip(RoundedCornerShape(25.dp))
                            .border(2.dp, Color(0xFF69CDD8))
                            .wrapContentSize()
                            .clickable { changeImage = 1 }
                            .background(Color(0xFF96F5CC))
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = stringResource(R.string.empty_glass_description),
                        fontSize = 18.sp)
                }
            }
        }
    }
}

@Preview(showBackground = true,
    showSystemUi = true)
@Composable
fun GreetingPreview() {
    LemonadeTheme {
        lemonadeProcess()
    }
}