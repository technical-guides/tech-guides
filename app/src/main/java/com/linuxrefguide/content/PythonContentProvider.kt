package com.linuxrefguide.content

import com.linuxrefguide.NavigationState

object PythonContentProvider : ContentProvider {
    override fun getWelcomeMessage(): String = """
Welcome to the Python Ref. Guide!

This interactive tutorial will guide you through essential Python concepts,
from basic syntax to advanced programming techniques.

What you'll learn:

• Basic Topics: Installation, variables, control structures, I/O
• Intermediate Topics: Functions, modules, OOP, file handling
• Advanced Topics: Generators, decorators, concurrency, web development

How to navigate:

• Use the sidebar menu to select a topic category
• Click or tap to navigate through menus and subtopics
• Use the back button (← Back) to return to previous menus

Getting Started:

Choose a topic category from the sidebar to start learning!
Each section includes explanations, examples, and best practices.

Good luck on your Python journey!
    """.trimIndent()

    override fun getMenuContent(state: NavigationState): String {
        return when (state) {
            NavigationState.MAIN_MENU -> """
Python Ref. Guide

Select a category to begin:

Basic Topics
Learn essential Python fundamentals.

Intermediate Topics
Master programming techniques.

Advanced Topics
Dive into expert-level Python usage.

Exit
Close the application.
            """.trimIndent()
            NavigationState.BASIC_SUBMENU -> """
Basic Topics Menu

Select a subtopic to begin learning:

Installation & Setup
Install Python on various platforms.

Variables & Data Types
Work with Python variables.

Control Structures
Use if, for, while.

Basic Input/Output
Handle I/O operations.
            """.trimIndent()
            NavigationState.INTERMEDIATE_SUBMENU -> """
Intermediate Topics Menu

Select a subtopic to advance your Python skills:

Functions
Define and use functions.

Modules & Packages
Organize code with modules.

Object-Oriented Programming
Create classes and objects.

File Handling
Read and write files.
            """.trimIndent()
            NavigationState.ADVANCED_SUBMENU -> """
Advanced Topics Menu

Select a subtopic for expert-level Python knowledge:

Generators & Iterators
Create efficient iterators.

Decorators
Enhance functions.

Concurrency & Multithreading
Run parallel tasks.

Web Development Basics
Build web apps.
            """.trimIndent()
        }
    }

    override fun getTopicContent(level: String, id: String): String {
        return when (level) {
            "basics" -> when (id) {
                "install" -> """
Installation & Setup - Getting Started with Python

Install Python:

Steps:
• Download from python.org
• Install on Linux: sudo apt install python3
• Install on Windows: Run installer
• Verify: python3 --version

Safety Tips:
• Use official sources
• Keep Python updated

Pro Tips:
• Use pyenv for version management
• Set up virtual environments

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                "variables" -> """
Variables & Data Types - Working with Data

Basic data types:

Examples:
• x = 5 # Integer
• name = "Alice" # String
• nums = [1, 2, 3] # List
• flag = True # Boolean

Safety Tips:
• Avoid reserved words
• Use descriptive names

Pro Tips:
• Use type hints
• Check with type()

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                "control" -> """
Control Structures - Flow Control

Control program flow:

Examples:
• if x > 0: print("Positive")
• for i in range(5): print(i)
• while x < 10: x += 1
• try: x = int(input()) except: pass

Safety Tips:
• Avoid infinite loops
• Handle exceptions

Pro Tips:
• Use list comprehensions
• Break loops early

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                "io" -> """
Basic Input/Output - Handling I/O

Basic I/O:

Examples:
• print("Hello, world!") # Output
• name = input("Enter name: ") # Input
• print(f"Hi, {name}")
• print("Log", file=open("log.txt", "w"))

Safety Tips:
• Validate input
• Close files properly

Pro Tips:
• Use f-strings for formatting
• Redirect output to files

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                else -> "Content for basic-$id coming soon!"
            }
            "intermediate" -> when (id) {
                "functions" -> """
Functions - Defining Reusable Code

Define functions:

Examples:
• def add(a, b): return a + b
• def greet(name="User"): print(f"Hi, {name}")
• lambda x: x * 2
• def my_func(*args, **kwargs): print(args, kwargs)

Safety Tips:
• Avoid side effects
• Document functions

Pro Tips:
• Use default arguments
• Leverage *args, **kwargs

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                "modules" -> """
Modules & Packages - Organizing Code

Use modules:

Examples:
• import math; print(math.pi)
• from datetime import datetime
• import mymodule; mymodule.func()
• pip install requests

Safety Tips:
• Avoid naming conflicts
• Use virtual environments

Pro Tips:
• Create __init__.py for packages
• Use pip freeze

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                "oop" -> """
Object-Oriented Programming - Classes and Objects

Use OOP:

Examples:
• class Person: def __init__(self, name): self.name = name
• p = Person("Alice"); print(p.name)
• class Student(Person): pass
• @property def name(self): return self._name

Safety Tips:
• Avoid deep inheritance
• Use clear naming

Pro Tips:
• Use properties for getters/setters
• Implement __str__

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                "files" -> """
File Handling - Reading and Writing Files

Handle files:

Examples:
• with open("file.txt", "r") as f: print(f.read())
• with open("file.txt", "w") as f: f.write("Data")
• import csv; csv.reader(f)
• import json; json.load(f)

Safety Tips:
• Use with statement
• Handle exceptions

Pro Tips:
• Use pathlib for paths
• Process files in chunks

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                else -> "Content for intermediate-$id coming soon!"
            }
            "advanced" -> when (id) {
                "generators" -> """
Generators & Iterators - Efficient Iteration

Create generators:

Examples:
• def my_gen(): for i in range(5): yield i
• g = my_gen(); next(g)
• [x * 2 for x in range(5)]
• iter_obj = iter([1, 2, 3])

Safety Tips:
• Handle StopIteration
• Avoid memory-heavy lists

Pro Tips:
• Use yield from
• Create custom iterators

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                "decorators" -> """
Decorators - Enhancing Functions

Use decorators:

Examples:
• def my_dec(func): def wrapper(): print("Start"); func(); print("End"); return wrapper
• @my_dec def say_hi(): print("Hi")
• from functools import wraps
• def timer(func): ... # Time execution

Safety Tips:
• Preserve function metadata
• Test decorators separately

Pro Tips:
• Use @wraps
• Stack multiple decorators

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                "concurrency" -> """
Concurrency & Multithreading - Parallel Tasks

Run parallel tasks:

Examples:
• import threading; t = threading.Thread(target=func)
• from concurrent.futures import ThreadPoolExecutor
• import asyncio; async def my_task(): ...
• await asyncio.sleep(1)

Safety Tips:
• Avoid race conditions
• Use locks

Pro Tips:
• Use ThreadPoolExecutor
• Prefer asyncio for I/O

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                "web" -> """
Web Development Basics - Building Web Apps

Build web apps:

Examples:
• from flask import Flask; app = Flask(__name__)
• @app.route("/"); def home(): return "Hello"
• import requests; r = requests.get("url")
• from django.urls import path

Safety Tips:
• Validate user input
• Secure API keys

Pro Tips:
• Use Flask for lightweight apps
• Deploy with gunicorn

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                else -> "Content for advanced-$id coming soon!"
            }
            else -> "Content for $level-$id coming soon!"
        }
    }
}