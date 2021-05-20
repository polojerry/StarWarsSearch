object AppDependencies {
    //std lib
    val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"

    //android ui
     val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
     val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
     val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
     val material =
        "com.google.android.material:material:${Versions.material}"
     val activityKtx = "androidx.activity:activity-ktx:${Versions.activityVersion}"
     val fragment =  "androidx.fragment:fragment-testing:${Versions.fragment}"

    //DI-->> Hilt
     val hilt =
        "com.google.dagger:hilt-android:${Versions.hilt}"
     val hiltKapt =
        "com.google.dagger:hilt-android-compiler:${Versions.hilt}"

    //Hilt View Model
     val hiltViewModel = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hiltViewModel}"
     val hiltViewModelKapt = "androidx.hilt:hilt-compiler:${Versions.hiltViewModel}"

     val liveData =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifeCycle}"
     val viewModel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifeCycle}"

    //coroutines
     val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesCore}"

    //Navigation
     val navigationFragment =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
     val navigationUi =
        "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"

    //Shimmer
     val shimmer = "com.facebook.shimmer:shimmer:${Versions.shimmer}"

    //COil
     val coil = "io.coil-kt:coil:${Versions.coil}"

    //test libs
     val junit = "junit:junit:${Versions.junit}"
     val extJUnit = "androidx.test.ext:junit:${Versions.extJunit}"

    //Espresso
     val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"
     val espressoContrib = "androidx.test.espresso:espresso-contrib:${Versions.espresso}"

    ///Jetpack
     val archCore = "androidx.arch.core:core-testing:${Versions.arch}"
     val coroutineTest =  "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutinesTest}"
     val navigationTest = "androidx.navigation:navigation-testing:${Versions.navigation}"
    //hilt
     val hiltTestAndroid = "com.google.dagger:hilt-android-testing:${Versions.hilt}"
     val hiltTestAndroidKapt = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"

    // For Robolectric tests.
     val robolectric =  "com.google.dagger:hilt-android-testing:${Versions.robolectric}"
     val kaptHilt = "com.google.dagger:hilt-android-compiler:${Versions.robolectric}"
    
    val appLibraries = arrayListOf<String>().apply {
        add(kotlinStdLib)
        add(coreKtx)
        add(appcompat)
        add(constraintLayout)
        add(material)
        add(hilt)
        add(hiltViewModel)
        add(activityKtx)
        add(liveData)
        add(viewModel)
        add(navigationFragment)
        add(navigationUi)
        add(shimmer)
        add(coil)
        add(coroutinesCore)
        add(DataDependencies.retrofit)
        add(DataDependencies.moshi)
        add(DataDependencies.loggingInterceptor)
    }

    val androidTestLibraries = arrayListOf<String>().apply {
        add(extJUnit)
        add(espressoCore)
        add(navigationTest)
        add(hiltTestAndroid)
        add(espressoContrib)
    }

    val testLibraries = arrayListOf<String>().apply {
        add(archCore)
        add(extJUnit)
        add(coroutineTest)
        add(robolectric)
    }

    val appKapt = arrayListOf<String>().apply {
        add(hiltKapt)
        add(hiltViewModelKapt)
    }

    val appKaptTest =arrayListOf<String>().apply {
        add(kaptHilt)
    }

    val appAndroidTestKapt =arrayListOf<String>().apply {
        add(hiltTestAndroidKapt)
    }

    val appDebugImplementation =arrayListOf<String>().apply {
        add(fragment)
    }
}