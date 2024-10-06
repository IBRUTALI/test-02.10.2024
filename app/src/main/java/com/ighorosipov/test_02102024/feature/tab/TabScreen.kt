package com.ighorosipov.test_02102024.feature.tab

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ighorosipov.test_02102024.feature.navigation.components.bottom_navigation.MainBottomNavigation
import com.ighorosipov.test_02102024.feature.navigation.components.tab_nav_graphs.TabNavGraph

@Composable
fun TabScreen(
    navController: NavHostController = rememberNavController()
) {
    Scaffold(
        bottomBar = {
            MainBottomNavigation(
                navController = navController
            )
        }
    ) { paddingValues ->
        TabNavGraph(
            modifier = Modifier.padding(paddingValues),
            navController = navController
        )
    }
}