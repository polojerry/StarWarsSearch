plugins {
    id("java-library")
    id("kotlin")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    //local module
    implementation(project(LocalModules.domainModule))

    //data libs
    implementation(DataDependencies.dataLibraries)

}