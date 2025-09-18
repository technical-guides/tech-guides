package com.guides.content

import com.guides.NavigationState

object BurpSuiteContentProvider: ContentProvider {
    override fun getWelcomeMessage(): String = """
🛡️ Welcome to the Burp Suite Ref. Guide! 🛡️

This interactive tutorial will guide you through essential Burp Suite concepts,
from basic proxy usage to advanced web vulnerability exploitation.

📖 What you'll learn:

• Basic Topics: Setup, proxy, intercepting traffic
• Intermediate Topics: Scanner, repeater, intruder
• Advanced Topics: Extender, macros, custom plugins

🎯 How to navigate:

• Use the sidebar menu to select a topic category
• Click or tap to navigate through menus and subtopics
• Use the back button (← Back) to return to previous menus

🚀 Getting Started:

Choose a topic category from the sidebar to explore subtopics and start learning!
Each section includes explanations, examples, and best practices.

Good luck on your Burp Suite journey! 🎓
    """.trimIndent()

    override fun getMenuContent(state: NavigationState): String {
        return when (state) {
            NavigationState.MAIN_MENU -> """
📚 Burp Suite Ref. Guide

Select a category to begin:

📖 Basic Topics
Learn essential Burp Suite fundamentals.

⚡ Intermediate Topics
Master testing tools.

🚀 Advanced Topics
Dive into expert-level features.

❌ Exit
Close the application.
            """.trimIndent()
            NavigationState.BASIC_SUBMENU -> """
📰 Basic Topics Menu

Select a subtopic to begin learning:

🛠️ Installation & Setup
Installing and configuring Burp Suite.

🌐 Proxy Basics
Setting up the HTTP proxy.

🔍 Intercepting Traffic
Capturing and modifying requests.

📜 Scope Management
Defining target scope.
            """.trimIndent()
            NavigationState.INTERMEDIATE_SUBMENU -> """
⚡ Intermediate Topics Menu

Select a subtopic to advance your Burp Suite skills:

🕵️ Scanner
Automated vulnerability scanning.

🔄 Repeater
Manually testing HTTP requests.

💥 Intruder
Automated attack simulation.

📊 Session Handling
Managing authentication.
            """.trimIndent()
            NavigationState.ADVANCED_SUBMENU -> """
🚀 Advanced Topics Menu

Select a subtopic for expert-level Burp Suite knowledge:

🛠️ Extender
Using and developing extensions.

🔄 Macros
Automating repetitive tasks.

📜 Custom Plugins
Writing your own plugins.

🔍 Advanced Attacks
Complex vulnerability exploitation.
            """.trimIndent()
        }
    }

