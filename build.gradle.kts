// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.0" apply false
    id("com.android.library") version "8.1.0" apply false
    id("org.jetbrains.kotlin.android") version "1.8.0" apply false
    id("org.jetbrains.kotlin.jvm") version "1.8.0" apply false
    id("com.google.dagger.hilt.android") version "2.47" apply false
    id("androidx.navigation.safeargs.kotlin") version "2.7.1" apply false
    kotlin("kapt") version "1.9.10"
}
allprojects {
    ext {
        set("core_ktx_version", "1.10.1")
        set("junit_version", "4.13.2")
        set("hilt_version", "2.47")
        set("retrofit_version", "2.9.0")
        set("okhttp_version", "4.10.0")
        set("navigation_version", "2.7.1")
        set("mockk_version", "1.12.0")
        set("coroutines_test_version", "1.6.1")
    }
}
