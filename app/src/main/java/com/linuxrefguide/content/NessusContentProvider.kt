package com.linuxrefguide.content

import com.linuxrefguide.NavigationState

object NessusContentProvider: ContentProvider {
   override fun getWelcomeMessage(): String = """
🛡️ Welcome to the Nessus Ref. Guide! 🛡️

This interactive tutorial will guide you through essential Nessus concepts,
from basic vulnerability scanning to advanced compliance checks.

📖 What you'll learn:

• Basic Topics: Installation, setup, basic scans
• Intermediate Topics: Scan policies, credentialed scans, reports
• Advanced Topics: Custom policies, plugins, automation

🎯 How to navigate:

• Use the sidebar menu to select a topic category
• Click or tap to navigate through menus and subtopics
• Use the back button (← Back) to return to previous menus

🚀 Getting Started:

Choose a topic category from the sidebar to explore subtopics and start learning!
Each section includes explanations, examples, and best practices.

Good luck on your Nessus journey! 🎓
    """.trimIndent()

   override fun getMenuContent(state: NavigationState): String {
        return when (state) {
            NavigationState.MAIN_MENU -> """
📚 Nessus Ref. Guide

Select a category to begin:

📖 Basic Topics
Learn essential Nessus fundamentals.

⚡ Intermediate Topics
Master scanning techniques.

🚀 Advanced Topics
Dive into expert-level features.

❌ Exit
Close the application.
            """.trimIndent()
            NavigationState.BASIC_SUBMENU -> """
📰 Basic Topics Menu

Select a subtopic to begin learning:

🛠️ Installation & Setup
Installing Nessus and initial configuration.

🔍 Basic Scans
Running vulnerability scans.

📡 Dashboard
Understanding the Nessus interface.

📊 Scan Results
Viewing and interpreting results.
            """.trimIndent()
            NavigationState.INTERMEDIATE_SUBMENU -> """
⚡ Intermediate Topics Menu

Select a subtopic to advance your Nessus skills:

🚪 Scan Policies
Configuring scan templates.

🖥️ Credentialed Scans
Authenticated scanning.

📈 Reports
Generating and customizing reports.

🔎 Compliance Checks
Running compliance audits.
            """.trimIndent()
            NavigationState.ADVANCED_SUBMENU -> """
🚀 Advanced Topics Menu

Select a subtopic for expert-level Nessus knowledge:

📜 Custom Policies
Creating custom scan policies.

🛠️ Plugins
Managing and writing plugins.

🔄 Automation
Automating scans with APIs.

🔍 Advanced Analysis
Deep dive into scan data.
            """.trimIndent()
        }
    }

