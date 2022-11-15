plugins {
    plugin.scripts.`android-library`
    id("hilt")
}

android {
    namespace = "com.srizan.data"
}

dependencies {
    implementation(projects.core.database)
    implementation(projects.core.network)
    implementation(projects.domain)
}