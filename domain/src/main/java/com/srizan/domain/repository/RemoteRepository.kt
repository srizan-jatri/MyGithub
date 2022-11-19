package com.srizan.domain.repository

import com.srizan.domain.model.ApiResult
import com.srizan.domain.model.GitHubUserDomainModel
import com.srizan.domain.model.RepoDomainModel
import kotlinx.coroutines.flow.Flow

interface RemoteRepository {
    suspend fun getRepoList(): Flow<ApiResult<List<RepoDomainModel>>>
    suspend fun getUserDetails(userName: String): Flow<ApiResult<GitHubUserDomainModel>>
}