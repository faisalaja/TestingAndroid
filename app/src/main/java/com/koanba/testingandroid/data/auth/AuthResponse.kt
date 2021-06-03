package com.koanba.testingandroid.data.auth


import com.google.gson.annotations.SerializedName

data class AuthResponse(
    @SerializedName("error")
    val error: String = "",
    @SerializedName("token")
    val token: String = ""
)