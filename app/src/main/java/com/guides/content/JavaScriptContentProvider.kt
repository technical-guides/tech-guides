package com.guides.content

import com.guides.NavigationState

object JavaScriptContentProvider : ContentProvider {
    override fun getWelcomeMessage(): String = """
🌐 Welcome to the JavaScript Ref. Guide! 🌐

This extensive tutorial covers JavaScript from fundamentals to advanced topics, with numerous examples, best practices, and real-world applications to make you a proficient web developer.

📖 What you'll learn:

• Basic Topics: Installation & setup, variables & data types, control structures, functions
• Intermediate Topics: Arrays & objects, DOM manipulation, async basics, modules
• Advanced Topics: Promises & async/await, closures, prototypes & inheritance, frameworks intro

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
📚 JavaScript Ref. Guide

Select a category to begin:

📖 Basic Topics
Learn essential JavaScript fundamentals.

⚡ Intermediate Topics
Master web techniques.

🚀 Advanced Topics
Dive into expert-level features.

❌ Exit
Close the application.
            """.trimIndent()
            NavigationState.BASIC_SUBMENU -> """
📰 Basic Topics Menu

Select a subtopic to begin learning:

🛠️ Installation & Setup
Setting up JavaScript environment.

🔤 Variables & Data Types
Understanding basic data.

🔀 Control Structures
If, switch, loops.

📊 Functions
Defining functions.
            """.trimIndent()
            NavigationState.INTERMEDIATE_SUBMENU -> """
⚡ Intermediate Topics Menu

Select a subtopic to advance your skills:

📦 Arrays & Objects
Manipulating data structures.

🖼️ DOM Manipulation
Interacting with HTML.

🕒 Async Basics
Callbacks and timers.

📁 Modules
Import/export code.
            """.trimIndent()
            NavigationState.ADVANCED_SUBMENU -> """
🚀 Advanced Topics Menu

Select a subtopic for expert-level knowledge:

🔄 Promises & Async/Await
Handling asynchronous code.

🎨 Closures
Function scopes and privacy.

🔍 Prototypes & Inheritance
OOP in JavaScript.

🛠️ Frameworks Intro
Getting started with React or Vue.
            """.trimIndent()
        }
    }

    override fun getTopicContent(level: String, id: String): String {
        return when (level) {
            "basics" -> when (id) {
                "install" -> """
🛠️ Installation & Setup - Getting Started with JavaScript

JavaScript is the language of the web, running in browsers and on servers with Node.js. This section covers setup for development and running your first script.

Detailed Explanation:
No installation needed for browsers; use console. For server-side, install Node.js. Use editors like VS Code.

Multiple Code Examples:
1. Node.js Installation on Ubuntu:
```bash
sudo apt update
sudo apt install nodejs npm
node -v
```
Explanation: Installs Node.js and npm, verifies version.

2. Hello World in Browser:
```html
<script>
    console.log("Hello, JavaScript!");
</script>
```
Explanation: Logs to console in browser.

3. Hello World in Node.js:
```javascript
console.log("Hello, JavaScript!");
// Run: node hello.js
```
Explanation: Runs in Node.js.

4. Setup VS Code:
- Install VS Code
- Add JavaScript extension

Explanation: Enhances coding with linting.

Common Mistakes:
- Wrong Node version.
- No PATH setup.

Real-World Applications:
- Web development.
- Server scripts.

⚠️ Safety Tips:
• Use official Node.js.
• Update regularly.

💡 Pro Tips:
• Use nvm for versions.
• Debug with console.

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                "variables" -> """
🔤 Variables & Data Types - Building Blocks of JavaScript

Variables store data in JavaScript, with dynamic typing.

Detailed Explanation:
Use let, const, var. Types: number, string, boolean, object.

Multiple Code Examples:
1. Variables:
```javascript
let age = 25;
const PI = 3.14;
var name = "Alice";
```
Explanation: let for mutable, const for constant, var for older code.

2. Data Types:
```javascript
let num = 42;
let str = "Hello";
let bool = true;
let obj = {key: "value"};
let arr = [1, 2, 3];
```
Explanation: Basic types and collections.

3. Typeof:
```javascript
console.log(typeof age); // number
```
Explanation: Checks type.

4. Template Literals:
```javascript
console.log(`Name: $\{name}`);
```
Explanation: Interpolates variables.

Common Mistakes:
- Using var (hoisting issues).
- Mutable const objects.

Real-World Applications:
- Data handling in apps.
- Configurations.

⚠️ Safety Tips:
• Use let/const.
• Check types.

💡 Pro Tips:
• Destructuring.
• Use Object.freeze.

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
```javascript
let x = 10;
if (x > 5) {
    console.log("Large");
} else if (x == 5) {
    console.log("Medium");
} else {
    console.log("Small");
}
```
Explanation: Checks conditions sequentially.

2. Switch:
```javascript
let day = "Monday";
switch (day) {
    case "Monday":
        console.log("Start week");
        break;
    default:
        console.log("Other day");
}
```
Explanation: Matches day to cases.

3. For Loop:
```javascript
for (let i = 0; i < 3; i++) {
    console.log(i);
}
```
Explanation: Initializes i, checks condition, increments.

4. For-Of:
```javascript
let fruits = ["apple", "banana"];
for (let fruit of fruits) {
    console.log(fruit);
}
```
Explanation: Iterates over array elements.

Common Mistakes:
- Loose == vs ===.
- Missing breaks.

Real-World Applications:
- User logic.
- Data looping.

⚠️ Safety Tips:
• Strict equality.
• Avoid infinite loops.

💡 Pro Tips:
• Use forEach.
• Ternary operators.

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                "functions" -> """
📊 Functions - Reusable Code

Functions encapsulate logic.

Detailed Explanation:
Declare with function or arrow.

Multiple Code Examples:
1. Function Declaration:
```javascript
function add(a, b) {
    return a + b;
}
```
Explanation: Adds two numbers.

2. Arrow Function:
```javascript
const greet = (name) => `Hi, $\{name}`;
```
Explanation: Concise greeting.

3. Default Params:
```javascript
function say( msg = "Hello" ) {
    console.log(msg);
}
```
Explanation: Uses default if no argument.

4. Rest Params:
```javascript
function sum(...nums) {
    return nums.reduce((a, b) => a + b, 0);
}
```
Explanation: Variable args as array.

Common Mistakes:
- This in arrow functions.
- Missing return.

Real-World Applications:
- Event handlers.
- Utilities.

⚠️ Safety Tips:
• Validate args.
• Avoid side effects.

💡 Pro Tips:
• IIFE for scope.
• Closures.

[Interactive exercises coming soon!]

Press Escape to return to Basic Topics menu.
                """.trimIndent()
                else -> "Content for $level-$id coming soon!"
            }
            "intermediate" -> when (id) {
                "arrays" -> """
📦 Arrays & Objects - Data Structures

Manipulate arrays and objects.

Detailed Explanation:
Arrays are lists, objects are key-value pairs.

Multiple Code Examples:
1. Array Methods:
```javascript
let nums = [1, 2, 3];
nums.push(4);
nums.pop();
```
Explanation: Push adds, pop removes last.

2. Map:
```javascript
let doubles = nums.map(n => n * 2);
```
Explanation: Maps each element.

3. Object:
```javascript
let user = {name: "Alice", age: 25};
user.email = "alice@email.com";
delete user.age;
```
Explanation: Adds/deletes properties.

4. Spread:
```javascript
let newUser = {...user, id: 1};
let allNums = [...nums, 5];
```
Explanation: Copies and adds elements.

Common Mistakes:
- Mutating originals.
- Object keys as strings.

Real-World Applications:
- JSON data.
- State management.

⚠️ Safety Tips:
• Clone before modifying.
• Check for keys.

💡 Pro Tips:
• Use Object.keys/values.
• Destructuring.

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                "dom" -> """
🖼️ DOM Manipulation - Web Interaction

Manipulate HTML with DOM.

Detailed Explanation:
Select elements, modify attributes, add events.

Multiple Code Examples:
1. Select Element:
```javascript
let elem = document.getElementById("myId");
```
Explanation: Gets element by ID.

2. Modify Text:
```javascript
elem.textContent = "New text";
```
Explanation: Changes text content.

3. Add Element:
```javascript
let div = document.createElement("div");
document.body.appendChild(div);
```
Explanation: Creates and adds div.

4. Event Listener:
```javascript
elem.addEventListener("click", () => console.log("Clicked"));
```
Explanation: Adds click handler.

Common Mistakes:
- Not waiting for DOM ready.
- ID/class confusion.

Real-World Applications:
- Dynamic UIs.
- Forms.

⚠️ Safety Tips:
• Sanitize user input.
• Avoid innerHTML.

💡 Pro Tips:
• Use querySelectorAll.
• Delegation for events.

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                "async" -> """
🕒 Async Basics - Non-Blocking Code

Basic async with callbacks and timers.

Detailed Explanation:
Use setTimeout, setInterval, callbacks.

Multiple Code Examples:
1. SetTimeout:
```javascript
setTimeout(() => console.log("Delayed"), 1000);
```
Explanation: Executes after delay.

2. SetInterval:
```javascript
setInterval(() => console.log("Repeat"), 1000);
```
Explanation: Repeats periodically.

3. Callback:
```javascript
function asyncTask(cb) {
    setTimeout(() => cb("Done"), 1000);
}
asyncTask(result => console.log(result));
```
Explanation: Calls cb when done.

4. Clear Timer:
```javascript
let timer = setTimeout(() => {}, 1000);
clearTimeout(timer);
```
Explanation: Cancels timeout.

Common Mistakes:
- Callback hell.
- Not clearing timers.

Real-World Applications:
- Animations.
- Polling.

⚠️ Safety Tips:
• Limit timers.
• Handle errors in callbacks.

💡 Pro Tips:
• Use promises for better async.
• Debounce functions.

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                "modules" -> """
📁 Modules - Code Organization

Modules for modular code.

Detailed Explanation:
Use import/export for ES6 modules.

Multiple Code Examples:
1. Export Function:
```javascript
// math.js
export function add(a, b) {
    return a + b;
}
```
Explanation: Exports add function.

2. Import:
```javascript
import { add } from "./math.js";
console.log(add(3, 4));
```
Explanation: Imports and uses add.

3. Default Export:
```javascript
export default class MyClass {}
```
Explanation: Default export.

4. Import Default:
```javascript
import MyClass from "./myclass.js";
```
Explanation: Imports default.

Common Mistakes:
- Wrong paths.
- Type="module" missing.

Real-World Applications:
- Large apps.
- Libraries.

⚠️ Safety Tips:
• Secure module paths.
• Avoid global pollution.

💡 Pro Tips:
• Dynamic import.
• Tree shaking.

[Interactive exercises coming soon!]

Press Escape to return to Intermediate Topics menu.
                """.trimIndent()
                else -> "Content for $level-$id coming soon!"
            }
            "advanced" -> when (id) {
                "promises" -> """
🔄 Promises & Async/Await - Async Code

Manage async with promises.

Detailed Explanation:
Promises for async results. Await for promise resolution.

Multiple Code Examples:
1. Promise:
```javascript
new Promise((resolve, reject) => {
    setTimeout(() => resolve("Done"), 1000);
}).then(result => console.log(result));
```
Explanation: Resolves after delay.

2. Reject:
```javascript
new Promise((resolve, reject) => {
    reject("Error");
}).catch(err => console.log(err));
```
Explanation: Handles rejection.

3. Async/Await:
```javascript
async function myAsync() {
    let result = await new Promise((res) => setTimeout(res, 1000, "Done"));
    return result;
}
myAsync().then(console.log);
```
Explanation: Awaits promise.

4. Promise.all:
```javascript
Promise.all([
    new Promise(res => res(1)),
    new Promise(res => res(2))
]).then(console.log);
```
Explanation: Waits for all promises.

Common Mistakes:
- Forgetting await.
- Unhandled rejections.

Real-World Applications:
- API calls.
- File loading.

⚠️ Safety Tips:
• Handle rejections.
• Avoid blocking.

💡 Pro Tips:
• Use Promise.race.
• Async iterators.

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                "closures" -> """
🎨 Closures - Scoped Functions

Closures capture outer scope.

Detailed Explanation:
Functions remember variables from enclosing scope.

Multiple Code Examples:
1. Basic Closure:
```javascript
function outer() {
    let x = 10;
    return function inner() {
        return x;
    }
}
const func = outer();
console.log(func());
```
Explanation: Inner returns x from outer.

2. Counter:
```javascript
function counter() {
    let count = 0;
    return function() {
        count++;
        return count;
    };
}
const c = counter();
console.log(c()); // 1
```
Explanation: Private count incremented.

3. Private Variables:
```javascript
function myModule() {
    let privateVar = "secret";
    return {
        getVar: () => privateVar
    };
}
const m = myModule();
console.log(m.getVar());
```
Explanation: Encapsulates privateVar.

Common Mistakes:
- Modifying closed variables.
- Memory leaks.

Real-World Applications:
- Modules.
- Event handlers.

⚠️ Safety Tips:
• Avoid large closures.
• Clear references.

💡 Pro Tips:
• Use for encapsulation.
• Combine with IIFE.

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                "prototypes" -> """
🔍 Prototypes & Inheritance - OOP in JS

Prototypes for inheritance.

Detailed Explanation:
Objects inherit from prototypes.

Multiple Code Examples:
1. Prototype:
```javascript
function Person(name) {
    this.name = name;
}
Person.prototype.greet = function() {
    console.log("Hi, " + this.name);
};
const p = new Person("Alice");
p.greet();
```
Explanation: Adds greet to prototype.

2. Inheritance:
```javascript
function Student(name, grade) {
    Person.call(this, name);
    this.grade = grade;
}
Student.prototype = Object.create(Person.prototype);
const s = new Student("Bob", "A");
s.greet();
```
Explanation: Inherits greet, adds grade.

3. Class Syntax:
```javascript
class Person {
    constructor(name) {
        this.name = name;
    }
    greet() {
        console.log("Hi, " + this.name);
    }
}
class Student extends Person {
    constructor(name, grade) {
        super(name);
        this.grade = grade;
    }
}
const s = new Student("Bob", "A");
s.greet();
```
Explanation: ES6 class syntax.

Common Mistakes:
- Wrong this.
- Prototype chain issues.

Real-World Applications:
- OOP structures.
- Libraries.

⚠️ Safety Tips:
• Use new.
• Check inheritance.

💡 Pro Tips:
• Use Object.create.
• Mixins.

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                "frameworks" -> """
🛠️ Frameworks Intro - Building Apps

Intro to JS frameworks.

Detailed Explanation:
Frameworks like React for UI.

Multiple Code Examples:
1. React Component:
```jsx
import React from 'react';
function App() {
    return <h1>Hello, React!</h1>;
}
export default App;
```
Explanation: Basic React component.

2. State in React:
```jsx
import { useState } from 'react';
function Counter() {
    const [count, setCount] = useState(0);
    return <button onClick={() => setCount(count + 1)}>{count}</button>;
}
```
Explanation: State with hook.

3. Vue Instance:
```javascript
new Vue({
    el: '#app',
    data: {
        message: 'Hello, Vue!'
    }
});
```
Explanation: Basic Vue app.

Common Mistakes:
- No key in lists.
- Mutable state.

Real-World Applications:
- SPAs.
- UIs.

⚠️ Safety Tips:
• Sanitize inputs.
• Update frameworks.

💡 Pro Tips:
• Use hooks in React.
• Vuex for state.

[Interactive exercises coming soon!]

Press Escape to return to Advanced Topics menu.
                """.trimIndent()
                else -> "Content for $level-$id coming soon!"
            }
            else -> "Content for $level-$id coming soon!"
        }
    }
}