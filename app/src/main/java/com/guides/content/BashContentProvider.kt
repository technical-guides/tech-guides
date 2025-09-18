package com.guides.content

import com.guides.NavigationState

object BashContentProvider : ContentProvider {
    override fun getWelcomeMessage(): String = """
Welcome to the Bash Ref. Guide!

This interactive tutorial will guide you through essential Bash scripting,
from basic commands to advanced automation.

What you'll learn:

• Basic Topics: Installation, variables, control structures, functions
• Intermediate Topics: File operations, arrays, error handling, loops
• Advanced Topics: Traps, networking, process substitution, coprocs

How to navigate:

• Use the sidebar menu to select a topic category
• Click or tap to navigate through menus and subtopics
• Use the back button (← Back) to return to previous menus

Getting Started:

Choose a topic category from the sidebar to start learning!
Each section includes explanations, examples, and best practices.

Good luck on your Bash journey!
    """.trimIndent()

    override fun getMenuContent(state: NavigationState): String {
        return when (state) {
            NavigationState.MAIN_MENU -> """
Bash Ref. Guide

Select a category to begin:

Basic Topics
Learn essential Bash fundamentals.

Intermediate Topics
Master scripting techniques.

Advanced Topics
Dive into expert-level Bash usage.

Exit
Close the application.
            """.trimIndent()
            NavigationState.BASIC_SUBMENU -> """
Basic Topics Menu

Select a subtopic to begin learning:

Installation & Setup
Set up Bash environment.

Variables
Use variables in scripts.

Control Structures
Use if, for, while.

Functions
Define reusable functions.
            """.trimIndent()
            NavigationState.INTERMEDIATE_SUBMENU -> """
Intermediate Topics Menu

Select a subtopic to advance your Bash skills:

File Operations
Work with files.

Arrays
Use arrays in scripts.

Error Handling
Handle script errors.

Advanced Loops
Complex loop structures.
            """.trimIndent()
            NavigationState.ADVANCED_SUBMENU -> """
Advanced Topics Menu

Select a subtopic for expert-level Bash knowledge:

Traps & Signals
Handle signals.

Networking
Perform network tasks.

Process Substitution
Advanced command substitution.

Coprocs
Use coprocesses.
            """.trimIndent()
        }
    }

    override fun getTopicContent(level: String, id: String): String {
        return when (level) {
            "basics" -> when (id) {
                "install" -> """
Installation & Setup - Setting Up Bash

Set up Bash:

Steps:
• Bash is built-in on Linux/macOS
• Install Git Bash on Windows
• Verify: bash --version
• Use: #!/bin/bash in scripts

Safety Tips:
• Use official distributions
• Keep Bash updated

Pro Tips:
• Use .bashrc for aliases
• Install bash-completion

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                "variables" -> """
Variables - Using Variables

Define variables:

Examples:
• name="Alice"; echo $\name
• x=5; echo $((x + 1))
• export MY_VAR=value
• unset MY_VAR

Safety Tips:
• Quote variables: "$\name"
• Avoid reserved names

Pro Tips:
• Use $\{name} for clarity
• Set defaults: $\{name:-default}

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                "control" -> """
Control Structures - Flow Control

Control script flow:

Examples:
• if [ "$\x" -gt 0 ]; then echo "Positive"; fi
• for i in {1..5}; do echo $\i; done
• while [ $\x -lt 10 ]; do x=$((x+1)); done
• case $\x in 1) echo "One";; esac

Safety Tips:
• Quote variables in tests
• Avoid infinite loops

Pro Tips:
• Use [[ ]] for tests
• Combine with || and &&

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                "functions" -> """
Functions - Reusable Code

Define functions:

Examples:
• my_func() { echo "Hello"; }
• my_func arg1() { echo "$1"; }
• return_val() { return 42; }
• local x=5 # Scope variable

Safety Tips:
• Avoid global variables
• Test functions separately

Pro Tips:
• Use local for variables
• Return with exit codes

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                else -> "Content for basic-$id coming soon!"
            }
            "intermediate" -> when (id) {
                "files" -> """
File Operations - Working with Files

Manage files:

Examples:
• cat file.txt # Display
• echo "Data" > file.txt # Write
• mv file1 file2 # Move
• find . -name "*.txt" # Search

Safety Tips:
• Use quotes for filenames
• Check before deleting

Pro Tips:
• Use find with -exec
• Redirect with >>

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                "arrays" -> """
Arrays - Using Arrays

Work with arrays:

Examples:
• arr=(1 2 3); echo $\{arr[0]}
• arr[1]="new"; echo $\{arr[@]}
• for i in "$\{arr[@]}"; do echo $\i; done
• echo $\{#arr[@]} # Length

Safety Tips:
• Quote array elements
• Validate indices

Pro Tips:
• Use associative arrays
• Slice arrays: $\{arr[@]:1:2}

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                "error" -> """
Error Handling - Managing Errors

Handle errors:

Examples:
• set -e # Exit on error
• command || echo "Failed"
• trap 'echo Error' ERR
• if ! command; then exit 1; fi

Safety Tips:
• Test error handling
• Log errors

Pro Tips:
• Use trap for cleanup
• Check $? for exit codes

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                "loops" -> """
Advanced Loops - Complex Looping

Advanced loops:

Examples:
• for ((i=0; i<5; i++)); do echo $\i; done
• while read line; do echo $\line; done < file.txt
• find . -type f | while read f; do echo $\f; done
• break 2 # Exit nested loops

Safety Tips:
• Avoid infinite loops
• Test conditions

Pro Tips:
• Use read with IFS
• Combine with find

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                else -> "Content for intermediate-$id coming soon!"
            }
            "advanced" -> when (id) {
                "traps" -> """
Traps & Signals - Handling Signals

Handle signals:

Examples:
• trap 'echo Exit' EXIT
• trap 'rm temp' SIGINT
• kill -SIGTERM $$ # Send signal
• trap '' SIGINT # Ignore signal

Safety Tips:
• Test traps locally
• Avoid blocking critical signals

Pro Tips:
• Use trap for cleanup
• Combine with wait

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                "networking" -> """
Networking - Network Tasks

Perform network tasks:

Examples:
• curl http://example.com
• nc -zv host 80 # Port scan
• ssh user@host # Remote access
• wget file.url # Download

Safety Tips:
• Secure credentials
• Monitor traffic

Pro Tips:
• Use ssh-agent
• Script with curl

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                "process" -> """
Process Substitution - Advanced Substitution

Use process substitution:

Examples:
• diff <(ls dir1) <(ls dir2)
• tee >(grep error > errors.log)
• while read line; do ...; done < <(command)
• cat <(echo "Data")

Safety Tips:
• Test commands separately
• Check compatibility

Pro Tips:
• Combine with tee
• Use in pipelines

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                "coprocs" -> """
Coprocs - Using Coprocesses

Use coprocesses:

Examples:
• coproc my_proc { cat; }
• echo "Data" >&$\{my_proc[1]}
• read line <&$\{my_proc[0]}
• coproc { sleep 10; echo Done; }

Safety Tips:
• Close FDs properly
• Test in simple scripts

Pro Tips:
• Use named pipes
• Monitor coproc status

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                else -> "Content for advanced-$id coming soon!"
            }
            else -> "Content for $level-$id coming soon!"
        }
    }
}