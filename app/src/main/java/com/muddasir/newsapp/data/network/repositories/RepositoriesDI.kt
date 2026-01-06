package com.muddasir.newsapp.data.network.repositories

import com.muddasir.newsapp.data.network.remoteapis.DataRepositories
import com.muddasir.newsapp.data.network.remoteapis.RemoteApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn

import dagger.hilt.android.components.ActivityRetainedComponent
@Module
@InstallIn(ActivityRetainedComponent::class)
object RepositoriesDI {

    @Provides
    fun provideDataRepository(remoteApiService: RemoteApiService): DataRepositories =
        DataRepositories(remoteApiService)

}