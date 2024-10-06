package com.ighorosipov.test_02102024.feature.navigation.components.bottom_navigation

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.ighorosipov.test_02102024.R
import com.ighorosipov.test_02102024.feature.navigation.Screen
import com.ighorosipov.test_02102024.ui.theme.Grey
import com.ighorosipov.test_02102024.ui.theme.Typography

@Composable
fun MainBottomNavigation(
    navController: NavController,
    showLabel: Boolean = true,
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar(
        modifier = Modifier
            .statusBarsPadding()
            .height(60.dp),
        containerColor = MaterialTheme.colorScheme.secondary
    ) {
        val items = listOf(
            BottomNavigationItem(
                title = stringResource(R.string.devices_screen),
                route = Screen.DevicesGraph.route,
                selectedIcon = ImageVector.vectorResource(R.drawable.ic_phone_fill),
                unselectedIcon = ImageVector.vectorResource(R.drawable.ic_phone_outline),
                hasNotification = false,
            ),
            BottomNavigationItem(
                title = stringResource(R.string.messages_screen),
                route = Screen.MessagesGraph.route,
                selectedIcon = ImageVector.vectorResource(R.drawable.ic_mail_fill),
                unselectedIcon = ImageVector.vectorResource(R.drawable.ic_mail_outline),
                hasNotification = false,
            )
        )

        items.forEach { item ->
            val isCurrentDestination: Boolean = currentDestination?.hierarchy?.any {
                it.route == item.route
            } == true
            NavigationBarItem(
                modifier = Modifier.padding(0.dp),
                colors = androidx.compose.material3.NavigationBarItemDefaults
                    .colors(
                        indicatorColor = MaterialTheme.colorScheme.secondary
                    ),
                selected = isCurrentDestination,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                label = {
                    if (showLabel) Text(
                        text = item.title,
                        style = Typography.bodySmall,
                        color = if (!isCurrentDestination) {
                            Grey
                        } else {
                            MaterialTheme.colorScheme.onTertiary
                        }
                    )
                },
                icon = {
                    BadgedBox(
                        badge = {
                            if (item.hasNotification) {
                                Badge()
                            }
                        }
                    ) {
                        Icon(
                            imageVector = if (isCurrentDestination) {
                                item.selectedIcon
                            } else {
                                item.unselectedIcon
                            },
                            tint = if (isCurrentDestination) {
                                MaterialTheme.colorScheme.onSurface
                            } else {
                                Grey
                            },
                            contentDescription = item.title
                        )
                    }
                }
            )
        }
    }
}