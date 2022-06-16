plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.serialization)
    id("dagger.hilt.android.plugin")
    kotlin("kapt")
}

android {

    compileSdk = 32

    defaultConfig {
        minSdk = 21
        targetSdk = 32
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
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

}

dependencies {
    implementation(projects.libs.navigation)
    implementation(projects.libs.compose)

    implementation(libs.androidx.core.coreKtx)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.uiToolingPreview)
    implementation(libs.androidx.lifecycle.lifecycleRuntimeKtx)
    implementation(libs.androidx.activity.activityCompose)
    implementation(libs.androidx.lifecycle.viewmodelCompose)
    implementation(libs.androidx.lifecycle.viewmodelKtx)
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