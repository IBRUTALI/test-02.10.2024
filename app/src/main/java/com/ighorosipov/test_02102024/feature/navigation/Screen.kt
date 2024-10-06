package com.ighorosipov.test_02102024.feature.navigation

import androidx.annotation.StringRes
import com.ighorosipov.test_02102024.R

sealed class Screen(
    val route: String,
) {

    data object RootGraph : Screen(route = "root_graph")

    data object TabGraph : Screen(route = "tab_graph") {
        data class Tab(
            @StringRes val labelStringId: Int = R.string.tab_screen,
        ) : Screen(route = "tab_screen")
    }

    data object DevicesGraph : Screen(route = "devices_graph") {
        data class DevicesScreen(
            @StringRes val labelStringId: Int = R.string.devices_screen,
        ) : Screen(route = "devices_screen")
    }

    data object MessagesGraph : Screen(route = "messages_graph") {
        data class MessagesScreen(
            @StringRes val labelStringId: Int = R.string.messages_screen,
        ) : Screen(route = "messages_screen")
    }

}