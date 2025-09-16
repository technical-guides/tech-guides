package com.linuxrefguide

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.addCallback
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.linuxrefguide.ui.MainScreen
import com.linuxrefguide.ui.SubtopicScreen
import com.linuxrefguide.ui.TopicScreen
import com.linuxrefguide.ui.WelcomeScreen
import com.linuxrefguide.ui.theme.LinuxRefGuideTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LinuxRefGuideTheme {
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
    NavHost(navController = navController, startDestination = "main") {
        composable("main") {
            MainScreen(navController = navController)
        }
        composable("welcome") {
            WelcomeScreen(navController = navController)
        }
        composable("subtopics/{level}") { backStackEntry ->
            val level = backStackEntry.arguments?.getString("level") ?: "basic"
            SubtopicScreen(navController = navController, level = level)
        }
        composable("topic/{level}/{id}") { backStackEntry ->
            val level = backStackEntry.arguments?.getString("level") ?: "basic"
            val id = backStackEntry.arguments?.getString("id") ?: "files"
            TopicScreen(navController = navController, level = level, id = id)
        }
    }
}