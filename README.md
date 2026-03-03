**Android Architecture & Database Demo**

![Android](https://img.shields.io/badge/Platform-Android-green)
![Kotlin](https://img.shields.io/badge/Language-Kotlin-blue)
![Architecture](https://img.shields.io/badge/Architecture-orange)

A simple Android demo project to compare multiple architecture patterns and database solutions in Kotlin.

**📌 Overview**

This project is designed for educational purposes, showcasing:

MVC, MVP, MVVM (with & without Coroutines)

Room and SQLite database integration

Async operations using Kotlin Coroutines (only in MVVM module)

Clear separation of concerns and architecture comparison

It is not production-ready, but ideal for understanding Android architecture patterns and their differences.

**✨ Features**

✅ MVC architecture

✅ MVP architecture

✅ MVVM with Coroutines

✅ MVVM without Coroutines

✅ Room Database

✅ SQLite Database


**📊 Architecture Comparison**

| Architecture             | Network / Async Handling                        | Speed & Performance | Code Complexity       | Best Use Case / Notes                                            |
| ------------------------ | ----------------------------------------------- | ------------------- | --------------------- | ---------------------------------------------------------------- |
| **MVC**                  | Manual async, can block UI                      | Fast for small apps | Low-small, High-large | Simple demos; tight View-Controller coupling                     |
| **MVP**                  | Async handled in Presenter                      | Moderate            | Moderate              | Medium apps; better testability, clear View-Presenter separation |
| **MVVM w/o Coroutines**  | Async via LiveData or callbacks                 | Moderate            | Moderate              | Apps using LiveData & Room; avoids tight coupling                |
| **MVVM with Coroutines** | Async handled efficiently via Coroutines & Flow | Fast & responsive   | Low-medium            | Modern apps; recommended approach; reactive programming support  |


**🛠 Tech Stack**

Kotlin

Android Architecture Patterns: MVC, MVP, MVVM

Room & SQLite Databases

Kotlin Coroutines (only in MVVM module)


**🚀 How to Use**

Clone the repository:

git clone https://github.com/yourusername/your-repo-name.git

Open in Android Studio.

Explore each module:

MVC → Model, View, Controller

MVP → Model, View, Presenter

MVVM → Model, ViewModel, View (with or without Coroutines)

Test database functionality with Room or SQLite modules.


**👩‍💻 Author**

Sangita Patel

Android Application Developer 


**⭐ Show Your Support**

If you find this demo helpful, please give it a ⭐ on GitHub.
