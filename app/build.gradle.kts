plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.medilert"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.medilert"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    // Core Libraries
    implementation(libs.appcompat)
    implementation(libs.constraintlayout)
    implementation(libs.activity)
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)

    // Material Design Components
    implementation("com.google.android.material:material:1.9.0") // Correct Kotlin syntax

    // Testing Libraries
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}
