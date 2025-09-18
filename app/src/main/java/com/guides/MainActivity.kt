package com.guides

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.addCallback
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.guides.ui.MainScreen
import com.guides.ui.SubtopicScreen
import com.guides.ui.TopicScreen
import com.guides.ui.theme.GuideTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GuideTheme {
                val navController = rememberNavController()
                // Register back press handler
                onBackPressedDispatcher.addCallback(this) {
                    if (navController.currentDestination?.route == "main") {
                        finish() // Exit app if on main screen
                    } else {
                        navController.popBackStack() // Navigate back
                    }
                }
                AppNavigation(navController)
            }
        }
    }
}

@Composable
fun AppNavigation(navController: NavHostController) {
    val topic = "Linux"
    NavHost(navController = navController, startDestination = "main") {
        composable("main") {
            MainScreen(navController = navController, topic = topic)
        }
        composable("subtopics/{level}") { backStackEntry ->
            val level = backStackEntry.arguments?.getString("level") ?: "N/A"
            SubtopicScreen(navController = navController, topic = topic, level = level)
        }
        composable("topic/{level}/{id}") { backStackEntry ->
            val level = backStackEntry.arguments?.getString("level") ?: "N/A"
            val id = backStackEntry.arguments?.getString("id") ?: "N/A"
            TopicScreen(navController = navController, topic = topic, level = level, id = id)
        }
    }
}
