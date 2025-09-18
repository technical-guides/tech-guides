package com.guides.content

import com.guides.NavigationState

object PythonContentProvider : ContentProvider {
    override fun getWelcomeMessage(): String = """
🐍 Welcome to the Python Ref. Guide! 🐍

This extensive tutorial covers Python from fundamentals to advanced topics, with numerous examples, best practices, and real-world applications to make you a proficient developer.

📖 What you'll learn:

• Basic Topics: Installation & setup, variables & data types, control structures, basic input/output
• Intermediate Topics: Functions, modules & packages, object-oriented programming, file handling
• Advanced Topics: Generators & iterators, decorators, concurrency & multithreading, web development basics

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
📚 Python Ref. Guide

Select a category to begin:

📖 Basic Topics
Learn essential Python fundamentals.

⚡ Intermediate Topics
Master programming techniques.

🚀 Advanced Topics
Dive into expert-level Python usage.

❌ Exit
Close the application.
            """.trimIndent()
            NavigationState.BASIC_SUBMENU -> """
📰 Basic Topics Menu

Select a subtopic to begin learning:

🛠️ Installation & Setup
How to install Python on various platforms.

🔤 Variables & Data Types
Understanding basic data structures.

🔀 Control Structures
If statements, loops, and conditionals.

📊 Basic Input/Output
Handling user input and output.
            """.trimIndent()
            NavigationState.INTERMEDIATE_SUBMENU -> """
⚡ Intermediate Topics Menu

Select a subtopic to advance your Python skills:

💻 Functions
Defining and using functions.

📦 Modules & Packages
Organizing code into modules.

🧱 Object-Oriented Programming
Classes, inheritance, and polymorphism.

📁 File Handling
Reading and writing files.
            """.trimIndent()
            NavigationState.ADVANCED_SUBMENU -> """
🚀 Advanced Topics Menu

Select a subtopic for expert-level Python knowledge:

🔄 Generators & Iterators
Efficient data processing.

🎨 Decorators
Enhancing functions.

🕒 Concurrency & Multithreading
Async programming and threads.

🌐 Web Development Basics
Intro to Flask or Django.
            """.trimIndent()
        }
    }

    override fun getTopicContent(level: String, id: String): String {
        return when (level) {
            "basics" -> when (id) {
                "install" -> """
🛠️ Installation & Setup - Getting Started with Python

Python is a versatile, high-level programming language known for its readability and vast ecosystem. Proper installation and setup are key to a smooth development experience. This section covers installation on major platforms, virtual environments, and initial configuration.

Detailed Explanation:
Python 3 is the current standard (Python 2 is deprecated). Use package managers on Linux/macOS or installers on Windows. Virtual environments isolate projects. Pip is the package manager. IDEs like VS Code enhance productivity.

Multiple Code Examples:
1. Installation on Ubuntu/Debian:
```bash
sudo apt update
sudo apt install python3 python3-pip
python3 --version
```
Explanation: This updates the package list and installs Python 3 and pip. The --version command verifies the installation.

2. Installation on Fedora:
```bash
sudo dnf install python3 python3-pip
python3 --version
```
Explanation: Dnf is the package manager for Fedora. It installs Python 3 and pip, and --version checks the version.

3. Installation on Windows:
- Download installer from python.org
- Run .exe, check "Add Python to PATH"
- Verify in cmd:
```cmd
python --version
```
Explanation: The installer adds Python to the system PATH. The cmd command verifies the installation.

4. Installation on macOS with Homebrew:
```bash
brew install python3
python3 --version
```
Explanation: Homebrew installs Python 3, and --version confirms it.

5. Create Virtual Environment:
```bash
python3 -m venv myenv
source myenv/bin/activate
deactivate
```
Explanation: Venv creates an isolated environment. Activate enters it, deactivate exits.

6. Install Package with Pip:
```bash
pip install requests
pip list
```
Explanation: Installs the requests library. Pip list shows installed packages.

Common Mistakes:
- Using Python 2 instead of 3, causing compatibility issues.
- Not using virtual environments, leading to dependency conflicts.
- Forgetting to add Python to PATH, making commands unavailable.
- Installing globally, polluting system Python.
- Ignoring pip warnings for updates.

Real-World Applications:
- Setting up for web development with Flask.
- Data analysis with Pandas in Jupyter.
- Automation scripts for DevOps.
- Machine learning with TensorFlow.
- Game development with Pygame.

⚠️ Safety Tips:
• Download from official python.org to avoid malware.
• Use virtual environments to isolate projects.
• Keep Python and pip updated for security fixes.
• Avoid running untrusted code.
• Secure pip packages; use trusted sources.
• Use HTTPS for pip installations.
• Limit permissions for scripts.
• Backup environments before updates.

💡 Pro Tips:
• Use pyenv for multiple Python versions.
• Install VS Code with Python extension for linting/debugging.
• Use pipenv or poetry for dependency management.
• Run Python with -m for modules.
• Check sys.path for import paths.
• Use conda for scientific computing.
• Set up aliases in shell for python3.
• Use IDLE for quick testing.

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                "variables" -> """
🔤 Variables & Data Types - Building Blocks of Python

Variables store data in Python, with dynamic typing making it flexible. Understanding data types is essential for efficient programming.

Detailed Explanation:
Python variables are references to objects. No explicit declaration; assign values directly. Data types include primitives (int, float, str, bool) and collections (list, tuple, dict, set). Mutable types (list, dict) can be modified; immutable (tuple, str) cannot.

Detailed Explanation of Data Types:
- Primitives are basic values like numbers and strings.
- Collections hold multiple items.
- Type checking with type().

Multiple Code Examples:
1. Primitive Types:
```python
age = 25  # int
price = 19.99  # float
name = "Alice"  # str
active = True  # bool
print(type(age))  # <class 'int'>
```
Explanation: This assigns values to variables and prints the type of age. Primitives are immutable.

2. Collections:
```python
numbers = [1, 2, 3]  # list (mutable)
point = (10, 20)  # tuple (immutable)
user = {"name": "Alice", "age": 25}  # dict (mutable)
unique = {1, 2, 3}  # set (mutable)
```
Explanation: Lists can be changed, tuples cannot. Dicts are key-value pairs, sets are unique unordered collections.

3. Modification:
```python
numbers.append(4)
user["email"] = "alice@email.com"
unique.add(4)
```
Explanation: Append adds to list, bracket notation adds to dict, add to set.

4. String Operations:
```python
greeting = "Hello, " + name
multiline = '''This is
                multi-line'''
print(f"Name: {name.upper()}")
```
Explanation: + concatenates, triple quotes for multiline, f-string for interpolation, upper() converts to uppercase.

5. Type Conversion:
```python
str_age = str(age)
int_price = int(price)
list_point = list(point)
```
Explanation: str() converts to string, int() to integer, list() to list.

Common Mistakes:
- Modifying immutable types, causing errors.
- Using = instead of == for comparisons.
- Forgetting quotes for strings.
- List vs tuple confusion.
- Dict key errors with missing keys.

Real-World Applications:
- Data processing in scripts.
- User data in web apps.
- Configurations in DevOps.
- Machine learning datasets.
- Game state management.

⚠️ Safety Tips:
• Validate user input for types.
• Use type hints for clarity.
• Handle None with checks.
• Avoid global variables.
• Secure sensitive data in memory.
• Use immutable types for thread safety.
• Test for type errors.
• Log variable states.

💡 Pro Tips:
• Use collections.namedtuple for structured tuples.
• Dict comprehension: {k: v*2 for k, v in dict.items()}
• Set operations for unique data.
• Use typing module for hints.
• Profile with memory_profiler.
• Use frozenset for immutable sets.
• String formatting with %.
• Check with isinstance().

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                "control" -> """
🔀 Control Structures - Flow Control

Control structures direct program execution based on conditions and repetition.

Detailed Explanation:
If-elif-else for conditionals. For loops iterate over sequences. While for condition-based loops. Try-except for error handling.

Detailed Explanation of Conditionals:
- If checks a condition, elif for additional checks, else for default.
- Loops repeat code; for for iterables, while for conditions.

Multiple Code Examples:
1. If-Else:
```python
score = 85
if score >= 90:
    grade = "A"
elif score >= 80:
    grade = "B"
else:
    grade = "C"
print(grade)
```
Explanation: This assigns grade based on score using conditional logic.

2. For Loop:
```python
fruits = ["apple", "banana", "cherry"]
for fruit in fruits:
    print(fruit.upper())
```
Explanation: Iterates over list, printing each item in uppercase.

3. While Loop:
```python
count = 0
while count < 3:
    print(count)
    count += 1
```
Explanation: Prints count while condition is true, incrementing each time.

4. Try-Except:
```python
try:
    x = 10 / 0
except ZeroDivisionError as e:
    print("Error: " + str(e))
finally:
    print("Cleanup")
```
Explanation: Handles division by zero error, with cleanup in finally.

5. Loop with Else:
```python
for i in range(3):
    print(i)
else:
    print("Loop completed")
```
Explanation: Else runs if loop completes without break.

Common Mistakes:
- Missing colon after if/for.
- Indentation errors.
- Infinite while loops.
- Catching broad exceptions.

Real-World Applications:
- User input validation.
- Data processing loops.
- Error handling in apps.

⚠️ Safety Tips:
• Validate conditions.
• Use break for loop exits.
• Handle exceptions specifically.
• Avoid deep nesting.
• Log errors.

💡 Pro Tips:
• Use enumerate for indices.
• List comprehensions for concise loops.
• Use else with try.
• Short-circuit with and/or.
• Use match in 3.10+.

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                "io" -> """
📊 Basic Input/Output - Interacting with Users

I/O operations allow programs to read input and produce output.

Detailed Explanation:
Input() for user input. Print() for output. Format strings for dynamic output.

Detailed Explanation of I/O:
- Input reads from stdin, print writes to stdout.
- f-strings for formatting.

Multiple Code Examples:
1. Basic Input:
```python
name = input("Enter name: ")
print("Hello, " + name)
```
Explanation: Reads user input, concatenates with string, prints result.

2. Formatted Print:
```python
age = 25
print(f"Age: {age}")
```
Explanation: f-string interpolates variable into string.

3. Multiple Outputs:
```python
print("One", "Two", sep=", ", end=".\n")
```
Explanation: Sep separates arguments, end sets ending character.

4. File Output:
```python
with open("output.txt", "w") as f:
    print("Data", file=f)
```
Explanation: Prints to file instead of console.

5. Command Line Args:
```python
import sys
print(sys.argv[1])
```
Explanation: Accesses first command-line argument.

Common Mistakes:
- Not validating input.
- Large outputs without buffering.

Real-World Applications:
- CLI tools.
- Logging.

⚠️ Safety Tips:
• Validate input.
• Avoid eval.

💡 Pro Tips:
• Use argparse for args.
• Redirect with sys.stdout.

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                else -> "Content for $level-$id coming soon!"
            }
            "intermediate" -> when (id) {
                "functions" -> """
💻 Functions - Reusable Code

Functions encapsulate code for reuse.

Detailed Explanation:
Define with def. Use parameters, return values.

Detailed Explanation of Functions:
- Functions reduce duplication.
- Parameters pass data, return outputs.

Multiple Code Examples:
1. Basic Function:
```python
def add(a, b):
    return a + b
print(add(3, 4))
```
Explanation: Adds two numbers and returns result.

2. Default Args:
```python
def greet(name="Guest"):
    print(f"Hi, {name}")
greet()
```
Explanation: Uses default if no argument provided.

3. Variable Args:
```python
def sum_nums(*args):
    return sum(args)
print(sum_nums(1, 2, 3))
```
Explanation: *args allows variable arguments as tuple.

4. Keyword Args:
```python
def info(**kwargs):
    print(kwargs)
info(name="Alice", age=25)
```
Explanation: **kwargs allows keyword arguments as dict.

5. Lambda:
```python
double = lambda x: x * 2
print(double(5))
```
Explanation: Anonymous function for simple operations.

Common Mistakes:
- Global variables in functions.
- Missing return.

Real-World Applications:
- Modular code in scripts.
- Utility functions.

⚠️ Safety Tips:
• Validate params.
• Avoid side effects.

💡 Pro Tips:
• Use docstrings.
• Type hints.

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                "modules" -> """
📦 Modules & Packages - Organizing Code

Modules and packages structure large projects.

Detailed Explanation:
Import modules. Packages are directories with __init__.py.

Detailed Explanation of Modules:
- Modules are files with code.
- Import to use.

Multiple Code Examples:
1. Import Standard Module:
```python
import math
print(math.sqrt(16))
```
Explanation: Imports math, calls sqrt.

2. From Import:
```python
from datetime import date
print(date.today())
```
Explanation: Imports specific item.

3. Custom Module:
```python
# mymodule.py
def func():
    return "Hello from module"
# main.py
import mymodule
print(mymodule.func())
```
Explanation: Custom module usage.

4. Package Import:
```python
# mypackage/__init__.py
from .mymodule import func
```
Explanation: Init for package.

5. Third-Party:
```python
import requests
r = requests.get("http://example.com")
print(r.status_code)
```
Explanation: Uses requests for HTTP.

Common Mistakes:
- Circular imports.
- Wrong path.

Real-World Applications:
- Reusable libraries.
- Large apps.

⚠️ Safety Tips:
• Trusted packages.
• Update dependencies.

💡 Pro Tips:
• Relative imports.
• Pipenv for management.

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                "oop" -> """
🧱 Object-Oriented Programming - Classes and Objects

OOP promotes reusable code with classes.

Detailed Explanation:
Classes define blueprints. Instances are objects.

Detailed Explanation of OOP:
- Init for constructors.
- Self for instance.

Multiple Code Examples:
1. Basic Class:
```python
class Dog:
    def __init__(self, name):
        self.name = name
    def bark(self):
        print("Woof!")
d = Dog("Buddy")
d.bark()
```
Explanation: Class with init and method.

2. Inheritance:
```python
class Puppy(Dog):
    def play(self):
        print("Playing")
p = Puppy("Max")
p.bark()
```
Explanation: Inherits bark, adds play.

3. Property:
```python
class Circle:
    def __init__(self, radius):
        self.radius = radius
    @property
    def area(self):
        return 3.14 * self.radius ** 2
c = Circle(5)
print(c.area)
```
Explanation: Property for computed attribute.

4. Static Method:
```python
class Math:
    @staticmethod
    def add(a, b):
        return a + b
print(Math.add(3, 4))
```
Explanation: Static method without self.

Common Mistakes:
- Forgetting self.
- Mutable defaults.

Real-World Applications:
- Models in apps.
- Frameworks.

⚠️ Safety Tips:
• Validate data.
• Use private attrs.

💡 Pro Tips:
• Dataclasses.
• Abstract classes.

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                "files" -> """
📁 File Handling - Reading and Writing Files

File handling is crucial for data persistence.

Detailed Explanation:
Use open() with modes (r, w, a, b). With statement ensures closure.

Detailed Explanation of File Modes:
- 'r' for read, 'w' for write, 'a' for append, 'b' for binary.

Multiple Code Examples:
1. Write File:
```python
with open("file.txt", "w") as f:
    f.write("Line 1\nLine 2")
```
Explanation: Writes two lines to file.

2. Read File:
```python
with open("file.txt", "r") as f:
    print(f.read())
```
Explanation: Reads entire file content.

3. Append:
```python
with open("file.txt", "a") as f:
    f.write("\nLine 3")
```
Explanation: Adds line without overwriting.

4. Binary Mode:
```python
with open("image.png", "rb") as f:
    data = f.read()
```
Explanation: Reads binary data.

5. CSV Reading:
```python
import csv
with open("data.csv", "r") as f:
    reader = csv.reader(f)
    for row in reader:
        print(row)
```
Explanation: Reads CSV rows as lists.

Common Mistakes:
- Not using with.
- Wrong mode.

Real-World Applications:
- Logging.
- Data export.

⚠️ Safety Tips:
• Validate paths.
• Handle exceptions.

💡 Pro Tips:
• Use pathlib.
• JSON serialization.

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                else -> "Content for $level-$id coming soon!"
            }
            "advanced" -> when (id) {
                "generators" -> """
🔄 Generators & Iterators - Efficient Data Processing

Generators provide memory-efficient iteration.

Detailed Explanation:
Yield keyword creates generators. Iterators implement __iter__ and __next__.

Detailed Explanation of Generators:
- Yield pauses function, resuming on next call.
- Useful for large datasets.

Multiple Code Examples:
1. Generator Function:
```python
def my_gen():
    yield 1
    yield 2
    yield 3
for x in my_gen():
    print(x)
```
Explanation: Yields values one at a time, saving memory.

2. Generator Expression:
```python
squares = (x**2 for x in range(5))
print(next(squares))
```
Explanation: Lazy evaluation of squares.

3. Custom Iterator:
```python
class MyIter:
    def __iter__(self):
        self.n = 0
        return self
    def __next__(self):
        if self.n < 3:
            self.n += 1
            return self.n
        raise StopIteration
for x in MyIter():
    print(x)
```
Explanation: Custom class mimicking iterator.

4. Yield From:
```python
def sub_gen():
    yield "a"
    yield "b"
def main_gen():
    yield from sub_gen()
    yield "c"
print(list(main_gen()))
```
Explanation: Delegates yielding to sub-generator.

Common Mistakes:
- Forgetting yield.
- Infinite generators.

Real-World Applications:
- Large data processing.
- Streaming.

⚠️ Safety Tips:
• Handle StopIteration.
• Avoid side effects.

💡 Pro Tips:
• Use itertools.
• Profile memory.

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                "decorators" -> """
🎨 Decorators - Function Enhancements

Decorators modify function behavior.

Detailed Explanation:
Decorators are functions that wrap other functions.

Detailed Explanation of Decorators:
- @decorator syntax applies wrapper.
- Useful for logging, timing.

Multiple Code Examples:
1. Simple Decorator:
```python
def my_dec(func):
    def wrapper():
        print("Start")
        func()
        print("End")
    return wrapper

@my_dec
def hello():
    print("Hello")
hello()
```
Explanation: Wrapper adds start/end around hello.

2. With Args:
```python
def repeat(n):
    def dec(func):
        def wrapper(*args, **kwargs):
            for _ in range(n):
                func(*args, **kwargs)
        return wrapper
    return dec

@repeat(3)
def say(s):
    print(s)
say("Hi")
```
Explanation: Repeats function call n times.

3. Class Decorator:
```python
def add_method(cls):
    def new_method(self):
        print("New method")
    cls.new_method = new_method
    return cls

@add_method
class MyClass:
    pass
m = MyClass()
m.new_method()
```
Explanation: Adds method to class.

4. Functools Wraps:
```python
from functools import wraps
def dec(func):
    @wraps(func)
    def wrapper():
        return func()
    return wrapper
```
Explanation: Preserves original function metadata.

Common Mistakes:
- Losing metadata.
- Wrong order.

Real-World Applications:
- Logging.
- Timing.

⚠️ Safety Tips:
• Use @wraps.
• Test thoroughly.

💡 Pro Tips:
• Decorate classes.
• Chain decorators.

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                "concurrency" -> """
🕒 Concurrency & Multithreading - Parallel Execution

Concurrency allows running multiple tasks simultaneously.

Detailed Explanation:
Use threading for I/O-bound, multiprocessing for CPU-bound, asyncio for async I/O.

Detailed Explanation of Concurrency:
- Threading for concurrent I/O.
- GIL limits CPU-bound threading.

Multiple Code Examples:
1. Threading:
```python
import threading
def worker():
    print("Working")
t = threading.Thread(target=worker)
t.start()
t.join()
```
Explanation: Runs worker in separate thread.

2. Lock:
```python
lock = threading.Lock()
def inc():
    with lock:
        global count
        count += 1
```
Explanation: Protects shared count from race conditions.

3. Multiprocessing:
```python
from multiprocessing import Process
p = Process(target=worker)
p.start()
p.join()
```
Explanation: Runs worker in separate process.

4. Asyncio:
```python
import asyncio
async def task():
    await asyncio.sleep(1)
    print("Done")
asyncio.run(task())
```
Explanation: Async task with await.

5. Pool:
```python
from concurrent.futures import ThreadPoolExecutor
with ThreadPoolExecutor() as executor:
    executor.submit(worker)
```
Explanation: Pool for multiple tasks.

Common Mistakes:
- Race conditions.
- GIL limitations.

Real-World Applications:
- Web scraping.
- Server handling.

⚠️ Safety Tips:
• Use locks.
• Handle exceptions.

💡 Pro Tips:
• Use futures.
• Profile concurrency.

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                "web" -> """
🌐 Web Development Basics - Intro to Web Apps

Build basic web apps with Flask or Django.

Detailed Explanation:
Flask is lightweight, Django is full-featured.

Detailed Explanation of Web Development:
- Flask for simple APIs.
- Django for full apps.

Multiple Code Examples:
1. Flask Hello World:
```python
from flask import Flask
app = Flask(__name__)

@app.route('/')
def home():
    return "Hello, Flask!"

app.run(debug=True)
```
Explanation: Creates Flask app with home route.

2. Flask Route with Param:
```python
@app.route('/user/<name>')
def user(name):
    return f"Hi, {name}"
```
Explanation: Dynamic route with parameter.

3. Django Setup:
```bash
django-admin startproject myproject
cd myproject
python manage.py startapp myapp
```
Explanation: Creates Django project and app.

4. Django View:
```python
# myapp/views.py
from django.http import HttpResponse
def home(request):
    return HttpResponse("Hello, Django!")
```
Explanation: Simple view returning response.

5. Flask JSON API:
```python
from flask import jsonify
@app.route('/api')
def api():
    return jsonify({"key": "value"})
```
Explanation: JSON response for API.

Common Mistakes:
- Debug mode in production.
- No input validation.

Real-World Applications:
- APIs.
- Web sites.

⚠️ Safety Tips:
• Use HTTPS.
• Validate inputs.

💡 Pro Tips:
• Use virtualenv.
• Deploy with Gunicorn.

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                else -> "Content for $level-$id coming soon!"
            }
            else -> "Content for $level-$id coming soon!"
        }
    }
}