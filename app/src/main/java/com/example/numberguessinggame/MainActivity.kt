package com.example.numberguessinggame

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.numberguessinggame.ui.theme.ButtonColor
import com.example.numberguessinggame.ui.theme.HeadingColor
import com.example.numberguessinggame.ui.theme.NumberGuessingGameTheme
import com.example.numberguessinggame.ui.theme.TextColor
import kotlin.reflect.typeOf

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            NumberGuessingGameTheme {
                PageNavigation()
            }
        }
    }
}

@Composable
fun PageNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "main"){
        composable ("main"){
            MainPage(navController = navController)
        }
        composable ("play_game"){
            PlayGamePage(navController = navController)
        }
        composable ("win_game/{sonuc}", arguments = listOf(
            navArgument("sonuc") { type= NavType.BoolType }
        )){
            val sonuc = it.arguments?.getBoolean("sonuc")!!
            WinGamePage(sonuc=sonuc)
        }
    }
}

@Composable
fun MainPage(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Text(
            text = "Guessing Game ",
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold,
            color = HeadingColor
        )
        Spacer(modifier = Modifier.height(25.dp))

        Button(onClick = {
            navController.navigate("play_game")
        },
            colors = ButtonDefaults.buttonColors(
                contentColor = TextColor,
                containerColor = ButtonColor,
            ),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.size(280.dp,42.dp)
            ) {
            Text("Play Game", fontSize = 14.sp)
        }
Color.TRANSPARENT
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NumberGuessingGameTheme {
       PageNavigation()
    }
}