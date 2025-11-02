# ⚡ EV Charger Finder (WIP)

> Android + Spring Boot demo app for discovering and reserving EV charging stations.  
> Built with **Jetpack Compose**, **feature-based Navigation DSL**, and a **Spring Boot REST API** backend.  
> Work in progress — focused on clean architecture, modularisation, and robust state handling.

---

## 🚀 Overview
EV Charger Finder is a full-stack personal project that explores **modern Android development** practices:
- **Compose Navigation DSL** with modular graph registration  
- **Offline-first data flow** (retry/backoff/idempotent writes)  
- **BLE/NFC pairing mock** for hardware-integrated systems  
- **Spring Boot** backend for station and reservation APIs  
- **CI/CD integration** with GitHub Actions + Firebase

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
