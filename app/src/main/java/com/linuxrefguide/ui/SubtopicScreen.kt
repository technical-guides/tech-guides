package com.linuxrefguide.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.linuxrefguide.ui.theme.DarkHeaderBackground
import com.linuxrefguide.ui.theme.DarkPurpleBackground
import com.linuxrefguide.ui.theme.GreenBackground

@Composable
fun SubtopicScreen(navController: NavController, level: String) {
    val subtopics = when (level) {
        "basic" -> listOf(
            "files" to "File Commands",
            "nav" to "Directory Navigation",
            "view" to "File Viewing",
            "perms" to "Permissions"
        )
        "intermediate" -> listOf(
            "process" to "Process Management",
            "monitor" to "System Monitoring",
            "storage" to "Storage & Filesystems",
            "shell" to "Shell Scripting",
            "users" to "User Management",
            "packages" to "Package Management",
            "network" to "Network Basics"
        )
        "advanced" -> listOf(
            "kernel" to "Kernel & Modules",
            "network" to "Advanced Networking",
            "security" to "Security Hardening",
            "virtual" to "Virtualization",
            "ha" to "High Availability",
            "internals" to "System Internals",
            "performance" to "Performance Tuning"
        )
        else -> emptyList()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Spacer(modifier = Modifier.height(24.dp)) // Add space above back button

        Button(
            onClick = { navController.popBackStack("main", inclusive = false) },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(
                containerColor = GreenBackground
            )
        ) {
            Text(
                text = "Back to Main Menu",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = DarkHeaderBackground
            )
        ) {
            Text(
                text = "${level.replaceFirstChar { it.uppercase() }} Topics",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.onPrimary,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            )
        }

        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(subtopics) { (id, title) ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { navController.navigate("topic/$level/$id") },
                    colors = CardDefaults.cardColors(
                        containerColor = GreenBackground
                    )
                ) {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}