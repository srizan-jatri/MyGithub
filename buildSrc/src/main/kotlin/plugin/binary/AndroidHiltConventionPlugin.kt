package plugin.binary
import constants.Versions

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
                add("implementation", "com.google.dagger:hilt-android:${Versions.hilt}")
                add("kapt", "com.google.dagger:hilt-android-compiler:${Versions.hilt}")
            }

            with(extensions.getByName("kapt") as KaptExtension) {
                correctErrorTypes = true
            }
        }
    }
}