package com.pucpr.pos.loginscreenkotlin.home

import android.R
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pucpr.pos.loginscreenkotlin.ui.theme.LoginScreenKotlinTheme

@Composable
fun Home(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { btChooseImgOnClick() },
            modifier = Modifier
                .height(120.dp)
                .width(120.dp)
        ) {
            Text(
                text = "Escolher Imagem",
                textAlign = TextAlign.Center,
                style = TextStyle(fontSize = 18.sp)
                )
        }
    }
}

fun btChooseImgOnClick() {

}


@Preview
@Composable
fun PrevHome() {
    LoginScreenKotlinTheme {
        Home()
    }
}