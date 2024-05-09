plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

private val composeLibsVersion = "1.6.7"
private val composeUiLibsVersion = "1.6.7"
private val composeCompilerVersion = "1.5.13"

android {
    namespace = "io.github.yamin8000.pentris"
    compileSdk = 34

    defaultConfig {
        applicationId = "io.github.yamin8000.pentris"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0.0"

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            isMinifyEnabled = true
            isShrinkResources = true
        }
        debug {
            isMinifyEnabled = false
            isShrinkResources = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
        languageVersion = "1.9"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = composeCompilerVersion
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    kotlin.sourceSets.configureEach {
        languageSettings.enableLanguageFeature("DataObjects")
    }
}

dependencies {
    //core android
    implementation("androidx.core:core-ktx:1.13.1")
    //compose core
    debugImplementation("androidx.compose.ui:ui-tooling:$composeUiLibsVersion")
    implementation("androidx.compose.ui:ui:$composeUiLibsVersion")
    implementation("androidx.compose.ui:ui-tooling-preview:$composeUiLibsVersion")
    implementation("androidx.activity:activity-compose:1.9.0")
    //compose material3
    implementation("androidx.compose.material:material:$composeLibsVersion")
    implementation("androidx.compose.material:material-icons-extended:$composeLibsVersion")
    //material3
    val material3Version = "1.2.1"
    implementation("androidx.compose.material3:material3:$material3Version")
    implementation("androidx.compose.material3:material3-window-size-class:$material3Version")
    //compose navigation
    implementation("androidx.navigation:navigation-compose:2.7.7")
    //datastore
    implementation("androidx.datastore:datastore-preferences:1.1.1")
}