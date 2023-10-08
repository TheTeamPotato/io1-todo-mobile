package com.io1.todo.feature.main

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.io1.todo.navigation.bar.ApplicationBottomBar
import com.io1.todo.navigation.graphs.MainNavGraph

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(navController: NavHostController = rememberNavController()) {
    Scaffold(
        bottomBar = { ApplicationBottomBar(navController = navController) }
    ) {
        MainNavGraph(navController = navController)
    }
}