   override fun getTopicContent(level: String, id: String): String {
        return when (level) {
            "basics" -> when (id) {
                "install" -> """
🛠️ Installation & Setup - Getting Started with Nessus

Installing and configuring Nessus:

📥 Installation:
• Download from tenable.com
• Linux: sudo dpkg -i Nessus*.deb
• Windows: Run installer
• macOS: Install via DMG

🔧 Initial Setup:
• Access: https://localhost:8834
• Create admin account
• Activate license (Professional)

🛡️ Configuration:
• Set scan limits
• Configure email notifications

⚠️ Safety Tips:
• Secure admin credentials
• Use on authorized systems

💡 Pro Tips:
• Update plugins regularly
• Save config backups

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                "scans" -> """
🔍 Basic Scans - Running Vulnerability Scans

Starting Nessus scans:

🔍 Create Scan:
• Scans > New Scan
• Choose template (e.g., Basic Network Scan)
• Set target IPs or domains

📜 Run Scan:
• Launch immediately or schedule
• Monitor progress in Scans tab

🛡️ Scan Options:
• Set discovery settings
• Limit ports for speed

⚠️ Safety Tips:
• Scan authorized targets only
• Avoid production systems

💡 Pro Tips:
• Save scan templates
• Use host discovery first

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                "dashboard" -> """
📡 Dashboard - Nessus Interface

Navigating the Nessus UI:

🔍 Scans Tab:
• View running/completed scans
• Pause or stop scans

📜 Vulnerabilities Tab:
• View detected issues
• Filter by severity

🛡️ Settings:
• Configure global settings
• Manage users and roles

⚠️ Safety Tips:
• Restrict UI access
• Log out after use

💡 Pro Tips:
• Customize dashboard views
• Use filters for quick access

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                "results" -> """
📊 Scan Results - Interpreting Output

Analyzing scan results:

🔍 Viewing Results:
• Scans > Completed > Click scan
• Sort by severity or host

📜 Exporting:
• Export as PDF, HTML, CSV
• Reports > Generate Report

🛡️ Analysis:
• Drill down into vulnerabilities
• Check plugin details

⚠️ Safety Tips:
• Secure result files
• Share only with authorized parties

💡 Pro Tips:
• Save custom report templates
• Use filters for prioritization

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                else -> "Content for $level-$id coming soon!"
            }
            "intermediate" -> when (id) {
                "policies" -> """
🚪 Scan Policies - Customizing Scans

Configuring scan templates:

🔍 Create Policy:
• Policies > New Policy
• Choose template or custom
• Set scan parameters

📜 Settings:
• Discovery, Port Scanning, Assessment
• Enable/disable plugins

🛡️ Saving:
• Save for reuse
• Share with team

⚠️ Safety Tips:
• Test policies on non-production
• Avoid overly aggressive scans

💡 Pro Tips:
• Clone existing policies
• Optimize for speed

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                "credentialed" -> """
🖥️ Credentialed Scans - Authenticated Scanning

Running authenticated scans:

🔍 Add Credentials:
• Scan > Credentials > Add
• SSH, Windows, or database creds
• Test credentials before scan

📜 Benefits:
• Deeper system analysis
• Fewer false positives

🛡️ Configuration:
• Enable in scan policy
• Limit to trusted hosts

⚠️ Safety Tips:
• Secure credential storage
• Use dedicated accounts

💡 Pro Tips:
• Rotate credentials regularly
• Monitor credentialed scan logs

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                "reports" -> """
📈 Reports - Customizing Output

Generating and customizing reports:

🔍 Report Types:
• Executive Summary
• Detailed Vulnerability Report
• Compliance Report

📜 Customization:
• Reports > Templates
• Add filters, logos, sections

🛡️ Exporting:
• PDF, HTML, CSV
• Schedule automatic reports

⚠️ Safety Tips:
• Encrypt report files
• Share securely

💡 Pro Tips:
• Use custom templates
• Automate report delivery

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                "compliance" -> """
🔎 Compliance Checks - Auditing Systems

Running compliance scans:

🔍 Templates:
• Scan > New Scan > Compliance
• Choose standards (e.g., PCI DSS, CIS)

📜 Configuration:
• Select audit files
• Enable in policy settings

🛡️ Results:
• View compliance status
• Remediate non-compliant items

⚠️ Safety Tips:
• Verify compliance scope
• Backup before remediation

💡 Pro Tips:
• Use custom audit files
• Schedule regular audits

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                else -> "Content for $level-$id coming soon!"
            }
            "advanced" -> when (id) {
                "policies" -> """
📜 Custom Policies - Advanced Scanning

Creating tailored policies:

🔍 Advanced Settings:
• Fine-tune plugin options
• Adjust scan depth, timeouts
• Enable experimental plugins

📜 Sharing:
• Export/import policies
• Use for team consistency

🛡️ Testing:
• Test on sandbox systems
• Monitor performance impact

⚠️ Safety Tips:
• Avoid untested plugins
• Log policy changes

💡 Pro Tips:
• Version control policies
• Optimize for specific targets

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                "plugins" -> """
🛠️ Plugins - Managing and Writing

Handling Nessus plugins:

🔍 Managing Plugins:
• Plugins > Enable/Disable
• Update via Settings > Plugins

📜 Writing Plugins:
• Use NASL (Nessus Attack Scripting Language)
• Save in .nasl files
• Test locally before deployment

🛡️ Deployment:
• Upload via Nessus UI
• Verify plugin execution

⚠️ Safety Tips:
• Test plugins in sandbox
• Avoid untrusted sources

💡 Pro Tips:
• Use NASL documentation
• Share plugins securely

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                "automation" -> """
🔄 Automation - Nessus APIs

Automating scans with APIs:

🔍 API Setup:
• Enable API in Settings
• Generate API keys
• Use REST API endpoints

📜 Examples:
• /scans - Create/launch scans
• /reports - Generate reports
• Use curl or Python requests

🛡️ Scripting:
• Automate scan scheduling
• Integrate with CI/CD

⚠️ Safety Tips:
• Secure API keys
• Limit API access

💡 Pro Tips:
• Use Python for automation
• Log all API calls

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                "analysis" -> """
🔍 Advanced Analysis - Deep Data Insights

Analyzing scan data:

🔍 Vulnerability Analysis:
• Filter by CVSS score
• Cross-reference with CVE

📜 Host Analysis:
• Group by host or vuln
• Track remediation progress

🛡️ Custom Dashboards:
• Create in Nessus UI
• Visualize trends

⚠️ Safety Tips:
• Secure analysis data
• Share only with authorized

💡 Pro Tips:
• Export to SIEM
• Use filters for focus

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                else -> "Content for $level-$id coming soon!"
            }
            else -> "Content for $level-$id coming soon!"
        }
    }
}