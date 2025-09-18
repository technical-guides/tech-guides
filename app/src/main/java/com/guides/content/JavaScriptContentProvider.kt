package com.guides.content

import com.guides.NavigationState

object JavaScriptContentProvider : ContentProvider {
    override fun getWelcomeMessage(): String = """
🌐 Welcome to the JavaScript Ref. Guide! 🌐

This interactive tutorial will guide you through essential JavaScript concepts,
from basic syntax to advanced web development.

📖 What you'll learn:

• Basic Topics: Installation, variables, control structures, functions
• Intermediate Topics: Arrays/objects, DOM, async basics, modules
• Advanced Topics: Promises, closures, prototypes, frameworks intro

🎯 How to navigate:

• Use the sidebar menu to select a topic category
• Click or tap to navigate through menus and subtopics
• Use the back button (← Back) to return to previous menus

🚀 Getting Started:

Choose a topic category from the sidebar to explore subtopics and start learning!
Each section includes explanations, examples, and best practices.

Good luck on your JavaScript journey! 🎓
    """.trimIndent()

    override fun getMenuContent(state: NavigationState): String {
        return when (state) {
            NavigationState.MAIN_MENU -> """
📚 JavaScript Ref. Guide

Select a category to begin:

📖 Basic Topics
Learn essential JavaScript fundamentals.

⚡ Intermediate Topics
Master web techniques.

🚀 Advanced Topics
Dive into expert-level usage.

❌ Exit
Close the application.
            """.trimIndent()
            NavigationState.BASIC_SUBMENU -> """
📰 Basic Topics Menu

Select a subtopic to begin learning:

🛠️ Installation & Setup
Node.js and browsers.

🔤 Variables & Data Types
let, const, var.

🔀 Control Structures
If, switch, loops.

📊 Functions
Defining functions.
            """.trimIndent()
            NavigationState.INTERMEDIATE_SUBMENU -> """
⚡ Intermediate Topics Menu

Select a subtopic to advance your skills:

📦 Arrays & Objects
Manipulating data.

🖼️ DOM Manipulation
Interacting with HTML.

🕒 Async Basics
Callbacks, setTimeout.

📁 Modules
Import/export.
            """.trimIndent()
            NavigationState.ADVANCED_SUBMENU -> """
🚀 Advanced Topics Menu

Select a subtopic for expert-level knowledge:

🔄 Promises & Async/Await
Handling async.

🎨 Closures
Function scopes.

🔍 Prototypes & Inheritance
OOP in JS.

🛠️ Frameworks Intro
React or Vue basics.
            """.trimIndent()
        }
    }

