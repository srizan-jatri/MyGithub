package com.srizan.network.model

import kotlinx.serialization.Serializable

@Serializable
data class GitHubUserNetworkModel(
    val login: String?,
    val avatar_url: String?,
    val name: String?,
    val blog: String?,
    val location: String?,
    val email: String?,
    val bio: String?,
    val twitter_username: String?,
    val public_repos: Int?,
    val followers: Int?,
    val following: Int?
)