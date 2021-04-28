package com.study.androidstudy_hoon.domain.base

import androidx.room.Database
import androidx.room.RoomDatabase
import com.study.androidstudy_hoon.data.dao.RepoDao
import com.study.androidstudy_hoon.data.dto.Repo
import dagger.Binds
import dagger.Provides

@Database(entities = [Repo::class], version = 1, exportSchema = false)
abstract class RepoDatabase : RoomDatabase() {
    abstract fun repoDao(): RepoDao
}