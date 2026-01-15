📰 News App
📖 Overview
A modern Android News application built with the latest Android, Kotlin, and Jetpack technologies.
The app follows Clean Architecture principles and a reactive UI approach, ensuring scalability, maintainability, and high test coverage—ready for real-world production use.
🏗 Architecture
MVVM + Clean Architecture
UI Layer – Jetpack Compose UI & ViewModels
Domain Layer – Business logic, Use Cases
Data Layer – Repositories, Remote & Local data sources
Repository Pattern for data abstraction
Unidirectional Data Flow for predictable state management
🎨 UI & Design
Jetpack Compose (Material 3)
Declarative, lifecycle-aware UI
Responsive layouts with modern design components
⚡ Async & Reactive Programming
Kotlin Coroutines for structured concurrency
Kotlin Flow
Cold Flows for on-demand data streams
Hot Flows (StateFlow, SharedFlow) for UI state & events
🌐 Networking & Data
Retrofit + OkHttp + Gson for robust API communication
Room Database for local persistence & offline support
Coil for efficient image loading and caching
🧪 Testing
JUnit – Unit testing
Mockito – Mocking dependencies
kotlinx-coroutines-test – Coroutine testing
MockWebServer – API layer testing
Compose UI Tests – UI behavior validation
🔄 CI/CD
Automated GitHub Actions pipeline includes:
Build & static code analysis
Unit & UI test execution
Signed App Bundle generation
Deployment to Internal Testing Track
✨ Key Features
✔ Clean and modular architecture
✔ Reactive UI with Flow-driven state
✔ Offline-first support
✔ High test coverage
✔ Production-ready CI/CD pipeline
