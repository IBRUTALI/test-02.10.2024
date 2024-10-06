package com.ighorosipov.test_02102024.feature.navigation.components.tab_nav_graphs

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.ighorosipov.test_02102024.feature.devices.presentation.screens.DevicesScreen
import com.ighorosipov.test_02102024.feature.navigation.Screen
import com.ighorosipov.test_02102024.ui.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DevicesScreenNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    val context = LocalContext.current
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination?.route
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    val title = when (currentDestination) {
                        Screen.DevicesGraph.DevicesScreen().route -> {
                            context.resources.getString(
                                Screen.DevicesGraph.DevicesScreen().labelStringId
                            )
                        }

                        else -> null
                    }
                    title?.let {
                        Text(
                            text = title,
                            style = Typography.titleLarge
                        )
                    }
                },
                navigationIcon = {
                    if (navController.previousBackStackEntry != null) {
                        IconButton(onClick = { navController.navigateUp() }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Back"
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.background)
            )
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            route = Screen.DevicesGraph.route,
            startDestination = Screen.DevicesGraph.DevicesScreen().route
        ) {
            composable(
                route = Screen.DevicesGraph.DevicesScreen().route
            ) {
                DevicesScreen(
                    modifier = modifier.padding(paddingValues),
                    navController = navController
                )
            }
        }
    }
}