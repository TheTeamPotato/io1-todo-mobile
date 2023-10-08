package com.io1.todo.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.io1.todo.feature.dashboard.view.DashboardScreenRoute
import com.io1.todo.feature.settings.view.SettingsScreenRoute
import com.io1.todo.navigation.bar.AppBottomNavItem
import com.io1.todo.navigation.utils.Graph

@Composable
fun MainNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.MAIN,
        startDestination = AppBottomNavItem.Dashboard.route
    ) {
        composable(route = AppBottomNavItem.Dashboard.route) {
            DashboardScreenRoute()
        }
        composable(route = AppBottomNavItem.Settings.route) {
            SettingsScreenRoute()
        }
    }
}

