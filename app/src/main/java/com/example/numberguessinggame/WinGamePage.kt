package com.example.numberguessinggame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.Center
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.numberguessinggame.ui.theme.ButtonColor
import com.example.numberguessinggame.ui.theme.Heading2Color
import com.example.numberguessinggame.ui.theme.HeadingColor
import com.example.numberguessinggame.ui.theme.NumberGuessingGameTheme
import com.example.numberguessinggame.ui.theme.TextColor

@Composable
fun WinGamePage(sonuc: Boolean){
    Column (modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ){
        if (sonuc){
            Image(
                painter = painterResource(R.drawable.winwin),
                contentDescription = ""
            )
        }else{
            Image(
                painter = painterResource(R.drawable.gameoverover),
                contentDescription = ""
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun WinGamePree() {
    NumberGuessingGameTheme {
        //WinGamePage()
    }
}