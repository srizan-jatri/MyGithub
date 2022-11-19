package com.srizan.data.repository

import com.srizan.data.mapper.GitHubUserNetworkToDomainMapper
import com.srizan.data.mapper.RepoNetworkToDomainMapper
import com.srizan.data.mapper.mapFromApiResponse
import com.srizan.data.wrapper.NetworkBoundResource
import com.srizan.domain.repository.RemoteRepository
import com.srizan.network.GitHubApiService
import javax.inject.Inject

class RemoteRepositoryImpl @Inject constructor(
    private val gitHubApiService: GitHubApiService,
    private val networkBoundResource: NetworkBoundResource,
    private val repoNetworkToDomainMapper: RepoNetworkToDomainMapper,
    private val gitHubUserNetworkToDomainMapper: GitHubUserNetworkToDomainMapper
) : RemoteRepository {
    override suspend fun getRepoList() = mapFromApiResponse(
        apiResult = networkBoundResource.downloadData {
            gitHubApiService.getRepoList("srizanx")
        }, mapper = repoNetworkToDomainMapper
    )

    override suspend fun getUserDetails(userName: String) = mapFromApiResponse(
        apiResult = networkBoundResource.downloadData {
            gitHubApiService.getUserDetails(userName)
        }, mapper = gitHubUserNetworkToDomainMapper
    )
}