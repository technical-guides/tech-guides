package com.guides.content

import com.guides.NavigationState

object BashContentProvider : ContentProvider {
    override fun getWelcomeMessage(): String = """
🐚 Welcome to the Bash Ref. Guide! 🐚

This comprehensive tutorial covers Bash scripting from fundamentals to advanced techniques, with detailed explanations, numerous examples, and practical tips for automation and system administration.

📖 What you'll learn:

• Basic Topics: Installation & setup, variables & data types, control structures, basic commands
• Intermediate Topics: Functions, arrays, file manipulation, process management
• Advanced Topics: Advanced scripting, regular expressions, networking, debugging

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
📚 Bash Ref. Guide

Select a category to begin:

📖 Basic Topics
Learn essential Bash fundamentals.

⚡ Intermediate Topics
Master scripting techniques.

🚀 Advanced Topics
Dive into expert-level Bash features.

❌ Exit
Close the application.
            """.trimIndent()
            NavigationState.BASIC_SUBMENU -> """
📰 Basic Topics Menu

Select a subtopic to begin learning:

🛠️ Installation & Setup
Setting up Bash environment on various platforms.
Commands: bash, chmod, source

🔤 Variables & Data Types
Working with variables and basic data types in Bash.
Concepts: Strings, integers, environment variables

🔀 Control Structures
Using if statements, loops, and conditionals for flow control.
Commands: if, for, while, case

📊 Basic Commands
Common Bash commands for file and text manipulation.
Commands: ls, cd, echo, grep, cat
            """.trimIndent()
            NavigationState.INTERMEDIATE_SUBMENU -> """
⚡ Intermediate Topics Menu

Select a subtopic to advance your Bash skills:

💻 Functions
Defining reusable functions for modular scripts.
Commands: function, return, local

📦 Arrays
Managing lists and associative arrays.
Concepts: Indexed arrays, associative arrays, iteration

📁 File Manipulation
Reading, writing, and processing files.
Commands: read, write, sed, awk, cat

🛠️ Process Management
Controlling and monitoring system processes.
Commands: ps, kill, bg, fg, jobs
            """.trimIndent()
            NavigationState.ADVANCED_SUBMENU -> """
🚀 Advanced Topics Menu

Select a subtopic for expert-level Bash knowledge:

📜 Advanced Scripting
Building complex scripts with error handling and modularity.
Concepts: Traps, set options, subshells

🔍 Regular Expressions
Pattern matching and text processing with regex.
Commands: grep, sed, awk, regex operators

🌐 Networking
Network-related scripting and monitoring.
Commands: curl, nc, ping, ssh

🐞 Debugging
Troubleshooting and optimizing Bash scripts.
Tools: set -x, trap, shellcheck
            """.trimIndent()
        }
    }

    override fun getTopicContent(level: String, id: String): String {
        return when (level) {
            "basics" -> when (id) {
                "install" -> """
🛠️ Installation & Setup - Getting Started with Bash

Bash (Bourne Again Shell) is a powerful command-line shell and scripting language for Unix-like systems. This section covers installing Bash, verifying the setup, configuring the environment, and running your first script.

Detailed Explanation:
Bash is pre-installed on most Linux and macOS systems. On Windows, use WSL or Git Bash. Configuration involves editing .bashrc for aliases and environment settings. Scripts require a shebang (#!/bin/bash) and executable permissions. Key tools include bash, chmod, and source. Ensure PATH is set for script execution.

Detailed Explanation of Setup Components:
• Installation: Use package managers (apt, brew) or WSL for Windows.
• Configuration: .bashrc for user settings, /etc/bash.bashrc for system-wide.
• Scripts: Shebang ensures Bash execution, chmod adds permissions.
• Verification: Check version and shell type.

Multiple Code Examples:
1. Verify Bash Installation:
```bash
bash --version
```
Explanation: Displays Bash version (e.g., GNU bash, version 5.1). Run in terminal to confirm Bash is installed.

2. Install Bash on Ubuntu/Debian:
```bash
sudo apt update
sudo apt install bash
bash --version
```
Explanation: Updates package list, installs Bash, verifies version. Ensures latest Bash is available.

3. Install Bash on Windows (WSL):
```bash
wsl --install
bash
echo "\$\SHELL"
```
Explanation: Installs WSL, starts Bash, confirms shell path (e.g., /bin/bash).

4. Configure .bashrc:
```bash
echo 'alias ll="ls -la"' >> ~/.bashrc
source ~/.bashrc
ll
```
Explanation: Adds ll alias for detailed ls, reloads .bashrc, tests alias. Simplifies commands.

5. Create and Run Script:
```bash
echo '#!/bin/bash\necho "Hello, Bash!"' > hello.sh
chmod +x hello.sh
./hello.sh
```
Explanation: Creates script with shebang, makes it executable, runs it to print message.

6. Add Script to PATH:
```bash
mkdir ~/bin
mv hello.sh ~/bin/
export PATH="\$\HOME/bin:\$\PATH"
hello.sh
```
Explanation: Creates bin directory, moves script, updates PATH, runs script from anywhere.

7. Check Shell Type:
```bash
echo "\$\0"
ps -p \$\\$\
```
Explanation: \$\0 shows current shell, ps confirms process details. Verifies Bash is running.

Common Mistakes:
- Running scripts without chmod +x, causing permission errors.
- Incorrect shebang (e.g., #!/bin/sh).
- Not sourcing .bashrc after changes.
- Case-sensitive variable names.
- PATH misconfiguration, preventing script execution.
- Using sudo for user-level scripts.
- Overwriting system .bashrc.

Real-World Applications:
- Automating system administration tasks (e.g., backups).
- Setting up development environments.
- Writing CLI tools for DevOps.
- Configuring servers with scripts.
- Managing user environments in CI/CD pipelines.
- Quick prototyping for automation.
- Running cron jobs for scheduling.

⚠️ Safety Tips:
• Use shebang (#!/bin/bash) to specify Bash.
• Run scripts with least privileges; avoid sudo unless necessary.
• Backup .bashrc before editing.
• Secure script permissions with chmod 700.
• Test scripts in a sandbox environment.
• Avoid running untrusted scripts from the internet.
• Log installation steps for auditing.

💡 Pro Tips:
• Use shopt to enable features (e.g., shopt -s autocd).
• Customize PS1 for prompt (e.g., export PS1="\\u@\\h:\\w\\$\ ").
• Use .bash_profile for login shells.
• Leverage /etc/bash.bashrc for system-wide configs.
• Install shellcheck to lint scripts.
• Add ~/bin to PATH for custom scripts.
• Use tput for colored output in scripts.

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                "variables" -> """
🔤 Variables & Data Types - Building Blocks of Bash

Variables in Bash store data for scripting, using dynamic typing where most values are treated as strings. Understanding how to define, access, and manipulate variables is crucial for effective scripting.

Detailed Explanation:
Variables are assigned with name=value (no spaces). Access using \$\name or \$\{name} for clarity. Bash supports strings, integers (via arithmetic), arrays, and environment variables (exported for child processes). Readonly variables prevent changes. Parameter expansion provides defaults, substitutions, and slicing.

Detailed Explanation of Variable Types:
• Strings: Default type, quoted for safety (e.g., "\$\var").
• Integers: Used in arithmetic with (( )).
• Arrays: Indexed or associative for lists.
• Environment: Exported for subprocesses.
• Special Variables: \$\?, \$\1, \$\HOME, etc.

Multiple Code Examples:
1. Basic Variable Assignment and Access:
```bash
name="Alice"
echo "\$\name"
```
Explanation: Assigns string "Alice" to name, prints it. Quotes prevent issues with unset variables.

2. Environment Variable:
```bash
export MY_VAR="test"
env | grep MY_VAR
```
Explanation: Exports MY_VAR for subprocesses, grep confirms it’s in environment.

3. Readonly Variable:
```bash
readonly PI=3.14
echo "\$\PI"
```
Explanation: Sets constant PI, prevents reassignment, prints value.

4. Parameter Expansion with Default:
```bash
default="World"
echo "\$\{name:-\$\default}"
```
Explanation: Prints name if set, else default ("World").

5. Arithmetic Operation:
```bash
count=5
((count+=1))
echo "\$\count"
```
Explanation: Increments count using arithmetic, prints result (6).

6. String Manipulation:
```bash
greeting="Hello, \$\name"
echo "\$\{greeting^^}"
```
Explanation: Converts greeting to uppercase using parameter expansion.

7. Special Variables:
```bash
echo "\$\? \$\1 \$\HOME"
```
Explanation: \$\? shows last command’s exit status, \$\1 first argument, \$\HOME user’s home directory.

Common Mistakes:
- Spaces around = in assignments (e.g., name = "Alice").
- Missing \$\ when accessing variables.
- Not quoting variables, causing word splitting or errors.
- Overwriting system variables like PATH.
- Forgetting export for child processes.
- Case-sensitive variable names.
- Using unset variables without defaults.

Real-World Applications:
- Storing configuration in scripts.
- Managing user input in CLI tools.
- Environment setup for DevOps pipelines.
- Logging variable states in automation.
- Dynamic command construction in scripts.
- Parsing outputs from commands.
- Temporary variables for processing.

⚠️ Safety Tips:
• Quote variables to prevent splitting: "\$\var".
• Avoid eval for variable expansion; use parameter expansion.
• Use readonly for constants to prevent accidental changes.
• Validate user input before assigning to variables.
• Unset sensitive variables after use (unset var).
• Use local variables in functions to avoid conflicts.
• Log variable changes in critical scripts for debugging.

💡 Pro Tips:
• Use \$\{var,,} for lowercase, \$\{var^^} for uppercase.
• Set defaults with \$\{var:=value}.
• Use declare -p to inspect variables.
• Store arrays for complex data structures.
• Use getopts for parsing CLI arguments.
• Avoid global variables in large scripts.
• Use mktemp for temporary variable storage.

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                "control" -> """
🔀 Control Structures - Flow Control in Bash

Control structures manage script execution flow using conditionals and loops, enabling dynamic behavior based on data or conditions.

Detailed Explanation:
Bash uses if-then-else for conditionals, for/while/until for loops, and case for pattern matching. The test command ([ ]) or [[ ]] evaluates conditions. Proper quoting and operators (e.g., -eq, ==) are critical for robust scripts.

Detailed Explanation of Control Structures:
• If: Tests conditions with [ ] or [[ ]].
• Loops: For iterates over lists, while/until for conditions.
• Case: Matches patterns for multi-option logic.
• Test: Evaluates expressions (e.g., -f for file existence).

Multiple Code Examples:
1. If Statement with Numeric Comparison:
```bash
age=20
if [ "\$\age" -gt 18 ]; then
    echo "Adult"
elif [ "\$\age" -eq 18 ]; then
    echo "Just 18"
else
    echo "Minor"
fi
```
Explanation: Checks age against 18, prints category. Quotes ensure safe variable expansion.

2. For Loop over List:
```bash
for i in 1 2 3; do
    echo "Number: \$\i"
done
```
Explanation: Iterates over space-separated list, prints each number.

3. While Loop with Counter:
```bash
count=0
while [ "\$\count" -lt 3 ]; do
    echo "Count: \$\count"
    ((count++))
done
```
Explanation: Loops until count reaches 3, incrementing each iteration.

4. Case Statement for Pattern Matching:
```bash
day="Monday"
case "\$\day" in
    "Monday")
        echo "Start of week"
        ;;
    "Friday")
        echo "End of week"
        ;;
    *)
        echo "Other day"
        ;;
esac
```
Explanation: Matches day to patterns, prints message. * is default case.

5. File Existence Check:
```bash
[ -f "file.txt" ] && echo "File exists" || echo "File missing"
```
Explanation: Tests if file exists, prints result using short-circuit operators.

6. Until Loop:
```bash
count=0
until [ "\$\count" -ge 3 ]; do
    echo "Count: \$\count"
    ((count++))
done
```
Explanation: Loops until count is 3 or more, opposite of while.

7. Loop with Break:
```bash
for i in {1..5}; do
    [ "\$\i" -eq 3 ] && break
    echo "\$\i"
done
```
Explanation: Exits loop when i equals 3, printing only 1 and 2.

Common Mistakes:
- Missing spaces in test conditions (e.g., [ \$\var=val ]).
- Using = instead of == in [[ ]].
- Not quoting variables in tests, causing errors.
- Infinite loops without break or condition update.
- Incorrect operators (-eq for numbers, == for strings).
- Missing fi or esac to close blocks.
- Overusing nested conditionals.

Real-World Applications:
- Automating system checks (e.g., disk space).
- Processing files in loops for batch operations.
- Validating user input in scripts.
- Conditional execution in CI/CD pipelines.
- Monitoring system status in scripts.
- Creating interactive menus.
- Handling errors based on conditions.

⚠️ Safety Tips:
• Quote variables in tests: "[ "\$\var" = "value" ]".
• Use [[ ]] for safer string comparisons.
• Avoid complex nested conditionals for readability.
• Test conditions in isolation before scripting.
• Use break to prevent infinite loops.
• Log control flow for debugging.
• Validate inputs to conditionals to prevent errors.

💡 Pro Tips:
• Use (( )) for arithmetic tests (e.g., ((count > 0))).
• Combine tests with && or || for concise logic.
• Use select for interactive menus.
• Leverage case for pattern matching over if.
• Enable set -e for immediate error exit.
• Debug with set -x to trace execution.
• Use trap for cleanup on exit or errors.

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                "commands" -> """
📊 Basic Commands - Essential Bash Commands

Bash commands are the foundation of scripting, enabling file manipulation, text processing, and system interaction.

Detailed Explanation:
Commands like ls, cd, echo, grep, and cat handle common tasks. Redirection (>, <, >>) and pipes (|) enhance functionality. Understanding options (e.g., -la for ls) and exit codes is key.

Detailed Explanation of Command Types:
• File Navigation: ls, cd, pwd for directories.
• File Operations: touch, cat, cp for files.
• Text Processing: grep, cut, sort for data.
• Redirection: > for output, < for input.

Multiple Code Examples:
1. List Directory Contents:
```bash
ls -la
```
Explanation: Lists files with details (permissions, sizes) including hidden files.

2. Change Directory:
```bash
cd /tmp
pwd
```
Explanation: Changes to /tmp, prints current directory with pwd.

3. Redirect Output to File:
```bash
echo "Hello" > output.txt
cat output.txt
```
Explanation: Writes "Hello" to file, cat displays content.

4. Pipe with Grep:
```bash
ls /etc | grep ".conf\$\"
```
Explanation: Lists /etc, filters for .conf files using regex.

5. Command Substitution:
```bash
current_date="\$\(date)"
echo "Today is \$\current_date"
```
Explanation: Captures date output, embeds in string.

6. Append to File:
```bash
echo "More data" >> output.txt
```
Explanation: Appends to file without overwriting.

7. Sort and Unique:
```bash
echo -e "banana\napple\nbanana" | sort | uniq
```
Explanation: Sorts lines, removes duplicates.

Common Mistakes:
- Overwriting files with > instead of >>.
- Not escaping special characters in regex.
- Ignoring stderr output in pipes.
- Running destructive commands (e.g., rm) without confirmation.
- Misusing command substitution syntax.
- Forgetting quotes around variables.
- Assuming command success without checking \$\?.

Real-World Applications:
- File management in automation scripts.
- Log parsing with grep and awk.
- System monitoring with ps and top.
- Backups using tar and redirection.
- Text processing in data pipelines.
- Automating tasks with cron.
- CLI tools for quick operations.

⚠️ Safety Tips:
• Use --dry-run for commands like rsync.
• Redirect errors to /dev/null cautiously (2>/dev/null).
• Test commands with echo before execution.
• Avoid running as root unless required.
• Secure file permissions for outputs (chmod).
• Backup files before destructive operations.
• Validate inputs to commands to prevent errors.

💡 Pro Tips:
• Use xargs for piping to complex commands.
• Alias frequent commands in .bashrc.
• Use tee to write to file and display output.
• Check command availability with command -v.
• Use which to locate command paths.
• Combine with cron for scheduled tasks.
• Use cut or awk for advanced text processing.

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                else -> "Content for $level-$id coming soon!"
            }
            "intermediate" -> when (id) {
                "functions" -> """
💻 Functions - Reusable Bash Code

Functions group commands for reuse, making scripts modular and maintainable.

Detailed Explanation:
Define functions with name() { ... } or function keyword. Functions accept parameters (\$\1, \$\2) and can return values (via echo or return). Local variables prevent scope conflicts. Functions enhance script organization and reusability.

Detailed Explanation of Function Components:
• Parameters: Accessed as \$\1, \$\2, etc.
• Return: Numeric exit codes or echo for data.
• Local: Scopes variables to function.
• Export: Makes functions available to subprocesses.

Multiple Code Examples:
1. Basic Function:
```bash
greet() {
    echo "Hello, \$\1!"
}
greet "Alice"
```
Explanation: Defines greet, takes name as \$\1, prints greeting.

2. Return Numeric Status:
```bash
check_file() {
    [ -f "\$\1" ] && return 0 || return 1
}
check_file "test.txt" && echo "Exists"
```
Explanation: Returns 0 if file exists, 1 if not; && uses exit status.

3. Local Variables:
```bash
my_func() {
    local temp="temporary"
    echo "\$\temp"
}
my_func
```
Explanation: Local temp avoids global conflict, prints value.

4. Function with Echo Return:
```bash
add() {
    echo "\$\((\$\1 + \$\2))"
}
result="\$\(add 3 4)"
echo "\$\result"
```
Explanation: Echoes sum, captured via command substitution.

5. Recursive Function:
```bash
factorial() {
    if [ "\$\1" -le 1 ]; then
        echo 1
    else
        echo "\$\(("\$\1 * \$\(factorial \$\((\$\1 - 1)))"))"
    fi
}
factorial 5
```
Explanation: Recursively calculates factorial, returns 120 for 5.

6. Function with Options:
```bash
parse_args() {
    while [ "\$\#" -gt 0 ]; do
        echo "Arg: \$\1"
        shift
    done
}
parse_args a b c
```
Explanation: Loops through arguments, shifts to next.

7. Exported Function:
```bash
my_func() { echo "Exported"; }
export -f my_func
bash -c "my_func"
```
Explanation: Exports function, runs in new shell.

Common Mistakes:
- Forgetting local, causing variable conflicts.
- Using return for non-numeric values.
- Not quoting parameters, causing errors.
- Recursive functions without base case.
- Misusing \$\# or \$\* for arguments.
- Forgetting shift in argument loops.
- Not checking function existence.

Real-World Applications:
- Modular scripts for DevOps.
- Reusable utilities in pipelines.
- Input validation in CLI tools.
- System checks in automation.
- Error handling in scripts.
- Menu-driven scripts.
- Logging utilities.

⚠️ Safety Tips:
• Use local to scope variables.
• Quote parameters: "\$\1".
• Validate input parameters.
• Avoid recursive depth issues.
• Use return for status codes only.
• Log function calls for debugging.
• Test functions independently.

💡 Pro Tips:
• Use declare -f to list functions.
• Export with export -f for subprocesses.
• Parse arguments with getopts.
• Use trap for cleanup in functions.
• Combine with arrays for complex params.
• Debug with set -x inside functions.
• Document functions with comments.

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                "arrays" -> """
📦 Arrays - Managing Lists in Bash

Arrays store multiple values, enabling complex data handling in scripts.

Detailed Explanation:
Bash supports indexed arrays (0-based) and associative arrays (key-value). Declare with (), access with \$\{array[index]}. Use declare -a or -A for clarity. Arrays are powerful for lists and mappings.

Detailed Explanation of Array Types:
• Indexed Arrays: Sequential lists (e.g., fruits=("apple" "banana")).
• Associative Arrays: Key-value pairs (declare -A).
• Operations: Append, loop, slice, length.

Multiple Code Examples:
1. Indexed Array:
```bash
fruits=("apple" "banana" "cherry")
echo "\$\{fruits[1]}"
```
Explanation: Declares array, prints second element (banana).

2. Loop Through Array:
```bash
for fruit in "\$\{fruits[@]}"; do
    echo "\$\fruit"
done
```
Explanation: Iterates over all elements, prints each fruit.

3. Associative Array:
```bash
declare -A user
user["name"]="Alice"
user["age"]=25
echo "\$\{user[name]}"
```
Explanation: Declares key-value array, prints name.

4. Append to Array:
```bash
fruits+=("orange")
echo "\$\{fruits[@]}"
```
Explanation: Adds orange to array, prints all elements.

5. Array Length:
```bash
echo "\$\{#fruits[@]}"
```
Explanation: Prints number of elements (e.g., 4).

6. Array Slicing:
```bash
echo "\$\{fruits[@]:1:2}"
```
Explanation: Prints elements 1 and 2 (banana cherry).

7. Read into Array:
```bash
read -a words <<< "one two three"
echo "\$\{words[1]}"
```
Explanation: Reads string into array, prints second word.

Common Mistakes:
- Not quoting array elements, causing splitting.
- Wrong index syntax (e.g., \$\fruits[1]).
- Forgetting declare -A for associative arrays.
- Out-of-bounds access errors.
- Using arrays in POSIX sh (not Bash).
- Not checking array existence.
- Misusing \$\{array[*]} vs \$\{array[@]}.

Real-World Applications:
- Processing lists of files in scripts.
- Storing configuration data.
- Managing user inputs in CLI tools.
- Parsing command outputs (e.g., ls).
- Handling data in automation pipelines.
- Storing temporary results.
- Building dynamic menus.

⚠️ Safety Tips:
• Quote array elements: "\$\{array[@]}".
• Check bounds before access: [ "\$\{#array[@]}" -gt 0 ].
• Validate array inputs to prevent errors.
• Use declare -p to debug arrays.
• Avoid storing sensitive data in arrays.
• Test array operations in isolation.
• Use unset to clear arrays after use.

💡 Pro Tips:
• Use \$\{array[*]} for space-separated strings.
• Slice arrays for subsets: \$\{array[@]:1:2}.
• Use mapfile to read files into arrays.
• Combine arrays with functions for processing.
• Use set -u to catch unset arrays.
• Store command outputs with array=( $\(cmd) ).
• Use associative arrays for config mappings.

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                "files" -> """
📁 File Manipulation - Reading and Writing Files

File manipulation is essential for Bash scripting, enabling data persistence, processing, and automation.

Detailed Explanation:
Use redirection (>, >>), cat, read, sed, and awk for file operations. Ensure proper permissions and error handling. Commands like touch create files, while read processes content line by line.

Detailed Explanation of File Operations:
• Writing: Use > to overwrite, >> to append.
• Reading: Use read, cat, or while loops.
• Processing: Sed and awk for text manipulation.
• Testing: Use [ -f ] for file checks.

Multiple Code Examples:
1. Create File:
```bash
touch newfile.txt
```
Explanation: Creates empty file newfile.txt.

2. Write to File:
```bash
echo "Data" > file.txt
```
Explanation: Overwrites file.txt with "Data".

3. Append to File:
```bash
echo "More data" >> file.txt
```
Explanation: Appends "More data" to file.txt.

4. Read File Line by Line:
```bash
while IFS= read -r line; do
    echo "Line: \$\line"
done < file.txt
```
Explanation: Reads each line, prints with prefix, IFS preserves whitespace.

5. Sed Replace:
```bash
sed -i 's/old/new/g' file.txt
```
Explanation: Replaces all "old" with "new" in file.txt.

6. Awk Processing:
```bash
awk '{print \$\1}' file.txt
```
Explanation: Prints first column of each line.

7. File Test:
```bash
if [ -f "file.txt" ]; then
    echo "File exists"
fi
```
Explanation: Checks if file exists, prints message.

Common Mistakes:
- Overwriting files with > instead of >>.
- Not quoting file paths with spaces.
- Ignoring read errors for missing files.
- Running sed without backup (-i.bak).
- Incorrect permissions causing access issues.
- Forgetting to close file descriptors.
- Misusing redirection with pipes.

Real-World Applications:
- Processing log files in monitoring scripts.
- Updating configuration files.
- Extracting data for reports.
- Automating backups with tar.
- Parsing CSV files with awk.
- Generating reports with redirection.
- Scripting file cleanup tasks.

⚠️ Safety Tips:
• Use sed -i.bak for backups before editing.
• Check file existence with [ -f ].
• Secure permissions with chmod 600.
• Quote file paths: "\$\file".
• Avoid eval with file content.
• Redirect errors: 2>/dev/null.
• Test operations in a sandbox.

💡 Pro Tips:
• Use tee for simultaneous output and file write.
• Leverage awk for complex parsing.
• Use mktemp for temporary files.
• Combine with find for batch processing.
• Use flock for file locking.
• Compress files with gzip in scripts.
• Monitor changes with inotifywait.

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                "processes" -> """
🛠️ Process Management - Controlling Processes

Bash excels at managing system processes for automation and monitoring, allowing control over running programs and system resources.

Detailed Explanation:
Use ps, kill, bg, fg, and jobs to manage processes. Background tasks run with &. Trap handles signals. Monitor with top or htop.

Detailed Explanation of Process Management:
• Process Listing: ps, pgrep list running processes.
• Termination: kill, killall stop processes.
• Job Control: bg, fg, jobs for shell jobs.
• Signals: Trap for signal handling.

Multiple Code Examples:
1. Run in Background:
```bash
sleep 10 &
jobs
```
Explanation: Runs sleep in background, jobs lists active jobs.

2. List Processes:
```bash
ps aux | grep sleep
```
Explanation: Lists all processes, filters for sleep.

3. Kill Process:
```bash
kill "\$\(pgrep sleep)"
```
Explanation: Finds and terminates sleep process.

4. Foreground Job:
```bash
sleep 10 &
fg %1
```
Explanation: Runs sleep in background, brings to foreground.

5. Trap Signal:
```bash
trap 'echo "Terminated"; exit' SIGTERM
sleep 100
```
Explanation: Prints message on SIGTERM, exits.

6. Check Process Status:
```bash
kill -0 "\$\(pgrep sleep)" && echo "Running"
```
Explanation: Tests if process exists without killing.

7. Nohup for Persistence:
```bash
nohup sleep 100 &
```
Explanation: Runs sleep immune to hangup signals.

Common Mistakes:
- Killing wrong PID, affecting other processes.
- Forgetting & for background tasks.
- Ignoring signal handling for cleanup.
- Not checking process status before kill.
- Overloading system with background jobs.
- Misusing killall with similar names.
- Not redirecting nohup output.

Real-World Applications:
- Monitoring services in scripts.
- Automating process restarts.
- Managing daemons in DevOps.
- Cleanup scripts for stale processes.
- Resource monitoring in pipelines.
- Background tasks in automation.
- Signal handling in servers.

⚠️ Safety Tips:
• Verify PIDs with pgrep before killing.
• Use kill -0 to check process existence.
• Prefer SIGTERM over SIGKILL.
• Log process actions for auditing.
• Run processes with least privileges.
• Handle traps for cleanup on exit.
• Monitor system load with top.

💡 Pro Tips:
• Use nohup for persistent processes.
• Leverage wait for process synchronization.
• Use htop for interactive monitoring.
• Schedule with cron for recurring tasks.
• Detach processes with disown.
• Redirect output with &>.
• Use pidof for PID lookup.

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                else -> "Content for $level-$id coming soon!"
            }
            "advanced" -> when (id) {
                "scripting" -> """
📜 Advanced Scripting - Complex Bash Scripts

Advanced scripting combines functions, error handling, and modularity for robust automation.

Detailed Explanation:
Use set options (e.g., -euo pipefail), traps, and subshells for complex scripts. Modularize with functions and source files. Log actions for debugging.

Detailed Explanation of Scripting Techniques:
• Set Options: -e for exit on error, -u for unset vars.
• Traps: Handle signals for cleanup.
• Subshells: Isolate execution with ().
• Logging: Redirect output to files.

Multiple Code Examples:
1. Script with Error Handling:
```bash
#!/bin/bash
set -euo pipefail
command || { echo "Failed"; exit 1; }
```
Explanation: Exits on error, fails pipe if any command fails.

2. Logging Function:
```bash
log() {
    local level="\$\1"; shift
    echo "[\$\level] \$\@" | tee -a log.txt
}
log INFO "Script started"
```
Explanation: Logs message with level, writes to file and console.

3. Trap for Cleanup:
```bash
trap 'echo "Cleaning up"; rm -f temp.txt' EXIT
touch temp.txt
```
Explanation: Removes temp.txt on script exit.

4. Subshell:
```bash
( cd /tmp; touch file.txt )
```
Explanation: Runs commands in isolated subshell.

5. Source External Script:
```bash
source ./utils.sh
```
Explanation: Imports functions from utils.sh.

6. Complex Script Example:
```bash
#!/bin/bash
set -e
files=("\$\(ls)")
for file in "\$\{files[@]}"; do
    log INFO "Processing \$\file"
done
```
Explanation: Lists files, logs each processing step.

7. Getopts for Args:
```bash
while getopts "f:h" opt; do
    case "\$\opt" in
        f) file="\$\OPTARG";;
        h) echo "Help"; exit 0;;
    esac
done
```
Explanation: Parses -f and -h options.

Common Mistakes:
- Ignoring set options, leading to silent failures.
- Complex logic without functions.
- Not handling traps for cleanup.
- Misusing getopts for arguments.
- Hardcoding paths or values.

Real-World Applications:
- DevOps automation pipelines.
- System maintenance scripts.
- Log analysis tools.
- Deployment scripts.
- Backup automation.
- Service monitoring.
- Complex CLI tools.

⚠️ Safety Tips:
• Use set -e for error handling.
• Test scripts in non-production environments.
• Secure sensitive data in variables.
• Log all critical actions.
• Avoid eval for dynamic code.
• Backup files before manipulation.
• Use subshells for isolation.

💡 Pro Tips:
• Use shopt for extended globbing (e.g., shopt -s extglob).
• Modularize with source for reusable code.
• Use coproc for co-processes.
• Profile scripts with time command.
• Lint with shellcheck for errors.
• Use set -x for debugging.
• Organize scripts in functions.

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                "regex" -> """
🔍 Regular Expressions - Pattern Matching

Regex in Bash enables powerful text processing and pattern matching for data extraction and validation.

Detailed Explanation:
Use grep, sed, or [[ ]] with =~ for regex. Patterns include literals, wildcards (*, ?), and groups. Extended regex (-E) supports advanced features like alternation (|).

Detailed Explanation of Regex Tools:
• Grep: Searches text with patterns.
• Sed: Replaces or transforms text.
• Bash =~: Matches within [[ ]].
• Awk: Processes structured data.

Multiple Code Examples:
1. Grep with Regex:
```bash
echo "test@example.com" | grep -E '[a-z]+@[a-z]+\.[a-z]+'
```
Explanation: Matches email pattern, prints if found.

2. Sed Replace with Regex:
```bash
echo "hello123" | sed -E 's/[0-9]+/NUM/g'
```
Explanation: Replaces digits with "NUM".

3. Bash Regex Match:
```bash
if [[ "test@example.com" =~ ^[a-z]+@[a-z]+\.[a-z]+$\ ]]; then
    echo "Valid email"
fi
```
Explanation: Tests email format, prints if valid.

4. Capture Groups:
```bash
[[ "test@example.com" =~ ([a-z]+)@([a-z]+)\.([a-z]+) ]]
echo "User: \$\{BASH_REMATCH[1]}"
```
Explanation: Captures username, prints it.

5. Awk with Regex:
```bash
echo "user1@example.com" | awk '/@example\.com$\/ {print \$\0}'
```
Explanation: Prints lines matching domain.

6. Extended Regex:
```bash
echo "cat or dog" | grep -E 'cat|dog'
```
Explanation: Matches "cat" or "dog" with alternation.

7. Replace with Sed Backup:
```bash
sed -i.bak -E 's/old/new/g' file.txt
```
Explanation: Replaces in file, saves backup.

Common Mistakes:
- Unquoted regex patterns causing errors.
- Greedy patterns matching too much.
- Forgetting -E for extended regex.
- Missing capture group syntax.
- Not handling no-match cases.
- Overcomplicating regex patterns.
- Ignoring case sensitivity.

Real-World Applications:
- Parsing logs for errors.
- Validating user input (e.g., emails).
- Extracting data from files.
- Transforming config files with sed.
- Filtering command outputs.
- Monitoring network logs.
- Automating text processing.

⚠️ Safety Tips:
• Test regex on regex101.com.
• Avoid complex regex in scripts.
• Quote patterns to prevent expansion.
• Handle no-match cases gracefully.
• Secure regex inputs from users.
• Use -i.bak for sed backups.
• Log regex matches for debugging.

💡 Pro Tips:
• Use grep -P for Perl regex.
• Combine with awk for complex parsing.
• Use capture groups for extraction.
• Optimize patterns for performance.
• Use case-insensitive flags (e.g., grep -i).
• Test edge cases in patterns.
• Document regex for clarity.

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                "networking" -> """
🌐 Networking - Network-Related Scripting

Bash supports network tasks for automation, monitoring, and communication, making it valuable for system administration.

Detailed Explanation:
Commands like curl, nc, ping, and ssh handle network operations. Redirection and pipes process outputs. Tools like netstat and ss monitor connections.

Detailed Explanation of Network Tools:
• Curl: HTTP requests and downloads.
• Nc (netcat): Raw TCP/UDP connections.
• Ping: Network reachability.
• SSH: Remote command execution.

Multiple Code Examples:
1. HTTP Request with Curl:
```bash
curl -s http://example.com
```
Explanation: Silently fetches webpage content.

2. Netcat Listener:
```bash
nc -l 12345
```
Explanation: Listens on port 12345 for connections.

3. Ping Check:
```bash
ping -c 4 8.8.8.8 || echo "Host down"
```
Explanation: Pings Google DNS 4 times, reports if fails.

4. SSH Remote Command:
```bash
ssh user@host "uptime"
```
Explanation: Runs uptime on remote host.

5. Check Open Port:
```bash
nc -zv localhost 22 2>/dev/null && echo "Port open"
```
Explanation: Tests if port 22 is open, redirects stderr.

6. Download File:
```bash
wget -q http://example.com/file.txt
```
Explanation: Quietly downloads file.txt.

7. Monitor Connections:
```bash
ss -tuln
```
Explanation: Lists TCP/UDP listening ports.

Common Mistakes:
- No error handling for network failures.
- Hardcoding IPs or hosts.
- Ignoring timeouts in curl or nc.
- Unsecured SSH keys.
- Not redirecting stderr.
- Misusing wget vs curl.
- Forgetting port checks.

Real-World Applications:
- Monitoring network services.
- Automating remote backups.
- Fetching APIs in scripts.
- Testing network connectivity.
- Managing remote servers.
- Log collection over SSH.
- Network diagnostics.

⚠️ Safety Tips:
• Secure SSH keys with chmod 600.
• Use timeouts with curl (--max-time).
• Validate network inputs to prevent injection.
• Log network activities for auditing.
• Avoid plain-text credentials in scripts.
• Test connectivity before operations.
• Use HTTPS for secure requests.

💡 Pro Tips:
• Use wget for simple downloads.
• Schedule network tasks with cron.
• Use ssh-agent for key management.
• Query DNS with dig or nslookup.
• Monitor with netstat or ss.
• Parse JSON APIs with jq.
• Use curl --fail for error checking.

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                "debugging" -> """
🐞 Debugging - Troubleshooting Bash Scripts

Debugging ensures robust Bash scripts by identifying and fixing errors.

Detailed Explanation:
Use set -x for tracing, trap for signal handling, and shellcheck for linting. Check exit codes with \$\? and log errors for analysis.

Detailed Explanation of Debugging Tools:
• Set -x: Traces command execution.
• Trap: Captures signals or debug events.
• Shellcheck: Lints scripts for errors.
• \$\?: Checks command success.

Multiple Code Examples:
1. Enable Tracing:
```bash
set -x
echo "Debugging"
set +x
```
Explanation: Prints each command before execution for tracing.

2. Trap Debug:
```bash
trap 'echo "Line \$\LINENO: \$\BASH_COMMAND"' DEBUG
echo "Test"
```
Explanation: Logs each command with line number.

3. Check Exit Code:
```bash
ls /nonexistent
echo "Exit code: \$\?"
```
Explanation: Prints exit code (2 for failure).

4. Log Errors:
```bash
command 2> error.log || cat error.log
```
Explanation: Redirects stderr to file, displays if fails.

5. Shellcheck Usage:
```bash
shellcheck myscript.sh
```
Explanation: Lints script for errors and warnings.

6. Debug with Set Options:
```bash
set -euo pipefail
command || echo "Failed"
```
Explanation: Exits on error, unset vars, or pipe failure.

7. Redirect Trace:
```bash
bash -x myscript.sh 2> trace.log
```
Explanation: Runs script with tracing, saves to file.

Common Mistakes:
- Not enabling debugging in scripts.
- Ignoring exit codes, missing errors.
- Overwriting logs with redirection.
- Not using shellcheck for linting.
- Debugging in production environments.
- Forgetting to disable set -x.
- Ignoring stderr output.

Real-World Applications:
- Debugging automation scripts.
- Validating CI/CD pipelines.
- Troubleshooting system scripts.
- Ensuring robust CLI tools.
- Logging errors in servers.
- Analyzing script failures.
- Optimizing performance.

⚠️ Safety Tips:
• Disable set -x in production scripts.
• Secure debug logs (chmod 600).
• Test debugging in non-production environments.
• Clear traps after debugging.
• Avoid logging sensitive data.
• Backup scripts before changes.
• Validate commands before execution.

💡 Pro Tips:
• Use bash -n for syntax checking.
• Run shellcheck with -x for sourced files.
• Use tee for live logging.
• Debug processes with ps or strace.
• Redirect trace with BASH_XTRACEFD.
• Combine with time for profiling.
• Log to syslog for system integration.

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                else -> "Content for $level-$id coming soon!"
            }
            else -> "Content for $level-$id coming soon!"
        }
    }
}