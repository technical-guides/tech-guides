package com.guides.content

import com.guides.NavigationState

object NmapContentProvider : ContentProvider {
    override fun getWelcomeMessage(): String = """
🌐 Welcome to the Nmap Ref. Guide! 🌐

This comprehensive tutorial covers Nmap, the industry-standard network scanning tool, from fundamentals to advanced techniques. Learn to map networks, discover vulnerabilities, and automate scans with detailed explanations and practical examples.

📖 What you'll learn:

• Basic Topics: Installation & setup, basic scans, host discovery, port scanning
• Intermediate Topics: Service detection, OS fingerprinting, scan optimization, output formats
• Advanced Topics: NSE scripting, firewall evasion, custom scripts, automation

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
📚 Nmap Ref. Guide

Select a category to begin:

📖 Basic Topics
Learn essential Nmap fundamentals.

⚡ Intermediate Topics
Master scanning techniques.

🚀 Advanced Topics
Dive into expert-level Nmap features.

❌ Exit
Close the application.
            """.trimIndent()
            NavigationState.BASIC_SUBMENU -> """
📰 Basic Topics Menu

Select a subtopic to begin learning:

🛠️ Installation & Setup
Installing and configuring Nmap.

🔍 Basic Scans
Running simple network scans.
Commands: nmap, ping scan

🌐 Host Discovery
Identifying live hosts.
Commands: -sn, -PE

📡 Port Scanning
Discovering open ports.
Commands: -p, -sS, -sT
            """.trimIndent()
            NavigationState.INTERMEDIATE_SUBMENU -> """
⚡ Intermediate Topics Menu

Select a subtopic to advance your Nmap skills:

🖥️ Service Detection
Identifying services on ports.
Commands: -sV, -A

🔎 OS Fingerprinting
Detecting operating systems.
Commands: -O

⚙️ Scan Optimization
Improving scan performance.
Options: --min-rate, -T

📊 Output Formats
Saving and analyzing scan results.
Options: -oN, -oX
            """.trimIndent()
            NavigationState.ADVANCED_SUBMENU -> """
🚀 Advanced Topics Menu

Select a subtopic for expert-level Nmap knowledge:

📜 NSE Scripting
Using Nmap Scripting Engine.
Commands: --script

🔥 Firewall Evasion
Bypassing firewalls and IDS.
Options: -f, --source-port

🛠️ Custom Scripts
Writing NSE scripts.
Language: Lua

🔄 Automation
Automating scans with scripts.
Tools: cron, bash
            """.trimIndent()
        }
    }

    override fun getTopicContent(level: String, id: String): String {
        return when (level) {
            "basics" -> when (id) {
                "install" -> """
🛠️ Installation & Setup - Getting Started with Nmap

Nmap (Network Mapper) is a powerful open-source tool for network exploration and security auditing. This section covers installing Nmap, verifying the setup, and configuring the environment for effective scanning.

Detailed Explanation:
Nmap is available on Linux, macOS, and Windows. Install via package managers (e.g., apt, brew) or compile from source for the latest features. Verify with nmap --version. Configure sudo for privileged scans (e.g., SYN scans). Update scripts with nmap --script-updatedb. Ensure network permissions for scanning.

Detailed Explanation of Installation Components:
• Package Managers: apt for Debian/Ubuntu, brew for macOS.
• Source Install: For cutting-edge features.
• Scripts: NSE scripts in /usr/share/nmap/scripts.
• Privileges: Sudo for raw packet scans.
• Verification: Check version and script database.

Multiple Code Examples:
1. Install Nmap on Ubuntu:
```bash
sudo apt update
sudo apt install nmap
nmap --version
```
Explanation: Updates package list, installs Nmap, verifies version (e.g., 7.94).

2. Install Nmap on macOS:
```bash
brew install nmap
nmap --version
```
Explanation: Uses Homebrew to install, confirms version.

3. Compile Nmap from Source:
```bash
wget https://nmap.org/dist/nmap-latest.tar.bz2
tar -xjf nmap-latest.tar.bz2
cd nmap-*
./configure && make && sudo make install
```
Explanation: Downloads, compiles, and installs latest Nmap.

4. Update NSE Scripts:
```bash
sudo nmap --script-updatedb
```
Explanation: Updates Nmap Scripting Engine database.

5. Check Sudo Permissions:
```bash
sudo nmap --privileged --version
```
Explanation: Verifies Nmap can run privileged scans.

6. Install Zenmap (GUI):
```bash
sudo apt install zenmap
zenmap
```
Explanation: Installs GUI frontend, launches it.

7. Configure PATH:
```bash
echo 'export PATH="\$\PATH:/usr/local/bin"' >> ~/.bashrc
source ~/.bashrc
```
Explanation: Adds Nmap to PATH, reloads .bashrc.

Common Mistakes:
- Running without sudo, limiting scan types (e.g., no SYN scan).
- Not updating scripts, missing new vulnerabilities.
- Installing outdated versions via default repos.
- Misconfiguring network permissions, causing scan failures.
- Forgetting to verify installation with nmap --version.
- Running as root unnecessarily, risking system exposure.
- Ignoring dependencies (e.g., libpcap).

Real-World Applications:
- Auditing network security in enterprise environments.
- Setting up for pentesting labs.
- Preparing for bug bounty hunting.
- Configuring CI/CD pipeline scans.
- Teaching network security fundamentals.
- Mapping internal networks for IT admins.
- Compliance checks for open ports.

⚠️ Safety Tips:
• Install from official sources (nmap.org) to avoid malicious builds.
• Use sudo only for necessary scans (e.g., -sS, -O).
• Backup .bashrc before modifying PATH.
• Run in a sandbox or VM for testing to isolate risks.
• Avoid scanning networks without explicit permission.
• Log installation steps for auditing.
• Secure script directory permissions (chmod 755 /usr/share/nmap).

💡 Pro Tips:
• Use --data-dir to specify custom script locations.
• Install ncat and nping for additional tools.
• Run nmap -v for verbose installation checks.
• Use Zenmap for visual scan management.
• Automate updates with cron (e.g., nmap --script-updatedb).
• Verify checksums of downloaded tarballs.
• Integrate with tools like Metasploit for exploitation.

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                "scans" -> """
🔍 Basic Scans - Running Simple Network Scans

Basic scans identify hosts and open ports, forming the foundation of network exploration with Nmap.

Detailed Explanation:
Use nmap <target> for a default scan. Options like -sP (ping scan) and -sT (TCP connect) control scan types. Targets can be IPs, ranges, or hostnames. Scan output shows open ports and basic info. Always specify scope to avoid unintended scanning.

Detailed Explanation of Scan Types:
• Default Scan: TCP SYN scan (-sS) if privileged.
• Ping Scan: -sn for host discovery.
• TCP Connect: -sT for non-privileged users.
• Targets: IPs, CIDR, ranges (e.g., 192.168.1.0-255).

Multiple Code Examples:
1. Default Scan:
```bash
nmap 192.168.1.1
```
Explanation: Scans common ports on single host, shows open ports.

2. Ping Scan:
```bash
nmap -sn 192.168.1.0/24
```
Explanation: Discovers live hosts in subnet without port scanning.

3. TCP Connect Scan:
```bash
nmap -sT 192.168.1.1
```
Explanation: Uses full TCP handshake, works without sudo.

4. Scan Multiple Hosts:
```bash
nmap 192.168.1.1,2,3
```
Explanation: Scans three specific IPs.

5. Scan Range:
```bash
nmap 192.168.1.1-100
```
Explanation: Scans first 100 IPs in subnet.

6. Verbose Output:
```bash
nmap -v 192.168.1.1
```
Explanation: Provides detailed scan progress and results.

7. Save Output:
```bash
nmap -oN scan.txt 192.168.1.1
```
Explanation: Saves results to scan.txt for review.

Common Mistakes:
- Scanning without permission, violating laws.
- Not specifying targets, scanning too broadly.
- Using -sS without sudo, defaulting to -sT.
- Ignoring scan errors (e.g., host down).
- Not saving output, losing results.
- Misinterpreting open vs filtered ports.
- Running scans on production without approval.

Real-World Applications:
- Mapping corporate networks for IT audits.
- Identifying rogue devices in a subnet.
- Preparing for pentests by scoping targets.
- Checking firewall rules for open ports.
- Teaching network scanning basics.
- Verifying server configurations.
- Compliance checks for exposed services.

⚠️ Safety Tips:
• Obtain explicit permission before scanning.
• Limit scans to authorized networks.
• Use -sn for non-intrusive discovery.
• Redirect errors to /dev/null (nmap ... 2>/dev/null).
• Log scan commands for auditing.
• Avoid aggressive scans on sensitive systems.
• Test in a lab environment first.

💡 Pro Tips:
• Use -iL <file> for target lists.
• Combine -v and -d for debug output.
• Run nmap --reason for port status details.
• Use --open to show only open ports.
• Schedule scans with cron for monitoring.
• Parse output with grep or awk.
• Use Zenmap for GUI-based scans.

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                "discovery" -> """
🌐 Host Discovery - Identifying Live Hosts

Host discovery identifies active devices on a network, a critical first step in scanning.

Detailed Explanation:
Use -sn for ping scans, avoiding port scans. Options like -PE (ICMP echo) and -PS (TCP SYN) refine discovery. Exclude hosts with --exclude. Discovery is lightweight, reducing network impact.

Detailed Explanation of Discovery Techniques:
• Ping Scan: -sn disables port scanning.
• ICMP: -PE for echo requests.
• TCP SYN: -PS for specific ports.
• ARP: Used automatically for local networks.

Multiple Code Examples:
1. Basic Ping Scan:
```bash
nmap -sn 192.168.1.0/24
```
Explanation: Lists live hosts in subnet.

2. ICMP Echo Scan:
```bash
nmap -PE 192.168.1.1
```
Explanation: Uses ICMP to check if host is up.

3. TCP SYN Discovery:
```bash
nmap -PS80,443 192.168.1.1
```
Explanation: Sends SYN to ports 80, 443.

4. Exclude Hosts:
```bash
nmap -sn 192.168.1.0/24 --exclude 192.168.1.1
```
Explanation: Skips specified host.

5. ARP Scan:
```bash
sudo nmap -PR 192.168.1.0/24
```
Explanation: Uses ARP for local network.

6. Verbose Discovery:
```bash
nmap -sn -v 192.168.1.0/24
```
Explanation: Shows detailed discovery process.

7. Save Discovery Output:
```bash
nmap -sn -oN hosts.txt 192.168.1.0/24
```
Explanation: Saves live hosts to file.

Common Mistakes:
- Scanning without permission, risking legal issues.
- Missing --exclude, scanning sensitive hosts.
- Not using sudo for ARP scans.
- Ignoring filtered hosts.
- Overloading network with fast scans.
- Not verifying live hosts.
- Misinterpreting down hosts.

Real-World Applications:
- Mapping DMZ networks.
- Detecting unauthorized devices.
- Preparing for vulnerability scans.
- Auditing network inventory.
- Teaching network discovery.
- Verifying firewall blocks.
- Compliance checks for live hosts.

⚠️ Safety Tips:
• Get permission for scans.
• Use -sn for minimal impact.
• Log all discovery commands.
• Avoid scanning critical systems.
• Exclude sensitive IPs.
• Test in isolated networks.
• Monitor network load.

💡 Pro Tips:
• Use -iL for host lists.
• Combine -PS with common ports.
• Use --reason for details.
• Parse output with grep.
• Automate with scripts.
• Use -n to skip DNS.
• Integrate with asset management.

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                "ports" -> """
📡 Port Scanning - Discovering Open Ports

Port scanning identifies open, closed, or filtered ports on hosts.

Detailed Explanation:
Use -p to specify ports, -sS for SYN scans, -sT for TCP connect. Options like --open filter results. Port states indicate firewall presence.

Detailed Explanation of Port Scan Types:
• SYN Scan: -sS, stealth, requires sudo.
• TCP Connect: -sT, full handshake.
• UDP Scan: -sU, for UDP services.
• Port Ranges: -p1-1000, -p- for all.

Multiple Code Examples:
1. SYN Scan:
```bash
sudo nmap -sS 192.168.1.1
```
Explanation: Stealth scan of common ports.

2. TCP Connect Scan:
```bash
nmap -sT 192.168.1.1
```
Explanation: Full TCP handshake scan.

3. Specific Ports:
```bash
nmap -p 22,80,443 192.168.1.1
```
Explanation: Scans only listed ports.

4. UDP Scan:
```bash
sudo nmap -sU 192.168.1.1
```
Explanation: Scans UDP ports.

5. All Ports:
```bash
nmap -p- 192.168.1.1
```
Explanation: Scans all 65,535 ports.

6. Open Ports Only:
```bash
nmap --open 192.168.1.1
```
Explanation: Shows only open ports.

7. Save Port Scan:
```bash
nmap -p 80,443 -oN ports.txt 192.168.1.1
```
Explanation: Saves results to file.

Common Mistakes:
- Not using sudo for -sS.
- Scanning all ports, slowing scans.
- Ignoring filtered ports.
- No permission for scans.
- Not saving output.
- Misinterpreting states.

Real-World Applications:
- Checking server exposures.
- Firewall rule audits.
- Pentesting prep.
- Compliance scans.
- Teaching port scanning.

⚠️ Safety Tips:
• Scan authorized targets.
• Use --open to reduce noise.
• Log scans for auditing.
• Avoid aggressive scans.
• Test in lab environments.

💡 Pro Tips:
• Use -F for fast scans.
• Combine with -sV.
• Parse with grep.
• Use --reason for details.
• Schedule with cron.

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                else -> "Content for $level-$id coming soon!"
            }
            "intermediate" -> when (id) {
                "services" -> """
🖥️ Service Detection - Identifying Services

Service detection identifies software and versions running on open ports.

Detailed Explanation:
Use -sV for service detection, -A for comprehensive scans. Version intensity (--version-intensity) controls depth. Scripts enhance detection.

Detailed Explanation of Service Detection:
• Service Scan: -sV probes services.
• Comprehensive: -A includes -sV, -O.
• Intensity: 0-9, higher is more thorough.
• Scripts: NSE for specific services.

Multiple Code Examples:
1. Service Scan:
```bash
nmap -sV 192.168.1.1
```
Explanation: Detects services on open ports.

2. Comprehensive Scan:
```bash
sudo nmap -A 192.168.1.1
```
Explanation: Includes service, OS, scripts.

3. Version Intensity:
```bash
nmap -sV --version-intensity 9 192.168.1.1
```
Explanation: Uses maximum probe depth.

4. Specific Service:
```bash
nmap --script http-title 192.168.1.1
```
Explanation: Gets HTTP titles.

5. Save Service Output:
```bash
nmap -sV -oN services.txt 192.168.1.1
```
Explanation: Saves service details.

6. Aggressive Service Scan:
```bash
nmap -sV --version-all 192.168.1.1
```
Explanation: Uses all probes.

7. Script with Args:
```bash
nmap --script http-enum --script-args http-enum.basepath=/app 192.168.1.1
```
Explanation: Enumerates web paths.

Common Mistakes:
- Not using -sV, missing versions.
- Low intensity, incomplete data.
- Ignoring script output.
- No permission for scans.

Real-World Applications:
- Identifying vulnerable services.
- Compliance checks.
- Pentesting prep.
- Network inventory.

⚠️ Safety Tips:
• Scan authorized targets.
• Log service scans.
• Use low intensity initially.
• Avoid production systems.

💡 Pro Tips:
• Use --script vuln.
• Combine with -A.
• Parse with awk.
• Automate with cron.

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                "os" -> """
🔎 OS Fingerprinting - Detecting Operating Systems

OS fingerprinting identifies remote system types and versions.

Detailed Explanation:
Use -O for OS detection. Requires sudo for TCP/IP stack analysis. Combine with -sV for full profiling.

Detailed Explanation of OS Detection:
• OS Scan: -O analyzes TCP/IP.
• Comprehensive: -A includes -O.
• Accuracy: Depends on open ports.

Multiple Code Examples:
1. OS Scan:
```bash
sudo nmap -O 192.168.1.1
```
Explanation: Detects OS and version.

2. Comprehensive Scan:
```bash
sudo nmap -A 192.168.1.1
```
Explanation: Includes OS, services.

3. Save OS Output:
```bash
nmap -O -oN os.txt 192.168.1.1
```
Explanation: Saves OS details.

4. Verbose OS Scan:
```bash
sudo nmap -O -v 192.168.1.1
```
Explanation: Detailed OS output.

5. Specific Ports:
```bash
sudo nmap -O -p 22,80 192.168.1.1
```
Explanation: Limits ports for OS scan.

6. Aggressive OS Scan:
```bash
sudo nmap -O --osscan-guess 192.168.1.1
```
Explanation: Guesses OS aggressively.

7. Script with OS:
```bash
nmap --script banner -O 192.168.1.1
```
Explanation: Combines banner grab with OS.

Common Mistakes:
- No sudo, failing OS scan.
- Ignoring port requirements.
- Misinterpreting guesses.

Real-World Applications:
- Vulnerability mapping.
- Compliance audits.
- Pentesting prep.

⚠️ Safety Tips:
• Use sudo for -O.
• Scan authorized targets.
• Log scans.

💡 Pro Tips:
• Combine with -sV.
• Use --osscan-limit.
• Parse output.

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                "optimization" -> """
⚙️ Scan Optimization - Improving Performance

Optimize Nmap scans for speed and efficiency.

Detailed Explanation:
Use --min-rate, -T, --max-retries for performance. Timing templates (-T0 to -T5) balance speed and accuracy.

Detailed Explanation of Optimization:
• Rate: --min-rate for packets/sec.
• Timing: -T0 (slow) to -T5 (fast).
• Retries: --max-retries for reliability.

Multiple Code Examples:
1. Fast Scan:
```bash
nmap -T4 192.168.1.1
```
Explanation: Uses aggressive timing.

2. Rate Control:
```bash
nmap --min-rate 1000 192.168.1.1
```
Explanation: Sets minimum packet rate.

3. Limit Retries:
```bash
nmap --max-retries 1 192.168.1.1
```
Explanation: Reduces retries.

4. Parallel Scans:
```bash
nmap --min-parallelism 10 192.168.1.0/24
```
Explanation: Increases parallel hosts.

5. Timing Template:
```bash
nmap -T3 192.168.1.1
```
Explanation: Balanced timing.

6. Host Timeout:
```bash
nmap --host-timeout 30s 192.168.1.1
```
Explanation: Limits per-host time.

7. Save Optimized:
```bash
nmap -T4 -oN fast.txt 192.168.1.1
```
Explanation: Saves fast scan output.

Common Mistakes:
- Too aggressive, triggering IDS.
- No timeout, hanging scans.
- Ignoring retries.

Real-World Applications:
- Large network scans.
- Time-sensitive audits.

⚠️ Safety Tips:
• Test timing in lab.
• Log aggressive scans.
• Avoid -T5 on prod.

💡 Pro Tips:
• Use --stats-every.
• Combine with -v.
• Automate optimization.

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                "output" -> """
📊 Output Formats - Saving and Analyzing Results

Nmap supports multiple output formats for analysis.

Detailed Explanation:
Use -oN (normal), -oX (XML), -oG (grepable). Combine with -oA for all formats.

Detailed Explanation of Outputs:
• Normal: -oN, human-readable.
• XML: -oX, for tools.
• Grepable: -oG, for scripts.

Multiple Code Examples:
1. Normal Output:
```bash
nmap -oN scan.txt 192.168.1.1
```
Explanation: Saves to text file.

2. XML Output:
```bash
nmap -oX scan.xml 192.168.1.1
```
Explanation: Saves for parsing.

3. Grepable Output:
```bash
nmap -oG scan.gnmap 192.168.1.1
```
Explanation: Saves for grep.

4. All Outputs:
```bash
nmap -oA scan 192.168.1.1
```
Explanation: Saves all formats.

5. Parse XML:
```bash
xmlstarlet sel -t -v "//host" scan.xml
```
Explanation: Extracts hosts from XML.

6. Grep Open Ports:
```bash
grep "open" scan.gnmap
```
Explanation: Filters open ports.

7. Verbose Save:
```bash
nmap -v -oN verbose.txt 192.168.1.1
```
Explanation: Saves detailed output.

Common Mistakes:
- Not saving output.
- Wrong format for tools.
- Large files.

Real-World Applications:
- Reporting vulns.
- Tool integration.

⚠️ Safety Tips:
• Secure output files.
• Log outputs.

💡 Pro Tips:
• Use -oX with tools.
• Parse with scripts.

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                else -> "Content for $level-$id coming soon!"
            }
            "advanced" -> when (id) {
                "scripting" -> """
📜 NSE Scripting - Using Nmap Scripting Engine

NSE extends Nmap with Lua scripts for advanced tasks.

Detailed Explanation:
Use --script to run NSE scripts. Categories include vuln, auth, discovery.

Detailed Explanation of NSE:
• Scripts: Located in /usr/share/nmap/scripts.
• Categories: vuln, brute, http.
• Args: --script-args for customization.

Multiple Code Examples:
1. Run Vuln Script:
```bash
nmap --script vuln 192.168.1.1
```
Explanation: Checks for vulnerabilities.

2. HTTP Enum:
```bash
nmap --script http-enum 192.168.1.1
```
Explanation: Enumerates web paths.

3. Script with Args:
```bash
nmap --script http-title --script-args http.useragent="Custom" 192.168.1.1
```
Explanation: Customizes user agent.

4. Multiple Scripts:
```bash
nmap --script http-title,http-methods 192.168.1.1
```
Explanation: Runs multiple scripts.

5. Script Trace:
```bash
nmap --script-trace http-enum 192.168.1.1
```
Explanation: Shows script execution.

6. Update Scripts:
```bash
sudo nmap --script-updatedb
```
Explanation: Updates script database.

7. Custom Script:
```bash
nmap --script my-script.nse 192.168.1.1
```
Explanation: Runs custom script.

Common Mistakes:
- Outdated scripts.
- Wrong args.
- No permission.

Real-World Applications:
- Vuln scanning.
- Service discovery.

⚠️ Safety Tips:
• Test scripts.
• Update regularly.

💡 Pro Tips:
• Use --script-help.
• Write custom scripts.

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                "evasion" -> """
🔥 Firewall Evasion - Bypassing Defenses

Evade firewalls and IDS with Nmap techniques.

Detailed Explanation:
Use -f, --source-port, --data-length to bypass.

Detailed Explanation of Evasion:
• Fragmentation: -f splits packets.
• Source Port: --source-port uses specific ports.
• Decoys: -D adds fake IPs.

Multiple Code Examples:
1. Fragment Scan:
```bash
nmap -f 192.168.1.1
```
Explanation: Fragments packets.

2. Source Port:
```bash
nmap --source-port 53 192.168.1.1
```
Explanation: Uses port 53.

3. Decoy Scan:
```bash
nmap -D RND:10 192.168.1.1
```
Explanation: Uses 10 decoy IPs.

4. Spoof MAC:
```bash
nmap --spoof-mac 00:11:22:33:44:55 192.168.1.1
```
Explanation: Spoofs MAC address.

5. Data Length:
```bash
nmap --data-length 100 192.168.1.1
```
Explanation: Adds padding.

6. Bad Checksum:
```bash
nmap --badsum 192.168.1.1
```
Explanation: Sends invalid checksums.

7. Idle Scan:
```bash
nmap -sI zombiehost 192.168.1.1
```
Explanation: Uses zombie host.

Common Mistakes:
- Overuse of evasion.
- Triggering IDS.

Real-World Applications:
- Pentesting firewalls.
- IDS testing.

⚠️ Safety Tips:
• Authorized only.
• Log attempts.

💡 Pro Tips:
• Combine techniques.
• Test in lab.

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                "custom" -> """
🛠️ Custom Scripts - Writing NSE Scripts

Write custom NSE scripts in Lua.

Detailed Explanation:
Use Lua to extend Nmap functionality.

Detailed Explanation of NSE Scripts:
• Structure: Lua with nmap libraries.
• Categories: vuln, discovery.
• Testing: Run with --script.

Multiple Code Examples:
1. Basic NSE Script:
```lua
description = [[Example Script]]
portrule = portnumber(80)
action = function(host, port)
  return "Port 80 open"
end
```
Explanation: Checks for port 80.

2. Save Script:
```bash
echo "script content" > /usr/share/nmap/scripts/my-script.nse
```
Explanation: Saves custom script.

3. Run Custom:
```bash
nmap --script my-script.nse 192.168.1.1
```
Explanation: Executes script.

4. Debug Script:
```bash
nmap --script-trace my-script.nse 192.168.1.1
```
Explanation: Traces execution.

5. Script with Args:
```bash
nmap --script my-script --script-args key=value 192.168.1.1
```
Explanation: Passes arguments.

6. Update DB:
```bash
sudo nmap --script-updatedb
```
Explanation: Updates script database.

7. Test Script:
```bash
nmap --script my-script.nse -d 192.168.1.1
```
Explanation: Debugs script.

Common Mistakes:
- Syntax errors.
- No testing.

Real-World Applications:
- Custom vulns.
- Automation.

⚠️ Safety Tips:
• Test locally.
• Secure scripts.

💡 Pro Tips:
• Use NSE docs.
• Share scripts.

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                "automation" -> """
🔄 Automation - Scripting Nmap Scans

Automate Nmap scans with Bash.

Detailed Explanation:
Use cron, Bash scripts for automation.

Detailed Explanation of Automation:
• Scripts: Combine nmap with loops.
• Cron: Schedule scans.
• Parsing: Use -oX, grep.

Multiple Code Examples:
1. Basic Script:
```bash
#!/bin/bash
nmap -oN scan.txt 192.168.1.0/24
```
Explanation: Scans subnet, saves output.

2. Cron Job:
```bash
echo "0 0 * * * nmap -oN scan.txt 192.168.1.0/24" | crontab -
```
Explanation: Schedules daily scan.

3. Parse XML:
```bash
xmlstarlet sel -t -v "//port" scan.xml
```
Explanation: Extracts ports.

4. Loop Scan:
```bash
for ip in 192.168.1.{1..10}; do nmap "\$\ip"; done
```
Explanation: Scans range.

5. Error Handling:
```bash
nmap 192.168.1.1 || echo "Scan failed"
```
Explanation: Handles errors.

6. Verbose Script:
```bash
nmap -v -oN verbose.txt 192.168.1.1
```
Explanation: Detailed output.

7. Email Results:
```bash
nmap -oN scan.txt 192.168.1.1 && mail -s "Scan Results" user@example.com < scan.txt
```
Explanation: Emails results.

Common Mistakes:
- No error handling.
- Over-scheduling.

Real-World Applications:
- Network monitoring.
- Compliance.

⚠️ Safety Tips:
• Secure scripts.
• Log scans.

💡 Pro Tips:
• Use -oX.
• Integrate with tools.

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                else -> "Content for $level-$id coming soon!"
            }
            else -> "Content for $level-$id coming soon!"
        }
    }
}