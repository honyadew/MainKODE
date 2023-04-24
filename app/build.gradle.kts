plugins {
    id (Deps.Plugins.application)
    id (Deps.Plugins.kotlinKapt)
    id (Deps.Plugins.kotlinAndroid)
    id (Deps.Plugins.hilt)
}

android {
    namespace = Config.appName
    compileSdk = Config.compileSdk

    defaultConfig {
        applicationId = Config.appName
        minSdk = Config.MinSdk
        targetSdk = Config.targetSdk
        versionCode = Config.versionCode
        versionName = Config.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures{
        viewBinding = true
    }
}

dependencies {
    project(path = ":data")
    project(path = ":domain")

    implementation(Deps.Core.coreKts)
    implementation(Deps.Core.appCompat)
    implementation(Deps.Core.androidMaterial)
    implementation(Deps.Core.constaraiLayout)

    implementation(Deps.Hilt.hilt)
    annotationProcessor(Deps.Hilt.annotation)

    testImplementation(Deps.Test.junit)
    testImplementation(Deps.Test.androidJunit)
    testImplementation(Deps.Test.esspresso)
}

kapt {
    correctErrorTypes = true
}