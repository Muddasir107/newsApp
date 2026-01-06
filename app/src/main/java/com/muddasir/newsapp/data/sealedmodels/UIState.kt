package com.muddasir.newsapp.data.sealedmodels

import com.muddasir.newsapp.data.models.GithubApiReposModel

sealed class UIState<out T>{
    data class Idle(val nothing: Nothing? = null): UIState<GithubApiReposModel>()
    data class Success<out T>(val data:T?= null):UIState<T>()
    data class Loading(val nothing: Nothing? = null): UIState<Nothing>()
    data class Failed(val message:String?= null): UIState<Nothing>()
    data class Exception(val message: String?=null): UIState<Nothing>()
}