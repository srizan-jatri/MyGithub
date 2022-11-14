package com.srizan.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.srizan.database.dao.RepoDao
import com.srizan.database.model.RepoEntity

@Database(
    entities =
    [
        RepoEntity::class,
    ],
    version = 1, exportSchema = false
)

abstract class AppDatabase : RoomDatabase() {
    abstract fun repoDao(): RepoDao
}