package com.guides.content

import com.guides.NavigationState

interface ContentProvider {
    fun getWelcomeMessage(): String
    fun getMenuContent(state: NavigationState): String
    fun getTopicContent(level: String, id: String): String
}