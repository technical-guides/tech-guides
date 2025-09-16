package com.linuxrefguide.ui

import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.padding
import com.linuxrefguide.content.ContentProvider
import com.linuxrefguide.content.NavigationState

@Composable
fun MenuScreen(state: NavigationState) {
    Text(
        text = ContentProvider.getMenuContent(state),
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    )
}