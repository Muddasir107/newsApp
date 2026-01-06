package com.muddasir.newsapp.data.network.remoteapis

import com.muddasir.newsapp.data.models.GithubApiReposModel
import javax.inject.Inject

class DataRepositories @Inject constructor(val remoteApiService: RemoteApiService) {

   suspend fun getPublicGithubRepos(): GithubApiReposModel {
       return remoteApiService.getGithubRepos()
    }
}