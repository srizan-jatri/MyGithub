package com.srizan.network.model

data class RepoNetworkModel(
    val id: Long,
    val name: String,
    val full_name: String,
    val owner: Owner,
    val description: String,
    val stargazers_count: Int,
    val watchers_count: Int,
    val language: String
)

data class Owner(
    val login: String,
    val avatar_url: String,
)
