import io.gitlab.arturbosch.detekt.Detekt

buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(libs.gradlePlugin.hilt)
    }
}

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.detekt)
}

allprojects {
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }
}

subprojects {
    apply(plugin = "io.gitlab.arturbosch.detekt")

    detekt {
        ignoreFailures = false
        buildUponDefaultConfig = true
        parallel = true
        autoCorrect = false
        config.setFrom(files(project.rootDir.resolve("detekt.yml")))

        dependencies {
            detektPlugins(rootProject.libs.detekt.plugins.formatting)
        }
    }

    tasks {
        withType<Detekt> {
            this.jvmTarget = "1.8"
            reports {
                html.required.set(true)
            }
        }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}