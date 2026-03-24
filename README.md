# wordleMockUpActually

## Description
A Kotlin-based Android application that recreates the popular Wordle word 
guessing game with custom logic and a native Android UI. Players guess a 
hidden word within a limited number of attempts, receiving color-coded 
feedback after each guess.

## Tech Stack
- **Language**: Kotlin
- **Platform**: Android
- **IDE**: Android Studio
- **Build System**: Gradle

## How to Play
- Guess the hidden word in 6 attempts
- After each guess, tiles change color to indicate accuracy:
  - **Green** — correct letter, correct position
  - **Yellow** — correct letter, wrong position
  - **Gray** — letter not in the word

## Features
- Custom Wordle game logic built from scratch
- Color coded tile feedback system
- Native Android UI
- Tracks remaining attempts

## Prerequisites
- Android Studio
- Android SDK
- JDK 17+

## Setup & Installation
1. Clone the repository
```bash
   git clone https://github.com/leighbee-bit/wordleMockUpActually.git
```
2. Open the project in Android Studio
3. Let Gradle sync and download dependencies
4. Run on an emulator or physical Android device

## What I Learned
- Implementing custom game logic in Kotlin
- Managing UI state across multiple interactions
- Working with color feedback systems in Android
- String manipulation and character comparison logic

## Future Improvements
- Daily word challenges
- Word dictionary validation
- Score tracking and streaks
- Animations on tile reveals
- Dark mode support

## License
MIT License
