<div align="center"><img src="https://user-images.githubusercontent.com/61796073/147771856-5a48e5a8-54e8-40f7-8772-bfcd6da70f39.png"></div>

# CoffeeTimeNews ☕
<i>Build with modern Android Application Development tools and libraries. Main aim of this project is to practice with Jetpack Compose on MVVM arcihtecture design.</i>
<br>

## Features :fire:
- Jetpack Compose UI
- Dark / Light Mode
- Offline Capability - Cached Articles
- Single Activity Design

## Screenshots 📱
### 🌞 Light Mode

### 🌙 Dark Mode

## Libraries & Tools 🛠️
- [Kotlin](https://kotlinlang.org/docs/home.html)
  - [Flow](https://developer.android.com/kotlin/flow)
  - [Coroutines](https://developer.android.com/kotlin/coroutines)
- [Retrofit](https://square.github.io/retrofit/)
- [Moshi](https://github.com/square/moshi)
- [Accompanist](https://github.com/google/accompanist)
- [Jetpack Components](https://developer.android.com/jetpack)
  - [Compose](https://developer.android.com/jetpack/compose)
  - [Navigation](https://developer.android.com/guide/navigation/navigation-getting-started)
  - [Hilt](https://developer.android.com/training/dependency-injection)
  - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
  - [Datastore](https://developer.android.com/topic/libraries/architecture/datastore) 
  - [Room](https://developer.android.com/training/data-storage/room)

## Modules
- ```app```: Holds common application needs such as Compose Views, ViewModels, DI bindings, etc.
- ```core```: Pure JVM module includes utilities, interfaces, etc.
- ```data```: Data Source data holds Persistant Storage and Network Layer.
- ```repository```: For single source of data. Implements data module.

## Architecture (MVVM - Model View View-Model)
![mvvm](https://user-images.githubusercontent.com/61796073/147772339-679a9bd3-ab8f-4be5-80d2-b1599c9533b1.png)

## Development Setup 💻
You need to use latest [Canary Version](https://developer.android.com/studio/preview) of Android Studio 4.2 or newer to be able to build the app.



