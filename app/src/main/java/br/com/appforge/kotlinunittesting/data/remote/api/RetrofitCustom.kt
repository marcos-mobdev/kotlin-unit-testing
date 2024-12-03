package br.com.appforge.kotlinunittesting.data.remote.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitCustom {
    fun getRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getDummyAPI():DummyAPIService{
        return getRetrofit().create(DummyAPIService::class.java)
    }
}