package com.srizan.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey


const val REPO_TABLE = "repo"

@Entity(
    tableName = REPO_TABLE
)
data class RepoEntity(
    @PrimaryKey
    val a: String
)
