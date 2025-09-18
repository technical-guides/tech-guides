package com.guides.ui

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
import com.guides.ui.theme.DarkHeaderBackground
import com.guides.ui.theme.GreenBackground

@Composable
fun SubtopicScreen(navController: NavController, topic: String, level: String) {
    var subtopics: List<Pair<String, String>> = emptyList()

    when (topic) {
        "Linux" -> {
            subtopics = when (level) {
                "basics" -> listOf(
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
        }
        "Nmap" -> {
            subtopics = when (level) {
                "basics" -> listOf(
                    "install" to "Installation & Setup",
                    "discovery" to "Host Discovery",
                    "scans" to "Simple Scans",
                    "output" to "Output Formats"
                )

                "intermediate" -> listOf(
                    "ports" to "Port Scanning",
                    "service" to "Service Detection",
                    "os" to "OS Fingerprinting",
                    "timing" to "Timing & Performance"
                )

                "advanced" -> listOf(
                    "scripting" to "Scripting Engine",
                    "evasion" to "Evasion Techniques",
                    "vuln" to "Vulnerability Scanning",
                    "custom" to "Custom Scripts"
                )

                else -> emptyList()
            }
        }
        "BurpSuite" -> {
            subtopics = when (level) {
                "basics" -> listOf(
                    "install" to "Installation & Setup",
                    "proxy" to "Proxy Basics",
                    "intercept" to "Intercepting Traffic",
                    "scope" to "Scope Management"
                )

                "intermediate" -> listOf(
                    "scanner" to "Scanner",
                    "repeater" to "Repeater",
                    "intruder" to "Intruder",
                    "session" to "Session Handling"
                )

                "advanced" -> listOf(
                    "extender" to "Extender",
                    "macros" to "Macros",
                    "plugins" to "Custom Plugins",
                    "attacks" to "Advanced Attacks"
                )

                else -> emptyList()
            }
        }
        "Wireshark" -> {
            subtopics = when (level) {
                "basics" -> listOf(
                    "install" to "Installation & Setup",
                    "capture" to "Packet Capture",
                    "filters" to "Basic Filters",
                    "interface" to "Interface Overview"
                )

                "intermediate" -> listOf(
                    "display" to "Display Filters",
                    "protocol" to "Protocol Analysis",
                    "stats" to "Statistics",
                    "streams" to "Follow Streams"
                )

                "advanced" -> listOf(
                    "filters" to "Custom Filters",
                    "decrypt" to "Decryption",
                    "scripting" to "Lua Scripting",
                    "injection" to "Packet Injection"
                )

                else -> emptyList()
            }
        }
        "Nessus" -> {
            subtopics = when (level) {
                "basics" -> listOf(
                    "install" to "Installation & Setup",
                    "scans" to "Basic Scans",
                    "dashboard" to "Dashboard",
                    "results" to "Scan Results"
                )

                "intermediate" -> listOf(
                    "policies" to "Scan Policies",
                    "credentialed" to "Credentialed Scans",
                    "reports" to "Reports",
                    "compliance" to "Compliance Checks"
                )

                "advanced" -> listOf(
                    "policies" to "Custom Policies",
                    "plugins" to "Plugins",
                    "automation" to "Automation",
                    "analysis" to "Advanced Analysis"
                )

                else -> emptyList()
            }
        }
        "Metasploit" -> {
            subtopics = when (level) {
                "basics" -> listOf(
                    "install" to "Installation & Setup",
                    "modules" to "Modules Overview",
                    "exploits" to "Basic Exploits",
                    "workspaces" to "Workspaces"
                )

                "intermediate" -> listOf(
                    "meterpreter" to "Meterpreter",
                    "post" to "Post-Exploitation",
                    "pivoting" to "Pivoting",
                    "auxiliary" to "Auxiliary Modules"
                )

                "advanced" -> listOf(
                    "payloads" to "Custom Payloads",
                    "scripting" to "Scripting",
                    "evasion" to "Evasion Techniques",
                    "automation" to "Automation"
                )

                else -> emptyList()
            }
        }
        "Python" -> {
            subtopics = when (level) {
                "basics" -> listOf(
                    "install" to "Installation & Setup",
                    "variables" to "Variables & Data Types",
                    "control" to "Control Structures",
                    "io" to "Basic Input/Output"
                )

                "intermediate" -> listOf(
                    "functions" to "Functions",
                    "modules" to "Modules & Packages",
                    "oop" to "Object-Oriented Programming",
                    "files" to "File Handling"
                )

                "advanced" -> listOf(
                    "generators" to "Generators & Iterators",
                    "decorators" to "Decorators",
                    "concurrency" to "Concurrency & Multithreading",
                    "web" to "Web Development Basics"
                )

                else -> emptyList()
            }
        }
        "Bash" -> {
            subtopics = when (level) {
                "basics" -> listOf(
                    "install" to "Installation & Setup",
                    "variables" to "Variables",
                    "control" to "Control Structures",
                    "functions" to "Functions"
                )

                "intermediate" -> listOf(
                    "files" to "File Operations",
                    "arrays" to "Arrays",
                    "error" to "Error Handling",
                    "loops" to "Advanced Loops"
                )

                "advanced" -> listOf(
                    "traps" to "Traps & Signals",
                    "networking" to "Networking",
                    "process" to "Process Substitution",
                    "coprocs" to "Coprocs"
                )

                else -> emptyList()
            }
        }
        "Java" -> {
            subtopics = when (level) {
                "basics" -> listOf(
                    "install" to "Installation & Setup",
                    "variables" to "Variables & Data Types",
                    "control" to "Control Structures",
                    "methods" to "Methods"
                )

                "intermediate" -> listOf(
                    "oop" to "Object-Oriented Programming",
                    "collections" to "Collections",
                    "exceptions" to "Exceptions",
                    "files" to "File I/O"
                )

                "advanced" -> listOf(
                    "generics" to "Generics",
                    "concurrency" to "Concurrency",
                    "jvm" to "JVM Internals",
                    "streams" to "Streams"
                )

                else -> emptyList()
            }
        }
        "C++" -> {
            subtopics = when (level) {
                "basics" -> listOf(
                    "install" to "Installation & Setup",
                    "variables" to "Variables & Data Types",
                    "control" to "Control Structures",
                    "functions" to "Functions"
                )

                "intermediate" -> listOf(
                    "pointers" to "Pointers",
                    "structures" to "Structures & Unions",
                    "files" to "File I/O",
                    "classes" to "Classes"
                )

                "advanced" -> listOf(
                    "templates" to "Templates",
                    "multithreading" to "Multithreading",
                    "memory" to "Memory Management",
                    "stl" to "STL"
                )

                else -> emptyList()
            }
        }
        "JavaScript" -> {
            subtopics = when (level) {
                "basics" -> listOf(
                    "install" to "Installation & Setup",
                    "variables" to "Variables & Data Types",
                    "control" to "Control Structures",
                    "functions" to "Functions"
                )

                "intermediate" -> listOf(
                    "arrays" to "Arrays & Objects",
                    "dom" to "DOM Manipulation",
                    "async" to "Async Basics",
                    "modules" to "Modules"
                )

                "advanced" -> listOf(
                    "promises" to "Promises & Async/Await",
                    "closures" to "Closures",
                    "prototypes" to "Prototypes & Inheritance",
                    "frameworks" to "Frameworks Intro"
                )

                else -> emptyList()
            }
        }
        else -> {
            subtopics = emptyList()
        }
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