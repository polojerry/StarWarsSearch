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

    val mockWebServer = "com.squareup.okhttp3:mockwebserver:${Versions.mockWebServer}"

    val dataLibraries = arrayListOf<String>().apply {
        add(kotlinStdLib)
        add(coroutinesCore)
        add(retrofit)
        add(moshi)
        add(loggingInterceptor)
    }

    val testLibraries = arrayListOf<String>().apply {
        add(mockWebServer)
    }
}