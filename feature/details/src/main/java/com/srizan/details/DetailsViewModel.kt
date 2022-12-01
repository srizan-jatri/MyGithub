package com.srizan.details

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.srizan.domain.model.ApiResult
import com.srizan.domain.model.GitHubUserDomainModel
import com.srizan.domain.model.RepoDomainModel
import com.srizan.domain.usecase.GetUserDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val getUserDetailsUseCase: GetUserDetailsUseCase
) : ViewModel() {
    var uiState by mutableStateOf<UserDetailsUIState>(UserDetailsUIState.IdleState)
    val action: (UiAction) -> Unit = {
        when (it) {
            is UiAction.GetUserDetails -> {
                getUserDetails(it.userName)
            }
        }
    }

    private fun getUserDetails(userName: String) {
        viewModelScope.launch {
            getUserDetailsUseCase.invoke(GetUserDetailsUseCase.Params(userName)).collect {
                uiState = when (it) {
                    is ApiResult.Error -> UserDetailsUIState.ErrorState(it.message)
                    is ApiResult.Loading -> UserDetailsUIState.LoadingState
                    is ApiResult.Success -> UserDetailsUIState.SuccessState(it.data)
                }
            }
        }
    }
}

sealed interface UserDetailsUIState {
    data class SuccessState(val user: GitHubUserDomainModel) : UserDetailsUIState
    data class ErrorState(val message: String) : UserDetailsUIState
    object LoadingState : UserDetailsUIState
    object IdleState : UserDetailsUIState
}

sealed interface UiAction {
    data class GetUserDetails(val userName: String) : UiAction
}