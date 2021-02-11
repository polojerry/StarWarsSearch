object AppDependencies {
    //std lib
    val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"

    //android ui
    private val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    private val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    private val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    private val material =
        "com.google.android.material:material:${Versions.material}"
    private val activityKtx = "androidx.activity:activity-ktx:${Versions.activityVersion}"
    private val fragment =  "androidx.fragment:fragment-testing:${Versions.fragment}"

    //DI-->> Hilt
    private val hilt =
        "com.google.dagger:hilt-android:${Versions.hilt}"
    private val hiltKapt =
        "com.google.dagger:hilt-android-compiler:${Versions.hilt}"

    //Hilt View Model
    private val hiltViewModel = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hiltViewModel}"
    private val hiltViewModelKapt = "androidx.hilt:hilt-compiler:${Versions.hiltViewModel}"

    private val liveData =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifeCycle}"
    private val viewModel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifeCycle}"

    //coroutines
    private val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesCore}"

    //Navigation
    private val navigationFragment =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    private val navigationUi =
        "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"

    //Shimmer
    private val shimmer = "com.facebook.shimmer:shimmer:${Versions.shimmer}"

    //COil
    private val coil = "io.coil-kt:coil:${Versions.coil}"

    //test libs
    private val junit = "junit:junit:${Versions.junit}"
    private val extJUnit = "androidx.test.ext:junit:${Versions.extJunit}"

    //Espresso
    private val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    private val espressoContrib = "androidx.test.espresso:espresso-contrib:${Versions.espresso}"

    ///Jetpack
    private val archCore = "androidx.arch.core:core-testing:${Versions.arch}"
    private val coroutineTest =  "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutinesTest}"
    private val navigationTest = "androidx.navigation:navigation-testing:${Versions.navigation}"
    //hilt
    private val hiltTestAndroid = "com.google.dagger:hilt-android-testing:${Versions.hilt}"
    private val hiltTestAndroidKapt = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"

    // For Robolectric tests.
    private val robolectric =  "com.google.dagger:hilt-android-testing:${Versions.robolectric}"
    private val kaptHilt = "com.google.dagger:hilt-android-compiler:${Versions.robolectric}"
    
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