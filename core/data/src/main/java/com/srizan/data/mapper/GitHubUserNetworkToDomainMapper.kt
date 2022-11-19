package com.srizan.data.mapper

import com.srizan.domain.model.GitHubUserDomainModel
import com.srizan.network.model.GitHubUserNetworkModel
import javax.inject.Inject

class GitHubUserNetworkToDomainMapper @Inject constructor() :
    Mapper<GitHubUserNetworkModel, GitHubUserDomainModel> {
    override fun mapFromApiResponse(type: GitHubUserNetworkModel) = GitHubUserDomainModel(
        login = type.login ?: "",
        avatarUrl = type.avatar_url ?: "",
        name = type.name ?: "",
        company = type.company ?: "",
        blog = type.blog ?: "",
        location = type.location ?: "",
        email = type.email ?: "",
        bio = type.bio ?: "",
        twitterUsername = type.twitter_username ?: "",
        publicRepos = type.public_repos ?: 0,
        followers = type.followers ?: 0,
        following = type.following ?: 0
    )
}