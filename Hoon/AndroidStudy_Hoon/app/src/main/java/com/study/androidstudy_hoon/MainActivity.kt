package com.study.androidstudy_hoon

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.study.androidstudy_hoon.databinding.ActivityMainBinding
import com.study.androidstudy_hoon.domain.base.BaseActivity
import com.study.androidstudy_hoon.presenter.main.MainViewModel
import com.study.androidstudy_hoon.presenter.main.RoomAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>({ ActivityMainBinding.inflate(it) }) {

    private val viewModel: MainViewModel by viewModels()
    private val roomAdapter by lazy { RoomAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.flBtnMain.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }

        initAdapter()
        initObserve()
    }

    private fun initAdapter() {
        binding.searchHistoryRecyclerviewMain.adapter = roomAdapter
    }

    private fun initObserve() {
        viewModel.searchRepoList.observe(this, {
            if (it.isEmpty()) {
                binding.searchHistoryRecyclerviewMain.visibility = View.GONE
                binding.emptyDataTextViewMain.visibility = View.VISIBLE
            } else {
                binding.searchHistoryRecyclerviewMain.visibility = View.VISIBLE
                binding.emptyDataTextViewMain.visibility = View.GONE
                roomAdapter.submitList(it)
            }
        })
    }

    override fun onResume() {
        super.onResume()
        viewModel.fetchRoomRepoList()
    }

}