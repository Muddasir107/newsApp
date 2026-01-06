package com.muddasir.newsapp.modules.news.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muddasir.newsapp.data.models.GithubApiReposModel
import com.muddasir.newsapp.data.network.usecase.DataRepoUsecase
import com.muddasir.newsapp.data.sealedmodels.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(val dataRepoUsecase: DataRepoUsecase) : ViewModel() {


    private val _uiState = MutableStateFlow<UIState<GithubApiReposModel>>(UIState.Idle())
    val uiState: StateFlow<UIState<GithubApiReposModel>> = _uiState

    fun getGithubRepository() {
        viewModelScope.launch {

            val data = dataRepoUsecase.getGithubRepos()
            data.collect {it ->
            when (it) {
                is UIState.Loading -> {
                    _uiState.emit(UIState.Loading())
                }

                is UIState.Success<*> -> {
                    _uiState.emit(it as UIState<GithubApiReposModel>)
                }

                is UIState.Failed -> {
                    _uiState.emit(UIState.Failed())
                }

                else -> {}
            }

            print(data.toString())
        }
            }
    }


}