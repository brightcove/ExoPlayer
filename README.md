# ExoPlayer #

ExoPlayer is an application level media player for Android. It provides an
alternative to Android’s MediaPlayer API for playing audio and video both
locally and over the Internet. ExoPlayer supports features not currently
supported by Android’s MediaPlayer API, including DASH and SmoothStreaming
adaptive playbacks. Unlike the MediaPlayer API, ExoPlayer is easy to customize
and extend, and can be updated through Play Store application updates.

## Documentation ##

* The [developer guide][] provides a wealth of information to help you get
  started.
* The [class reference][] documents the ExoPlayer library classes.
* The [release notes][] document the major changes in each release.

[developer guide]: https://google.github.io/ExoPlayer/guide.html
[class reference]: https://google.github.io/ExoPlayer/doc/reference
[release notes]: https://github.com/brightcove/ExoPlayer/blob/master/RELEASENOTES.md

## Using ExoPlayer ##

#### Via Brightcove repo ####

The easiest way to get started using ExoPlayer is by including the following in
your project's `build.gradle` file:

```gradle
repositories {
    maven {
      url 'http://repo.brightcove.com/releases'
    }
}
```
and
```gradle
compile 'com.google.exoplayer:library:X.X.X'
```

where `X.X.X` is your preferred version. For the latest version, see the
project's [Releases][].

[Releases]: https://github.com/brightcove/ExoPlayer/blob/master/RELEASES.md

#### As source ####

ExoPlayer can also be built from source using Gradle. You can include it as a
dependent project like so:

```gradle
// settings.gradle
include ':app', ':..:ExoPlayer:library'

// app/build.gradle
dependencies {
    compile project(':..:ExoPlayer:library')
}
```

#### As a jar ####

If you want to use ExoPlayer as a jar, run:

```sh
./gradlew jarRelease
```

and copy `library.jar` to the libs folder of your new project.

## Developing ExoPlayer ##

#### Using Android Studio ####

To develop ExoPlayer using Android Studio, simply open the ExoPlayer project in
the root directory of the repository.
