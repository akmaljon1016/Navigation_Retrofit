package com.dars.navigationretrofit

import com.dars.navigationretrofit.model.UsersItem
import retrofit2.Call
import retrofit2.http.GET

interface NetworkApi {
    @GET("users")
    fun getUser(): Call<List<UsersItem>>

    @GET("posts")
    fun getPosts():Call<List<PostsItem>>
}