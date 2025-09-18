package com.guides.content

import com.guides.NavigationState

object BurpSuiteContentProvider : ContentProvider {
    override fun getWelcomeMessage(): String = """
🛡️ Welcome to the Burp Suite Ref. Guide! 🛡️

Dive deep into Burp Suite, the leading toolkit for web application security testing. This comprehensive guide covers everything from setup to advanced exploitation, with detailed explanations, numerous examples, and expert tips to make you a proficient tester.

📖 What you'll learn:

• Basic Topics: Installation & setup, proxy basics, intercepting traffic, scope management
• Intermediate Topics: Scanner, repeater, intruder, session handling
• Advanced Topics: Extender, macros, custom plugins, advanced attacks

🎯 How to navigate:

• Use the sidebar menu to select a topic category
• Click or tap to navigate through menus and subtopics
• Use the back button (← Back) to return to previous menus

🚀 Getting Started:

Choose a topic category from the sidebar to explore subtopics and start learning!
Each section includes in-depth explanations, multiple practical examples, safety guidelines, pro tips, common pitfalls, and real-world applications.

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

Burp Suite is a powerful web vulnerability scanner and proxy tool used by security professionals worldwide. Proper installation and setup are critical for effective testing. This section provides a step-by-step guide, covering various platforms, configuration options, and best practices to get you up and running smoothly.

Detailed Explanation:
Burp Suite comes in Community (free) and Professional (paid) editions. The Professional edition includes advanced features like the active scanner. Installation requires Java Runtime Environment (JRE) 8 or later. After installation, launch Burp and create a temporary project for quick testing or a disk-based project for saving state. Configure the proxy listener and install the CA certificate for HTTPS interception. Initial setup also involves adjusting user options for performance and usability.

Detailed Explanation of Installation Components:
• Editions: Community for learning, Professional for advanced scanning.
• Java: Ensure JRE 8+; use java -version to check.
• Projects: Temporary for quick tests, persistent for complex audits.
• Proxy: Default listener on 127.0.0.1:8080.
• CA Certificate: Essential for HTTPS; trust it in browsers.

Multiple Code Examples:
1. Launching Burp with More Memory (Java Command):
```bash
java -Xmx4g -jar burpsuite_community.jar
```
Explanation: Allocates 4GB heap to Burp, preventing out-of-memory errors during large scans.

2. Installing CA Certificate in Firefox:
- Export CA from Burp Proxy > Options > CA Certificate
- Firefox > Preferences > Privacy & Security > Certificates > Import
- Trust the certificate for websites
Explanation: Exports Burp's CA, imports to Firefox, trusts for HTTPS interception.

3. Configuring Browser Proxy (Chrome):
- Chrome Settings > System > Open proxy settings
- Set HTTP and HTTPS proxy to 127.0.0.1:8080
Explanation: Routes browser traffic through Burp for interception.

4. Checking Burp Version via Command Line:
```bash
java -jar burpsuite_community.jar --version
```
Explanation: Displays Burp version for verification.

5. Headless Mode for Automation:
```bash
java -jar burpsuite_community.jar --headless
```
Explanation: Runs Burp without UI for scripted testing.

6. Custom User Options:
- User Options > Misc > Enable "Accept unsafe SSL certificates"
Explanation: Allows interception of self-signed certificates for testing.

7. Memory Configuration:
- User Options > Misc > Set "Maximum memory in MB" to 4096
Explanation: Increases Burp's memory limit for handling large projects.

Common Mistakes:
- Not installing the CA certificate, leading to SSL errors and broken HTTPS interception.
- Using insufficient memory, causing crashes during large scans or complex projects.
- Forgetting to configure browser proxy, resulting in no traffic capture.
- Running as root/admin, potentially compromising security and exposing the system.
- Ignoring updates, missing critical bug fixes and new features.
- Using temporary projects for long-term work, losing data on restart.
- Not disabling debug mode, leaking sensitive info.

Real-World Applications:
- Setting up for web app pentesting in a lab environment.
- Integrating with CI/CD for automated security checks in development pipelines.
- Using in bug bounty hunting for quick setup on target applications.
- Configuring for team use with shared projects and extensions.
- Setting up for mobile app testing with emulator proxies and traffic analysis.
- Preparing for certification exams like OSCP or CEH.
- Customizing for specific protocols like WebSockets or gRPC.

⚠️ Safety Tips:
• Always download from the official PortSwigger website to avoid malicious versions.
• Run Burp with least privileges; avoid admin mode unless necessary.
• Disable the proxy when not testing to prevent unintended interception of sensitive traffic.
• Secure your CA certificate; don't share it with others.
• Update Burp regularly to address security vulnerabilities and new features.
• Use on virtual machines to isolate testing environments from the host system.
• Avoid testing on production systems without explicit permission.
• Log all activities for compliance and auditing purposes.

💡 Pro Tips:
• Use --user-config-file to load custom configurations from a file.
• Set up multiple proxy listeners for different browsers or projects.
• Use -Dproxy.auth.disabled=true for non-authenticated proxies.
• Integrate with extensions like Logger++ from day one for comprehensive logging.
• Use Burp's command-line options for automated scans in scripts.
• Configure performance settings in User Options > Misc for large-scale testing.
• Test setup with Burp's diagnostic tools and the "Burp Suite Community Edition" tester.

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                "proxy" -> """
🌐 Proxy Basics - Capturing HTTP Traffic

The Burp Proxy is the core feature for intercepting and modifying web traffic. It acts as a man-in-the-middle proxy, allowing you to inspect and alter requests and responses between your browser and the target server.

Detailed Explanation:
Burp Proxy listens on a local port (default 8080) and intercepts traffic when your browser is configured to use it. Intercept mode allows pausing requests for modification. For HTTPS, Burp's CA certificate must be installed to avoid warnings. Invisible proxying handles non-proxy-aware clients. Match and replace rules automate modifications. The proxy history tab logs all traffic for review.

Detailed Explanation of Proxy Components:
• Listener: Configures port and interfaces.
• Intercept: Pauses traffic for editing.
• CA Certificate: Enables HTTPS interception.
• Match and Replace: Automates text changes.
• History: Logs requests/responses.

Multiple Code Examples:
1. Configuring Proxy Listener:
- Proxy > Options > Add
- Bind to port 8081, all interfaces
Explanation: Creates a listener on port 8081 for traffic routing.

2. Browser Proxy Settings (Firefox):
- Preferences > Network Settings > Manual proxy
- HTTP Proxy: 127.0.0.1, Port: 8080
- Use for all protocols
Explanation: Routes all browser traffic through Burp.

3. Match and Replace Rule:
- Proxy > Options > Match and Replace
- Type: Request header
- Match: User-Agent:.*
- Replace: User-Agent: CustomAgent
Explanation: Replaces User-Agent header in all requests.

4. Export CA Certificate:
- Proxy > Options > CA Certificate > Export > DER format
Explanation: Exports Burp CA for browser installation.

5. Import CA in System Trust Store (macOS):
- Open Keychain Access
- Import DER file to System
- Trust for SSL
Explanation: Trusts Burp CA system-wide for HTTPS.

6. Invisible Proxying Setup:
- Proxy > Options > Support invisible proxying
- Configure app to use proxy via environment: http_proxy=127.0.0.1:8080
Explanation: Enables proxy for non-aware apps.

7. Proxy History Filter:
- Proxy > HTTP history > Filter > Show only in-scope
Explanation: Filters history to scoped traffic.

Common Mistakes:
- Not installing CA certificate, causing SSL errors and broken HTTPS interception.
- Leaving intercept on, blocking traffic and hanging the browser.
- Forgetting to forward requests, leading to incomplete sessions.
- Using wrong port, resulting in no traffic capture.
- Ignoring scope, capturing unnecessary traffic and increasing noise.
- Not clearing history, risking data leaks.
- Misconfiguring match and replace, altering wrong traffic.

Real-World Applications:
- Debugging API calls in development environments.
- Testing for injection vulnerabilities by modifying parameters.
- Analyzing mobile app traffic through emulator proxies.
- Reverse engineering web protocols for research.
- Compliance testing for HTTP headers and cookies.
- Training new security testers on traffic interception.

⚠️ Safety Tips:
• Disable intercept when not needed to avoid browser hangs.
• Clear history regularly to prevent data leaks.
• Use separate browser profiles for testing.
• Secure exported CA certificates; don't share them.
• Avoid proxying sensitive non-test traffic.
• Log proxy activities for auditing.
• Use HTTPS for Burp UI if possible.
• Test in isolated environments.

💡 Pro Tips:
• Use keyboard shortcuts: Ctrl+F to forward, Ctrl+D to drop.
• Compare edited vs original requests in history.
• Use comments on intercepted items for notes.
• Combine with macros for automated modifications.
• Use extensions like "Proxy HTTP history in tab" for better navigation.
• Debug with event log for proxy issues.
• Export intercepted sessions for analysis.
• Use for training on vulnerability exploitation.

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                "intercept" -> """
🔍 Intercepting Traffic - Modifying Requests

Intercepting traffic is key to manual testing in Burp Suite. It allows pausing HTTP/HTTPS requests and responses for inspection and modification.

Detailed Explanation:
In Proxy > Intercept tab, toggle intercept to pause traffic. Edit request/response in the inspector, then forward or drop. Actions send to other tools. Filters limit interception to specific types. Use breakpoints for conditional interception.

Detailed Explanation of Interception Process:
• Intercept Tab: Controls pausing.
• Inspector: Edits headers, body, params.
• Actions: Send to Repeater, Intruder.
• Filters: Based on URL, method, etc.
• Breakpoints: Conditional pausing.

Multiple Code Examples:
1. Basic Interception:
- Intercept on
- Browse site
- Edit User-Agent header
- Forward request
Explanation: Pauses request, modifies header, forwards to server.

2. Filter Setup:
- Proxy > Intercept > Intercept Client Requests
- Based on: URL in scope
- And MIME type: HTML, CSS, JS
Explanation: Intercepts only in-scope HTML/JS/CSS requests.

3. Response Modification:
- Intercept responses
- Edit Content-Length if body changed
- Forward
Explanation: Adjusts length for modified response.

4. Action Menu:
- Right-click intercepted request
- Send to Repeater
Explanation: Sends for manual replay.

5. Auto-Intercept Rule:
- Proxy > Options > Intercept Client Requests
- Add condition: Method is POST
Explanation: Auto-intercepts POST requests.

6. Conditional Breakpoint:
- Proxy > Options > Breakpoints
- On response: Status code = 404
Explanation: Breaks on 404 responses.

7. Drop Request:
- Intercept tab > Drop
Explanation: Discards request without forwarding.

Common Mistakes:
- Forgetting to forward, hanging the browser.
- Incorrect Content-Length, breaking responses.
- Intercepting all traffic, overwhelming UI.
- Ignoring filters, capturing noise.
- Modifying without logging changes.
- Not handling redirects properly.
- Overlooking response headers.

Real-World Applications:
- Testing for XSS by modifying parameters.
- Bypassing client-side validation.
- Fuzzing inputs manually.
- Debugging API responses.
- Simulating server errors.
- Analyzing authentication flows.
- Training on request tampering.

⚠️ Safety Tips:
• Log all modifications for accountability.
• Test on non-production environments.
• Avoid altering live data.
• Secure intercepted sensitive info.
• Use in compliance with laws.
• Backup original requests.
• Limit intercept to test sessions.
• Monitor for session expiration.

💡 Pro Tips:
• Use keyboard shortcuts: Ctrl+F to forward, Ctrl+D to drop.
• Compare edited vs original in history.
• Use comments on intercepted items for notes.
• Combine with macros for automated modifications.
• Use extensions like "Proxy HTTP history in tab" for better navigation.
• Debug with event log for proxy issues.
• Export intercepted sessions for analysis.
• Use for training on vulnerability exploitation.

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                "scope" -> """
📜 Scope Management - Defining Targets

Scope management focuses testing on specific targets, reducing noise and preventing accidental scanning of out-of-scope areas.

Detailed Explanation:
Scope defines URLs/hosts for inclusion/exclusion in tools like Scanner, Intruder. Add from Site map or manually with regex. Exclude irrelevant domains to streamline analysis. Scope is critical for ethical testing.

Detailed Explanation of Scope Management:
• Inclusion: Add URLs/hosts to scope.
• Exclusion: Remove from scope.
• Regex: For complex patterns.
• Tools: Applies to all Burp modules.

Multiple Code Examples:
1. Add to Scope:
- Target > Site map > Right-click URL > Add to scope
Explanation: Includes URL in scope for testing.

2. Exclude from Scope:
- Right-click URL > Exclude from scope
Explanation: Removes URL from scope.

3. Manual Scope:
- Target > Scope > Add > URL prefix: http://example.com
Explanation: Adds all URLs under example.com.

4. Regex Scope:
- Add advanced scope with regex: ^http[s]?://(www\.)?example\.com
Explanation: Matches example.com with optional www and HTTP/HTTPS.

5. View Scope:
- Target > Scope tab
Explanation: Lists included/excluded items.

6. Scope in Scanner:
- Scanner > Options > Scope > Include in scope
Explanation: Limits scanner to scoped items.

7. Export Scope:
- Target > Scope > Export
Explanation: Saves scope for reuse.

Common Mistakes:
- Not defining scope, scanning everything.
- Too broad scope, including external sites.
- Forgetting to exclude, causing scope creep.
- Regex errors, missing targets.
- Not applying scope to all tools.
- Ignoring scope in macros.

Real-World Applications:
- Pentesting specific applications.
- Bug bounty hunting on scoped domains.
- Compliance scans for internal sites.
- Team-based testing with shared scope.
- Mobile app testing with limited endpoints.
- API security testing.

⚠️ Safety Tips:
• Define scope before scanning.
• Review scope regularly.
• Exclude sensitive areas.
• Document scope for reports.
• Use for legal compliance.
• Limit to authorized targets.
• Test scope with small scans.

💡 Pro Tips:
• Use scope in all tools (Scanner, Intruder).
• Export/import scope for projects.
• Combine with filters for precision.
• Automate scope with extensions.
• Use for multi-app projects.
• Validate regex with tools.
• Share scope with team.

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                else -> "Content for $level-$id coming soon!"
            }
            "intermediate" -> when (id) {
                "scanner" -> """
🕵️ Scanner - Automated Vulnerability Testing

Burp Scanner automates detection of web vulnerabilities, saving time in large applications.

Detailed Explanation:
Available in Professional, it performs passive and active scans. Passive analyzes traffic, active sends payloads. Configure crawl limits, throttle, and issue types. Results show severity, evidence, and remediation.

Detailed Explanation of Scanner Types:
• Passive: Analyzes existing traffic.
• Active: Sends test payloads.
• Config: Throttle to avoid DoS.

Multiple Code Examples:
1. New Scan:
- Dashboard > New scan > URL: http://target.com
- Scan type: Audit only
Explanation: Starts scan on URL.

2. Crawl and Audit:
- Include spidering for full coverage
Explanation: Crawls site before auditing.

3. Custom Config:
- Scan Configuration > Select issues
Explanation: Limits to specific vulns.

4. Command Line Scan:
```bash
java -jar burpsuite_pro.jar -u http://target.com -r report.html
```
Explanation: Headless scan to report.

5. Throttle Config:
- Scan Configuration > Throttle > 10 requests/sec
Explanation: Limits rate to prevent overload.

6. Issue Filter:
- Scanner > Issues > Filter by severity
Explanation: Views only high-severity issues.

7. Export Results:
- Scanner > Issues > Export > CSV
Explanation: Exports for analysis.

Common Mistakes:
- Scanning without permission.
- Not limiting scope, causing endless crawls.
- Ignoring false positives.
- Over-throttling, slowing scans.
- Not configuring issue types.

Real-World Applications:
- Initial vulnerability assessment.
- Regression testing in CI/CD.
- Bug bounty hunting.
- Compliance audits.
- Team security reviews.

⚠️ Safety Tips:
• Test on staging sites.
• Throttle to avoid DoS.
• Log all scans.
• Report responsibly.
• Limit to authorized targets.
• Monitor for crashes.
• Secure scan data.

💡 Pro Tips:
• Use custom configs for specific vulns.
• Integrate with CI/CD pipelines.
• Analyze issues with evidence.
• Use BApp extensions for custom scans.
• Schedule scans with cron.
• Export to Excel for reporting.
• Combine with manual testing.

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                "repeater" -> """
🔄 Repeater - Manual Request Testing

Repeater allows manual manipulation and resending of HTTP requests for testing.

Detailed Explanation:
Send requests from proxy to Repeater. Edit and send, view responses. Multiple tabs for parallel testing. History for previous requests.

Detailed Explanation of Repeater Features:
• Inspector: Edit headers, body, params.
• Tabs: Multiple requests.
• History: Arrow navigation.
• Actions: Send to Intruder.

Multiple Code Examples:
1. Send to Repeater:
- Proxy > HTTP history > Right-click > Send to Repeater
Explanation: Copies request to Repeater tab.

2. Edit Request:
- Change method, headers, body
- Send with Ctrl + R
Explanation: Modifies and resends request.

3. Response Analysis:
- View Pretty, Raw, Hex tabs
Explanation: Different views for response.

4. History Navigation:
- Use < > arrows
Explanation: Cycles through previous requests.

5. Compare Responses:
- Right-click > Compare with previous
Explanation: Highlights differences.

6. Macro Integration:
- Send to Repeater with macro
Explanation: Applies session handling.

7. Export Request:
- Right-click > Export request
Explanation: Saves for later use.

Common Mistakes:
- Not saving sessions.
- Ignoring history.
- Wrong encoding.
- Not updating Content-Length.
- Over-editing without testing.

Real-World Applications:
- Testing payloads for vulns.
- Debugging API responses.
- Simulating user actions.
- Fuzzing manually.
- Training on request tampering.

⚠️ Safety Tips:
• Test on non-prod.
• Log changes.
• Avoid sensitive data.
• Secure exported requests.
• Validate modifications.

💡 Pro Tips:
• Use shortcuts (Ctrl+R send).
• Save Repeater tabs in project.
• Use match/replace in request.
• Combine with Decoder.
• Automate with Turbo Intruder.

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                "intruder" -> """
💥 Intruder - Automated Attack Simulation

Intruder automates customized attacks by modifying requests with payloads.

Detailed Explanation:
Mark positions in request, choose attack type, load payloads. Run and analyze responses with grep, graphs.

Detailed Explanation of Attack Types:
• Sniper: Single position.
• Battering Ram: Same payload multiple positions.
• Pitchfork: Different payloads per position.
• Cluster Bomb: Cartesian product.

Multiple Code Examples:
1. Sniper Attack:
- Position: §payload§
- Payload: simple list
Explanation: Tests one position with list.

2. Cluster Bomb:
- Multiple positions
- Payload sets for each
Explanation: Tests combinations.

3. Payload from File:
- Load wordlist.txt
Explanation: Uses external payloads.

4. Grep Match:
- Extract specific responses
Explanation: Filters for keywords.

5. Resource Pool:
- Set threads, delays
Explanation: Controls load.

6. Custom Iterator:
- Payload type: custom
Explanation: Generates payloads dynamically.

7. Attack Analysis:
- View graph of responses
Explanation: Visualizes results.

Common Mistakes:
- Too many threads, overwhelming server.
- Not throttling.
- Wrong payload type.
- Ignoring grep matches.
- Overly long payloads.

Real-World Applications:
- Fuzzing parameters.
- Brute-force testing.
- Parameter pollution.
- Testing for race conditions.
- Bug bounty hunting.

⚠️ Safety Tips:
• Get permission.
• Limit impact.
• Monitor server load.
• Log attacks.
• Use on test environments.
• Avoid sensitive data in payloads.

💡 Pro Tips:
• Use custom payloads.
• Analyze with graphs.
• Combine with macros.
• Export results.
• Use for authentication testing.

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                "session" -> """
📊 Session Handling - Managing Authentication

Session handling maintains logged-in state during testing.

Detailed Explanation:
Use rules and macros to update cookies, tokens automatically.

Detailed Explanation of Session Handling:
• Rules: Update session data.
• Macros: Record sequences.
• Token Handling: Auto-update CSRF.

Multiple Code Examples:
1. Session Rule:
- Proxy > Options > Session handling
- Add rule with macro
Explanation: Applies macro to session.

2. Macro Recording:
- Tools > Macros > New
- Record login sequence
Explanation: Records steps for automation.

3. Token Handler:
- Handle CSRF tokens
Explanation: Updates dynamic tokens.

4. Cookie Jar:
- Update cookie jar
Explanation: Manages cookies.

5. Test Rule:
- Tools > Test session handling
Explanation: Validates rule.

Common Mistakes:
- Not testing rules.
- Ignoring scope.
- Wrong macro order.
- Token expiration.

Real-World Applications:
- Testing authenticated pages.
- Automating logins.
- Multi-step workflows.

⚠️ Safety Tips:
• Secure credentials.
• Test in isolation.
• Avoid production.

💡 Pro Tips:
• Use cookie jar.
• Debug rules.
• Combine with intruder.

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                else -> "Content for $level-$id coming soon!"
            }
            "advanced" -> when (id) {
                "extender" -> """
🛠️ Extender - Using Extensions

Extender expands Burp's functionality with plugins.

Detailed Explanation:
BApp Store for pre-built, write custom in Java/Python/Ruby.

Detailed Explanation of Extensions:
• BApp: Burp App Store.
• Custom: Implement IBurpExtender.
• Management: Load, unload.

Multiple Code Examples:
1. Install BApp:
- Extender > BApp Store > Install Logger++
Explanation: Adds logging extension.

2. Load JAR:
- Extender > Add > Select JAR
Explanation: Loads custom extension.

3. Basic Java Extension:
```java
public class MyExtension implements IBurpExtender {
    @Override
    public void registerExtenderCallbacks(IBurpExtenderCallbacks callbacks) {
        callbacks.setExtensionName("My Extension");
        callbacks.printOutput("Loaded!");
    }
}
```
Explanation: Sets name, prints message.

4. Python Extension:
- Use Jython
- Implement IBurpExtender
Explanation: Similar in Python.

5. Extension API Call:
```java
callbacks.registerProxyListener(new ProxyListener());
```
Explanation: Registers proxy listener.

Common Mistakes:
- Loading untrusted extensions.
- Not updating.
- API version mismatches.

Real-World Applications:
- Custom vuln checks.
- Tool integrations.

⚠️ Safety Tips:
• Verify sources.
• Test in sandbox.
• Disable unused.

💡 Pro Tips:
• Use API docs.
• Debug with console.

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                "macros" -> """
🔄 Macros - Automating Tasks

Macros automate multi-request sequences, useful for session maintenance.

Detailed Explanation:
Record macros for logins, then link to session rules.

Detailed Explanation of Macros:
• Recording: Capture request sequence.
• Variables: \$\{token} for dynamic values.
• Testing: Run in editor.

Multiple Code Examples:
1. Record Macro:
- Tools > Macros > New > Record
Explanation: Captures requests.

2. Session Rule:
- Add macro to session handling rule
Explanation: Applies to traffic.

3. Test Macro:
- Run in macro editor
Explanation: Simulates execution.

4. Variable in Macro:
- Use \$\{csrf_token}
Explanation: Replaces with value.

5. Macro Chain:
- Multiple macros in sequence
Explanation: Chains for complex flows.

Common Mistakes:
- Not handling variables.
- Ignoring failures.
- Wrong order.

Real-World Applications:
- Automated logins.
- CSRF handling.
- Multi-step workflows.

⚠️ Safety Tips:
• Test thoroughly.
• Secure data.

💡 Pro Tips:
• Use multiple macros.
• Export for reuse.

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                "plugins" -> """
📜 Custom Plugins - Writing Extensions

Develop custom plugins to extend Burp.

Detailed Explanation:
Use Burp API to implement interfaces for custom functionality.

Detailed Explanation of Plugin Development:
• IBurpExtender: Entry point.
• Callbacks: Access Burp features.
• Testing: Load in Extender.

Multiple Code Examples:
1. Basic Python Plugin:
```python
from burp import IBurpExtender
class BurpExtender(IBurpExtender):
    def registerExtenderCallbacks(self, callbacks):
        callbacks.setExtensionName("My Plugin")
        callbacks.printOutput("Loaded!")
```
Explanation: Sets name, prints message.

2. Proxy Listener:
```python
def registerProxyListener(self, callbacks):
    callbacks.registerProxyListener(self)
```
Explanation: Registers for proxy events.

3. Java Plugin:
```java
public class MyPlugin implements IBurpExtender {
    @Override
    public void registerExtenderCallbacks(IBurpExtenderCallbacks callbacks) {
        callbacks.setExtensionName("My Plugin");
    }
}
```
Explanation: Basic Java implementation.

4. Testing:
- Load in Extender tab
Explanation: Tests plugin.

5. Extension API Call:
```java
callbacks.registerProxyListener(new ProxyListener());
```
Explanation: Adds proxy listener.

Common Mistakes:
- API version mismatches.
- Memory leaks.
- Wrong interface.

Real-World Applications:
- Custom scanners.
- Tool integrations.

⚠️ Safety Tips:
• Test in non-prod.
• Secure code.

💡 Pro Tips:
• Use GitHub examples.
• Share plugins.

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                "attacks" -> """
🔍 Advanced Attacks - Complex Exploitation

Master advanced attack techniques in Burp.

Detailed Explanation:
Combine tools for chain attacks, exploiting vulns like SQLi, XSS, CSRF.

Detailed Explanation of Advanced Attacks:
• SQLi: Inject payloads.
• XSS: Script injection.
• CSRF: Forged requests.

Multiple Code Examples:
1. SQL Injection:
- Use Intruder with payloads
Explanation: Tests for SQLi.

2. XSS Testing:
- Repeater with scripts
Explanation: Tests for XSS.

3. CSRF PoC:
- Generate in Burp
Explanation: Creates CSRF exploit.

4. Parameter Pollution:
- Intruder with multiple params
Explanation: Tests for dup params.

5. Race Condition:
- Repeater rapid sends
Explanation: Tests for races.

Common Mistakes:
- Not chaining vulns.
- Ignoring context.

Real-World Applications:
- Pentesting reports.
- Bug bounties.

⚠️ Safety Tips:
• Authorized only.
• Log actions.

💡 Pro Tips:
• Use Collaborator.
• Automate with extensions.

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                else -> "Content for $level-$id coming soon!"
            }
            else -> "Content for $level-$id coming soon!"
        }
    }
}