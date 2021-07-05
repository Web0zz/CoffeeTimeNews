package com.web0z.coffeetimenews.di

import com.web0z.core.repository.CoffeeTimeNewsRepository
import com.web0z.repository.CoffeeTimeNewsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    @Repository
    fun coffeeTimeNewsRepository(coffeeTimeNewsRepositoryImpl: CoffeeTimeNewsRepositoryImpl): CoffeeTimeNewsRepository
}

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Repository