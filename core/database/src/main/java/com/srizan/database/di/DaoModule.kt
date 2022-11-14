package com.srizan.database.di

import com.srizan.database.AppDatabase
import com.srizan.database.dao.RepoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {
    @Provides
    fun provideRepoDao(database: AppDatabase): RepoDao = database.repoDao()
}
