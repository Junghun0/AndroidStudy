package com.study.androidstudy_hoon.domain.usecase

import com.study.androidstudy_hoon.data.dto.Repo
import com.study.androidstudy_hoon.data.repository.GithubSearchRepoImpl
import com.study.androidstudy_hoon.data.repository.GithubSearchRepository
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SearchRepoUseCase @Inject constructor(private val githubSearchRepository: GithubSearchRepoImpl) {
    fun getSearchResult(query: String): Single<List<Repo>> =
        githubSearchRepository.getGithubSearchRepository(query)
            .subscribeOn(Schedulers.io())
            .map {
                it.items
            }
}