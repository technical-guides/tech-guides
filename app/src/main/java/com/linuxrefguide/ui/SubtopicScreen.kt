package com.linuxrefguide.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

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
        Text(
            text = "${level.replaceFirstChar { it.uppercase() }} Topics",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(subtopics.size) { index ->
                val (id, title) = subtopics[index]
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { navController.navigate("topic/$level/$id") },
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant
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

        Button(
            onClick = { navController.popBackStack("main", inclusive = false) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Back to Main Menu")
        }
    }
}