package com.hs.station.di

import com.hs.station.data.StationRepositoryImpl
import com.hs.station.domain.StationRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindStationRepository(
        impl: StationRepositoryImpl
    ): StationRepository
}