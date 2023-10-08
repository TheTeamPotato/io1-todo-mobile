package com.io1.todo.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.io1.todo.feature.main.MainScreen
import com.io1.todo.navigation.utils.Graph

@Composable
fun RootNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.AUTH
    ) {
        authNavGraph(navController = navController)
        composable(route = Graph.MAIN) {
            MainScreen()
        }
    }
}