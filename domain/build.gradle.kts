plugins {
    id("java-library")
    id("kotlin")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    //app libs
    implementation(DomainDependencies.domainLibraries)

    //test
    testImplementation(CommonDependencies.testLibraries)

}