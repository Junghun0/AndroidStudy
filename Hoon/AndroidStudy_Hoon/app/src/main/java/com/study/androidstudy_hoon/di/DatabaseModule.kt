package com.study.androidstudy_hoon.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.study.androidstudy_hoon.domain.base.RepoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    
    @Singleton
    @Provides
    fun provideRoomDatabase(@ApplicationContext context: Context): RoomDatabase =
        Room.databaseBuilder(
            context,
            RepoDatabase::class.java,
            "repo"
        ).build()
}