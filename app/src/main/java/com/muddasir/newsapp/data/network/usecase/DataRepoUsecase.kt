package com.muddasir.newsapp.data.network.usecase

import com.muddasir.newsapp.data.models.GithubApiReposModel
import com.muddasir.newsapp.data.network.remoteapis.DataRepositories
import com.muddasir.newsapp.data.sealedmodels.UIState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DataRepoUsecase @Inject constructor(val dataRepositories: DataRepositories) {
    suspend fun getGithubRepos(): Flow<UIState<GithubApiReposModel>> = flow {

        emit(UIState.Loading())
        var result: UIState<GithubApiReposModel>? = null
        val dataFromGit = dataRepositories.getPublicGithubRepos()

        if (!dataFromGit.isNullOrEmpty()) {
            result = UIState.Success(dataFromGit)
            emit(result)
        } else {
            result = UIState.Failed("Api Failed")
            emit(result)
        }

    }
}