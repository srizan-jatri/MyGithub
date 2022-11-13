package plugin.binary

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.plugin.KaptExtension

class AndroidHiltConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("org.jetbrains.kotlin.kapt")
                apply("com.google.dagger.hilt.android")
            }
            with(dependencies) {
                add("implementation", "com.google.dagger:hilt-android:2.44")
                add("kapt", "com.google.dagger:hilt-android-compiler:2.44")
            }

            with(extensions.getByName("kapt") as KaptExtension) {
                correctErrorTypes = true
            }
        }
    }
}