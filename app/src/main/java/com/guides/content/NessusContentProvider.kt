package com.guides.content

import com.guides.NavigationState

object NessusContentProvider : ContentProvider {
    override fun getWelcomeMessage(): String = """
🛡️ Welcome to the Nessus Ref. Guide! 🛡️

This in-depth tutorial covers Nessus from fundamentals to advanced, with detailed explanations, multiple examples, and practical tips for vulnerability scanning.

📖 What you'll learn:

• Basic Topics: Installation & setup, basic scans, dashboard, scan results
• Intermediate Topics: Scan policies, credentialed scans, reports, compliance checks
• Advanced Topics: Custom policies, plugins, automation, advanced analysis

🎯 How to navigate:

• Use the sidebar menu to select a topic category
• Click or tap to navigate through menus and subtopics
• Use the back button (← Back) to return to previous menus

🚀 Getting Started:

Choose a topic category from the sidebar to explore subtopics and start learning!
Each section includes thorough explanations, multiple code examples, safety tips, pro tips, common mistakes, and real-world applications.

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
Installing and configuring Nessus.

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

Nessus is a leading vulnerability scanner by Tenable. This section covers installation, activation, and initial configuration.

Detailed Explanation:
Download from tenable.com. Activate with license. Setup users and plugins.

Multiple Code Examples:
1. Linux Install:
```bash
sudo dpkg -i Nessus*.deb
```
Explanation: Installs Nessus package.

2. Start Nessus:
```bash
sudo /etc/init.d/nessusd start
```
Explanation: Starts Nessus service.

3. Access UI:
- https://localhost:8834
Explanation: Opens web interface.

4. Plugin Update:
```bash
/opt/nessus/sbin/nessus-update-plugins
```
Explanation: Updates vulnerability plugins.

5. API Setup:
```bash
/opt/nessus/sbin/nessuscli fetch --register <license>
```
Explanation: Registers with license.

6. User Creation:
- UI: Settings > Users > Add
Explanation: Adds admin user.

7. Plugin Scan:
```bash
/opt/nessus/sbin/nessuscli update --plugins-only
```
Explanation: Updates only plugins.

Common Mistakes:
- Wrong license.
- Firewall blocks port.

Real-World Applications:
- Vulnerability assessments.
- Compliance.

⚠️ Safety Tips:
• Secure UI.
• Update plugins.

💡 Pro Tips:
• Use agents.
• API setup.

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                "scans" -> """
🔍 Basic Scans - Running Vulnerability Scans

Start basic scans in Nessus.

Detailed Explanation:
Create scan, set targets, launch.

Multiple Code Examples:
1. Command Line Scan:
```bash
/opt/nessus/bin/nessuscmd 192.168.1.1 -T xml
```
Explanation: Scans IP, outputs XML.

2. UI Scan Creation:
- New Scan > Basic Network Scan
Explanation: UI-based scan setup.

Common Mistakes:
- No targets.
- Wrong policy.

Real-World Applications:
- Network security.
- Audits.

⚠️ Safety Tips:
• Authorized targets.
• Limit scope.

💡 Pro Tips:
• Schedule scans.
• Export results.

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                "dashboard" -> """
📡 Dashboard - Nessus Interface

Navigate the Nessus dashboard.

Detailed Explanation:
View scans, vulnerabilities.

Multiple Code Examples:
1. API Dashboard Query:
```bash
curl -X GET -H "X-ApiKeys: accessKey=...; secretKey=..." https://localhost:8834/dashboard
```
Explanation: Fetches dashboard data via API.

Common Mistakes:
- Ignoring filters.
- Outdated view.

Real-World Applications:
- Monitoring.
- Reporting.

⚠️ Safety Tips:
• Secure access.
• Log out.

💡 Pro Tips:
• Custom dashboards.
• Search queries.

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                "results" -> """
📊 Scan Results - Interpreting Output

Analyze scan results.

Detailed Explanation:
View vulns, hosts, severity.

Multiple Code Examples:
1. API Results:
```bash
curl -X GET -H "X-ApiKeys: ..." https://localhost:8834/scans/1
```
Explanation: Fetches scan results via API.

Common Mistakes:
- Ignoring false positives.
- No remediation.

Real-World Applications:
- Vuln management.
- Reports.

⚠️ Safety Tips:
• Secure results.
• Prioritize critical.

💡 Pro Tips:
• Filter by severity.
• Export CSV.

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                else -> "Content for $level-$id coming soon!"
            }
            "intermediate" -> when (id) {
                "policies" -> """
🚪 Scan Policies - Custom Templates

Configure scan policies.

Detailed Explanation:
Create templates for scans.

Multiple Code Examples:
1. API Policy Creation:
```bash
curl -X POST -H "X-ApiKeys: ..." -d '{"name":"My Policy"}' https://localhost:8834/policies
```
Explanation: Creates new policy via API.

Common Mistakes:
- Default policies.
- Overly aggressive.

Real-World Applications:
- Custom scans.
- Compliance.

⚠️ Safety Tips:
• Test policies.
• Limit plugins.

💡 Pro Tips:
• Clone policies.
• Export/import.

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                "credentialed" -> """
🖥️ Credentialed Scans - Authenticated Scanning

Run credentialed scans.

Detailed Explanation:
Use creds for deeper scans.

Multiple Code Examples:
1. API Add Creds:
```bash
curl -X POST -H "X-ApiKeys: ..." -d '{"type":"ssh", "username":"user"}' https://localhost:8834/credentials
```
Explanation: Adds SSH credential via API.

Common Mistakes:
- Wrong creds.
- No testing.

Real-World Applications:
- Internal audits.
- Patch checks.

⚠️ Safety Tips:
• Secure creds.
• Use dedicated accounts.

💡 Pro Tips:
• Rotate creds.
• Log usage.

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                "reports" -> """
📈 Reports - Generating Outputs

Create reports from scans.

Detailed Explanation:
Export in various formats.

Multiple Code Examples:
1. API Export:
```bash
curl -X POST -H "X-ApiKeys: ..." -d '{"format":"html"}' https://localhost:8834/scans/1/export
```
Explanation: Exports scan as HTML.

Common Mistakes:
- No customization.
- Large reports.

Real-World Applications:
- Client reports.
- Compliance.

⚠️ Safety Tips:
• Secure reports.
• Redact sensitive info.

💡 Pro Tips:
• Custom templates.
• Automate exports.

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                "compliance" -> """
🔎 Compliance Checks - Auditing Systems

Run compliance scans.

Detailed Explanation:
Use templates for standards.

Multiple Code Examples:
1. API Compliance Scan:
```bash
curl -X POST -H "X-ApiKeys: ..." -d '{"template":"compliance"}' https://localhost:8834/scans
```
Explanation: Starts compliance scan via API.

Common Mistakes:
- Wrong template.
- No creds.

Real-World Applications:
• PCI DSS audits.
• CIS benchmarks.

⚠️ Safety Tips:
• Authorized systems.
• Backup before.

💡 Pro Tips:
• Custom audits.
• Schedule checks.

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                else -> "Content for $level-$id coming soon!"
            }
            "advanced" -> when (id) {
                "policies" -> """
📜 Custom Policies - Advanced Scanning

Create custom policies.

Detailed Explanation:
Tune plugins, discovery.

Multiple Code Examples:
1. API Custom Policy:
```bash
curl -X POST -H "X-ApiKeys: ..." -d '{"name":"Custom", "plugins":{}}' https://localhost:8834/policies
```
Explanation: Creates policy with custom plugins via API.

Common Mistakes:
- Unbalanced settings.
- No testing.

Real-World Applications:
- Tailored scans.
- Integration.

⚠️ Safety Tips:
• Test in lab.
• Document changes.

💡 Pro Tips:
• Import/export.
• Version control.

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                "plugins" -> """
🛠️ Plugins - Managing and Writing

Manage Nessus plugins.

Detailed Explanation:
Plugins are NASL scripts for checks.

Multiple Code Examples:
1. Update Plugins:
```bash
/opt/nessus/sbin/nessus-update-plugins
```
Explanation: Updates vulnerability plugins.

2. Basic NASL Script:
```nasl
include("compat.inc");
description = "Example Plugin";
script_version("1.0");
script_set_attribute(attribute:"synopsis", value:"Synopsis");
script_set_attribute(attribute:"description", value:"Description");
```
Explanation: Basic plugin structure.

Common Mistakes:
- Syntax errors.
- No testing.

Real-World Applications:
- Custom vulns.
- Compliance.

⚠️ Safety Tips:
• Test locally.
• Secure code.

💡 Pro Tips:
• Use NASL docs.
• Submit to Tenable.

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                "automation" -> """
🔄 Automation - Nessus APIs

Automate Nessus with APIs.

Detailed Explanation:
Use REST API for scans, reports.

Multiple Code Examples:
1. API Scan Launch:
```bash
curl -X POST -H "X-ApiKeys: ..." -d '{"uuid":"template-uuid"}' https://localhost:8834/scans
```
Explanation: Launches scan with template.

2. Get Scan Status:
```bash
curl -X GET -H "X-ApiKeys: ..." https://localhost:8834/scans/1
```
Explanation: Fetches scan status.

Common Mistakes:
- Wrong keys.
- No error handling.

Real-World Applications:
- CI/CD integration.
- Automated reporting.

⚠️ Safety Tips:
• Secure API keys.
• Limit access.

💡 Pro Tips:
• Use Python-Tenable.
• Schedule with cron.

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                "analysis" -> """
🔍 Advanced Analysis - Data Insights

Deep dive into scan data.

Detailed Explanation:
Filter, group, track remediation.

Multiple Code Examples:
1. API Vuln Export:
```bash
curl -X POST -H "X-ApiKeys: ..." -d '{"format":"csv"}' https://localhost:8834/scans/1/export
```
Explanation: Exports vulns as CSV.

Common Mistakes:
- Ignoring trends.
- No baselines.

Real-World Applications:
- Risk assessment.
- Reporting.

⚠️ Safety Tips:
• Secure analysis data.
• Verify findings.

💡 Pro Tips:
• Use dashboards.
• Integrate with SIEM.

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                else -> "Content for $level-$id coming soon!"
            }
            else -> "Content for $level-$id coming soon!"
        }
    }
}