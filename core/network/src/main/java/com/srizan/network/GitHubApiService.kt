package com.srizan.network

import com.srizan.network.model.GitHubUserNetworkModel
import com.srizan.network.model.RepoNetworkModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubApiService {
    @GET("/users/{username}/repos")
    suspend fun getRepoList(
        @Path("username") userName: String
    ): Response<List<RepoNetworkModel>>

    @GET("/users/{username}")
    suspend fun getUserDetails(@Path("username") userName: String)  : Response<GitHubUserNetworkModel>
}