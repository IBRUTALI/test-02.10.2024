package com.ighorosipov.test_02102024

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import androidx.navigation.compose.rememberNavController
import com.ighorosipov.test_02102024.feature.navigation.components.tab_nav_graphs.RootGraph
import com.ighorosipov.test_02102024.ui.theme.Test02102024Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test02102024Theme {
                Surface {
                    RootGraph(
                        navController = rememberNavController()
                    )
                }
            }
        }
    }
}