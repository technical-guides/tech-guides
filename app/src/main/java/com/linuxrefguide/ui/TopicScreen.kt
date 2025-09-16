package com.linuxrefguide.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.linuxrefguide.content.ContentProvider

@Composable
fun TopicScreen(navController: NavController, level: String, id: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = id.replaceFirstChar { it.uppercase() },
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Text(
            text = ContentProvider.getTopicContent(level, id),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
        )

        Button(
            onClick = { navController.popBackStack("subtopics/$level", inclusive = false) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Back to ${level.replaceFirstChar { it.uppercase() }} Topics")
        }
    }
}