    override fun getTopicContent(level: String, id: String): String {
        return when (level) {
            "basics" -> when (id) {
                "install" -> """
🛠️ Installation & Setup - Getting Started with Burp Suite

Essential steps for installing and configuring Burp Suite:

📥 Installation:
• Download from portswigger.net
• Requires Java (JRE 11+)
• Run: java -jar burpsuite.jar
• Choose Community or Professional edition

🔧 Browser Configuration:
• Set proxy to 127.0.0.1:8080
• Install Burp CA certificate
• Firefox: Preferences > Network Settings
• Chrome: Settings > System > Proxy

🛡️ License Activation (Professional):
• Activate license key in UI
• Check subscription status

⚠️ Safety Tips:
• Use on authorized systems only
• Secure license keys

💡 Pro Tips:
• Save project files for persistence
• Update regularly for new features

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                "proxy" -> """
🌐 Proxy Basics - Capturing HTTP Traffic

Setting up the Burp Suite proxy:

🔌 Proxy Setup:
• Enable proxy in Burp (Proxy > Options)
• Set listener to 127.0.0.1:8080
• Configure browser to use proxy
• Enable intercept to capture requests

📡 Invisible Proxying:
• Use for non-proxy-aware clients
• Proxy > Options > Invisible Proxy

🛡️ HTTPS Handling:
• Install Burp CA certificate
• Export from Proxy > Options > Import/Export CA

⚠️ Safety Tips:
• Disable intercept when not needed
• Clear history to save disk space

💡 Pro Tips:
• Use multiple listeners for different targets
• Filter traffic to reduce noise

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                "intercept" -> """
🔍 Intercepting Traffic - Modifying Requests

Capturing and editing HTTP traffic:

🔧 Intercepting Requests:
• Enable Intercept in Proxy tab
• Forward, Drop, or Modify requests
• Action: Send to Repeater/Intruder

📜 Response Modification:
• Intercept server responses
• Edit HTML, headers, or content

🛡️ Filters:
• Proxy > HTTP History > Filter
• By MIME type, status, or URL

⚠️ Safety Tips:
• Avoid modifying production traffic
• Log all changes

💡 Pro Tips:
• Use Match and Replace for automation
• Save intercepted requests

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                "scope" -> """
📜 Scope Management - Defining Targets

Setting up target scope:

🔍 Add to Scope:
• Target > Site Map > Right-click > Add to scope
• Include specific URLs or domains

🛡️ Exclude from Scope:
• Exclude irrelevant domains
• Reduce scan noise

📡 Scope Control:
• Target > Scope tab
• Use regex for advanced patterns

⚠️ Safety Tips:
• Limit scope to authorized targets
• Verify scope before scanning

💡 Pro Tips:
• Save scope in project file
• Use scope for focused testing

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                else -> "Content for $level-$id coming soon!"
            }
            "intermediate" -> when (id) {
                "scanner" -> """
🕵️ Scanner - Automated Vulnerability Testing

Using Burp Scanner:

🔍 Running Scans:
• Professional: Active/Passive scanning
• Right-click target > Actively scan
• Configure scan settings

📜 Scan Types:
• Active: Sends test payloads
• Passive: Analyzes captured traffic

🛡️ Scan Configuration:
• Issues > Scan defined issues
• Adjust speed and thoroughness

⚠️ Safety Tips:
• Only scan authorized targets
• Avoid production systems

💡 Pro Tips:
• Use crawl before active scan
• Export reports for clients

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                "repeater" -> """
🔄 Repeater - Manual Request Testing

Testing requests manually:

🔧 Sending Requests:
• Right-click > Send to Repeater
• Modify and resend requests
• View response in real-time

📜 Tabs:
• Create multiple Repeater tabs
• Label for organization

🛡️ Request History:
• View previous requests
• Compare responses

⚠️ Safety Tips:
• Test on non-production systems
• Log changes

💡 Pro Tips:
• Use keyboard shortcuts
• Save Repeater sessions

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                "intruder" -> """
💥 Intruder - Automated Attacks

Automating attack payloads:

🔍 Attack Types:
• Sniper: Single payload position
• Battering Ram: Same payload multiple positions
• Pitchfork: Different payloads per position

📜 Payloads:
• Simple list, numbers, brute force
• Intruder > Payloads > Configure

🛡️ Attack Settings:
• Adjust speed and limits
• Grep for specific responses

⚠️ Safety Tips:
• Avoid overwhelming servers
• Get permission for testing

💡 Pro Tips:
• Use payloads from files
• Analyze results with filters

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                "session" -> """
📊 Session Handling - Managing Authentication

Handling sessions in Burp:

🔧 Session Rules:
• Tools > Session Handling Rules
• Add cookies or headers
• Match scope or URL

📜 Macros:
• Record login sequence
• Tools > Macros > Add

🛡️ Token Handling:
• Handle CSRF tokens
• Auto-update session tokens

⚠️ Safety Tips:
• Secure session data
• Test on non-critical systems

💡 Pro Tips:
• Combine with Intruder
• Save macros for reuse

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                else -> "Content for $level-$id coming soon!"
            }
            "advanced" -> when (id) {
                "extender" -> """
🛠️ Extender - Using Extensions

Leveraging Burp extensions:

🔍 Installing Extensions:
• Extender > BApp Store
• Install Logger++, Turbo Intruder

📜 Writing Extensions:
• Use Java, Python, or Ruby
• Extender > APIs > Implement interfaces

🛡️ Managing Extensions:
• Enable/disable via Extender tab
• Update regularly

⚠️ Safety Tips:
• Verify extension sources
• Test in sandbox

💡 Pro Tips:
• Use Logger++ for logging
• Debug extensions locally

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                "macros" -> """
🔄 Macros - Automating Tasks

Creating macros for automation:

🔧 Creating Macros:
• Tools > Macros > Add
• Record request sequence
• Save for session handling

📜 Usage:
• Link to session handling rules
• Automate login or CSRF

🛡️ Testing Macros:
• Test in Proxy or Repeater
• Verify with logs

⚠️ Safety Tips:
• Avoid sensitive data in macros
• Test thoroughly

💡 Pro Tips:
• Combine with Intruder
• Export macros for reuse

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                "plugins" -> """
📜 Custom Plugins - Writing Extensions

Developing custom Burp plugins:

🔍 Java Plugins:
• Implement IBurpExtender
• Use Burp API interfaces
• Compile and load in Extender

📜 Python/Ruby:
• Use Jython/JRuby
• Extender > Options > Python/Ruby env

🛡️ Testing:
• Debug in development environment
• Log output to console

⚠️ Safety Tips:
• Test in non-production
• Secure plugin code

💡 Pro Tips:
• Use GitHub for examples
• Share plugins securely

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                "attacks" -> """
🔍 Advanced Attacks - Complex Exploitation

Exploiting vulnerabilities:

🔧 SQL Injection:
• Use Intruder for payloads
• Repeater for manual testing

📜 XSS Testing:
• Send payloads to Intruder
• Test reflected/stored XSS

🛡️ CSRF Exploits:
• Generate PoC in Burp
• Test with macros

⚠️ Safety Tips:
• Authorized testing only
• Log all actions

💡 Pro Tips:
• Combine with Scanner
• Use Logger++ for tracking

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                else -> "Content for $level-$id coming soon!"
            }
            else -> "Content for $level-$id coming soon!"
        }
    }
}