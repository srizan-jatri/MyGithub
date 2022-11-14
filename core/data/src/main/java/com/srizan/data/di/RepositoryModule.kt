package com.srizan.data.di

import com.srizan.data.repository.RemoteRepositoryImpl
import com.srizan.domain.repository.RemoteRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    fun bindRemoteRepository(remoteRepository: RemoteRepositoryImpl): RemoteRepository
}