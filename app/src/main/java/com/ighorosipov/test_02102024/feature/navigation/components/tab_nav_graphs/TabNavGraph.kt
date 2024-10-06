package com.ighorosipov.test_02102024.feature.navigation.components.tab_nav_graphs

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.ighorosipov.test_02102024.feature.navigation.Screen

@Composable
fun TabNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {

    NavHost(
        navController = navController,
        startDestination = Screen.TabGraph.route
    ) {
        navigation(
            startDestination = Screen.DevicesGraph.route,
            route = Screen.TabGraph.route
        ) {
            composable(route = Screen.DevicesGraph.route) {
                DevicesScreenNavGraph(modifier = modifier)
            }
            composable(route = Screen.MessagesGraph.route) {
                MessagesScreenNavGraph(modifier = modifier)
            }
        }
    }
}