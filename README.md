# harrypotter

Harry potter is Built with Jetpack Compose using HP-API. The app follows mvvm clean architecture design pattern. The app also supports material you

## **Screenshots**

- #### Light Mode
<img src="./screenshots/lightsplash.jpg" width="320">&emsp;
<img src="./screenshots/lightmain.jpg" width="320">&emsp;
<img src="./screenshots/lightsearch.jpg" width="320">&emsp;
<img src="./screenshots/lightdetails.jpg" width="320">&emsp;
<img src="./screenshots/lightfilter.jpg" width="320">

- #### Dark Mode
<img src="./screenshots/darksplash.jpg" width="320">&emsp;
<img src="./screenshots/darkmain.jpg" width="320">&emsp;
<img src="./screenshots/darksearch.jpg" width="320">&emsp;
<img src="./screenshots/darkdetails.jpg" width="320">&emsp;
<img src="./screenshots/darkfilter.jpg" width="320">

## Tech Stack
 - [Kotlin](https://kotlinlang.org/docs/reference/) - Kotlin is a cross-platform, statically typed, general-purpose programming language with type inference. Kotlin is designed to interoperate fully with Java, and the JVM version of Kotlin's standard library depends on the Java Class Library, but type inference allows its syntax to be more concise
 
 * [Jetpack Components:](https://developer.android.com/topic/architecture?gclid=Cj0KCQjw8O-VBhCpARIsACMvVLOH1satX45o9f4PMQ4Sxr7bG9myl6-KZL9nYda8PJsHV7m2uJL8bzgaAmqiEALw_wcB&gclsrc=aw.ds)
    * [Jetpack Compose](https://developer.android.com/jetpack/compose?gclid=Cj0KCQjwhqaVBhCxARIsAHK1tiMMwHsxQ8Z25jyEdtLha9erq11wROoEfL6RqpGMprgbDTNuMO3_Ri8aAu5EEALw_wcB&gclsrc=aw.ds) -  Android’s modern toolkit for building native UI. It simplifies and accelerates UI development on Android
    * [View Model](https://developer.android.com/topic/libraries/architecture/viewmodel)-  store and manage UI-related data in a lifecycle conscious way.
    * [Lifecycle]( https://developer.android.com/topic/libraries/architecture/lifecycle) - Perform actions in response to a change in the lifecycle status of another component, such as activities and fragments.
    * [Android KTX](https://developer.android.com/kotlin/ktx.html) - Android KTX is a set of Kotlin extensions that are included with Android Jetpack and other Android libraries. KTX extensions provide concise, idiomatic Kotlin to Jetpack, Android platform, and other APIs.

- [Retrofit](https://github.com/square/retrofit)- A type-safe HTTP client for Android and Java.
* [Dagger-Hilt](https://dagger.dev/hilt/)- a dependency injection library for Android that reduces the boilerplate of doing manual dependency injection in your project

* [Coroutines](https://developer.android.com/kotlin/coroutines) - a concurrency design pattern that you can use on Android to simplify code that executes asynchronously
* [Flow](https://developer.android.com/kotlin/flow)- In coroutines, a flow is a type that can emit multiple values sequentially, as opposed to suspend functions that return only a single value.
* [Coil](https://coil-kt.github.io/coil/compose/) - Image Loader library.
* [Lottie](https://github.com/airbnb/lottie-android) - Lottie is a mobile library for Android and iOS that parses Adobe After Effects animations exported as json with Bodymovin and renders them natively on mobile!
* [Mock web server](https://coil-kt.github.io/coil/compose/) - A scriptable web server for testing HTTP clients.
## Data Source
This application fetches its data from the [HP-API](https://hp-api.onrender.com/).
