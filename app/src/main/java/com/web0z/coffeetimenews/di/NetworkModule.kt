package com.web0z.coffeetimenews.di

import com.web0z.core.utils.moshi
import com.web0z.data.remote.api.CoffeeTimeNewsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    // TODO add dummy api url
    private val baseRetrofitBuilder: Retrofit.Builder = Retrofit.Builder()
        .baseUrl("")
        .addConverterFactory(MoshiConverterFactory.create(moshi))

    @Provides
    fun provideCoffeeTimeNewsService(): CoffeeTimeNewsService {
        return baseRetrofitBuilder
            .client(OkHttpClient())
            .build()
            .create(CoffeeTimeNewsService::class.java)
    }
}