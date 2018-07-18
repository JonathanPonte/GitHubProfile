package com.example.jonat.githubprofile.github.network

import android.util.Log
import com.example.jonat.githubprofile.github.model.Repository
import com.example.jonat.githubprofile.github.model.Usuario
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Network {



    private fun configuraRetrofit(): Retrofit {

        return Retrofit.Builder().baseUrl("https://api.github.com/").addConverterFactory(GsonConverterFactory.create()).build()
    }

    private val gitHubAPI by lazy{
        configuraRetrofit().create(GitHubAPI::class.java)
    }


    fun checarRequisicao(usuario: String){

        gitHubAPI.getRepositorios(usuario).enqueue(object : Callback<List<Repository>>{

            override fun onResponse(call: Call<List<Repository>>?, response: Response<List<Repository>>?) {

                response?.let {

                    if (it.isSuccessful){

                        response.body()?.let {

                            it.forEach{ repository ->
                                Log.d("tag", "Respositório ${repository.name} foi escrito em ${repository.language}")
                            }


                        }

                    }else

                        Log.d("Tag", "Errozinho")

                    }


                }


            override fun onFailure(call: Call<List<Repository>>?, t: Throwable?) {
                Log.d("Tag", "Errozão")
            }






        })



    }






}