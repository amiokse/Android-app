package com.example.a1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a1.ui.theme._1Theme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.material3.Button
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _1Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ){
                    App()
                }
            }
        }
    }
}

// 1. Создаёшь enum с названиями экранов
enum class Screen {
    FIRST, SECOND
}

// 2. В главной функции храниш текущий экран
@Composable
fun App() {
    var currentScreen by remember { mutableStateOf(Screen.FIRST) }

    when (currentScreen) {
        Screen.FIRST -> FirstScreen(
            onNavigate = { currentScreen = Screen.SECOND }
        )
        Screen.SECOND -> SecondScreen(
            onNavigate = { currentScreen = Screen.FIRST }
        )
    }
}

// 3. Первый экран
@Composable
fun FirstScreen(onNavigate: () -> Unit) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text("Это первый экран")
        Button(onClick = onNavigate) {
            Text("Перейти на второй")
        }
    }
}

// 4. Второй экран
@Composable
fun SecondScreen(onNavigate: () -> Unit) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text("Это второй экран")
        Button(onClick = onNavigate) {
            Text("Вернуться назад")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    _1Theme {
    }
}

