package com.srizan.network.di

import com.srizan.network.GitHubApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object ApiServiceModule {
    @Provides
    fun provideJphNetworkApi(
        retrofit: Retrofit
    ): GitHubApiService {
        return retrofit.create(GitHubApiService::class.java)
    }
}