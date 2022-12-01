package com.srizan.list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.srizan.domain.model.ApiResult
import com.srizan.domain.model.RepoDomainModel
import com.srizan.domain.usecase.GetRepoListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val getRepoListUseCase: GetRepoListUseCase
) : ViewModel() {
    var uiState by mutableStateOf<RepoListUIState>(RepoListUIState.IdleState)
    val action: (UiAction) -> Unit = {
        when (it) {
            UiAction.GetRepoList -> getRepoList()
        }
    }

    init {
        getRepoList()
    }

    private fun getRepoList() {
        viewModelScope.launch {
            getRepoListUseCase.invoke().collect {
                uiState = when (it) {
                    is ApiResult.Error -> RepoListUIState.ErrorState(message = it.message)
                    is ApiResult.Loading -> RepoListUIState.LoadingState
                    is ApiResult.Success -> RepoListUIState.SuccessState(it.data)
                }
            }
        }
    }
}

sealed interface RepoListUIState {
    data class SuccessState(val repoList: List<RepoDomainModel>) : RepoListUIState
    data class ErrorState(val message: String) : RepoListUIState
    object LoadingState : RepoListUIState
    object IdleState : RepoListUIState
}

sealed interface UiAction {
    object GetRepoList : UiAction
}