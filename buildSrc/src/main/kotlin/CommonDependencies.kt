object CommonDependencies {

    //test libs
    private val junit = "junit:junit:${Versions.junit}"
    private val extJUnit = "androidx.test.ext:junit:${Versions.extJunit}"
    private val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    private val mockito = "org.mockito:mockito-core:${Versions.mockito}"
    private val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutinesCore}"

    val androidTestLibraries = arrayListOf<String>().apply {
        add(extJUnit)
        add(espressoCore)
    }

    val testLibraries = arrayListOf<String>().apply {
        add(junit)
        add(mockito)
        add(coroutines)
    }

}