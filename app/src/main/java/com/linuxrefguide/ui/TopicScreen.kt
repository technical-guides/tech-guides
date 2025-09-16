package com.linuxrefguide.ui

import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.padding
import com.linuxrefguide.content.ContentProvider

@Composable
fun TopicScreen(level: String, id: String) {
    Text(
        text = ContentProvider.getTopicContent(level, id),
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    )
}