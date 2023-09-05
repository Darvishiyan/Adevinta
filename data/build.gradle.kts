plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.darvishiyan.data"
    compileSdk = 34

    defaultConfig {
        minSdk = 28

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    buildFeatures {
        buildConfig = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    api(project(mapOf("path" to ":domain")))

    implementation("androidx.core:core-ktx:${rootProject.extra["core_ktx_version"]}")

    // -------------- hilt
    val hiltVersion = rootProject.extra["hilt_version"]
    kapt("com.google.dagger:hilt-compiler:$hiltVersion")
    implementation("com.google.dagger:hilt-android:$hiltVersion")

    //-------------- internet
    val retrofitVersion = rootProject.extra["retrofit_version"]
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation("com.squareup.retrofit2:converter-gson:$retrofitVersion")
    val okhttpVersion = rootProject.extra["okhttp_version"]
    implementation("com.squareup.okhttp3:okhttp:$okhttpVersion")
    implementation("com.squareup.okhttp3:logging-interceptor:$okhttpVersion")

    // -------------- test
    testImplementation("junit:junit:${rootProject.extra["junit_version"]}")
    testImplementation("io.mockk:mockk:${rootProject.extra["mockk_version"]}")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:${rootProject.extra["coroutines_test_version"]}")
}
