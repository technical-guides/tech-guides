package com.linuxrefguide.content

import com.linuxrefguide.NavigationState

interface ContentProvider {
    fun getWelcomeMessage(): String
    fun getMenuContent(state: NavigationState): String
    fun getTopicContent(level: String, id: String): String
}