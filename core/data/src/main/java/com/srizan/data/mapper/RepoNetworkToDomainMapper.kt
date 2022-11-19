package com.srizan.data.mapper

import com.srizan.domain.model.OwnerDomainModel
import com.srizan.domain.model.RepoDomainModel
import com.srizan.network.model.RepoNetworkModel
import javax.inject.Inject

class RepoNetworkToDomainMapper @Inject constructor() :
    Mapper<List<RepoNetworkModel>, List<RepoDomainModel>> {
    override fun mapFromApiResponse(type: List<RepoNetworkModel>) = type.map { repoNetworkModel ->
        RepoDomainModel(
            id = repoNetworkModel.id ?: 0,
            name = repoNetworkModel.name ?: "",
            fullName = repoNetworkModel.full_name ?: "",
            owner = OwnerDomainModel(
                login = repoNetworkModel.owner?.login ?: "",
                avatarUrl = repoNetworkModel.owner?.avatar_url ?: ""
            ),
            description = repoNetworkModel.description ?: "No Description",
            stargazersCount = repoNetworkModel.stargazers_count ?: 0,
            watchersCount = repoNetworkModel.watchers_count ?: 0,
            language = repoNetworkModel.language ?: "Unknown Language"
        )
    }
}