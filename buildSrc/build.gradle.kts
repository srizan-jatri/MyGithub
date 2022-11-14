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
}

gradlePlugin {
    plugins {
        register("hilt") {
            id = "hilt"
            implementationClass = "plugin.binary.AndroidHiltConventionPlugin"
        }
    }
}