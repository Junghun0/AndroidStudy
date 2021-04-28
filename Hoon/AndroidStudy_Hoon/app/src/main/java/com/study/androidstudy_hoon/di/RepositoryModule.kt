package com.study.androidstudy_hoon.di

import com.study.androidstudy_hoon.data.repository.GithubSearchRepoImpl
import com.study.androidstudy_hoon.data.repository.RoomRepository
import com.study.androidstudy_hoon.data.service.GithubRepoService
import com.study.androidstudy_hoon.domain.base.RepoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object RepositoryModule {
    @Provides
    fun provideRoomRepository(repoDatabase: RepoDatabase): RoomRepository =
        RoomRepository(repoDatabase)

    @Provides
    fun provideSearchRepository(service: GithubRepoService): GithubSearchRepoImpl =
        GithubSearchRepoImpl(service)
}