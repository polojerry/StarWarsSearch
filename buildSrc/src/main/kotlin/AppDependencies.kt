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

    //DI-->> Hilt
    private val hilt =
        "com.google.dagger:hilt-android:${Versions.hilt}"
    private val hiltKapt =
        "com.google.dagger:hilt-android-compiler:${Versions.hilt}"

    //Hilt View Model
    private val hiltViewModel =  "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hiltViewModel}"
    private val hiltViewModelKapt =  "androidx.hilt:hilt-compiler:${Versions.hiltViewModel}"

    private val liveData =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifeCycle}"
    private val viewModel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifeCycle}"


    private val navigationFragment =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    private val navigationUi =
        "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"


    //test libs
    private val junit = "junit:junit:${Versions.junit}"
    private val extJUnit = "androidx.test.ext:junit:${Versions.extJunit}"
    private val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"

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
        add(DataDependencies.retrofit)
        add(DataDependencies.moshi)
        add(DataDependencies.loggingInterceptor)
    }

    val androidTestLibraries = arrayListOf<String>().apply {
        add(extJUnit)
        add(espressoCore)
    }

    val testLibraries = arrayListOf<String>().apply {
        add(junit)
    }

    val appKapt = arrayListOf<String>().apply {
        add(hiltKapt)
        add(hiltViewModelKapt)
    }
}