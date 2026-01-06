package com.muddasir.newsapp.data.network.remoteapis

import com.muddasir.newsapp.constants.NetworkConstants
import com.muddasir.newsapp.data.models.GithubApiReposModel
import retrofit2.http.GET

interface RemoteApiService {

    @GET(NetworkConstants.REPOS)
    suspend fun getGithubRepos(): GithubApiReposModel
}