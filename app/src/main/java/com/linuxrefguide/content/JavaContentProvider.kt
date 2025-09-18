package com.linuxrefguide.content

import com.linuxrefguide.NavigationState

object JavaContentProvider : ContentProvider {
    override fun getWelcomeMessage(): String = """
Welcome to the Java Ref. Guide!

This interactive tutorial will guide you through essential Java concepts,
from basic syntax to advanced programming techniques.

What you'll learn:

• Basic Topics: Installation, variables, control structures, methods
• Intermediate Topics: OOP, collections, exceptions, file I/O
• Advanced Topics: Generics, concurrency, JVM, streams

How to navigate:

• Use the sidebar menu to select a topic category
• Click or tap to navigate through menus and subtopics
• Use the back button (← Back) to return to previous menus

Getting Started:

Choose a topic category from the sidebar to start learning!
Each section includes explanations, examples, and best practices.

Good luck on your Java journey!
    """.trimIndent()

    override fun getMenuContent(state: NavigationState): String {
        return when (state) {
            NavigationState.MAIN_MENU -> """
Java Ref. Guide

Select a category to begin:

Basic Topics
Learn essential Java fundamentals.

Intermediate Topics
Master programming techniques.

Advanced Topics
Dive into expert-level Java usage.

Exit
Close the application.
            """.trimIndent()
            NavigationState.BASIC_SUBMENU -> """
Basic Topics Menu

Select a subtopic to begin learning:

Installation & Setup
Install Java on various platforms.

Variables & Data Types
Work with Java variables.

Control Structures
Use if, for, while.

Methods
Define reusable methods.
            """.trimIndent()
            NavigationState.INTERMEDIATE_SUBMENU -> """
Intermediate Topics Menu

Select a subtopic to advance your Java skills:

Object-Oriented Programming
Create classes and objects.

Collections
Use lists, sets, maps.

Exceptions
Handle errors.

File I/O
Read and write files.
            """.trimIndent()
            NavigationState.ADVANCED_SUBMENU -> """
Advanced Topics Menu

Select a subtopic for expert-level Java knowledge:

Generics
Use generic types.

Concurrency
Run parallel tasks.

JVM Internals
Understand the JVM.

Streams
Process data streams.
            """.trimIndent()
        }
    }

    override fun getTopicContent(level: String, id: String): String {
        return when (level) {
            "basics" -> when (id) {
                "install" -> """
Installation & Setup - Getting Started with Java

Install Java:

Steps:
• Download JDK from oracle.com
• Install on Linux: sudo apt install openjdk-17-jdk
• Install on Windows: Run installer
• Verify: java -version

Safety Tips:
• Use official sources
• Keep JDK updated

Pro Tips:
• Set JAVA_HOME
• Use IDE like IntelliJ

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                "variables" -> """
Variables & Data Types - Working with Data

Basic data types:

Examples:
• int x = 5;
• String name = "Alice";
• double pi = 3.14;
• boolean flag = true;

Safety Tips:
• Initialize variables
• Use meaningful names

Pro Tips:
• Use final for constants
• Check with instanceof

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                "control" -> """
Control Structures - Flow Control

Control program flow:

Examples:
• if (x > 0) { System.out.println("Positive"); }
• for (int i = 0; i < 5; i++) { ... }
• while (x < 10) { x++; }
• switch (x) { case 1: ... }

Safety Tips:
• Avoid infinite loops
• Handle edge cases

Pro Tips:
• Use enhanced for loops
• Break early when possible

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                "methods" -> """
Methods - Defining Reusable Code

Define methods:

Examples:
• public int add(int a, int b) { return a + b; }
• public void greet(String name) { System.out.println("Hi, " + name); }
• public static void main(String[] args) { ... }
• private String getName() { return name; }

Safety Tips:
• Avoid side effects
• Document with Javadoc

Pro Tips:
• Use method overloading
• Keep methods short

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                else -> "Content for basic-$id coming soon!"
            }
            "intermediate" -> when (id) {
                "oop" -> """
Object-Oriented Programming - Classes and Objects

Use OOP:

Examples:
• public class Person { String name; public Person(String name) { this.name = name; } }
• Person p = new Person("Alice");
• class Student extends Person { ... }
• interface Printable { void print(); }

Safety Tips:
• Follow encapsulation
• Avoid deep inheritance

Pro Tips:
• Use interfaces
• Override toString()

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                "collections" -> """
Collections - Lists, Sets, Maps

Use collections:

Examples:
• List<String> list = new ArrayList<>();
• Set<Integer> set = new HashSet<>();
• Map<String, Integer> map = new HashMap<>();
• list.add("Item"); map.put("key", 1);

Safety Tips:
• Check for null
• Use appropriate collection

Pro Tips:
• Use Collections.unmodifiableList
• Iterate with forEach

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                "exceptions" -> """
Exceptions - Handling Errors

Handle exceptions:

Examples:
• try { int x = 1/0; } catch (ArithmeticException e) { ... }
• throw new IllegalArgumentException("Invalid");
• public void method() throws IOException { ... }
• finally { System.out.println("Cleanup"); }

Safety Tips:
• Catch specific exceptions
• Avoid empty catch blocks

Pro Tips:
• Use custom exceptions
• Log exceptions

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                "files" -> """
File I/O - Reading and Writing Files

Handle files:

Examples:
• Files.readAllLines(Paths.get("file.txt"));
• Files.write(Paths.get("file.txt"), "Data".getBytes());
• BufferedReader br = new BufferedReader(new FileReader("file.txt"));
• Files.newOutputStream(Paths.get("file.txt"));

Safety Tips:
• Close resources
• Handle IOExceptions

Pro Tips:
• Use try-with-resources
• Use Files class

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                else -> "Content for intermediate-$id coming soon!"
            }
            "advanced" -> when (id) {
                "generics" -> """
Generics - Using Generic Types

Use generics:

Examples:
• List<String> list = new ArrayList<>();
• <T> void print(T item) { System.out.println(item); }
• class Box<T> { T value; }
• List<? extends Number> nums;

Safety Tips:
• Avoid raw types
• Check type bounds

Pro Tips:
• Use wildcard types
• Create generic methods

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                "concurrency" -> """
Concurrency - Running Parallel Tasks

Manage concurrency:

Examples:
• Thread t = new Thread(() -> System.out.println("Run"));
• ExecutorService es = Executors.newFixedThreadPool(2);
• synchronized (obj) { ... }
• CompletableFuture.runAsync(() -> ...);

Safety Tips:
• Avoid race conditions
• Use locks carefully

Pro Tips:
• Use thread pools
• Prefer CompletableFuture

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                "jvm" -> """
JVM Internals - Understanding the JVM

Explore JVM:

Topics:
• Class loading
• Garbage collection
• JIT compilation
• Memory management

Examples:
• -Xmx512m # Set heap size
• jmap -histo PID # Heap dump
• jstack PID # Thread dump

Safety Tips:
• Monitor memory usage
• Avoid tuning without testing

Pro Tips:
• Use VisualVM
• Analyze GC logs

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                "streams" -> """
Streams - Processing Data Streams

Use streams:

Examples:
• List<Integer> nums = Arrays.asList(1, 2, 3);
• nums.stream().map(x -> x * 2).collect(Collectors.toList());
• Stream.of("a", "b").filter(s -> s.length() > 1);
• IntStream.range(0, 5).sum();

Safety Tips:
• Avoid side effects
• Check stream state

Pro Tips:
• Use parallel streams
• Combine with collectors

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                else -> "Content for advanced-$id coming soon!"
            }
            else -> "Content for $level-$id coming soon!"
        }
    }
}