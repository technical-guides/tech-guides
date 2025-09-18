package com.guides.content

import com.guides.NavigationState

object CppContentProvider : ContentProvider {
    override fun getWelcomeMessage(): String = """
🛠️ Welcome to the C/C++ Ref. Guide! 🛠️

This interactive tutorial will guide you through essential C/C++ concepts,
from basic syntax to advanced system programming.

📖 What you'll learn:

• Basic Topics: Installation, variables, control structures, functions
• Intermediate Topics: Pointers, structures, file I/O, classes
• Advanced Topics: Templates, multithreading, memory management, STL

🎯 How to navigate:

• Use the sidebar menu to select a topic category
• Click or tap to navigate through menus and subtopics
• Use the back button (← Back) to return to previous menus

🚀 Getting Started:

Choose a topic category from the sidebar to explore subtopics and start learning!
Each section includes explanations, examples, and best practices.

Good luck on your C/C++ journey! 🎓
    """.trimIndent()

    override fun getMenuContent(state: NavigationState): String {
        return when (state) {
            NavigationState.MAIN_MENU -> """
📚 C/C++ Ref. Guide

Select a category to begin:

📖 Basic Topics
Learn essential C/C++ fundamentals.

⚡ Intermediate Topics
Master core techniques.

🚀 Advanced Topics
Dive into expert-level usage.

❌ Exit
Close the application.
            """.trimIndent()
            NavigationState.BASIC_SUBMENU -> """
📰 Basic Topics Menu

Select a subtopic to begin learning:

🛠️ Installation & Setup
Compilers and IDEs.

🔤 Variables & Data Types
Primitives and arrays.

🔀 Control Structures
If, switch, loops.

📊 Functions
Defining functions.
            """.trimIndent()
            NavigationState.INTERMEDIATE_SUBMENU -> """
⚡ Intermediate Topics Menu

Select a subtopic to advance your skills:

🔹 Pointers
Memory addressing.

🧱 Structures & Unions
Custom types.

📁 File I/O
Reading/writing files.

🧑‍🏫 Classes (C++)
OOP basics.
            """.trimIndent()
            NavigationState.ADVANCED_SUBMENU -> """
🚀 Advanced Topics Menu

Select a subtopic for expert-level knowledge:

🔧 Templates (C++)
Generic programming.

🕒 Multithreading
Concurrency.

🔍 Memory Management
Allocators, smart pointers.

📦 STL (C++)
Standard Template Library.
            """.trimIndent()
        }
    }

