package com.pucpr.pos.loginscreenkotlin.home

import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pucpr.pos.loginscreenkotlin.repository.StorageRepository
import com.pucpr.pos.loginscreenkotlin.ui.theme.LoginScreenKotlinTheme

@Composable
fun Home(){
    var selectedImageUri by remember { mutableStateOf<Uri?>(null) }
    val galleryLauncher = rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent(), onResult = { uri: Uri? ->
        selectedImageUri = uri
    })

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                galleryLauncher.launch("image/*")
                Log.d("ImagePath", selectedImageUri?.lastPathSegment.toString())
                selectedImageUri?.let {
                    val imageName = it.lastPathSegment ?: ""
                    StorageRepository.addImage(
                        imagePath = "images",
                        imageName = imageName,
                        it
                    )
                }
            },
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

@Preview
@Composable
fun PrevHome() {
    LoginScreenKotlinTheme {
        Home()
    }
}