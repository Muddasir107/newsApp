package com.muddasir.newsapp.data.viewmodeldi

import com.muddasir.newsapp.data.network.remoteapis.DataRepositories
import com.muddasir.newsapp.data.network.usecase.DataRepoUsecase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
object ViewModelDi {

    @Provides
    fun provideDataRespositoryUseCase(dataRepositories: DataRepositories): DataRepoUsecase =
        DataRepoUsecase(dataRepositories)


}