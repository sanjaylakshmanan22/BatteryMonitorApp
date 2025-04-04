# 🔋 Battery Monitor App

A simple Android app built using **Kotlin** to monitor your device's battery level and notify you when it’s **low or fully charged**.

## 📱 Features

- 🧭 Start/Stop background monitoring service
- 📢 Sends notifications when:
  - Battery level drops below user-defined threshold (e.g., 25%)
  - Battery is fully charged (100%)
- ⚙️ Custom threshold settings saved using SharedPreferences
- 👀 Minimal UI using Jetpack Compose
- 🚫 No dark theme headaches 😄

## 🛠️ Built With

- **Kotlin**
- **Jetpack Compose**
- **Android Service**
- **NotificationCompat**
- **SharedPreferences**

## ⚙️ Requirements

- **Android Studio (Hedgehog/Koala or later)**
- **Android 8.0+ (API 26+)**
- Make sure to grant **Notification permission** on Android 13+.

## 🚀 Getting Started

### 1. Clone this repository

```bash
git clone https://github.com/sanjaylakshmanan22/BatteryMonitorApp.git
cd BatteryMonitor
