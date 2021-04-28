package com.study.androidstudy_hoon.presenter.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.study.androidstudy_hoon.data.dto.Repo
import com.study.androidstudy_hoon.domain.base.BaseViewModel
import com.study.androidstudy_hoon.domain.usecase.RoomRepoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val roomRepoUseCase: RoomRepoUseCase) : BaseViewModel() {

    private val _searchRepoList = MutableLiveData<List<Repo>>()
    val searchRepoList: LiveData<List<Repo>>
        get() = _searchRepoList

    fun fetchRoomRepoList() {
        addDisposable(
            roomRepoUseCase.getAllSearchRepo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    _searchRepoList.value = it
                }, {
                    Log.e("Error", "$it")
                })
        )
    }
}