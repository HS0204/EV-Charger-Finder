pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
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

rootProject.name = "EV-Charger-Finder"
include(":app")
include(":core:model")
include(":core:ui")
include(":core:network")
include(":core:database")
include(":feature:station")
include(":feature:booking")
include(":feature:map")
include(":feature:settings")
include(":core:navigation")
