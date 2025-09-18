package com.guides.content

import com.guides.NavigationState

object JavaContentProvider : ContentProvider {
    override fun getWelcomeMessage(): String = """
☕ Welcome to the Java Ref. Guide! ☕

This extensive tutorial covers Java from fundamentals to advanced topics, with numerous examples, best practices, and real-world applications to make you a proficient developer.

📖 What you'll learn:

• Basic Topics: Installation & setup, variables & data types, control structures, methods
• Intermediate Topics: Object-oriented programming, collections, exceptions, file I/O
• Advanced Topics: Generics, concurrency, JVM internals, streams

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
📚 Java Ref. Guide

Select a category to begin:

📖 Basic Topics
Learn essential Java fundamentals.

⚡ Intermediate Topics
Master programming techniques.

🚀 Advanced Topics
Dive into expert-level Java usage.

❌ Exit
Close the application.
            """.trimIndent()
            NavigationState.BASIC_SUBMENU -> """
📰 Basic Topics Menu

Select a subtopic to begin learning:

🛠️ Installation & Setup
Installing JDK and IDE.

🔤 Variables & Data Types
Primitives and references.

🔀 Control Structures
If, switch, loops.

📊 Methods
Defining methods.
            """.trimIndent()
            NavigationState.INTERMEDIATE_SUBMENU -> """
⚡ Intermediate Topics Menu

Select a subtopic to advance your Java skills:

🧱 Object-Oriented Programming
Classes, inheritance, polymorphism.

📦 Collections
Lists, sets, maps.

⚠️ Exceptions
Try-catch, custom exceptions.

📁 File I/O
Reading/writing files.
            """.trimIndent()
            NavigationState.ADVANCED_SUBMENU -> """
🚀 Advanced Topics Menu

Select a subtopic for expert-level Java knowledge:

🔧 Generics
Type-safe collections.

🕒 Concurrency
Threads, executors.

🔍 JVM Internals
Memory management.

🌊 Streams
Functional processing.
            """.trimIndent()
        }
    }

    override fun getTopicContent(level: String, id: String): String {
        return when (level) {
            "basics" -> when (id) {
                "install" -> """
🛠️ Installation & Setup - Getting Started with Java

Java is a versatile, object-oriented language used for applications across platforms. This section covers installing the JDK, configuring the environment, and setting up an IDE.

Detailed Explanation:
The JDK includes the compiler (javac), runtime (java), and tools. OpenJDK is open-source; Oracle JDK for commercial. Set JAVA_HOME and PATH for system access. Use IDEs like IntelliJ for productivity.

Multiple Code Examples:
1. Installation on Ubuntu:
```bash
sudo apt update
sudo apt install openjdk-17-jdk
java -version
```
Explanation: Updates packages and installs JDK 17. java -version verifies.

2. Installation on Windows:
- Download MSI from adoptium.net
- Run installer, add to PATH
- Verify in cmd:
```cmd
java -version
```
Explanation: Installer sets up JDK. cmd command checks version.

3. Installation on macOS:
```bash
brew install openjdk@17
java -version
```
Explanation: Homebrew installs JDK 17. Verify with java -version.

4. Set JAVA_HOME (Linux/macOS):
```bash
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
export PATH=\$\JAVA_HOME/bin:\$\PATH
```
Explanation: Sets JAVA_HOME to JDK path, adds bin to PATH.

5. Hello World:
```java
public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello, Java!");
    }
}
```
Explanation: Basic program printing message.

6. Compile and Run:
```bash
javac Hello.java
java Hello
```
Explanation: Compiles to bytecode, runs with JVM.

Common Mistakes:
- Using JRE instead of JDK.
- Wrong JAVA_HOME.
- Not adding to PATH.
- Old JDK versions.

Real-World Applications:
- Backend services.
- Android apps.

⚠️ Safety Tips:
• Download from trusted sources.
• Keep JDK updated.
• Secure JAVA_HOME.
• Test in VMs.
• Avoid old versions.

💡 Pro Tips:
• Use SDKMAN! for versions.
• Install IntelliJ Community.
• Use Gradle/Maven.
• Check with java -verbose.
• Set up Eclipse or VS Code.

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                "variables" -> """
🔤 Variables & Data Types - Building Blocks of Java

Variables store data in Java, with strong typing for safety.

Detailed Explanation:
Primitives (int, double) are efficient; references (String, Object) point to objects. Arrays store collections. Declare with type.

Detailed Explanation of Data Types:
- Primitives: Value types like int, double.
- References: Object types like String.

Multiple Code Examples:
1. Primitives:
```java
int age = 25;
double pi = 3.14159;
char letter = 'A';
boolean isTrue = true;
```
Explanation: Assigns values to primitive variables.

2. References:
```java
String name = "Alice";
Object obj = new Object();
```
Explanation: String is a reference type; Object is base class.

3. Arrays:
```java
int[] nums = new int[3];
nums[0] = 1;
String[] fruits = {"apple", "banana"};
```
Explanation: New allocates array; initializer for direct assignment.

4. Multi-Dimensional Array:
```java
int[][] matrix = {{1, 2}, {3, 4}};
```
Explanation: 2D array for matrix.

5. Var Inference (Java 10+):
```java
var list = new ArrayList<String>();
```
Explanation: Var infers type from right side.

Common Mistakes:
- Uninitialized variables.
- Primitive vs reference confusion.
- Array index errors.
- Var misuse.

Real-World Applications:
- Data storage in apps.
- Configurations.

⚠️ Safety Tips:
• Initialize variables.
• Use final for constants.
• Validate data.
• Avoid null unless necessary.
• Secure sensitive vars.

💡 Pro Tips:
• Use var for brevity.
• Prefer StringBuilder for strings.
• Use primitive types for performance.
• Check with instanceof.
• Use enums for fixed values.

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
```java
int x = 10;
if (x > 5) {
    System.out.println("Large");
} else if (x == 5) {
    System.out.println("Medium");
} else {
    System.out.println("Small");
}
```
Explanation: Checks conditions sequentially.

2. Switch:
```java
String day = "Monday";
switch (day) {
    case "Monday":
        System.out.println("Start week");
        break;
    default:
        System.out.println("Other day");
}
```
Explanation: Matches day to cases.

3. For Loop:
```java
for (int i = 0; i < 3; i++) {
    System.out.println(i);
}
```
Explanation: Initializes i, checks condition, increments.

4. Enhanced For:
```java
int[] nums = {1, 2, 3};
for (int n : nums) {
    System.out.println(n);
}
```
Explanation: Iterates over array elements.

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
• Use switch expressions (Java 12+).
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
```java
public int add(int a, int b) {
    return a + b;
}
```
Explanation: Adds two ints, returns sum.

2. Void Method:
```java
public void greet(String name) {
    System.out.println("Hi, " + name);
}
```
Explanation: Prints greeting, no return.

3. Overloading:
```java
public int add(int a, int b, int c) {
    return a + b + c;
}
```
Explanation: Same name, different params.

4. Static Method:
```java
public static void printHello() {
    System.out.println("Hello");
}
```
Explanation: Called without instance.

5. Varargs:
```java
public int sum(int... nums) {
    int total = 0;
    for (int n : nums) {
        total += n;
    }
    return total;
}
```
Explanation: Variable number of args.

Common Mistakes:
- Wrong return type.
- Missing static.

Real-World Applications:
- Utility classes.
- API methods.

⚠️ Safety Tips:
• Validate params.
• Handle exceptions.

💡 Pro Tips:
• Use @Override.
• Keep methods short.

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                else -> "Content for $level-$id coming soon!"
            }
            "intermediate" -> when (id) {
                "oop" -> """
🧱 Object-Oriented Programming - Classes and Objects

OOP in Java uses classes for blueprints.

Detailed Explanation:
Classes have fields, methods, constructors.

Multiple Code Examples:
1. Basic Class:
```java
public class Person {
    String name;
    public Person(String name) {
        this.name = name;
    }
    public void greet() {
        System.out.println("Hi, " + name);
    }
}
```
Explanation: Constructor sets name, method greets.

2. Inheritance:
```java
public class Student extends Person {
    int grade;
    public Student(String name, int grade) {
        super(name);
        this.grade = grade;
    }
}
```
Explanation: Extends Person, adds grade.

3. Interface:
```java
interface Greetable {
    void greet();
}
```
Explanation: Defines greet method.

4. Abstract Class:
```java
abstract class Shape {
    abstract double area();
}
```
Explanation: Requires area implementation.

Common Mistakes:
- Forgetting super().
- Poor encapsulation.

Real-World Applications:
- Models in apps.
- Frameworks.

⚠️ Safety Tips:
• Use private fields.
• Validate data.

💡 Pro Tips:
• Use interfaces.
• Apply SOLID.

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                "collections" -> """
📦 Collections - Data Structures

Collections handle groups of objects.

Detailed Explanation:
List, Set, Map interfaces with implementations.

Multiple Code Examples:
1. ArrayList:
```java
List<String> list = new ArrayList<>();
list.add("Alice");
```
Explanation: Dynamic list.

2. HashSet:
```java
Set<Integer> set = new HashSet<>();
set.add(1);
```
Explanation: Unique elements.

3. HashMap:
```java
Map<String, Integer> map = new HashMap<>();
map.put("Alice", 25);
```
Explanation: Key-value pairs.

4. Iteration:
```java
for (String s : list) {
    System.out.println(s);
}
```
Explanation: Enhanced for loop.

Common Mistakes:
- Concurrent modification.
- Raw types.

Real-World Applications:
- Data storage.
- Caches.

⚠️ Safety Tips:
• Use generics.
• Handle nulls.

💡 Pro Tips:
• Use unmodifiable.
• Stream API.

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                "exceptions" -> """
⚠️ Exceptions - Error Handling

Exceptions manage errors.

Detailed Explanation:
Try-catch handles thrown exceptions.

Multiple Code Examples:
1. Try-Catch:
```java
try {
    int x = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println(e.getMessage());
}
```
Explanation: Catches division error.

2. Throw:
```java
throw new IllegalArgumentException("Invalid");
```
Explanation: Throws custom exception.

3. Custom Exception:
```java
class MyException extends Exception {
    public MyException(String msg) {
        super(msg);
    }
}
```
Explanation: Custom class for exceptions.

4. Try-With-Resources:
```java
try (BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
    br.readLine();
} catch (IOException e) {
    e.printStackTrace();
}
```
Explanation: Auto-closes resource.

Common Mistakes:
- Broad catches.
- Empty catch blocks.

Real-World Applications:
- Robust apps.
- Logging errors.

⚠️ Safety Tips:
• Catch specific.
• Clean up in finally.

💡 Pro Tips:
• Use custom exceptions.
• Log with SLF4J.

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                "files" -> """
📁 File I/O - Handling Files

File I/O for data persistence.

Detailed Explanation:
Use Files class or streams for reading/writing.

Multiple Code Examples:
1. Write File:
```java
Files.writeString(Path.of("file.txt"), "Data");
```
Explanation: Writes string to file.

2. Read File:
```java
String content = Files.readString(Path.of("file.txt"));
```
Explanation: Reads entire file.

3. Buffered Reader:
```java
try (BufferedReader br = Files.newBufferedReader(Path.of("file.txt"))) {
    br.readLine();
}
```
Explanation: Reads line by line.

4. PrintWriter:
```java
try (PrintWriter pw = new PrintWriter("file.txt")) {
    pw.println("Line");
}
```
Explanation: Writes formatted lines.

Common Mistakes:
- Not closing streams.
- Wrong path.

Real-World Applications:
- Logging.
- Config files.

⚠️ Safety Tips:
• Handle IOException.
• Secure paths.

💡 Pro Tips:
• Use NIO for performance.
• Read lines with Files.lines.

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                else -> "Content for $level-$id coming soon!"
            }
            "advanced" -> when (id) {
                "generics" -> """
🔧 Generics - Type Safety

Generics for type-safe code.

Detailed Explanation:
<T> for parameterized types.

Multiple Code Examples:
1. Generic List:
```java
List<String> list = new ArrayList<>();
list.add("Alice");
```
Explanation: Type-safe string list.

2. Generic Method:
```java
<T> T max(T a, T b) {
    return a > b ? a : b;
}
```
Explanation: Generic for any comparable type.

3. Bounded Type:
```java
<T extends Number> T add(T a, T b) {
    return a.doubleValue() + b.doubleValue();
}
```
Explanation: Limits T to Number subtypes.

4. Wildcard:
```java
List<?> unknown = new ArrayList<>();
List<? extends Number> nums;
```
Explanation: ? for unknown, extends for subtypes.

Common Mistakes:
- Raw types.
- Type erasure issues.

Real-World Applications:
- Collections.
- APIs.

⚠️ Safety Tips:
• Use bounds.
• Avoid casts.

💡 Pro Tips:
• Use ? super T.
• Generic classes.

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                "concurrency" -> """
🕒 Concurrency - Parallel Execution

Concurrency for multi-tasking.

Detailed Explanation:
Threads for concurrent execution.

Multiple Code Examples:
1. Thread:
```java
Thread t = new Thread(() -> System.out.println("Run"));
t.start();
t.join();
```
Explanation: Runs lambda in thread.

2. Runnable:
```java
class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Run");
    }
}
new Thread(new MyRunnable()).start();
```
Explanation: Implements Runnable.

3. Executor:
```java
ExecutorService es = Executors.newFixedThreadPool(2);
es.submit(() -> System.out.println("Task"));
es.shutdown();
```
Explanation: Pool manages threads.

4. Synchronized:
```java
synchronized (obj) {
    // critical section
}
```
Explanation: Locks object.

5. Lock:
```java
Lock lock = new ReentrantLock();
lock.lock();
try {
    // code
} finally {
    lock.unlock();
}
```
Explanation: Explicit locking.

Common Mistakes:
- Race conditions.
- Deadlocks.

Real-World Applications:
- Servers.
- Computations.

⚠️ Safety Tips:
• Use locks.
• Handle interruptions.

💡 Pro Tips:
• Use Concurrent collections.
• CompletableFuture.

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                "jvm" -> """
🔍 JVM Internals - Runtime Environment

JVM executes Java bytecode.

Detailed Explanation:
Manages memory, GC, class loading.

Multiple Code Examples:
1. Memory Info:
```java
Runtime rt = Runtime.getRuntime();
System.out.println(rt.maxMemory());
```
Explanation: Prints max heap memory.

2. GC Call:
```java
System.gc();
```
Explanation: Suggests garbage collection.

3. Class Loading:
```java
Class.forName("java.lang.String");
```
Explanation: Loads class dynamically.

4. Thread Dump:
```java
Thread.dumpStack();
```
Explanation: Prints stack trace.

Common Mistakes:
- Ignoring GC tuning.
- Memory leaks.

Real-World Applications:
- Performance optimization.
- Debugging.

⚠️ Safety Tips:
• Tune carefully.
• Monitor metrics.

💡 Pro Tips:
• Use -XX options.
• Analyze with jstat.

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                "streams" -> """
🌊 Streams - Data Processing

Streams for functional-style operations.

Detailed Explanation:
Stream API for collections processing.

Multiple Code Examples:
1. Basic Stream:
```java
List.of(1, 2, 3).stream()
    .map(n -> n * 2)
    .forEach(System.out::println);
```
Explanation: Maps and prints.

2. Filter:
```java
List.of("apple", "banana").stream()
    .filter(s -> s.startsWith("a"))
    .collect(Collectors.toList());
```
Explanation: Filters strings.

3. Reduce:
```java
int sum = List.of(1, 2, 3).stream()
    .reduce(0, Integer::sum);
```
Explanation: Sums numbers.

4. Parallel:
```java
List.of(1, 2, 3).parallelStream()
    .map(n -> n * 2)
    .forEach(System.out::println);
```
Explanation: Parallel processing.

Common Mistakes:
- State in parallel streams.
- Closing streams.

Real-World Applications:
- Data filtering.
- Aggregation.

⚠️ Safety Tips:
• Avoid mutable state.
• Handle exceptions.

💡 Pro Tips:
• Use collectors.
• Combine operations.

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                else -> "Content for $level-$id coming soon!"
            }
            else -> "Content for $level-$id coming soon!"
        }
    }
}