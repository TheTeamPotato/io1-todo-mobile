package com.io1.todo.navigation.graphs

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.google.accompanist.pager.ExperimentalPagerApi
import com.io1.todo.feature.onboarding.view.OnboardingScreenRoute
import com.io1.todo.navigation.utils.Graph

@OptIn(ExperimentalAnimationApi::class, ExperimentalPagerApi::class)
fun NavGraphBuilder.authNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.AUTH,
        startDestination = AuthScreen.Onboarding.route
    ) {
        composable(route = AuthScreen.Onboarding.route) {
            OnboardingScreenRoute(onMainButtonClick = {
                navController.navigate(route = Graph.MAIN) {
                    popUpTo(route = Graph.AUTH) {
                        inclusive = true
                    }
                }
            })
        }
    }
}

sealed class AuthScreen(val route: String) {
    data object Onboarding : AuthScreen(route = "ONBOARDING")
}