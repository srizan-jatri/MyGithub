package com.srizan.domain.model

data class RepoDomainModel(
    val id: Long,
    val name: String,
    val stargazers_count: Int,
    val watchers_count: Int,
    val language: String
)