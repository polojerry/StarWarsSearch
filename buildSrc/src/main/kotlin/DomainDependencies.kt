object DomainDependencies {

    //std lib
    val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"

    //coroutines
    val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesCore}"


    val domainLibraries = arrayListOf<String>().apply {
        add(kotlinStdLib)
        add(coroutinesCore)
    }
}