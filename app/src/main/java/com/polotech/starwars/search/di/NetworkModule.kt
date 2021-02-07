package com.polotech.starwars.search.di

import com.polotech.starwars.data.remote.api.StarWarsApiService
import com.polotech.starwars.search.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(ActivityComponent::class)
object NetworkModule {

    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor().apply {
            level = when (BuildConfig.BUILD_TYPE) {
                "release" -> HttpLoggingInterceptor.Level.NONE
                else -> HttpLoggingInterceptor.Level.BODY
            }
        }
        return OkHttpClient.Builder()
            .connectTimeout(60L, TimeUnit.SECONDS)
            .readTimeout(60L, TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .build()
    }

    @Provides
    fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

    }

    @Provides
    fun provideStarWarsApiService(retrofit: Retrofit): StarWarsApiService {
        return retrofit.create(StarWarsApiService::class.java)
    }

    private val BASE_URL = "https://swapi.dev/api/"
}