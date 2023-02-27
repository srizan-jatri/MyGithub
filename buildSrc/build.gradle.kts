import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}
repositories {
    google()
    mavenCentral()
    //gradlePluginPortal()
}
tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions.apiVersion = "1.6"
}
dependencies {
    implementation("com.android.tools.build:gradle:7.3.1")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.20")
    implementation("com.google.dagger:hilt-android-gradle-plugin:2.44")

    // Make sure that you have the Google services Gradle plugin dependency
    implementation("com.google.gms:google-services:4.3.15")

    // Add the dependency for the App Distribution Gradle plugin
    implementation("com.google.firebase:firebase-appdistribution-gradle:3.2.0")
}

gradlePlugin {
    plugins {
        register("hilt") {
            id = "hilt"
            implementationClass = "plugin.binary.AndroidHiltConventionPlugin"
        }
    }
}