    override fun getTopicContent(level: String, id: String): String {
        return when (level) {
            "basics" -> when (id) {
                "install" -> """
🛠️ Installation & Setup - Getting Started with C/C++

Essential tools:

📥 Compiler:
• gcc/g++ on Linux: sudo apt install g++
• Clang: sudo apt install clang
• MSVC on Windows

📥 IDE:
• VS Code with C++ extension
• CLion or Code::Blocks

🔧 Hello World:
• g++ hello.cpp -o hello
• ./hello

⚠️ Safety Tips:
• Use C++23 standard
• Compile with warnings: -Wall

💡 Pro Tips:
• Use CMake for builds
• gdb for debugging

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                "variables" -> """
🔤 Variables & Data Types - Basics

C/C++ types:

🆕 Primitives:
• int x = 5;
• double pi = 3.14;

📋 Arrays:
• int arr[5] = {1,2,3,4,5};

🔍 Strings (C++):
• std::string name = "Alice";

⚠️ Safety Tips:
• Initialize variables
• Avoid buffer overflows

💡 Pro Tips:
• Use constexpr
• std::array in C++

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                "control" -> """
🔀 Control Structures - Flow

Controlling flow:

🧭 If/Switch:
• if (x > 0) { ... }
• switch (day) { case 1: ... }

📋 Loops:
• for (int i=0; i<5; i++) { ... }
• while (x > 0) { ... }

⚠️ Safety Tips:
• Avoid infinite loops
• Use range-based for (C++)

💡 Pro Tips:
• Goto for rare cases
• Break/continue

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                "functions" -> """
📊 Functions - Reusable Code

Defining functions:

🔧 Syntax:
• int add(int a, int b) { return a + b; }

📜 Overloading (C++):
• int add(double a, double b) { ... }

🛡️ Inline:
• inline int max(int a, int b) { ... }

⚠️ Safety Tips:
• Check parameters
• Avoid recursion depth

💡 Pro Tips:
• Function pointers
• Lambdas in C++

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                else -> "Content for $level-$id coming soon!"
            }
            "intermediate" -> when (id) {
                "pointers" -> """
🔹 Pointers - Memory Access

Using pointers:

🔍 Declaration:
• int* p = &x;

📜 Dereference:
• *p = 10;

🛡️ Arrays:
• int arr[5]; int* ptr = arr;

⚠️ Safety Tips:
• Check null
• Avoid dangling pointers

💡 Pro Tips:
• Const pointers
• Smart pointers (C++)

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                "structures" -> """
🧱 Structures & Unions - Custom Types

Defining structs:

🔍 Struct:
• struct Point { int x, y; };

📜 Usage:
• Point p = {1, 2};

🛡️ Unions:
• union Data { int i; float f; };

⚠️ Safety Tips:
• Align members
• Avoid undefined behavior

💡 Pro Tips:
• Bit fields
• Typedef

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                "files" -> """
📁 File I/O - Handling Files

File operations:

🔍 Reading (C):
• FILE* f = fopen("file.txt", "r"); fscanf(f, "%d", &x);

📜 Writing:
• fprintf(f, "Text");

🛡️ C++ Streams:
• std::ifstream ifs("file.txt");

⚠️ Safety Tips:
• Check fopen return
• Close files

💡 Pro Tips:
• Binary mode
• std::filesystem (C++17)

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                "classes" -> """
🧑‍🏫 Classes (C++) - OOP Basics

Using classes:

🔍 Definition:
• class Dog { public: void bark(); };

📜 Constructors:
• Dog() { ... }

🛡️ Access:
• private, protected, public

⚠️ Safety Tips:
• Rule of Three/Five
• Avoid leaks

💡 Pro Tips:
• Friend classes
• Virtual functions

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                else -> "Content for $level-$id coming soon!"
            }
            "advanced" -> when (id) {
                "templates" -> """
🔧 Templates (C++) - Generics

Using templates:

🔍 Function:
• template <typename T> T add(T a, T b) { return a + b; }

📜 Class:
• template <class T> class Box { T value; };

🛡️ Specialization:
• template <> class Box<char> { ... };

⚠️ Safety Tips:
• Compile-time errors
• Concepts (C++20)

💡 Pro Tips:
• Variadic templates
• SFINAE

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                "multithreading" -> """
🕒 Multithreading - Concurrency

Concurrent programming:

🔍 Threads (C++11):
• std::thread t([]{ ... }); t.join();

📜 Mutex:
• std::mutex m; std::lock_guard<std::mutex> lock(m);

🛡️ Condition Variables:
• std::condition_variable cv;

⚠️ Safety Tips:
• Avoid race conditions
• Use atomics

💡 Pro Tips:
• Futures/promises
• Thread pools

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                "memory" -> """
🔍 Memory Management - Allocation

Managing memory:

🔍 New/Delete:
• int* p = new int; delete p;

📜 Smart Pointers (C++):
• std::unique_ptr<int> up(new int);

🛡️ Allocators:
• Custom allocators for containers

⚠️ Safety Tips:
• Avoid leaks
• Valgrind for checks

💡 Pro Tips:
• RAII
• Placement new

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                "stl" -> """
📦 STL (C++) - Standard Library

Using STL:

🔍 Containers:
• std::vector<int> v;

📜 Algorithms:
• std::sort(v.begin(), v.end());

🛡️ Iterators:
• for (auto it = v.begin(); it != v.end(); ++it) { ... }

⚠️ Safety Tips:
• Check bounds
• Use const iterators

💡 Pro Tips:
• Ranges (C++20)
• Custom comparators

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                else -> "Content for $level-$id coming soon!"
            }
            else -> "Content for $level-$id coming soon!"
        }
    }
}