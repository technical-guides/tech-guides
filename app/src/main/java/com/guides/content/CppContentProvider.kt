package com.guides.content

import com.guides.NavigationState

object CppContentProvider : ContentProvider {
    override fun getWelcomeMessage(): String = """
🛠️ Welcome to the C/C++ Ref. Guide! 🛠️

This extensive tutorial covers C/C++ from fundamentals to advanced topics, with numerous examples, best practices, and real-world applications to make you a proficient developer.

📖 What you'll learn:

• Basic Topics: Installation & setup, variables & data types, control structures, functions
• Intermediate Topics: Pointers, structures & unions, file I/O, classes
• Advanced Topics: Templates, multithreading, memory management, STL

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
📚 C/C++ Ref. Guide

Select a category to begin:

📖 Basic Topics
Learn essential C/C++ fundamentals.

⚡ Intermediate Topics
Master core techniques.

🚀 Advanced Topics
Dive into expert-level features.

❌ Exit
Close the application.
            """.trimIndent()
            NavigationState.BASIC_SUBMENU -> """
📰 Basic Topics Menu

Select a subtopic to begin learning:

🛠️ Installation & Setup
Installing compilers and IDEs.

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

🧑‍🏫 Classes
OOP basics in C++.
            """.trimIndent()
            NavigationState.ADVANCED_SUBMENU -> """
🚀 Advanced Topics Menu

Select a subtopic for expert-level knowledge:

🔧 Templates
Generic programming in C++.

🕒 Multithreading
Concurrency in C++.

🔍 Memory Management
Allocators, smart pointers.

📦 STL
Standard Template Library.
            """.trimIndent()
        }
    }

    override fun getTopicContent(level: String, id: String): String {
        return when (level) {
            "basics" -> when (id) {
                "install" -> """
🛠️ Installation & Setup - Getting Started with C/C++

C/C++ are foundational languages for system programming, games, and performance-critical apps. This section covers installing compilers, setting up IDEs, and compiling your first program.

Detailed Explanation:
GCC for C, G++ for C++. Clang is an alternative. Use CMake for builds. IDEs like VS Code or CLion aid development.

Multiple Code Examples:
1. Installation on Ubuntu:
```bash
sudo apt update
sudo apt install g++
g++ --version
```
Explanation: Updates packages and installs G++ compiler. --version verifies installation.

2. Installation on Windows:
- Download MinGW from mingw.org
- Add bin to PATH
- Verify in cmd:
```cmd
g++ --version
```
Explanation: MinGW provides GCC for Windows. PATH allows command access.

3. Installation on macOS:
```bash
xcode-select --install
g++ --version
```
Explanation: Installs Command Line Tools, including G++.

4. Hello World (C++):
```cpp
#include <iostream>
int main() {
    std::cout << "Hello, C++!" << std::endl;
    return 0;
}
```
Explanation: Includes iostream, prints message, returns 0.

5. Compile and Run:
```bash
g++ hello.cpp -o hello
./hello
```
Explanation: Compiles to executable, runs it.

6. C Version:
```c
#include <stdio.h>
int main() {
    printf("Hello, C!\n");
    return 0;
}
gcc hello.c -o hello
./hello
```
Explanation: Similar for C using gcc.

Common Mistakes:
- Missing include directives.
- Wrong compiler (gcc for C++, g++ for C).
- Not setting PATH.
- Syntax errors in code.
- Ignoring compiler warnings.

Real-World Applications:
- System software.
- Embedded systems.
- Game engines.
- Performance apps.
- Libraries.

⚠️ Safety Tips:
• Use official compilers.
• Update regularly.
• Compile with -Wall for warnings.
• Test in sandbox.
• Avoid insecure functions (e.g., gets).

💡 Pro Tips:
• Use CMake for multi-platform builds.
• Debug with gdb.
• Use VS Code with C++ extension.
• Compile with -std=c++17 for modern features.
• Use make for build automation.

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                "variables" -> """
🔤 Variables & Data Types - Building Blocks of C/C++

Variables store data in C/C++, with static typing for safety.

Detailed Explanation:
Primitives like int, float. Arrays for collections. Declare with type.

Detailed Explanation of Data Types:
- Primitives: Value types like int, double.
- Derived: Arrays, pointers.
- User-defined: Structs, classes.

Multiple Code Examples:
1. Primitives:
```cpp
int age = 25;
double pi = 3.14159;
char letter = 'A';
bool active = true;
```
Explanation: Assigns values to primitive variables.

2. Strings (C++):
```cpp
#include <string>
std::string name = "Alice";
```
Explanation: Uses std::string for strings.

3. Arrays:
```cpp
int nums[3] = {1, 2, 3};
char str[] = "Hello";
```
Explanation: Fixed-size array initialization.

4. 2D Array:
```cpp
int matrix[2][2] = {{1, 2}, {3, 4}};
```
Explanation: Multi-dimensional array for matrix.

5. Const Variables:
```cpp
const int MAX = 100;
```
Explanation: Constant value.

Common Mistakes:
- Uninitialized variables.
- Overflow in primitives.
- Array out-of-bounds.

Real-World Applications:
- Data storage in programs.
- Configurations.

⚠️ Safety Tips:
• Initialize variables.
• Use const for constants.
• Check array bounds.
• Avoid undefined behavior.
• Secure sensitive data.

💡 Pro Tips:
• Use constexpr for compile-time constants.
• Prefer std::array in C++.
• Use enum for grouped constants.
• Check types with typeid.
• Use static for persistent values.

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                "control" -> """
🔀 Control Structures - Flow Control

Control structures direct program execution.

Detailed Explanation:
If-else for conditionals. Switch for multiple cases. Loops for repetition.

Multiple Code Examples:
1. If-Else:
```cpp
int x = 10;
if (x > 5) {
    std::cout << "Large" << std::endl;
} else if (x == 5) {
    std::cout << "Medium" << std::endl;
} else {
    std::cout << "Small" << std::endl;
}
```
Explanation: Checks conditions sequentially.

2. Switch:
```cpp
char grade = 'A';
switch (grade) {
    case 'A':
        std::cout << "Excellent" << std::endl;
        break;
    default:
        std::cout << "Other" << std::endl;
}
```
Explanation: Matches grade to cases.

3. For Loop:
```cpp
for (int i = 0; i < 3; i++) {
    std::cout << i << std::endl;
}
```
Explanation: Initializes i, checks condition, increments.

4. While Loop:
```cpp
int count = 0;
while (count < 3) {
    std::cout << count << std::endl;
    count++;
}
```
Explanation: Loops while condition true.

5. Do-While:
```cpp
do {
    std::cout << count << std::endl;
    count++;
} while (count < 3);
```
Explanation: Executes at least once.

Common Mistakes:
- Missing breaks in switch.
- Off-by-one in loops.

Real-World Applications:
- Decision making.
- Iteration.

⚠️ Safety Tips:
• Validate conditions.
• Use break/continue.

💡 Pro Tips:
• Use range-based for (C++11).
• Labeled breaks.

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                "methods" -> """
📊 Methods - Reusable Code

Methods encapsulate logic.

Detailed Explanation:
Methods have return types, parameters.

Multiple Code Examples:
1. Basic Method:
```cpp
int add(int a, int b) {
    return a + b;
}
```
Explanation: Adds two ints.

2. Void Method:
```cpp
void greet(const std::string& name) {
    std::cout << "Hi, " << name << std::endl;
}
```
Explanation: Prints greeting.

3. Overloading:
```cpp
int add(int a, int b, int c) {
    return a + b + c;
}
```
Explanation: Same name, different params.

4. Inline Method:
```cpp
inline int max(int a, int b) {
    return a > b ? a : b;
}
```
Explanation: Suggests inlining for performance.

5. Template Method:
```cpp
template <typename T>
T max(T a, T b) {
    return a > b ? a : b;
}
```
Explanation: Generic max.

Common Mistakes:
- Wrong return type.
- Missing const.

Real-World Applications:
- Modular code.
- APIs.

⚠️ Safety Tips:
• Validate params.
• Handle exceptions.

💡 Pro Tips:
• Use const refs.
• Inline for small functions.

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                else -> "Content for $level-$id coming soon!"
            }
            "intermediate" -> when (id) {
                "pointers" -> """
🔹 Pointers - Memory Access

Pointers store memory addresses.

Detailed Explanation:
* for pointers, & for address.

Multiple Code Examples:
1. Basic Pointer:
```cpp
int x = 5;
int* p = &x;
*p = 10;
```
Explanation: p points to x, modifies x.

2. Array Pointer:
```cpp
int arr[3] = {1, 2, 3};
int* ptr = arr;
std::cout << *(ptr + 1) << std::endl;
```
Explanation: Pointer arithmetic for array access.

3. Function Pointer:
```cpp
void greet() { std::cout << "Hi" << std::endl; }
void (*fp)() = greet;
fp();
```
Explanation: Calls function via pointer.

4. Const Pointer:
```cpp
const int* cp = &x; // Can't modify value
int* const pc = &x; // Can't change pointer
```
Explanation: Const for safety.

5. Pointer to Pointer:
```cpp
int** pp = &p;
```
Explanation: Pointer to pointer.

Common Mistakes:
- Dangling pointers.
- Null dereference.

Real-World Applications:
- Dynamic memory.
- Data structures.

⚠️ Safety Tips:
• Check null.
• Free memory.

💡 Pro Tips:
• Use smart pointers.
• Avoid arithmetic errors.

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                "structures" -> """
🧱 Structures & Unions - Custom Types

Structures group data.

Detailed Explanation:
Struct for related data, union for overlapping.

Multiple Code Examples:
1. Struct:
```cpp
struct Point {
    int x, y;
};
Point p = {10, 20};
```
Explanation: Defines Point with x, y.

2. Union:
```cpp
union Data {
    int i;
    float f;
};
Data d;
d.i = 5;
```
Explanation: Shares memory for i or f.

3. Struct with Methods (C++):
```cpp
struct Circle {
    float radius;
    float area() const {
        return 3.14 * radius * radius;
    }
};
```
Explanation: Adds method to struct.

4. Typedef:
```cpp
typedef struct Point Point2D;
```
Explanation: Alias for struct.

5. Bit Field:
```cpp
struct Flags {
    unsigned int a : 1;
    unsigned int b : 2;
};
```
Explanation: Bit-level fields for memory efficiency.

Common Mistakes:
- Padding issues.
- Union overlapping misuse.

Real-World Applications:
- Data packets.
- Configurations.

⚠️ Safety Tips:
• Align data.
• Avoid undefined behavior.

💡 Pro Tips:
• Use bit fields.
• Combine with classes.

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                "files" -> """
📁 File I/O - Handling Files

File I/O for data persistence.

Detailed Explanation:
Use fopen, fread, fwrite in C; fstream in C++.

Multiple Code Examples:
1. C File Write:
```c
FILE* f = fopen("file.txt", "w");
if (f) {
    fprintf(f, "Hello");
    fclose(f);
}
```
Explanation: Opens, writes, closes file.

2. C File Read:
```c
char buffer[100];
fread(buffer, 1, 100, f);
```
Explanation: Reads bytes from file.

3. C++ File Stream:
```cpp
std::ofstream ofs("file.txt");
ofs << "Hello";
ofs.close();
```
Explanation: Writes to file using stream.

4. C++ Input:
```cpp
std::ifstream ifs("file.txt");
std::string line;
std::getline(ifs, line);
```
Explanation: Reads line from file.

5. Error Checking:
```cpp
if (!ifs.is_open()) {
    std::cerr << "Error opening file" << std::endl;
}
```
Explanation: Checks if file opened.

Common Mistakes:
- Not closing files.
- Wrong mode.

Real-World Applications:
- Logging.
- Data storage.

⚠️ Safety Tips:
• Check fopen return.
• Handle errors.

💡 Pro Tips:
• Use std::fstream.
• Binary mode for non-text.

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                "classes" -> """
🧑‍🏫 Classes - OOP in C++

Classes for OOP in C++.

Detailed Explanation:
Classes have members, constructors.

Multiple Code Examples:
1. Basic Class:
```cpp
class Dog {
public:
    std::string name;
    Dog(std::string n) : name(n) {}
    void bark() {
        std::cout << "Woof!" << std::endl;
    }
};
```
Explanation: Constructor initializes name, method barks.

2. Inheritance:
```cpp
class Puppy : public Dog {
public:
    Puppy(std::string n) : Dog(n) {}
};
```
Explanation: Inherits from Dog.

3. Virtual Function:
```cpp
virtual void bark() = 0; // Pure virtual
```
Explanation: Requires implementation.

4. Friend Function:
```cpp
friend void friendFunc(Dog& d);
```
Explanation: Grants access to private members.

5. Operator Overloading:
```cpp
Dog operator+(const Dog& other) {
    return Dog(name + other.name);
}
```
Explanation: Custom + operator.

Common Mistakes:
- Missing semicolons.
- Private access.

Real-World Applications:
- Objects in apps.
- Libraries.

⚠️ Safety Tips:
• Use private members.
• Handle constructors.

💡 Pro Tips:
• Rule of Three.
• Use const methods.

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                else -> "Content for $level-$id coming soon!"
            }
            "advanced" -> when (id) {
                "templates" -> """
🔧 Templates - Generic Programming

Templates for generic code in C++.

Detailed Explanation:
Template <typename T> for types.

Multiple Code Examples:
1. Function Template:
```cpp
template <typename T>
T add(T a, T b) {
    return a + b;
}
```
Explanation: Adds any type.

2. Class Template:
```cpp
template <class T>
class Box {
    T item;
public:
    void set(T i) { item = i; }
};
```
Explanation: Generic Box class.

3. Specialization:
```cpp
template<>
class Box<int> {
    // Specialized
};
```
Explanation: Specific for int.

4. Variadic Template:
```cpp
template <typename... Args>
void print(Args... args) {
    (std::cout << ... << args) << std::endl;
}
```
Explanation: Variable args.

Common Mistakes:
- Syntax errors.
- No instantiation.

Real-World Applications:
- Containers.
- Algorithms.

⚠️ Safety Tips:
• Compile-time checks.
• Avoid code bloat.

💡 Pro Tips:
• SFINAE.
• Concepts (C++20).

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                "multithreading" -> """
🕒 Multithreading - Concurrent Execution

Multithreading for parallelism in C++.

Detailed Explanation:
<std::thread> for threads.

Multiple Code Examples:
1. Basic Thread:
```cpp
std::thread t([] { std::cout << "Run" << std::endl; });
t.join();
```
Explanation: Runs lambda in thread.

2. Mutex:
```cpp
std::mutex m;
std::lock_guard<std::mutex> lock(m);
```
Explanation: Protects critical section.

3. Condition Variable:
```cpp
std::condition_variable cv;
cv.notify_one();
cv.wait(lock);
```
Explanation: Signals between threads.

4. Future:
```cpp
std::promise<int> p;
std::future<int> f = p.get_future();
p.set_value(42);
std::cout << f.get() << std::endl;
```
Explanation: Asynchronous value.

Common Mistakes:
- Race conditions.
- Deadlocks.

Real-World Applications:
- Servers.
- Computations.

⚠️ Safety Tips:
• Use guards.
• Avoid shared mutable state.

💡 Pro Tips:
• Use std::async.
• Atomic variables.

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                "memory" -> """
🔍 Memory Management - Allocation and Deallocation

Memory management in C/C++.

Detailed Explanation:
New/delete for dynamic memory.

Multiple Code Examples:
1. New/Delete:
```cpp
int* p = new int(5);
delete p;
```
Explanation: Allocates and frees int.

2. Array New:
```cpp
int* arr = new int[3];
delete[] arr;
```
Explanation: For arrays.

3. Smart Pointers:
```cpp
std::unique_ptr<int> up(new int(5));
std::shared_ptr<int> sp = std::make_shared<int>(5);
```
Explanation: Auto memory management.

4. Custom Allocator:
```cpp
std::vector<int, MyAllocator> v;
```
Explanation: Custom memory allocation.

Common Mistakes:
- Memory leaks.
- Double delete.

Real-World Applications:
- Dynamic data.
- Performance.

⚠️ Safety Tips:
• Use smart pointers.
• Check null.

💡 Pro Tips:
• RAII.
• Placement new.

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                "stl" -> """
📦 STL - Standard Template Library

STL provides containers, algorithms.

Detailed Explanation:
Vectors, maps, algorithms.

Multiple Code Examples:
1. Vector:
```cpp
std::vector<int> v = {1, 2, 3};
v.push_back(4);
```
Explanation: Dynamic array.

2. Map:
```cpp
std::map<std::string, int> m;
m["age"] = 25;
```
Explanation: Key-value pairs.

3. Algorithm:
```cpp
std::sort(v.begin(), v.end());
```
Explanation: Sorts vector.

4. Iterator:
```cpp
for (auto it = v.begin(); it != v.end(); ++it) {
    std::cout << *it << std::endl;
}
```
Explanation: Iterates over vector.

Common Mistakes:
- Invalid iterators.
- Wrong container.

Real-World Applications:
- Data management.
- Algorithms.

⚠️ Safety Tips:
• Check bounds.
• Use const iterators.

💡 Pro Tips:
• Use auto.
• Custom comparators.

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                else -> "Content for $level-$id coming soon!"
            }
            else -> "Content for $level-$id coming soon!"
        }
    }
}