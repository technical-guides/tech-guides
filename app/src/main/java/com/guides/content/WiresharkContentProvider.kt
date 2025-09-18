package com.guides.content

import com.guides.NavigationState

object WiresharkContentProvider: ContentProvider {
    override fun getWelcomeMessage(): String = """
🔍 Welcome to the Wireshark Ref. Guide! 🔍

This interactive tutorial will guide you through essential Wireshark concepts,
from capturing packets to analyzing complex network traffic.

📖 What you'll learn:

• Basic Topics: Installation, capturing packets, basic filters
• Intermediate Topics: Display filters, protocol analysis, statistics
• Advanced Topics: Custom filters, decryption, scripting

🎯 How to navigate:

• Use the sidebar menu to select a topic category
• Click or tap to navigate through menus and subtopics
• Use the back button (← Back) to return to previous menus

🚀 Getting Started:

Choose a topic category from the sidebar to explore subtopics and start learning!
Each section includes explanations, examples, and best practices.

Good luck on your Wireshark journey! 🎓
    """.trimIndent()

    override fun getMenuContent(state: NavigationState): String {
        return when (state) {
            NavigationState.MAIN_MENU -> """
📚 Wireshark Ref. Guide

Select a category to begin:

📖 Basic Topics
Learn essential Wireshark fundamentals.

⚡ Intermediate Topics
Master packet analysis.

🚀 Advanced Topics
Dive into expert-level features.

❌ Exit
Close the application.
            """.trimIndent()
            NavigationState.BASIC_SUBMENU -> """
📰 Basic Topics Menu

Select a subtopic to begin learning:

🛠️ Installation & Setup
Installing Wireshark and dependencies.

📡 Packet Capture
Starting and stopping captures.

🔍 Basic Filters
Applying simple capture filters.

📊 Interface Overview
Understanding the UI.
            """.trimIndent()
            NavigationState.INTERMEDIATE_SUBMENU -> """
⚡ Intermediate Topics Menu

Select a subtopic to advance your Wireshark skills:

🚪 Display Filters
Filtering displayed packets.

🖥️ Protocol Analysis
Analyzing common protocols.

📈 Statistics
Using Wireshark statistics tools.

🔎 Follow Streams
Tracking conversations.
            """.trimIndent()
            NavigationState.ADVANCED_SUBMENU -> """
🚀 Advanced Topics Menu

Select a subtopic for expert-level Wireshark knowledge:

📜 Custom Filters
Creating complex filters.

🔐 Decryption
Decrypting SSL/TLS traffic.

🛠️ Lua Scripting
Automating tasks with Lua.

🔍 Packet Injection
Injecting packets for testing.
            """.trimIndent()
        }
    }

