package com.srizan.domain.usecase

import com.srizan.domain.model.ApiResult
import com.srizan.domain.model.RepoDomainModel
import com.srizan.domain.repository.RemoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRepoListUseCase @Inject constructor(
    private val remoteRepository: RemoteRepository
) {
    suspend operator fun invoke(): Flow<ApiResult<List<RepoDomainModel>>> {
        return remoteRepository.getRepoList()
    }
}