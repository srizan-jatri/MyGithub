package com.srizan.database.dao

import androidx.room.*
import com.srizan.database.model.REPO_TABLE
import com.srizan.database.model.RepoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RepoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrIgnorePosts(postEntities: List<RepoEntity>): List<Long>

    @Update
    suspend fun updatePost(entities: List<RepoEntity>)

    @Query("SELECT * FROM $REPO_TABLE")
    fun getAllPosts(): Flow<List<RepoEntity>>
}