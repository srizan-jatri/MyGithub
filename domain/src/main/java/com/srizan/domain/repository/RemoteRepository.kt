package com.srizan.domain.repository

import com.srizan.domain.model.RepoDomainModel

interface RemoteRepository {
    suspend fun getRepoList(): List<RepoDomainModel>
}