package com.koanba.testingandroid.data.list


import com.google.gson.annotations.SerializedName

data class ListResponse(
    @SerializedName("data")
    val `data`: List<Data> = listOf(),
    @SerializedName("page")
    val page: Int = 0,
    @SerializedName("per_page")
    val perPage: Int = 0,
    @SerializedName("support")
    val support: Support = Support(),
    @SerializedName("total")
    val total: Int = 0,
    @SerializedName("total_pages")
    val totalPages: Int = 0
)