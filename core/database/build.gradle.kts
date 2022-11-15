plugins {
    plugin.scripts.`android-library`
    id("hilt")
}

android {
    namespace = "com.srizan.database"
}

dependencies {
    implementation("androidx.room:room-runtime:2.4.3")
    implementation("androidx.room:room-ktx:2.4.3")
    kapt("androidx.room:room-compiler:2.4.3")
}