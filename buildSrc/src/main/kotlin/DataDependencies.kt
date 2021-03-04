object DataDependencies {

    //std lib
    val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"

    //coroutines
    val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesCore}"

    //Network
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val moshi = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    val loggingInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}"

    //room
    private val room = "androidx.room:room-runtime:${Versions.roomVersion}"
    private val roomKapt = "androidx.room:room-compiler:${Versions.roomVersion}"
    private val roomKtx = "androidx.room:room-ktx:${Versions.roomVersion}"

    //test
    private val testRunner =  "androidx.test:runner:1.1.0"
    private val testCore =  "androidx.test:core:1.0.0"
    private val extJUnit = "androidx.test.ext:junit:${Versions.extJunit}"
    private val roomTest =  "androidx.room:room-testing:${Versions.roomVersion}"
    private val mockWebServer = "com.squareup.okhttp3:mockwebserver:${Versions.mockWebServer}"
    private val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"

    val dataLibraries = arrayListOf<String>().apply {
        add(kotlinStdLib)
        add(coroutinesCore)
        add(retrofit)
        add(moshi)
        add(loggingInterceptor)
        add(room)
        add(roomKtx)
    }

    val dataKapt = arrayListOf<String>().apply {
        add(roomKapt)
    }

    val testLibraries = arrayListOf<String>().apply {
        add(mockWebServer)
        add(roomTest)
        add(testCore)
    }

    val androidTestLibraries = arrayListOf<String>().apply {
        add(extJUnit)
        add(testRunner)
        add(espresso)
    }
}