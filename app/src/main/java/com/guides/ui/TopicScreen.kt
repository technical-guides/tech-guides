package com.guides.ui

import android.util.Log
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
import com.guides.ui.theme.DarkHeaderBackground
import androidx.compose.ui.graphics.RectangleShape
import com.guides.content.ContentProviderFactory
import com.guides.ui.theme.GreenBackground

@Composable
fun TopicScreen(navController: NavController, topic: String, level: String, id: String) {
    // Log level, id, and content for debugging
    val provider = ContentProviderFactory.getContentProvider(topic)
    val content = provider.getTopicContent(level, id).ifEmpty {
        "No content found for level: $level, id: $id"
    }
    Log.d("TopicScreen", "Rendering topic for level: $level, id: $id, content: $content")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Spacer(modifier = Modifier.height(24.dp)) // Add space above back button

        Button(
            onClick = { navController.popBackStack("subtopics/$level", inclusive = false) },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(
                containerColor = GreenBackground
            )
        ) {
            Text(
                text = "Back to ${level.replaceFirstChar { it.uppercase() }} Topics",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = DarkHeaderBackground
            )
        ) {
            Text(
                text = id.replaceFirstChar { it.uppercase() },
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.onPrimary,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            )
        }

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
//                // Debug: Display level and id on-screen
//                Text(
//                    text = "Debug: level=$level, id=$id",
//                    style = MaterialTheme.typography.bodySmall,
//                    color = MaterialTheme.colorScheme.onBackground,
//                    modifier = Modifier.fillMaxWidth()
//                )

                Text(
                    text = content,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}