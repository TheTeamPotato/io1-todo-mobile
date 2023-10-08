package com.io1.todo.feature.onboarding.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun OnboardingScreenRoute(onMainButtonClick: () -> Unit) {
    OnboardingScreen(onMainButtonClick = onMainButtonClick)
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun OnboardingScreen(onMainButtonClick: () -> Unit = {}) {
    Scaffold(modifier = Modifier
        .fillMaxSize(),
        containerColor = Color.Black,
        topBar = {

        },
        content = {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Onboarding", color = Color.White)
                Button(onClick = { onMainButtonClick() }) {
                    Text(text = "Go to main screen")
                }
            }
        }
    )
}