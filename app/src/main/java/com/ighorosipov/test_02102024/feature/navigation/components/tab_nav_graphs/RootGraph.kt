package com.ighorosipov.test_02102024.feature.navigation.components.tab_nav_graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ighorosipov.test_02102024.feature.navigation.Screen
import com.ighorosipov.test_02102024.feature.tab.TabScreen

@Composable
fun RootGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        route = Screen.RootGraph.route,
        startDestination = Screen.TabGraph.route
    ) {
        composable(
            route = Screen.TabGraph.route
        ) {
            TabScreen()
        }
    }
}