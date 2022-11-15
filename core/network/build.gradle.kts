plugins {
    plugin.scripts.`android-library`
    id("hilt")
}

android {
    namespace = "com.srizan.network"
}

dependencies {
    api("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.8")
    implementation("com.jakewharton.timber:timber:5.0.1")
}