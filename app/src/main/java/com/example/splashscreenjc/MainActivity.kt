package com.example.splashscreenjc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.splashscreenjc.ui.theme.SplashScreenJcTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        enableEdgeToEdge()
        setContent {
            SplashScreenJcTheme {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    LearnTextAndModifiers()
                }
            }
        }
    }
}

@Composable
fun LearnTextAndModifiers() {
    val clickOnText = { }

    Text(
        text = "hello",
        color = Color.Red,
        fontSize = 32.sp,
        fontStyle = FontStyle.Italic,
        modifier = Modifier.padding(22.dp)
            .background(Color.Black)
            .clickable(onClick = clickOnText)
    )
}

@Preview(showBackground = true)
@Composable
fun ShowPreview() {
    SplashScreenJcTheme {
        LearnTextAndModifiers()
    }
}