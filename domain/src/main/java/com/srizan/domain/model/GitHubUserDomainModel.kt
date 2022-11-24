package com.srizan.domain.model

data class GitHubUserDomainModel(
    val login: String,
    val avatarUrl: String,
    val name: String,
    val blog: String,
    val location: String,
    val email: String,
    val bio: String,
    val twitterUsername: String,
    val publicRepos: Int,
    val followers: Int,
    val following: Int
)