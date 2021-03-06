plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("dagger.hilt.android.plugin")
    kotlin("kapt")
}

android {
    compileSdk = 32

    defaultConfig {
        applicationId = "pl.krystiankaniowski.sky"
        minSdk = 21
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.get()
    }

    packagingOptions {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}

dependencies {
    implementation(projects.libs.compose)
    implementation(projects.libs.navigation)
    implementation(projects.features.about)
    implementation(projects.features.moon)
    implementation(projects.features.solarsystem)

    implementation(libs.androidx.core.coreKtx)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.uiToolingPreview)
    implementation(libs.androidx.lifecycle.lifecycleRuntimeKtx)
    implementation(libs.androidx.activity.activityCompose)
    implementation(libs.androidx.navigation.compose)

    implementation(libs.ktor.client.contentNegotiation)
    implementation(libs.ktor.client.android)
    implementation(libs.ktor.client.serializationJson)

    implementation(libs.hilt.android)
    implementation(libs.hilt.navigation.compose)
    kapt(libs.hilt.compiler)

    debugImplementation(libs.test.androidx.compose.uiTooling)
    debugImplementation(libs.test.androidx.compose.uiTestManifest)
}

dependencies {
    testImplementation(libs.test.junit4)
    androidTestImplementation(libs.test.androidx.test.junit4)
    androidTestImplementation(libs.test.androidx.test.espressoCore)
    androidTestImplementation(libs.test.androidx.compose.uiTestJunit4)
}