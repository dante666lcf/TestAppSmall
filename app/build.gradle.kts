plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
    id("kotlinx-serialization")
    id("com.google.devtools.ksp") version "1.6.21-1.0.6"
}

kotlin {
    sourceSets {
        debug {
            kotlin.srcDir("build/generated/ksp/debug/kotlin")
        }
        release {
            kotlin.srcDir("build/generated/ksp/release/kotlin")
        }
    }
}

android {
    namespace = "com.example.testapp"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.testapp"
        minSdk = 28
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    testOptions {
        unitTests {
            unitTests.isIncludeAndroidResources = true
            unitTests.isReturnDefaultValues = true
        }
    }
    buildTypes {
        release {
            isMinifyEnabled = true
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
        compose = true
    }
    composeOptions {
        val compose_version = "1.2.0-beta01"
        kotlinCompilerExtensionVersion = compose_version
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    val coreKtx = "1.5.0"
    implementation("androidx.test:core-ktx:$coreKtx")
    implementation("androidx.core:core-ktx:$coreKtx")

    val lifecycleRuntime = "2.3.1"
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleRuntime")

    val composeVersion = "1.2.0-beta01"
    implementation("androidx.compose.ui:ui:$composeVersion")
    implementation("androidx.compose.material:material:$composeVersion")
    implementation("androidx.compose.ui:ui-tooling-preview:$composeVersion")
    debugImplementation("androidx.compose.ui:ui-tooling:$composeVersion")
    debugImplementation("androidx.compose.ui:ui-test-manifest:$composeVersion")

    val composeNavigation = "2.5.2"
    implementation("androidx.navigation:navigation-compose:$composeNavigation")

    val activityCompose = "1.3.1"
    implementation("androidx.activity:activity-compose:$activityCompose")

    val androidRoom = "2.3.0"
    implementation("androidx.room:room-runtime:$androidRoom")
    kapt("androidx.room:room-compiler:$androidRoom")
    implementation("androidx.room:room-ktx:$androidRoom")

    val retrofit = "2.9.0"
    val retrofitKtxSerialization = "0.8.0"
    implementation("com.squareup.retrofit2:retrofit:$retrofit")
    implementation("com.squareup.retrofit2:converter-gson:$retrofit")
    implementation("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:$retrofitKtxSerialization")

    val pagingCompose = "1.0.0-alpha14"
    implementation("androidx.paging:paging-compose:$pagingCompose")

    val kotlinSerialization = "1.2.2"
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$kotlinSerialization")

    val androidDatastore = "1.0.0"
    implementation("androidx.datastore:datastore-preferences:$androidDatastore")

    val daggerHilt = "2.38.1"
    val androidHiltCompiler = "1.0.0"
    val hiltNavigationCompose = "1.0.0-alpha03"
    implementation("com.google.dagger:hilt-android:$daggerHilt")
    kapt("com.google.dagger:hilt-android-compiler:$daggerHilt")
    kapt("androidx.hilt:hilt-compiler:$androidHiltCompiler")
    implementation("androidx.hilt:hilt-navigation-compose:$hiltNavigationCompose")

    val accompanistVersion = "0.21.2-beta"
    implementation("com.google.accompanist:accompanist-pager:$accompanistVersion")
    implementation("com.google.accompanist:accompanist-pager-indicators:$accompanistVersion")
    implementation("com.google.accompanist:accompanist-flowlayout:$accompanistVersion")
    implementation("com.google.accompanist:accompanist-swiperefresh:$accompanistVersion")
    implementation("com.google.accompanist:accompanist-systemuicontroller:$accompanistVersion")

    val palette = "1.0.0"
    implementation("androidx.palette:palette-ktx:$palette")

    val raamcostaNavigation = "1.6.15-beta"
    implementation("io.github.raamcosta.compose-destinations:animations-core:$raamcostaNavigation")
    ksp("io.github.raamcosta.compose-destinations:ksp:$raamcostaNavigation")

    implementation("com.github.bumptech.glide:compose:1.0.0-alpha.1")
    val composeBom = platform("androidx.compose:compose-bom:2023.01.00")
    implementation(composeBom)

    debugImplementation("androidx.compose.ui:ui-tooling")
    implementation("androidx.compose.ui:ui-tooling-preview")
}