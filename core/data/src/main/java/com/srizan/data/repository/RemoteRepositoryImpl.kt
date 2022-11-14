package com.srizan.data.repository

import com.srizan.domain.model.RepoDomainModel
import com.srizan.domain.repository.RemoteRepository
import com.srizan.network.GitHubApiService
import javax.inject.Inject

class RemoteRepositoryImpl @Inject constructor(
    private val gitHubApiService: GitHubApiService
): RemoteRepository {
    override suspend fun getRepoList(): List<RepoDomainModel> {
        gitHubApiService.getRepoList("srizanx")
        return  listOf(RepoDomainModel(1,"name",5,5,""))
    }
}