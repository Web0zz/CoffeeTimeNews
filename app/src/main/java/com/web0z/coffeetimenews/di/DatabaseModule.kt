package com.web0z.coffeetimenews.di

import android.app.Application
import com.web0z.data.local.CoffeeTimeNewsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Singleton
    @Provides
    fun provideCoffeeTimeNewsDatabase(application: Application) =
        CoffeeTimeNewsDatabase.getInstance(application)

    @Singleton
    @Provides
    fun provideArticlesDao(database: CoffeeTimeNewsDatabase) = database.getArticlesDao()
}