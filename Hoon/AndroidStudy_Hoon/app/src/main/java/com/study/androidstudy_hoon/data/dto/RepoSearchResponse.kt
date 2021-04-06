package com.study.androidstudy_hoon.data.dto

import com.google.gson.annotations.SerializedName

data class RepoSearchResponse (
    @SerializedName("total_count") val total: Int =0,
    @SerializedName("items") val items: List<Repo> = emptyList()
)