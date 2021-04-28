package com.study.androidstudy_hoon.data.repository

import com.study.androidstudy_hoon.data.dto.Repo
import com.study.androidstudy_hoon.domain.base.RepoDatabase
import dagger.Binds
import dagger.BindsInstance
import dagger.Provides
import dagger.internal.InjectedFieldSignature
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject

class RoomRepository @Inject constructor(
    private val roomInstance: RepoDatabase
) {

    fun insertSearchRepo(repo: Repo): Completable {
        return roomInstance.repoDao().insert(repo)
    }

    fun getAllSearchRepo(): Observable<List<Repo>> {
        return roomInstance.repoDao().getAll()
    }
}