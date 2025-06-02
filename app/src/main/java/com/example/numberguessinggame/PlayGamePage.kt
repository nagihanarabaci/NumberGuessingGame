package com.example.numberguessinggame

import android.R
import android.os.Bundle
import android.util.Log
import androidx.compose.foundation.layout.Arrangement.Center
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.numberguessinggame.ui.theme.ButtonColor
import com.example.numberguessinggame.ui.theme.Heading2Color
import com.example.numberguessinggame.ui.theme.HeadingColor
import com.example.numberguessinggame.ui.theme.MainColor

import com.example.numberguessinggame.ui.theme.NumberGuessingGameTheme
import com.example.numberguessinggame.ui.theme.TextColor
import kotlin.random.Random

@Composable
fun PlayGamePage(navController : NavController){

    var guessNumber by remember { mutableStateOf("") }
    var randomNumber by remember { mutableStateOf(0) }
    var remainingNumber by remember { mutableStateOf(5) }
    var routeNumber by remember { mutableStateOf("") }
    Column (modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Center
    ){
        LaunchedEffect(key1 = true) {
            randomNumber= Random.nextInt(101)
            Log.e("random $randomNumber","")
        }
        Text(
            text = "Number Guessing Game ",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 28.sp,
            color = HeadingColor
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = "Guess a number between 1 and 100 ",
            fontWeight = FontWeight.Bold,
            color = Heading2Color
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = "Your remaining right to guess: $remainingNumber",
            fontWeight = FontWeight.Bold,
            color = MainColor
        )
        Spacer(modifier = Modifier.height(25.dp))
        OutlinedTextField(
            value = guessNumber,
            onValueChange = { guessNumber = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)

        )
        Spacer(modifier = Modifier.height(15.dp))

        Button(onClick = {
            remainingNumber = remainingNumber-1
            val guess = guessNumber.toInt()
            if (guess == randomNumber){
                navController.navigate("win_game/true"){
                    popUpTo("play_game") { inclusive=true }
                }
                return@Button // bu kodla butonun çaloşması durur
            }
            if (guess > randomNumber){
                routeNumber = "Decrease"

            }
            if (guess < randomNumber){
                routeNumber = "Increase"

            }
            if (remainingNumber == 0){
                navController.navigate("win_game/false"){
                    popUpTo("play_game") { inclusive=true }
                }
            }
            guessNumber = ""

        },
            modifier = Modifier.size(280.dp,42.dp),
            colors = ButtonDefaults.buttonColors(
                contentColor = TextColor,
                containerColor = ButtonColor,
            ),
            shape = RoundedCornerShape(8.dp)) {
            Text("GUESS")
        }
        Spacer(modifier = Modifier.height(25.dp))
        Text(
            text = "Guess lower $routeNumber",
            color = Heading2Color
        )

    }
}

@Preview(showBackground = true)
@Composable
fun PlayGamePre() {
    NumberGuessingGameTheme {
       // PlayGamePage()
    }
}