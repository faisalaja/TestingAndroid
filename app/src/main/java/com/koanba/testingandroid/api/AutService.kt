package com.koanba.testingandroid.api

import com.koanba.testingandroid.data.auth.AuthResponse
import com.koanba.testingandroid.utlis.Constants
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 *Create by Muhammad Al Faisal
 *on 03/06/21
 */
interface AutService {

    @FormUrlEncoded
    @POST(Constants.auth_url)
    fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<AuthResponse>
}