package com.guides.content

import com.guides.NavigationState

object WiresharkContentProvider : ContentProvider {
    override fun getWelcomeMessage(): String = """
📡 Welcome to the Wireshark Ref. Guide! 📡

This comprehensive tutorial covers Wireshark, the premier tool for packet analysis, from fundamentals to advanced techniques. Learn to capture, filter, and analyze network traffic with detailed explanations and practical examples.

📖 What you'll learn:

• Basic Topics: Installation & setup, capturing packets, basic filters, interface selection
• Intermediate Topics: Display filters, protocol analysis, packet decoding, statistics
• Advanced Topics: Lua scripting, decryption, custom profiles, automation

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
📚 Wireshark Ref. Guide

Select a category to begin:

📖 Basic Topics
Learn essential Wireshark fundamentals.

⚡ Intermediate Topics
Master packet analysis techniques.

🚀 Advanced Topics
Dive into expert-level Wireshark features.

❌ Exit
Close the application.
            """.trimIndent()
            NavigationState.BASIC_SUBMENU -> """
📰 Basic Topics Menu

Select a subtopic to begin learning:

🛠️ Installation & Setup
Installing and configuring Wireshark.

📡 Capturing Packets
Starting packet captures.
Commands: tshark, dumpcap

🔍 Basic Filters
Applying capture filters.
Syntax: BPF

🌐 Interface Selection
Choosing network interfaces.
            """.trimIndent()
            NavigationState.INTERMEDIATE_SUBMENU -> """
⚡ Intermediate Topics Menu

Select a subtopic to advance your Wireshark skills:

🖥️ Display Filters
Filtering displayed packets.
Syntax: Wireshark filter

🔎 Protocol Analysis
Analyzing specific protocols.
Examples: HTTP, TCP

📊 Packet Decoding
Decoding encrypted or custom packets.

⚙️ Statistics
Generating network statistics.
Tools: IO Graphs, Conversations
            """.trimIndent()
            NavigationState.ADVANCED_SUBMENU -> """
🚀 Advanced Topics Menu

Select a subtopic for expert-level Wireshark knowledge:

📜 Lua Scripting
Writing custom dissectors.
Language: Lua

🔥 Decryption
Decrypting SSL/TLS traffic.

🛠️ Custom Profiles
Creating tailored profiles.

🔄 Automation
Automating analysis with scripts.
Tools: tshark, bash
            """.trimIndent()
        }
    }

    override fun getTopicContent(level: String, id: String): String {
        return when (level) {
            "basics" -> when (id) {
                "install" -> """
🛠️ Installation & Setup - Getting Started with Wireshark

Wireshark is the leading tool for capturing and analyzing network packets. This section covers installation, configuration, and permissions for effective packet analysis.

Detailed Explanation:
Install Wireshark via package managers (apt, brew) or from wireshark.org. Requires libpcap for capture. Configure permissions for non-root capture with dumpcap. Tshark is the CLI version. Verify with wireshark --version.

Detailed Explanation of Installation Components:
• Package Managers: apt for Linux, brew for macOS.
• Permissions: Setcap or group for capture.
• Tshark: CLI for scripting.
• Dependencies: libpcap, Qt for GUI.

Multiple Code Examples:
1. Install on Ubuntu:
```bash
sudo apt update
sudo apt install wireshark
wireshark --version
```
Explanation: Installs Wireshark, verifies version.

2. Install on macOS:
```bash
brew install wireshark
wireshark --version
```
Explanation: Uses Homebrew to install.

3. Configure Permissions:
```bash
sudo dpkg-reconfigure wireshark-common
sudo usermod -aG wireshark "\$\USER"
```
Explanation: Allows non-root capture, adds user to wireshark group.

4. Install Tshark:
```bash
sudo apt install tshark
tshark -v
```
Explanation: Installs CLI tool, checks version.

5. Verify Libpcap:
```bash
ldconfig -p | grep libpcap
```
Explanation: Confirms libpcap is installed.

6. Update Wireshark:
```bash
sudo apt upgrade wireshark
```
Explanation: Updates to latest version.

7. Run Wireshark:
```bash
wireshark &
```
Explanation: Launches GUI in background.

Common Mistakes:
- Running without capture permissions, failing to see packets.
- Not installing tshark for CLI use.
- Missing libpcap, causing capture errors.
- Using root unnecessarily, risking security.
- Ignoring updates, missing bug fixes.
- Wrong interface selection.
- Not verifying dependencies.

Real-World Applications:
- Network troubleshooting in IT.
- Security analysis for attacks.
- Teaching packet analysis.
- Compliance monitoring.
- Debugging network apps.
- Preparing for pentests.
- Analyzing IoT traffic.

⚠️ Safety Tips:
• Download from wireshark.org.
• Use wireshark group for capture.
• Avoid root unless necessary.
• Secure capture files (chmod 600).
• Update regularly for security.
• Test in a lab environment.
• Log installation steps.

💡 Pro Tips:
• Use tshark for scripting.
• Check interface with ifconfig.
• Use --no-promiscuous-mode for stealth.
• Install Wireshark plugins.
• Automate updates with cron.
• Verify checksums for downloads.
• Integrate with other tools.

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                "capture" -> """
📡 Capturing Packets - Starting Packet Captures

Capturing packets is the core of Wireshark’s functionality, allowing real-time network analysis.

Detailed Explanation:
Use Wireshark GUI or tshark to capture. Select interfaces (e.g., eth0). Apply capture filters (BPF) to reduce noise. Save captures to .pcap files.

Detailed Explanation of Capture Components:
• Interfaces: eth0, wlan0, etc.
• Filters: BPF syntax (e.g., tcp port 80).
• Tshark: CLI capture tool.
• Files: Save as .pcap for analysis.

Multiple Code Examples:
1. Basic GUI Capture:
- Wireshark > Select eth0 > Start
Explanation: Starts capture on eth0.

2. Tshark Capture:
```bash
tshark -i eth0 -c 100 -w capture.pcap
```
Explanation: Captures 100 packets, saves to file.

3. Capture Filter:
```bash
tshark -i eth0 -f "tcp port 80" -w http.pcap
```
Explanation: Captures HTTP traffic.

4. List Interfaces:
```bash
tshark -D
```
Explanation: Shows available interfaces.

5. Promiscuous Mode:
```bash
tshark -i eth0 -p -w capture.pcap
```
Explanation: Disables promiscuous mode.

6. Save Capture:
```bash
tshark -i eth0 -w capture.pcap
```
Explanation: Saves to .pcap file.

7. Stop After Time:
```bash
tshark -i eth0 -a duration:60 -w capture.pcap
```
Explanation: Captures for 60 seconds.

Common Mistakes:
- Wrong interface, no packets.
- No permissions for capture.
- Large captures, filling disk.
- No filters, overwhelming data.
- Not saving captures.

Real-World Applications:
- Debugging network issues.
- Security monitoring.
- Compliance checks.

⚠️ Safety Tips:
• Use capture filters.
• Secure .pcap files.
• Log captures.

💡 Pro Tips:
• Use ring buffers.
• Combine with nmap.

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                "filters" -> """
🔍 Basic Filters - Applying Capture Filters

Capture filters reduce packet volume using BPF syntax.

Detailed Explanation:
BPF filters (e.g., host 192.168.1.1) limit capture. Apply in GUI or tshark -f.

Detailed Explanation of Filters:
• Host: Filter by IP.
• Port: Filter by port.
• Protocol: Filter by TCP, UDP.

Multiple Code Examples:
1. Host Filter:
```bash
tshark -i eth0 -f "host 192.168.1.1"
```
Explanation: Captures traffic for IP.

2. Port Filter:
```bash
tshark -i eth0 -f "tcp port 80"
```
Explanation: Captures HTTP traffic.

3. Protocol Filter:
```bash
tshark -i eth0 -f "udp"
```
Explanation: Captures UDP packets.

4. Combine Filters:
```bash
tshark -i eth0 -f "host 192.168.1.1 and port 443"
```
Explanation: Combines IP and port.

5. Not Filter:
```bash
tshark -i eth0 -f "not port 22"
```
Explanation: Excludes SSH.

6. Save Filtered:
```bash
tshark -i eth0 -f "tcp port 80" -w http.pcap
```
Explanation: Saves filtered capture.

7. GUI Filter:
- Capture > Options > Capture Filter: tcp port 80
Explanation: Applies filter in GUI.

Common Mistakes:
- Wrong BPF syntax.
- Overly broad filters.
- Ignoring filters.

Real-World Applications:
- HTTP analysis.
- Security monitoring.

⚠️ Safety Tips:
• Test filters.
• Log filter usage.

💡 Pro Tips:
• Use Wireshark filter builder.
• Save common filters.

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                "interfaces" -> """
🌐 Interface Selection - Choosing Network Interfaces

Selecting the correct interface is critical for capturing relevant packets.

Detailed Explanation:
Wireshark lists interfaces (eth0, wlan0). Use ifconfig or tshark -D to verify.

Detailed Explanation of Interfaces:
• Eth0: Wired interface.
• Wlan0: Wireless interface.
• Loopback: Local traffic.

Multiple Code Examples:
1. List Interfaces:
```bash
tshark -D
```
Explanation: Shows available interfaces.

2. Capture on Eth0:
```bash
tshark -i eth0 -w capture.pcap
```
Explanation: Captures on eth0.

3. Wireless Capture:
```bash
tshark -i wlan0 -w wifi.pcap
```
Explanation: Captures wireless traffic.

4. Multiple Interfaces:
```bash
tshark -i eth0 -i wlan0 -w multi.pcap
```
Explanation: Captures on both.

5. GUI Interface:
- Wireshark > Select eth0
Explanation: Selects in GUI.

6. Loopback Capture:
```bash
tshark -i lo -w loopback.pcap
```
Explanation: Captures localhost.

7. Verify Interface:
```bash
ifconfig eth0
```
Explanation: Checks interface status.

Common Mistakes:
- Wrong interface.
- No permissions.

Real-World Applications:
- Network troubleshooting.
- Security analysis.

⚠️ Safety Tips:
• Verify interfaces.
• Secure captures.

💡 Pro Tips:
• Use any for all interfaces.
• Monitor with ifconfig.

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                else -> "Content for $level-$id coming soon!"
            }
            "intermediate" -> when (id) {
                "display" -> """
🖥️ Display Filters - Filtering Displayed Packets

Display filters refine viewed packets in Wireshark.

Detailed Explanation:
Use Wireshark syntax (e.g., ip.addr == 192.168.1.1) to filter.

Detailed Explanation of Display Filters:
• IP: ip.addr, ip.src.
• Protocol: tcp, http.
• Fields: http.request.method.

Multiple Code Examples:
1. IP Filter:
- ip.addr == 192.168.1.1
Explanation: Shows traffic for IP.

2. Protocol Filter:
- tcp
Explanation: Shows TCP packets.

3. HTTP Method:
- http.request.method == "GET"
Explanation: Filters GET requests.

4. Combine Filters:
- ip.addr == 192.168.1.1 and tcp.port == 80
Explanation: Combines IP and port.

5. Tshark Filter:
```bash
tshark -r capture.pcap -Y "ip.addr == 192.168.1.1"
```
Explanation: Applies display filter.

6. Save Filtered:
```bash
tshark -r capture.pcap -Y "tcp" -w tcp.pcap
```
Explanation: Saves filtered packets.

7. Not Filter:
- !tcp.port == 22
Explanation: Excludes SSH.

Common Mistakes:
- Wrong syntax.
- Over-filtering.

Real-World Applications:
- Debugging issues.
- Security analysis.

⚠️ Safety Tips:
• Test filters.
• Save originals.

💡 Pro Tips:
• Use filter autocomplete.
• Save common filters.

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                "protocol" -> """
🔎 Protocol Analysis - Analyzing Specific Protocols

Analyze protocols like HTTP, TCP.

Detailed Explanation:
Use Wireshark’s protocol dissectors.

Detailed Explanation of Analysis:
• HTTP: Request/response details.
• TCP: Stream analysis.
• DNS: Query resolution.

Multiple Code Examples:
1. HTTP Filter:
- http
Explanation: Shows HTTP traffic.

2. TCP Stream:
- Right-click > Follow > TCP Stream
Explanation: Views TCP conversation.

3. DNS Filter:
- dns
Explanation: Shows DNS queries.

4. Tshark HTTP:
```bash
tshark -r capture.pcap -Y "http"
```
Explanation: Filters HTTP packets.

5. Export Objects:
- File > Export Objects > HTTP
Explanation: Saves HTTP files.

6. TCP Flags:
- tcp.flags.syn == 1
Explanation: Filters SYN packets.

7. Protocol Stats:
- Statistics > Protocol Hierarchy
Explanation: Shows protocol breakdown.

Common Mistakes:
- Ignoring protocol details.
- Wrong filters.

Real-World Applications:
- Debugging apps.
- Security monitoring.

⚠️ Safety Tips:
• Secure captures.
• Log analysis.

💡 Pro Tips:
• Use dissectors.
• Export objects.

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                "decoding" -> """
📊 Packet Decoding - Decoding Packets

Decode encrypted or custom packets.

Detailed Explanation:
Use Wireshark’s decode-as feature.

Detailed Explanation of Decoding:
• Decode-As: Reassign protocol.
• SSL/TLS: Decrypt with keys.

Multiple Code Examples:
1. Decode-As:
- Right-click > Decode As > HTTP
Explanation: Forces HTTP decoding.

2. SSL Key Log:
```bash
export SSLKEYLOGFILE=/tmp/sslkeylog.log
wireshark -o ssl.keylog_file:/tmp/sslkeylog.log
```
Explanation: Decrypts SSL with keys.

3. Tshark Decode:
```bash
tshark -r capture.pcap -o "ssl.keylog_file:/tmp/sslkeylog.log"
```
Explanation: Decrypts in tshark.

4. Custom Protocol:
- Edit > Preferences > Protocols
Explanation: Configures custom protocol.

5. Save Decoded:
```bash
tshark -r capture.pcap -Y "http" -w decoded.pcap
```
Explanation: Saves decoded packets.

Common Mistakes:
- Missing keys.
- Wrong protocol.

Real-World Applications:
- Debugging protocols.
- Security analysis.

⚠️ Safety Tips:
• Secure keys.
• Test decoding.

💡 Pro Tips:
• Use key logs.
• Custom dissectors.

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                "statistics" -> """
⚙️ Statistics - Generating Network Statistics

Wireshark provides stats like IO Graphs.

Detailed Explanation:
Use Statistics menu for insights.

Detailed Explanation of Stats:
• IO Graphs: Traffic over time.
• Conversations: Host interactions.
• Endpoints: Traffic by IP.

Multiple Code Examples:
1. IO Graph:
- Statistics > IO Graphs
Explanation: Plots traffic.

2. Conversations:
- Statistics > Conversations
Explanation: Lists host pairs.

3. Tshark Stats:
```bash
tshark -r capture.pcap -z conv,tcp
```
Explanation: TCP conversation stats.

4. Endpoints:
- Statistics > Endpoints
Explanation: Shows IP stats.

5. Packet Lengths:
- Statistics > Packet Lengths
Explanation: Packet size distribution.

6. Save Stats:
```bash
tshark -r capture.pcap -z io,stat,1 > stats.txt
```
Explanation: Saves stats.

7. Filter Stats:
- Statistics > IO Graphs > Filter: tcp
Explanation: Filters TCP stats.

Common Mistakes:
- Ignoring stats.
- No filters.

Real-World Applications:
- Traffic analysis.
- Performance monitoring.

⚠️ Safety Tips:
• Secure stat files.
• Limit scope.

💡 Pro Tips:
• Use IO Graphs.
• Export stats.

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                else -> "Content for $level-$id coming soon!"
            }
            "advanced" -> when (id) {
                "scripting" -> """
📜 Lua Scripting - Writing Custom Dissectors

Write Lua scripts for custom packet analysis.

Detailed Explanation:
Use Lua to create dissectors.

Detailed Explanation of Lua Scripts:
• Dissectors: Parse protocols.
• Post-dissectors: Add fields.

Multiple Code Examples:
1. Basic Lua Dissector:
```lua
my_proto = Proto("MyProto", "My Protocol")
my_field = ProtoField.string("myproto.field", "Field")
my_proto.fields = {my_field}
function my_proto.dissector(buffer, pinfo, tree)
    tree:add(my_field, buffer(0, buffer:len()))
end
```
Explanation: Defines custom protocol.

2. Load Script:
```bash
wireshark -X lua_script:my_dissector.lua
```
Explanation: Loads Lua script.

3. Post-Dissector:
```lua
post_dissector = Proto("PostProto", "Post Dissector")
function post_dissector.dissector(buffer, pinfo, tree)
    tree:add(post_dissector, "Custom Analysis")
end
```
Explanation: Adds post-analysis.

4. Debug Script:
```bash
wireshark -X lua_script:my_dissector.lua -l
```
Explanation: Enables Lua debug.

5. Register Protocol:
```lua
DissectorTable.get("tcp.port"):add(12345, my_proto)
```
Explanation: Assigns to port.

6. Save Script:
```bash
cp my_dissector.lua ~/.wireshark/plugins/
```
Explanation: Installs script.

7. Test Dissector:
```bash
tshark -r capture.pcap -X lua_script:my_dissector.lua
```
Explanation: Tests in tshark.

Common Mistakes:
- Syntax errors.
- Wrong protocol fields.

Real-World Applications:
- Custom protocols.
- Security analysis.

⚠️ Safety Tips:
• Test locally.
• Secure scripts.

💡 Pro Tips:
• Use Lua docs.
• Share dissectors.

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                "decryption" -> """
🔥 Decryption - Decrypting SSL/TLS Traffic

Decrypt SSL/TLS traffic in Wireshark.

Detailed Explanation:
Use SSLKEYLOGFILE or RSA keys.

Detailed Explanation of Decryption:
• Key Log: Browser-generated keys.
• RSA Keys: Server private keys.

Multiple Code Examples:
1. Set Key Log:
```bash
export SSLKEYLOGFILE=/tmp/sslkeylog.log
wireshark -o ssl.keylog_file:/tmp/sslkeylog.log
```
Explanation: Decrypts with key log.

2. Add RSA Key:
- Edit > Preferences > Protocols > SSL > RSA Keys
Explanation: Adds server key.

3. Tshark Decrypt:
```bash
tshark -r capture.pcap -o "ssl.keylog_file:/tmp/sslkeylog.log"
```
Explanation: Decrypts in CLI.

4. Verify Decryption:
- Filter: http
Explanation: Checks decrypted HTTP.

5. Save Decrypted:
```bash
tshark -r capture.pcap -o "ssl.keylog_file:/tmp/sslkeylog.log" -w decrypted.pcap
```
Explanation: Saves decrypted packets.

6. Debug SSL:
- Edit > Preferences > Protocols > SSL > Debug file
Explanation: Logs SSL issues.

7. Browser Config:
- Firefox: about:config > security.ssl.enable_keylog
Explanation: Enables key logging.

Common Mistakes:
- Missing keys.
- Wrong key format.

Real-World Applications:
- Debugging HTTPS.
- Security analysis.

⚠️ Safety Tips:
• Secure keys.
• Authorized only.

💡 Pro Tips:
• Use browser keylogs.
• Automate key collection.

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                "profiles" -> """
🛠️ Custom Profiles - Tailored Configurations

Create custom profiles for workflows.

Detailed Explanation:
Profiles save filter, display settings.

Detailed Explanation of Profiles:
• Profiles: Save configurations.
• Management: Create, export.

Multiple Code Examples:
1. Create Profile:
- Edit > Configuration Profiles > New
Explanation: Creates new profile.

2. Export Profile:
- Edit > Configuration Profiles > Export
Explanation: Saves profile.

3. Import Profile:
- Edit > Configuration Profiles > Import
Explanation: Loads profile.

4. CLI Profile:
```bash
wireshark -o "gui.profile:MyProfile"
```
Explanation: Uses custom profile.

5. Save Filters:
- Profile > Display Filters > Save
Explanation: Saves filters.

6. Switch Profile:
- Edit > Configuration Profiles > MyProfile
Explanation: Switches profile.

7. Tshark Profile:
```bash
tshark -C MyProfile -r capture.pcap
```
Explanation: Uses profile in tshark.

Common Mistakes:
- Not saving profiles.
- Overwriting defaults.

Real-World Applications:
- Team workflows.
- Custom analysis.

⚠️ Safety Tips:
• Backup profiles.
• Secure settings.

💡 Pro Tips:
• Share profiles.
• Use for specific tasks.

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                "automation" -> """
🔄 Automation - Scripting Wireshark Analysis

Automate analysis with tshark and Bash.

Detailed Explanation:
Use tshark for scripted analysis.

Detailed Explanation of Automation:
• Tshark: CLI for captures.
• Scripts: Parse with Bash.

Multiple Code Examples:
1. Auto Capture:
```bash
tshark -i eth0 -c 100 -w auto.pcap
```
Explanation: Captures 100 packets.

2. Script Analysis:
```bash
#!/bin/bash
tshark -r capture.pcap -Y "http" > http.txt
```
Explanation: Filters HTTP to file.

3. Cron Job:
```bash
echo "0 0 * * * tshark -i eth0 -c 100 -w daily.pcap" | crontab -
```
Explanation: Daily capture.

4. Parse Output:
```bash
tshark -r capture.pcap -T fields -e ip.src
```
Explanation: Extracts source IPs.

5. Email Results:
```bash
tshark -r capture.pcap -Y "http" > http.txt && mail -s "Results" user@example.com < http.txt
```
Explanation: Emails results.

6. Filter and Save:
```bash
tshark -r capture.pcap -Y "tcp.port == 80" -w filtered.pcap
```
Explanation: Saves filtered packets.

7. Stats Script:
```bash
tshark -r capture.pcap -z io,stat,1 > stats.txt
```
Explanation: Saves stats.

Common Mistakes:
- No error handling.
- Large captures.

Real-World Applications:
- Monitoring networks.
- Automated reporting.

⚠️ Safety Tips:
• Secure scripts.
• Log captures.

💡 Pro Tips:
• Use -T fields.
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