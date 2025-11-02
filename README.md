# ⚡ EV Charger Finder

> Android + Spring Boot demo app for discovering and reserving EV charging stations.  
> Built with **Jetpack Compose**, **feature-based Navigation DSL**, and a **Spring Boot REST API** backend.  
> Work in progress — focused on clean architecture, modularisation, and robust state handling.

---

## 🧭 About This Project

This project was started on **1 November 2025** as a personal initiative to **show my development philosophy and coding style**  
through a small but complete Android–Backend system.  
It’s not a production app, but a condensed showcase of what I’ve learned from real-world engineering.

The goal is to reflect the core practices I adopted from professional Android development:

1. **Reliable experience even in unstable networks** –  
   Map integration and offline-first behaviour, ensuring minimum usability under poor connectivity.  
2. **Tight Android–Backend collaboration** –  
   Clear API contracts, shared data models, and predictable sync flows.  
3. **Error tracking & response pipeline** –  
   Integrated telemetry (Firebase + backend logging) to support proactive debugging.  
4. **Maintainable and communicative code** –  
   Clean architecture for easy feature iteration and adaptation to data or spec changes.

> 🗓️ Development started: **1 November 2025**  
> 🎯 Target completion: **by end of November 2025**

---

## 🚀 Overview

EV Charger Finder is a full-stack Android project built to demonstrate practical engineering principles  
I’ve learned from real-world development — **resilience, clarity, and maintainability**.

The app focuses on delivering a **reliable EV-charging experience** even under poor or unstable network conditions.  
Users can browse nearby stations, view basic information, and make mock reservations even when offline.

Key aspects include:
- **Offline-first architecture** — caching, retry/backoff, and graceful fallback for unreliable networks  
- **Seamless Android ↔ Backend collaboration** via RESTful APIs built in Spring Boot  
- **Composable UI with clear data flow** using Jetpack Compose and a modular codebase  
- **BLE pairing mock** to simulate charger–device connection logic  
- **CI/CD and error tracking** through GitHub Actions and Firebase Crashlytics  

This project isn’t about size — it’s about demonstrating **how I design systems that remain usable and maintainable under constraints.**

---

## 🧩 Architecture
```
ev-charger-finder/
├── app/ # Entry point, NavHost, Scaffold
├── core/
│ ├── model/ # Domain models (Station, Booking)
│ ├── network/ # Retrofit clients, interceptors, DTOs
│ ├── database/ # Room entities, DAOs
│ └── navigation/ # Shared route constants
├── feature/
│ ├── map/ # Map + markers + location logic
│ ├── booking/ # Reservation flow
│ ├── station/ # Station details
│ └── settings/ # Language + BLE mock
└── backend/ # Spring Boot REST API
```

---

## 🧠 Tech Stack

| Layer | Stack |
|-------|-------|
| **Android** | Kotlin · Jetpack Compose · MVVM · Hilt · Coroutines · Retrofit · Room · Firebase |
| **Architecture** | Multi-module · Navigation DSL · Clean Architecture |
| **Backend** | Java 21 · Spring Boot 3 · SQLite/H2 · REST API |
| **Tooling** | GitHub Actions · Gradle KTS · Firebase Crashlytics |

---

## 🌿 Branch Strategy

This project uses a **feature-based branching model**, designed for clarity between Android and Backend modules.
```
main ← Acts as the release branch
│
├── Android/ ← Android mainline (active Compose client development)
│ ├── features/ ← New features (UI, navigation, modules)
│ ├── refactor/ ← Architecture & code cleanup
│ └── fix/ ← Bug fixes and small patches
│
└── Backend/ ← Backend mainline (Spring Boot API)
├── features/ ← Endpoint additions, DB schema updates
├── refactor/ ← Service restructuring, performance tuning
└── fix/ ← Minor fixes or quick patches
```
