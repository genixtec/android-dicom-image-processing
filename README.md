# Android dicom-image-processing
DICOM image processing using Imebra

[Imebra Offical Guide](https://imebra.com/wp-content/uploads/documentation/html/quick_tour.html)

## Prerequisite
  * [Download Imebra 4.2](https://imebra.com/get-it/)
  * Android Studio
  * Android SDK
  * Android NDK

## Imebrabuild setup

Extract the downloaded zip and you will find some folders wrappers, library, etc. For Android, we need wrappers and library folders to generate .aar.

  * Open the gradle project (Wrappers folder) in android studio
  * Build the project in release mode.
  
## Add .aar file android project

* File -> New Module -> Import .JAR/.AAR Module -> Select the Imebra-release.aar file and fill sub project name as Imebra.
* In Imebra module *build.gradle* put the below lines,
```
configurations.maybeCreate("default")
artifacts.add("default", file('imebrajni-release.aar'))

```
* In app module *build.gradle* put the below lines,
```
dependencies {
 implementation project(':imebra')
}

```
That's it Clean and Build.
