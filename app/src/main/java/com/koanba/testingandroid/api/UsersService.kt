package com.koanba.testingandroid.api

import com.koanba.testingandroid.data.list.ListResponse
import com.koanba.testingandroid.utlis.Constants
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 *Create by Muhammad Al Faisal
 *on 03/06/21
 */
interface UsersService {
    @GET(Constants.users_url)
    fun getList(
        @Query("page") page: Int
    ): Call<ListResponse>
}