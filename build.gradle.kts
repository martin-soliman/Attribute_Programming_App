// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript { //bluetooth dependencies
    dependencies {
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.42")
    }
}
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
    id("com.google.dagger.hilt.android") version "2.48" apply false
}