    override fun getTopicContent(level: String, id: String): String {
        return when (level) {
            "basics" -> when (id) {
                "install" -> """
🛠️ Installation & Setup - Getting Started with Wireshark

Essential steps for installing Wireshark:

📥 Linux Installation:
• sudo apt install wireshark - Ubuntu/Debian
• sudo dnf install wireshark - Fedora
• sudo yum install wireshark - CentOS/RHEL

📥 Windows/macOS:
• Download from wireshark.org
• Install with Npcap (Windows)
• Use Homebrew: brew install wireshark (macOS)

🔧 Permissions:
• Add user to wireshark group: sudo usermod -aG wireshark $\USER
• Configure dumpcap permissions

⚠️ Safety Tips:
• Install from official sources
• Run as non-root when possible

💡 Pro Tips:
• Update Npcap for Windows
• Use tshark for CLI captures

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                "capture" -> """
📡 Packet Capture - Starting Captures

Capturing network traffic:

🔍 Start Capture:
• Select interface in Wireshark UI
• Capture > Start or Ctrl+E
• Specify capture filter (optional)

🛑 Stop Capture:
• Capture > Stop or Ctrl+E
• Save to .pcap file

📜 Capture Options:
• Capture all interfaces
• Limit capture size/time

⚠️ Safety Tips:
• Capture on authorized networks
• Secure .pcap files

💡 Pro Tips:
• Use ring buffer for long captures
• Save frequently

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                "filters" -> """
🔍 Basic Filters - Capture Filters

Applying simple capture filters:

🔧 Syntax:
• host 192.168.1.1 - Capture by IP
• port 80 - Capture by port
• tcp - Capture TCP traffic

📜 Examples:
• src host 10.0.0.1 - Source IP
• dst port 443 - Destination port
• not arp - Exclude ARP traffic

⚠️ Safety Tips:
• Test filters on test networks
• Avoid capturing sensitive data

💡 Pro Tips:
• Save filters for reuse
• Use tshark for CLI filtering

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                "interface" -> """
📊 Interface Overview - Understanding the UI

Navigating Wireshark's interface:

🔍 Packet List:
• Displays captured packets
• Columns: Time, Source, Destination, Protocol

📜 Packet Details:
• Expand protocols for details
• Right-click for options

🛡️ Packet Bytes:
• Hex and ASCII view
• Select bytes for analysis

⚠️ Safety Tips:
• Protect sensitive packet data
• Clear history regularly

💡 Pro Tips:
• Customize column layout
• Use color rules for clarity

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                else -> "Content for $level-$id coming soon!"
            }
            "intermediate" -> when (id) {
                "display" -> """
🚪 Display Filters - Filtering Packets

Filtering displayed packets:

🔍 Syntax:
• ip.addr == 192.168.1.1 - Filter by IP
• tcp.port == 80 - Filter by port
• http.request - HTTP requests only

📜 Examples:
• ip.src == 10.0.0.1 - Source IP
• tcp.flags.syn == 1 - SYN packets
• !icmp - Exclude ICMP traffic

🛡️ Combining:
• ip.addr == 192.168.1.1 && tcp.port == 80

⚠️ Safety Tips:
• Verify filters for accuracy
• Avoid exposing sensitive data

💡 Pro Tips:
• Save filters for reuse
• Use autocomplete for fields

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                "protocol" -> """
🖥️ Protocol Analysis - Deep Packet Inspection

Analyzing common protocols:

🔍 HTTP:
• Filter: http
• Follow > HTTP Stream
• Inspect headers, payloads

📜 TCP:
• Filter: tcp
• Analyze sequence numbers
• Check for retransmissions

🛡️ DNS:
• Filter: dns
• Inspect queries/responses

⚠️ Safety Tips:
• Handle sensitive data carefully
• Log findings securely

💡 Pro Tips:
• Use Statistics > Protocol Hierarchy
• Export objects for HTTP

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                "stats" -> """
📈 Statistics - Network Insights

Using Wireshark statistics:

🔍 Protocol Hierarchy:
• Statistics > Protocol Hierarchy
• View protocol distribution

📜 Conversations:
• Statistics > Conversations
• Track IP/port conversations

🛡️ IO Graphs:
• Statistics > IO Graphs
• Visualize packet rates

⚠️ Safety Tips:
• Analyze in test environments
• Secure exported stats

💡 Pro Tips:
• Export stats to CSV
• Customize graph filters

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                "streams" -> """
🔎 Follow Streams - Tracking Conversations

Following protocol streams:

🔍 TCP Stream:
• Right-click packet > Follow > TCP Stream
• View full conversation

📜 HTTP Stream:
• Follow > HTTP Stream
• See request/response pairs

🛡️ UDP Stream:
• Follow > UDP Stream
• Useful for DNS, VoIP

⚠️ Safety Tips:
• Avoid saving sensitive streams
• Clear stream data post-analysis

💡 Pro Tips:
• Save streams to file
• Use filters before following

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                else -> "Content for $level-$id coming soon!"
            }
            "advanced" -> when (id) {
                "filters" -> """
📜 Custom Filters - Complex Filtering

Creating advanced display filters:

🔍 Boolean Logic:
• (ip.src == 10.0.0.1) && (tcp.port == 80)
• http.request.method == "POST"

📜 Field Matching:
• tcp.analysis.retransmission
• http.cookie contains "session"

🛡️ Regex:
• http.host matches "example\.com"
• frame contains "login"

⚠️ Safety Tips:
• Test filters in sandbox
• Avoid over-filtering

💡 Pro Tips:
• Save complex filters
• Use tshark for automation

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                "decrypt" -> """
🔐 Decryption - SSL/TLS Analysis

Decrypting encrypted traffic:

🔍 SSL/TLS Decryption:
• Edit > Preferences > Protocols > TLS
• Add RSA key or pre-master secret
• Use sslkeylogfile

📜 Configuration:
• Set SSLKEYLOGFILE environment variable
• Export from browser for testing

🛡️ Verification:
• Filter: tls
• Check handshake packets

⚠️ Safety Tips:
• Use only on authorized traffic
• Secure key files

💡 Pro Tips:
• Use Wireshark profiles
• Log keys for debugging

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                "scripting" -> """
🛠️ Lua Scripting - Automating Wireshark

Using Lua for automation:

🔍 Lua Basics:
• Create .lua script in plugins folder
• Register dissectors or listeners
• tap.packet(pinfo, tvb) - Packet tap

📜 Examples:
• Count HTTP requests
• Extract specific fields

🛡️ Loading:
• Tools > Lua > Evaluate
• Add to init.lua for auto-loading

⚠️ Safety Tips:
• Test scripts locally
• Avoid untrusted scripts

💡 Pro Tips:
• Use Wireshark Lua API docs
• Debug with print()

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                "injection" -> """
🔍 Packet Injection - Testing Networks

Injecting packets for testing:

🔍 Tools:
• Use tcpreplay: tcpreplay -i eth0 file.pcap
• Edit packets with Wireshark Editcap

📜 Modification:
• editcap --chop file.pcap out.pcap
• mergecap -w out.pcap file1.pcap file2.pcap

🛡️ Testing:
• Replay on test network
• Verify with Wireshark

⚠️ Safety Tips:
• Authorized networks only
• Log all injections

💡 Pro Tips:
• Use tcprewrite for packet edits
• Combine with filters

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                else -> "Content for $level-$id coming soon!"
            }
            else -> "Content for $level-$id coming soon!"
        }
    }
}