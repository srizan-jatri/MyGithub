package com.srizan.domain.model


data class RepoDomainModel(
    val id: Long,
    val name: String,
    val fullName: String,
    val owner: OwnerDomainModel,
    val description: String,
    val stargazersCount: Int,
    val watchersCount: Int,
    val language: String
)
data class OwnerDomainModel(
    val login: String,
    val avatarUrl: String,
)