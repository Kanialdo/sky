package pl.krystiankaniowski.sky.moon.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import pl.krystiankaniowski.sky.moon.infrastructure.skyHttpClient

@Module
@InstallIn(SingletonComponent::class)
object MoonModule {

    @Provides
    fun httpClient(): HttpClient = skyHttpClient
}