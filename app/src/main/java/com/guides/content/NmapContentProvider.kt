package com.guides.content

import com.guides.NavigationState

object NmapContentProvider : ContentProvider {
    override fun getWelcomeMessage(): String = """
Welcome to the Nmap Ref. Guide!

This interactive tutorial will guide you through essential Nmap concepts,
from basic scanning to advanced scripting and evasion techniques.

What you'll learn:

• Basic Topics: Installation, host discovery, simple scans, output formats
• Intermediate Topics: Port scanning, service detection, OS fingerprinting, timing
• Advanced Topics: Scripting engine, evasion techniques, vulnerability scanning, custom scripts

How to navigate:

• Use the sidebar menu to select a topic category
• Click or tap to navigate through menus and subtopics
• Use the back button (← Back) to return to previous menus

Getting Started:

Choose a topic category from the sidebar to explore subtopics and start learning!
Each section includes explanations, examples, and best practices.

Good luck on your Nmap journey!
    """.trimIndent()

    override fun getMenuContent(state: NavigationState): String {
        return when (state) {
            NavigationState.MAIN_MENU -> """
Nmap Ref. Guide

Select a category to begin:

Basic Topics
Learn essential Nmap fundamentals.

Intermediate Topics
Master scanning techniques.

Advanced Topics
Dive into expert-level Nmap usage.

Exit
Close the application.
            """.trimIndent()
            NavigationState.BASIC_SUBMENU -> """
Basic Topics Menu

Select a subtopic to begin learning:

Installation & Setup
Install Nmap on various platforms.

Host Discovery
Identify live hosts on a network.

Simple Scans
Basic network scanning techniques.

Output Formats
Save and format scan results.
            """.trimIndent()
            NavigationState.INTERMEDIATE_SUBMENU -> """
Intermediate Topics Menu

Select a subtopic to advance your Nmap skills:

Port Scanning
Scan for open ports.

Service Detection
Identify services on ports.

OS Fingerprinting
Detect operating systems.

Timing & Performance
Optimize scan performance.
            """.trimIndent()
            NavigationState.ADVANCED_SUBMENU -> """
Advanced Topics Menu

Select a subtopic for expert-level Nmap knowledge:

Scripting Engine
Use NSE for advanced scans.

Evasion Techniques
Bypass firewalls and IDS.

Vulnerability Scanning
Detect vulnerabilities.

Custom Scripts
Write your own NSE scripts.
            """.trimIndent()
        }
    }

