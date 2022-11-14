package com.srizan.domain.usecase

import com.srizan.domain.model.RepoDomainModel
import com.srizan.domain.repository.RemoteRepository
import javax.inject.Inject

class UseCase @Inject constructor(
    private val remoteRepository: RemoteRepository
) {
    suspend operator fun invoke(): List<RepoDomainModel> {
        return remoteRepository.getRepoList()
    }
}