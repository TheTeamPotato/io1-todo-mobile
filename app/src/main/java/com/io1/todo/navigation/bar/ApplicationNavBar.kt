package com.io1.todo.navigation.bar

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.io1.todo.utils.testtag.navbar.NavBarTestTags

sealed class AppBottomNavItem(
    val route: String,
    val title: String,
    val icon: ImageVector,
    val contentDescription: String,
    var testTag: String
) {
    data object Dashboard : AppBottomNavItem(
        route = "DASHBOARD",
        title = "Dashboard",
        icon = Icons.Default.Home,
        contentDescription = "Navigation Bar Dashboard Item",
        testTag = NavBarTestTags.DASHBOARD
    )

    data object Settings : AppBottomNavItem(
        route = "SETTINGS",
        title = "Settings",
        icon = Icons.Default.Settings,
        contentDescription = "Navigation Bar Settings Item",
        testTag = NavBarTestTags.SETTINGS
    )
}

@Composable
fun ApplicationBottomBar(navController: NavHostController) {
    val screens = listOf(
        AppBottomNavItem.Dashboard,
        AppBottomNavItem.Settings
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val bottomBarDestination = screens.any { it.route == currentDestination?.route }

    if (bottomBarDestination) {
        NavigationBar(containerColor = Color(0xFF222222), contentColor = Color.White) {
            screens.forEach { screen ->
                AddBottomNavigationItem(
                    screen = screen,
                    currentDestination = currentDestination,
                    navController = navController,
                    contentDescription = screen.contentDescription,
                    testTag = screen.testTag
                )
            }
        }
    }
}

@Composable
fun RowScope.AddBottomNavigationItem(
    screen: AppBottomNavItem,
    currentDestination: NavDestination?,
    navController: NavHostController,
    contentDescription: String,
    testTag: String
) {
    NavigationBarItem(
        modifier = Modifier.testTag(testTag),
        label = { Text(text = screen.title) },
        icon = { Icon(imageVector = screen.icon, contentDescription = contentDescription) },
        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
        colors = NavigationBarItemDefaults.colors(
            selectedTextColor = Color.White,
            selectedIconColor = Color.White,
            indicatorColor = Color(0xFF222222),
            unselectedIconColor = LocalContentColor.current.copy(alpha = 0.38f),
            unselectedTextColor = LocalContentColor.current.copy(alpha = 0.38f),
        ),
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}