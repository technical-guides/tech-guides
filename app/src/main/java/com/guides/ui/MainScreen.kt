package com.guides.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.guides.ui.theme.DarkHeaderBackground

@Composable
fun MainScreen(navController: NavController, topic: String) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(120.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = DarkHeaderBackground
            )
        ) {
            Text(
                text = "$topic Ref. Guide",
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.onPrimary,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            )
        }

        // Basic Topics
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { navController.navigate("subtopics/basics") },
            colors = CardDefaults.cardColors(
                containerColor = DarkHeaderBackground
            )
        ) {
            Text(
                text = "Basics",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }

        // Intermediate Topics
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { navController.navigate("subtopics/intermediate") },
            colors = CardDefaults.cardColors(
                containerColor = DarkHeaderBackground
            )
        ) {
            Text(
                text = "Intermediate",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }

        // Advanced Topics
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { navController.navigate("subtopics/advanced") },
            colors = CardDefaults.cardColors(
                containerColor = DarkHeaderBackground
            )
        ) {
            Text(
                text = "Advanced",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.weight(1f))
    }
}