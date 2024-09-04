plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)

}

android {
    namespace = "com.example.itsmovietime"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.itsmovietime"
        minSdk = 23
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose=true
    }
    composeOptions {
        kotlinCompilerExtensionVersion= "1.5.0"
    }



    buildFeatures{
        viewBinding=true
        dataBinding=true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.runtime.livedata)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)


    //retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.11.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.11.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.10.0")
//    implementation("com.squareup.okhttp3:okhttp3:4.10.0")

    //Glide dependency
    implementation ("com.github.bumptech.glide:glide:4.16.0")


    // ViewModel utilities for Compose
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.3")
    // LiveData
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.8.3")

    //coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.9")

    //lifecycle
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")

    //glide
    annotationProcessor("com.github.bumptech.glide:compiler:4.12.0")
    //image slider
    implementation("com.github.denzcoskun:ImageSlideshow:0.1.2")


    val compose_version = "1.5.0"
    // Compose UI
    implementation ("androidx.compose.ui:ui:$compose_version")
    implementation ("androidx.compose.material:material:$compose_version")
    implementation ("androidx.compose.ui:ui-tooling-preview:$compose_version")
    debugImplementation ("androidx.compose.ui:ui-tooling:1.5.0")
    // Lifecycle
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")
    implementation ("androidx.activity:activity-compose:1.7.2")
    //Image loading
    implementation ("io.coil-kt:coil-compose:2.4.0")
    implementation ("com.google.accompanist:accompanist-pager:0.28.0")

    androidTestImplementation ("androidx.compose.ui:ui-test-junit4:$compose_version")
    debugImplementation ("androidx.compose.ui:ui-tooling:$compose_version")




        // Retrofit
        implementation ("com.squareup.retrofit2:retrofit:2.9.0")
        implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

        // Other dependencies...


}
