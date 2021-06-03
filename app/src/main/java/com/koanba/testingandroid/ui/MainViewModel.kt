package com.koanba.testingandroid.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.koanba.testingandroid.api.ApiRequest
import com.koanba.testingandroid.data.auth.AuthResponse
import com.koanba.testingandroid.data.list.ListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 *Create by Muhammad Al Faisal
 *on 03/06/21
 */
class MainViewModel : ViewModel() {
    private val _auth = MutableLiveData<AuthResponse>()
    private val _usersList = MutableLiveData<ListResponse>()
    private val _msgResponse = MutableLiveData<String>()

    private val apiRequest = ApiRequest()

    val authResponse: MutableLiveData<AuthResponse>
        get() = _auth

    val getListUser: MutableLiveData<ListResponse>
        get() = _usersList

    val msgError: MutableLiveData<String>
        get() = _msgResponse

    fun auth(strEmail: String, strPassword: String) {
        apiRequest.authService(
            email = strEmail,
            password = strPassword
        ).enqueue(object : Callback<AuthResponse> {
            override fun onResponse(call: Call<AuthResponse>, response: Response<AuthResponse>) {
                if (response.isSuccessful){
                    _auth.value = response.body()
                } else _msgResponse.value = response.errorBody().toString()
            }

            override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
                _msgResponse.value = t.message

            }
        })
    }


    fun getList(pageNumber: Int) {
        apiRequest.listUsers(page = pageNumber).enqueue(object : Callback<ListResponse>{
            override fun onResponse(call: Call<ListResponse>, response: Response<ListResponse>) {
                if (response.isSuccessful){
                    _usersList.value = response.body()
                } else _msgResponse.value = response.errorBody().toString()
            }

            override fun onFailure(call: Call<ListResponse>, t: Throwable) {
                _msgResponse.value = t.message
            }
        })
    }


}