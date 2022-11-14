package com.srizan.network.model

data class RepoNetworkModel(
    val id: Long,
    val name: String,
    val stargazers_count: Int,
    val watchers_count: Int,
    val language: String
)
