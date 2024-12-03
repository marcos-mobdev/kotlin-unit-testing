package br.com.appforge.kotlinunittesting.data.remote.api

import br.com.appforge.kotlinunittesting.data.remote.dto.DummyAPIResponse
import retrofit2.Response
import retrofit2.http.GET

interface DummyAPIService {

    @GET("users")
    suspend fun getUsers(): Response<DummyAPIResponse>

}