    override fun getTopicContent(level: String, id: String): String {
        return when (level) {
            "basics" -> when (id) {
                "install" -> """
🛠️ Installation & Setup - Getting Started with JavaScript

JavaScript runs in browsers or Node.js:

📥 Node.js:
• Download from nodejs.org
• node -v - Check version

📥 Browser:
• Use console in DevTools (F12)
• Script tags in HTML

🔧 Hello World:
• console.log("Hello");

⚠️ Safety Tips:
• Use strict mode: 'use strict';
• Avoid global variables

💡 Pro Tips:
• Use npm for packages
• VS Code for editing

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                "variables" -> """
🔤 Variables & Data Types - Basics

Declaring variables:

🆕 Variables:
• let x = 5;
• const PI = 3.14;

📋 Types:
• Number, String, Boolean
• Object, Array

🔍 Checking:
• typeof x

⚠️ Safety Tips:
• Use let/const over var
• Avoid hoisting issues

💡 Pro Tips:
• Destructuring: let {a, b} = obj;
• Template literals

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                "control" -> """
🔀 Control Structures - Flow

Controlling flow:

🧭 If/Ternary:
• if (x > 0) { ... }
• x > 0 ? 'Positive' : 'Negative'

📋 Loops:
• for (let i=0; i<5; i++) { ... }
• while (x > 0) { ... }

⚠️ Safety Tips:
• Avoid infinite loops
• Use for...of for arrays

💡 Pro Tips:
• Switch with fallthrough
• Labelled breaks

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                "functions" -> """
📊 Functions - Reusable Code

Defining functions:

🔧 Syntax:
• function add(a, b) { return a + b; }

📜 Arrow:
• const add = (a, b) => a + b;

🛡️ Scope:
• Block scope with let/const

⚠️ Safety Tips:
• Handle undefined params
• Avoid arrow for methods

💡 Pro Tips:
• Default params: (a=1)
• Rest params: ...args

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                else -> "Content for $level-$id coming soon!"
            }
            "intermediate" -> when (id) {
                "arrays" -> """
📦 Arrays & Objects - Data Structures

Manipulating data:

🔍 Arrays:
• let arr = [1,2,3]; arr.push(4);

📜 Objects:
• let obj = {key: 'value'}; obj.newKey = 'new';

🛡️ Methods:
• arr.map(x => x*2)
• Object.keys(obj)

⚠️ Safety Tips:
• Check existence
• Avoid mutating originals

💡 Pro Tips:
• Spread: [...arr]
• Destructuring

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                "dom" -> """
🖼️ DOM Manipulation - Web Interaction

Working with DOM:

🔍 Select:
• document.getElementById('id')

📜 Modify:
• elem.textContent = 'New text'

🛡️ Events:
• elem.addEventListener('click', () => { ... })

⚠️ Safety Tips:
• Avoid innerHTML
• Delegate events

💡 Pro Tips:
• QuerySelector
• Custom events

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                "async" -> """
🕒 Async Basics - Non-Blocking

Basic async:

🔍 SetTimeout:
• setTimeout(() => { ... }, 1000)

📜 Callbacks:
• function cb(err, data) { ... }

🛡️ SetInterval:
• setInterval(() => { ... }, 1000)

⚠️ Safety Tips:
• Clear timeouts
• Handle callback hell

💡 Pro Tips:
• RequestAnimationFrame
• Debounce/throttle

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                "modules" -> """
📁 Modules - Code Organization

Using modules:

🔍 Export:
• export function func() { ... }

📜 Import:
• import { func } from './module.js'

🛡️ Default:
• export default class { ... }

⚠️ Safety Tips:
• Use type="module" in script
• Browser support

💡 Pro Tips:
• Dynamic import()
• Tree shaking

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                else -> "Content for $level-$id coming soon!"
            }
            "advanced" -> when (id) {
                "promises" -> """
🔄 Promises & Async/Await - Async Handling

Async programming:

🔍 Promises:
• new Promise((res, rej) => { ... })

📜 Async/Await:
• async function() { await promise; }

🛡️ Error Handling:
• .catch() or try-catch

⚠️ Safety Tips:
• Handle rejections
• Avoid mixing styles

💡 Pro Tips:
• Promise.all
• Race conditions

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                "closures" -> """
🎨 Closures - Scoped Functions

Using closures:

🔍 Definition:
• function outer() { let x=1; return () => x; }

📜 Usage:
• For private variables

🛡️ IIFE:
• (function() { ... })()

⚠️ Safety Tips:
• Memory leaks
• Var vs let

💡 Pro Tips:
• Module pattern
• Currying

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                "prototypes" -> """
🔍 Prototypes & Inheritance - OOP

JS OOP:

🔍 Prototypes:
• Object.prototype

📜 Inheritance:
• Child.prototype = Object.create(Parent.prototype)

🛡️ Classes (ES6):
• class Child extends Parent { }

⚠️ Safety Tips:
• Avoid modifying built-ins
• Use hasOwnProperty

💡 Pro Tips:
• Proto chain
• Mixins

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                "frameworks" -> """
🛠️ Frameworks Intro - Building Apps

Intro to frameworks:

🔍 React:
• const App = () => <div>Hello</div>;

📜 Vue:
• new Vue({ el: '#app' });

🛡️ Angular:
• @Component({ ... })

⚠️ Safety Tips:
• Learn vanilla first
• State management

💡 Pro Tips:
• Hooks in React
• Components

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                else -> "Content for $level-$id coming soon!"
            }
            else -> "Content for $level-$id coming soon!"
        }
    }
}