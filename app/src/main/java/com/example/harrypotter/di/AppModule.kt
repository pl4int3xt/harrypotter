package com.example.harrypotter.di

import com.example.harrypotter.constants.Constants
import com.example.harrypotter.data.remote.api.HarryPotterApi
import com.example.harrypotter.data.remote.repository.HarryPotterRepositoryImpl
import com.example.harrypotter.domain.repository.HarryPotterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideHarryPotterApi(): HarryPotterApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(HarryPotterApi::class.java)
    }

    @Provides
    @Singleton
    fun provideHarryPotterRepository(harryPotterApi: HarryPotterApi): HarryPotterRepository{
        return HarryPotterRepositoryImpl(harryPotterApi)
    }
}