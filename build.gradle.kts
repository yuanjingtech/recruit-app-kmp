import org.jfrog.gradle.plugin.artifactory.dsl.ArtifactoryPluginConvention

plugins {
    // this is necessary to avoid the plugins to be loaded multiple times
    // in each subproject"s classloader
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.composeHotReload) apply false
    alias(libs.plugins.composeMultiplatform) apply false
    alias(libs.plugins.composeCompiler) apply false
    alias(libs.plugins.kotlinJvm) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
    alias(libs.plugins.ktor) apply false
    alias(libs.plugins.publish) apply false
    alias(libs.plugins.artifactory) apply false
}
val build_number = providers.gradleProperty("project.build_number").getOrElse("SNAPSHOT")

subprojects {
    group = "com.yuanjingtech.recruit.app.kmp"
    version = "0.0.1-${build_number}"
    plugins.withId("com.vanniktech.maven.publish") {
        configure<com.vanniktech.maven.publish.MavenPublishBaseExtension> {
            publishToMavenCentral()

            signAllPublications()

            coordinates(group.toString(), name, version.toString())

            pom {
                name = "yuanjingtech's recruit library for kmp app"
                description = "yuanjingtech's recruit library for kmp app."
                inceptionYear = "2025"
                url = "https://github.com/yuanjingtech/recruit-app-kmp"
                licenses {
                    license {
                        name = "MIT License"
                        url = "https://github.com/yuanjingtech/recruit-app-kmp/blob/main/LICENSE"
                        distribution = "https://github.com/yuanjingtech/recruit-app-kmp/blob/main/LICENSE"
                    }
                }
                developers {
                    developer {
                        id = "yuanjingtech"
                        name = "yuanjingtech"
                        url = "https://github.com/yuanjingtech"
                    }
                }
                scm {
                    url = "https://github.com/yuanjingtech/recruit-app-kmp"
                    connection = "scm:git:git://github.com/yuanjingtech/recruit-app-kmp.git"
                    developerConnection = "scm:git:ssh://git@github.com/yuanjingtech/recruit-app-kmp.git"
                }
            }
        }
    }
}

val pluginId = libs.plugins.artifactory.get().pluginId
subprojects {
    val artifactory_contextUrl: String by extra
    val artifactory_user: String by extra
    val artifactory_password: String by extra
    plugins.withId(pluginId) {
        configure<ArtifactoryPluginConvention> {
            publish {
                contextUrl = artifactory_contextUrl
                repository {
                    repoKey = "gradle-dev-local"
                    username = artifactory_user
                    password = artifactory_password
                }
                defaults {
                    publications("ALL_PUBLICATIONS")
                }
            }
        }
    }
}