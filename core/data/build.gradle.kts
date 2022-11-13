plugins {
    id("org.jetbrains.kotlin.android")
    id("com.android.library")
    id("hilt")
    plugin.scripts.`android-library`
}

android {
    namespace = "com.srizan.data"
}

dependencies {
    implementation(projects.core.database)
    implementation(projects.core.network)
    implementation(projects.domain)
}