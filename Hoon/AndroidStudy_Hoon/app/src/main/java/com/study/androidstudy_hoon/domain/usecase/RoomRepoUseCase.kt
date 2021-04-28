package com.study.androidstudy_hoon.domain.usecase

import com.study.androidstudy_hoon.data.dto.Repo
import com.study.androidstudy_hoon.data.repository.RoomRepository
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject

class RoomRepoUseCase @Inject constructor(private val roomRepository: RoomRepository) {

    fun insertSearchRepo(repo: Repo): Completable {
        return roomRepository.insertSearchRepo(repo)
    }

    fun getAllSearchRepo(): Observable<List<Repo>> {
        return roomRepository.getAllSearchRepo()
    }
}