package com.study.androidstudy_hoon.di

import com.study.androidstudy_hoon.data.repository.GithubSearchRepoImpl
import com.study.androidstudy_hoon.data.repository.RoomRepository
import com.study.androidstudy_hoon.domain.usecase.RoomRepoUseCase
import com.study.androidstudy_hoon.domain.usecase.SearchRepoUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object UseCaseModule {
    @Provides
    fun provideRoomRepoUseCase(repository: RoomRepository): RoomRepoUseCase =
        RoomRepoUseCase(repository)

    @Provides
    fun provideSearchUseCase(repository: GithubSearchRepoImpl): SearchRepoUseCase =
        SearchRepoUseCase(repository)
}