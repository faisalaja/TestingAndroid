package com.koanba.testingandroid.api

import android.util.Log
import com.koanba.testingandroid.data.auth.AuthResponse
import com.koanba.testingandroid.data.list.ListResponse
import com.koanba.testingandroid.utlis.Constants
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 *Create by Muhammad Al Faisal
 *on 03/06/21
 */
class ApiRequest {
    private fun request(): Retrofit {

        return Retrofit.Builder()
            .baseUrl(Constants.base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun authService(email: String, password: String): Call<AuthResponse> {
        Log.d("TAG", "authService: $email $password")
        return request().create(AutService::class.java)
            .login(email, password)
    }

    fun listUsers(page: Int): Call<ListResponse> {
        return request().create(UsersService::class.java)
            .getList(page)
    }
}