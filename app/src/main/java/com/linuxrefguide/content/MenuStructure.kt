package com.linuxrefguide.content

object MenuStructure {
    data class MenuItem(val label: String, val id: String, val description: String = "")

    private val MAIN_MENU_ITEMS = listOf(
        MenuItem("Basic Topics", "basic", "Essential Linux fundamentals"),
        MenuItem("Intermediate Topics", "intermediate", "System administration skills"),
        MenuItem("Advanced Topics", "advanced", "Expert-level Linux mastery"),
        MenuItem("Exit", "exit", "Quit")
    )

    private val BASIC_MENU_ITEMS = listOf(
        MenuItem("File Commands", "basic-files", "Creating, copying, moving files"),
        MenuItem("Directory Navigation", "basic-nav", "Moving through the filesystem"),
        MenuItem("File Viewing", "basic-view", "Examining file contents"),
        MenuItem("Permissions", "basic-perms", "Understanding Linux security")
    )

    private val INTERMEDIATE_MENU_ITEMS = listOf(
        MenuItem("Process Management", "inter-process", "Controlling system processes"),
        MenuItem("System Monitoring", "inter-monitor", "Performance analysis tools"),
        MenuItem("Storage & Filesystems", "inter-storage", "Advanced disk management"),
        MenuItem("Shell Scripting", "inter-shell", "Automation and scripting"),
        MenuItem("User Management", "inter-users", "Accounts and permissions"),
        MenuItem("Package Management", "inter-packages", "Software installation"),
        MenuItem("Network Basics", "inter-network", "Basic networking concepts")
    )

    private val ADVANCED_MENU_ITEMS = listOf(
        MenuItem("Kernel & Modules", "adv-kernel", "Low-level system management"),
        MenuItem("Advanced Networking", "adv-network", "Network configuration & security"),
        MenuItem("Security Hardening", "adv-security", "System security & hardening"),
        MenuItem("Virtualization", "adv-virtual", "Containers and VMs"),
        MenuItem("High Availability", "adv-ha", "Clustering and load balancing"),
        MenuItem("System Internals", "adv-internals", "Deep system understanding"),
        MenuItem("Performance Tuning", "adv-performance", "Optimization techniques")
    )

    fun getMenuItems(state: NavigationState): List<MenuItem> {
        return when (state) {
            NavigationState.MAIN_MENU -> MAIN_MENU_ITEMS
            NavigationState.BASIC_SUBMENU -> BASIC_MENU_ITEMS
            NavigationState.INTERMEDIATE_SUBMENU -> INTERMEDIATE_MENU_ITEMS
            NavigationState.ADVANCED_SUBMENU -> ADVANCED_MENU_ITEMS
        }
    }
}