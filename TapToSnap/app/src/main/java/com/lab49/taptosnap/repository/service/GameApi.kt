package com.lab49.taptosnap.repository.service

import com.lab49.taptosnap.model.GameModelItem
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface GameApi {
    @GET("/v1/item/list")
    suspend fun getInitialList(): Response<List<GameModelItem>>

    companion object {
        var retrofitService: GameApi? = null
        fun getInstance() : GameApi {
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://taptosnap.nonprod.kube.lab49cloud.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(GameApi::class.java)
            }
            return retrofitService!!
        }

    }
}