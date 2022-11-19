package com.srizan.domain.usecase

import com.srizan.domain.model.ApiResult
import com.srizan.domain.model.GitHubUserDomainModel
import com.srizan.domain.repository.RemoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUserDetailsUseCase @Inject constructor(
    private val remoteRepository: RemoteRepository
) {
    data class Params(val userName: String)
    suspend operator fun invoke(params: Params): Flow<ApiResult<GitHubUserDomainModel>> {
        return remoteRepository.getUserDetails(params.userName)
    }
}