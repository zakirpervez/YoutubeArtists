package com.valuelabs.youtubeartists.di

import com.valuelabs.youtubeartists.models.TempModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideTempModel() = TempModel("Injection successful")
}
