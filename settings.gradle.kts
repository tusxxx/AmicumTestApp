pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "AmicumTestApp"
include(":app")
include(":data:places")
include(":data:place")
include(":domain:place")
include(":feature:idle")
include(":feature:manual")
include(":common:ui")
include(":common:navigation")
