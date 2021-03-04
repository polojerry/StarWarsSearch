plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    compileSdkVersion(AppConfig.compileSdk)
    buildToolsVersion(AppConfig.buildToolsVersion)

    defaultConfig {
        minSdkVersion(AppConfig.minSdk)
        targetSdkVersion(AppConfig.targetSdk)

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }

        getByName("debug") {
            isMinifyEnabled = false
        }
    }

    java {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    //local module
    implementation(project(LocalModules.domainModule))

    //data libs
    implementation(DataDependencies.dataLibraries)

    //kapt
    kapt(DataDependencies.dataKapt)

    //test
    testImplementation(CommonDependencies.testLibraries)
    testImplementation(DataDependencies.testLibraries)

    androidTestImplementation(DataDependencies.androidTestLibraries)

}