package com.linuxrefguide.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.compose.foundation.clickable
import com.linuxrefguide.content.ContentProvider
import com.linuxrefguide.content.MenuStructure
import com.linuxrefguide.content.NavigationState
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavHostController) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    var currentState by remember { mutableStateOf(NavigationState.MAIN_MENU) }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerContent(currentState) { newState, topicLevel, topicId ->
                currentState = newState
                if (topicId != null) {
                    navController.navigate("topic/$topicLevel/$topicId")
                } else {
                    navController.navigate("menu/$newState")
                }
                scope.launch { drawerState.close() }
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Linux Ref. Guide") },
                    navigationIcon = {
                        IconButton(onClick = { scope.launch { drawerState.open() } }) {
                            Icon(Icons.Default.Menu, contentDescription = "Menu")
                        }
                    }
                )
            }
        ) { padding ->
            Column(modifier = Modifier.padding(padding)) {
                NavHost(navController, startDestination = "welcome") {
                    composable("welcome") { WelcomeScreen() }
                    composable("menu/{state}") { backStackEntry ->
                        val state = backStackEntry.arguments?.getString("state")?.let { NavigationState.valueOf(it) } ?: NavigationState.MAIN_MENU
                        MenuScreen(state)
                    }
                    composable("topic/{level}/{id}") { backStackEntry ->
                        val level = backStackEntry.arguments?.getString("level") ?: ""
                        val id = backStackEntry.arguments?.getString("id") ?: ""
                        TopicScreen(level, id)
                    }
                }
            }
        }
    }
}

@Composable
fun DrawerContent(
    currentState: NavigationState,
    onItemClick: (NavigationState, String?, String?) -> Unit
) {
    LazyColumn {
        items(MenuStructure.getMenuItems(currentState).size) { index ->
            val item = MenuStructure.getMenuItems(currentState)[index]
            ListItem(
                headlineContent = { Text(item.label) },
                modifier = Modifier.clickable {
                    when (item.id) {
                        "basic" -> onItemClick(NavigationState.BASIC_SUBMENU, null, null)
                        "intermediate" -> onItemClick(NavigationState.INTERMEDIATE_SUBMENU, null, null)
                        "advanced" -> onItemClick(NavigationState.ADVANCED_SUBMENU, null, null)
                        "exit" -> { /* No-op for free version */ }
                        else -> {
                            val level = when (currentState) {
                                NavigationState.BASIC_SUBMENU -> "basic"
                                NavigationState.INTERMEDIATE_SUBMENU -> "intermediate"
                                NavigationState.ADVANCED_SUBMENU -> "advanced"
                                else -> ""
                            }
                            val topicId = item.id.split("-").last()
                            onItemClick(currentState, level, topicId)
                        }
                    }
                }
            )
        }
        if (currentState != NavigationState.MAIN_MENU) {
            item {
                ListItem(
                    headlineContent = { Text("← Back") },
                    modifier = Modifier.clickable {
                        onItemClick(NavigationState.MAIN_MENU, null, null)
                    }
                )
            }
        }
    }
}