    override fun getTopicContent(level: String, id: String): String {
        return when (level) {
            "basics" -> when (id) {
                "install" -> """
Installation & Setup - Getting Started with Nmap

Essential steps for installing Nmap:

Installing on Linux:
• sudo apt update && sudo apt install nmap - Ubuntu/Debian
• sudo dnf install nmap - Fedora
• sudo yum install nmap - CentOS/RHEL

Installing on Windows:
• Download installer from nmap.org
• Run setup wizard

Installing on macOS:
• brew install nmap - Using Homebrew
• Or download from nmap.org

Basic Configuration:
• nmap --version - Check installed version
• sudo nmap - Update permissions if needed

Safety Tips:
• Install from official sources
• Keep Nmap updated

Pro Tips:
• Use Zenmap for GUI
• Check dependencies (e.g., npcap on Windows)

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                "discovery" -> """
Host Discovery - Finding Live Hosts

Basic host discovery techniques:

Commands:
• nmap -sn 192.168.1.0/24 - Ping scan
• nmap -PE 192.168.1.1 - ICMP echo
• nmap -PS80,443 192.168.1.0/24 - TCP SYN ping
• nmap -PU53 192.168.1.0/24 - UDP ping

Safety Tips:
• Avoid scanning unauthorized networks
• Use -n to skip DNS resolution

Pro Tips:
• Combine -sn with -T4 for speed
• Use --reason for detailed output

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                "scans" -> """
Simple Scans - Basic Network Scanning

Basic scanning techniques:

Commands:
• nmap 192.168.1.1 - Default scan
• nmap -p 1-1000 192.168.1.1 - Port range
• nmap -F 192.168.1.1 - Fast scan
• nmap -sT 192.168.1.1 - TCP connect scan

Safety Tips:
• Scan only permitted targets
• Limit scan rate with --scan-delay

Pro Tips:
• Use -v for verbose output
• Save results with -oN output.txt

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                "output" -> """
Output Formats - Saving Scan Results

Saving and formatting output:

Commands:
• nmap -oN output.txt 192.168.1.1 - Normal output
• nmap -oX output.xml 192.168.1.1 - XML output
• nmap -oG output.grep 192.168.1.1 - Greppable output
• nmap -oA output 192.168.1.1 - All formats

Safety Tips:
• Secure output files
• Avoid overwriting files

Pro Tips:
• Use -oX with XML parsers
• Combine with --stylesheet for HTML

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                else -> "Content for basic-$id coming soon!"
            }
            "intermediate" -> when (id) {
                "ports" -> """
Port Scanning - Advanced Port Techniques

Scanning for open ports:

Commands:
• nmap -sS 192.168.1.1 - SYN scan
• nmap -sU 192.168.1.1 - UDP scan
• nmap -p- 192.168.1.1 - All ports
• nmap -sA 192.168.1.1 - ACK scan

Safety Tips:
• Respect network policies
• Monitor scan impact

Pro Tips:
• Use --open to show only open ports
• Combine with -T4 for speed

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                "service" -> """
Service Detection - Identifying Services

Detecting services on ports:

Commands:
• nmap -sV 192.168.1.1 - Version detection
• nmap -sV --version-intensity 9 192.168.1.1 - Aggressive
• nmap -A 192.168.1.1 - All detection
• nmap --script default 192.168.1.1 - Default scripts

Safety Tips:
• Avoid aggressive scans on sensitive systems
• Check script safety

Pro Tips:
• Use --version-all for thoroughness
• Save results with -oA

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                "os" -> """
OS Fingerprinting - Detecting Operating Systems

Identifying OS:

Commands:
• nmap -O 192.168.1.1 - OS detection
• nmap -O --osscan-guess 192.168.1.1 - Aggressive guess
• nmap -A 192.168.1.1 - OS and service detection
• nmap -O --fuzzy 192.168.1.1 - Fuzzy matching

Safety Tips:
• Requires root privileges
• Avoid on critical systems

Pro Tips:
• Combine with -v for details
• Use --osscan-limit for speed

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                "timing" -> """
Timing & Performance - Optimizing Scans

Optimizing scan performance:

Commands:
• nmap -T4 192.168.1.1 - Fast timing
• nmap --min-rate 1000 192.168.1.1 - Min packet rate
• nmap --max-retries 2 192.168.1.1 - Limit retries
• nmap --scan-delay 10ms 192.168.1.1 - Delay packets

Safety Tips:
• Avoid overwhelming networks
• Test timing on non-production

Pro Tips:
• Use -T5 for aggressive scans
• Monitor with --stats-every

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                else -> "Content for intermediate-$id coming soon!"
            }
            "advanced" -> when (id) {
                "scripting" -> """
Scripting Engine - Using NSE

Using Nmap Scripting Engine:

Commands:
• nmap --script http-enum 192.168.1.1 - Run script
• nmap --script "http-*" 192.168.1.1 - Run category
• nmap --script-args key=value 192.168.1.1 - Script args
• nmap --script-trace 192.168.1.1 - Trace script

Safety Tips:
• Verify script safety
• Avoid intrusive scripts

Pro Tips:
• Update scripts: nmap --script-updatedb
• Use --script-help for details

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                "evasion" -> """
Evasion Techniques - Bypassing Defenses

Bypassing firewalls/IDS:

Commands:
• nmap -f 192.168.1.1 - Fragment packets
• nmap --mtu 16 192.168.1.1 - Set MTU
• nmap --data-length 32 192.168.1.1 - Add data
• nmap --source-port 53 192.168.1.1 - Source port

Safety Tips:
• Use only with permission
• Log all scans

Pro Tips:
• Combine with -D (decoy)
• Use --randomize-hosts

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                "vuln" -> """
Vulnerability Scanning - Detecting Vulnerabilities

Scanning for vulnerabilities:

Commands:
• nmap --script vuln 192.168.1.1 - Vuln scripts
• nmap --script smb-vuln-* 192.168.1.1 - SMB vulns
• nmap -sV --script vuln 192.168.1.1 - With version
• nmap --script-args unsafe=1 192.168.1.1 - Aggressive

Safety Tips:
• Avoid on production systems
• Verify permissions

Pro Tips:
• Use -oX for reporting
• Combine with -A for thoroughness

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                "custom" -> """
Custom Scripts - Writing NSE Scripts

Writing custom NSE scripts:

Basics:
• Save as .nse in /usr/share/nmap/scripts/
• Use Lua: portrule = function(host, port) ...
• nmap --script my-script.nse 192.168.1.1

Examples:
• prule = shortport.portnumber(80)
• action = function(host, port) print("Open") end

Safety Tips:
• Test scripts locally
• Avoid infinite loops

Pro Tips:
• Use nmaplib for complex logic
• Debug with --script-trace

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                else -> "Content for advanced-$id coming soon!"
            }
            else -> "Content for $level-$id coming soon!"
        }
    }
}