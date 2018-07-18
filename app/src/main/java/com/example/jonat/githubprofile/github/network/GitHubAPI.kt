package com.example.jonat.githubprofile.github.network

import com.example.jonat.githubprofile.github.model.Repository
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubAPI {

    @GET("users/{user}/repos")
    fun getRepositorios(@Path("user") user: String): Call<List<Repository>>


}