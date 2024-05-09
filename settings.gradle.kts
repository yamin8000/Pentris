/*
 *     Pentris/Pentris
 *     settings.gradle.kts Copyrighted by Yamin Siahmargooei at 2024/5/9
 *     settings.gradle.kts Last modified at 2024/5/9
 *     This file is part of Pentris/Pentris.
 *     Copyright (C) 2024  Yamin Siahmargooei
 *
 *     Pentris/Pentris is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Pentris/Pentris is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Pentris.  If not, see <https://www.gnu.org/licenses/>.
 */

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

rootProject.name = "Pentris"
include(":app")
