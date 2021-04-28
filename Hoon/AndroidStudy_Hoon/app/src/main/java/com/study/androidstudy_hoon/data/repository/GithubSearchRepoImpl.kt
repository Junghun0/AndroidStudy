package com.study.androidstudy_hoon.data.repository

import com.study.androidstudy_hoon.data.dto.RepoSearchResponse
import com.study.androidstudy_hoon.data.service.GithubRepoService
import com.study.androidstudy_hoon.data.service.GithubServiceBuilder
import io.reactivex.Single
import javax.inject.Inject

class GithubSearchRepoImpl @Inject constructor(
    private val retrofitInstance: GithubRepoService
) : GithubSearchRepository {
    override fun getGithubSearchRepository(query: String): Single<RepoSearchResponse> {
        return retrofitInstance.searchRepository(query)
    }
}

