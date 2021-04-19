# NYTimes-App Clones

Below the Dependeny of our project We Used In Our App

    implementation 'androidx.swiperefreshlayout:swiperefreshlayout:1.0.0'
    implementation 'androidx.legacy:legacy-support-v4:1.0.0'
    implementation 'androidx.lifecycle:lifecycle-extensions:2.2.0'
    //firebase
    implementation 'androidx.wear:wear:1.0.0'
    implementation 'com.google.firebase:firebase-auth:19.2.0'
    compileOnly 'com.google.android.wearable:wearable:2.6.0'
    def jetpack_version = "2.1.0"
    def anko_version = '0.10.0'
    def lifecycle_version = "2.3.1"
    def arch_version = "2.1.0"
    def retrofit_version = "2.9.0"
    def coroutines = "1.1.1"
    def kotlinCoroutineVersion = "1.4.1"
    implementation fileTree(dir: 'libs', include: ['*.jar'])
    implementation "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version"
    implementation 'androidx.appcompat:appcompat:1.2.0'
    implementation 'androidx.core:core-ktx:1.3.2'
    implementation 'androidx.constraintlayout:constraintlayout:2.0.4'
    testImplementation 'junit:junit:4.13.2'
    androidTestImplementation 'androidx.test.ext:junit:1.1.2'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.3.0'
    implementation 'com.google.android.material:material:1.4.0-alpha02'
    // ViewModel
    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version"
    // LiveData
    implementation "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version"
    // Lifecycles only (without ViewModel or LiveData)
    implementation "androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle_version"
    // Saved state module for ViewModel
    implementation "androidx.lifecycle:lifecycle-viewmodel-savedstate:$lifecycle_version"
    // Jetpack Compose Integration for ViewModel
    implementation "androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha04"
    // Annotation processor
    kapt "androidx.lifecycle:lifecycle-compiler:$lifecycle_version"
    // alternately - if using Java8, use the following instead of lifecycle-compiler
    implementation "androidx.lifecycle:lifecycle-common-java8:$lifecycle_version"
    // optional - helpers for implementing LifecycleOwner in a Service
    implementation "androidx.lifecycle:lifecycle-service:$lifecycle_version"
    // optional - ProcessLifecycleOwner provides a lifecycle for the whole application process
    implementation "androidx.lifecycle:lifecycle-process:$lifecycle_version"
    // optional - ReactiveStreams support for LiveData
    implementation "androidx.lifecycle:lifecycle-reactivestreams-ktx:$lifecycle_version"
    // optional - Test helpers for LiveData
    testImplementation "androidx.arch.core:core-testing:$arch_version"
    // Jetpack Compose Integration for ViewModel
    implementation "androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha04"
    // Annotation processor
    kapt "androidx.lifecycle:lifecycle-compiler:$lifecycle_version"
    // alternately - if using Java8, use the following instead of lifecycle-compiler
    implementation "androidx.lifecycle:lifecycle-common-java8:$lifecycle_version"
    // optional - helpers for implementing LifecycleOwner in a Service
    implementation "androidx.lifecycle:lifecycle-service:$lifecycle_version"
    // optional - ProcessLifecycleOwner provides a lifecycle for the whole application process
    implementation "androidx.lifecycle:lifecycle-process:$lifecycle_version"
    // optional - ReactiveStreams support for LiveData
    implementation "androidx.lifecycle:lifecycle-reactivestreams-ktx:$lifecycle_version"
    // optional - Test helpers for LiveData
    testImplementation "androidx.arch.core:core-testing:$arch_version"
    //Coroutines
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutines"
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinCoroutineVersion"
    def room_version = "2.3.0-rc01"
    implementation "androidx.room:room-runtime:$room_version"
    kapt "androidx.room:room-compiler:$room_version"
    // optional - Kotlin Extensions and Coroutines support for Room
    implementation "androidx.room:room-ktx:$room_version"
    // optional - Test helpers
    testImplementation "androidx.room:room-testing:$room_version"
    kapt "com.android.databinding:compiler:$jetpack_version"
    //Anko
    implementation "org.jetbrains.anko:anko-commons:$anko_version"
    // Retrofit & OkHttp
    implementation "com.squareup.retrofit2:retrofit:$retrofit_version"
    implementation "com.squareup.retrofit2:converter-gson:$retrofit_version"
    implementation "com.squareup.okhttp3:logging-interceptor:4.9.0"
    testImplementation "com.android.support.test.espresso:espresso-core:3.0.2"
    testImplementation "androidx.test.ext:junit-ktx:1.1.3-alpha05"
    androidTestImplementation "androidx.test.ext:junit-ktx:1.1.3-alpha05"
    androidTestImplementation "org.mockito:mockito-core:2.27.0"
    testImplementation "org.mockito:mockito-core:2.27.0"
    testImplementation "android.arch.core:core-testing:2.1.0"
    testImplementation "com.squareup.okhttp3:mockwebserver:3.6.0"
    implementation 'androidx.recyclerview:recyclerview:1.2.0'
    implementation 'androidx.cardview:cardview:1.0.0'
    implementation 'com.github.bumptech.glide:glide:4.12.0'
    annotationProcessor 'com.github.bumptech.glide:compiler:4.12.0'
    androidTestImplementation 'com.android.support.test:runner:1.0.2'
    androidTestCompile "android.arch.core:core-testing:1.1.1"
    testImplementation 'org.robolectric:robolectric:4.5.1'
    //glide dependencys
    // Retrofit & OkHttp
    implementation 'com.squareup.retrofit2:retrofit:2.6.0'
    // This library is used by retrofit internally to convert json-pojo and pojo-json
    implementation 'com.squareup.retrofit2:converter-gson:2.5.0'
    //This library is used to observe the API logs, Http status code and the API response
    implementation 'com.squareup.okhttp3:logging-interceptor:3.12.3'
    // Navigation Components
    implementation "androidx.navigation:navigation-fragment-ktx:2.3.5"
    implementation "androidx.navigation:navigation-ui-ktx:2.3.5"
    implementation 'com.github.bumptech.glide:glide:4.12.0'
    annotationProcessor 'com.github.bumptech.glide:compiler:4.12.0'
    //dagger hilt
    implementation "com.google.dagger:hilt-android:$hilt_version"
    kapt "com.google.dagger:hilt-compiler:$hilt_version"
    // jsoup HTML parser library @ https://jsoup.org/
    implementation 'org.jsoup:jsoup:1.13.1'
    implementation 'com.github.jumadeveloper:networkmanager:0.0.2'
    implementation 'com.github.delight-im:Android-AdvancedWebView:v3.2.1'
    def paging_version = '3.0.0-beta03'
    implementation "androidx.paging:paging-runtime:$paging_version"
    // alternatively - without Android dependencies for tests
    testImplementation "androidx.paging:paging-common:$paging_version"
    // optional - RxJava2 support
    implementation "androidx.paging:paging-rxjava2:$paging_version"
    // optional - RxJava3 support
    implementation "androidx.paging:paging-rxjava3:$paging_version"
    // optional - Guava ListenableFuture support
    implementation "androidx.paging:paging-guava:$paging_version"
    // Jetpack Compose Integration
    implementation "androidx.paging:paging-compose:1.0.0-alpha08"
    def work_version = "2.5.0"
    // (Java only)
    implementation "androidx.work:work-runtime:$work_version"
    // Kotlin + coroutines
    implementation "androidx.work:work-runtime-ktx:$work_version"
    // optional - RxJava2 support
    implementation "androidx.work:work-rxjava2:$work_version"
    // optional - GCMNetworkManager support
    implementation "androidx.work:work-gcm:$work_version"
    // optional - Test helpers
    androidTestImplementation "androidx.work:work-testing:$work_version"
    // optional - Multiprocess support
    implementation "androidx.work:work-multiprocess:$work_version"
