package com.example.splashscreenjc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.splashscreenjc.ui.theme.SplashScreenJcTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        enableEdgeToEdge()
        setContent {
            SplashScreenJcTheme {
                SplashScreenApp()
            }
        }
    }
}

@Composable
fun SplashScreenApp() {
    var showSplash by remember { mutableStateOf(true) }
    
    if (showSplash) {
        SplashScreen(
            onSplashComplete = {
                showSplash = false
            }
        )
    } else {
        MainScreen()
    }
}

@Composable
fun SplashScreen(onSplashComplete: () -> Unit) {
    var startAnimation by remember { mutableStateOf(false) }
    val alphaAnim = animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(
            durationMillis = 3000
        ), label = ""
    )

    LaunchedEffect(key1 = true) {
        startAnimation = true
        delay(3000)
        onSplashComplete()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(200.dp)
                .alpha(alphaAnim.value),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "SplashScreenJC",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimary,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun MainScreen() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            Greeting(
                name = "Welcome to the App!",
            )
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier,
        fontSize = 24.sp,
        fontWeight = FontWeight.Medium
    )
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    SplashScreenJcTheme {
        SplashScreen(onSplashComplete = {})
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SplashScreenJcTheme {
        Greeting("Android")
    }
}