package br.com.appforge.kotlinunittesting.data.remote.repository

import br.com.appforge.kotlinunittesting.data.remote.api.DummyAPIService
import br.com.appforge.kotlinunittesting.data.remote.dto.DummyAPIResponse
import br.com.appforge.kotlinunittesting.data.remote.dto.User
import retrofit2.Response

class DummyApiServiceFake :DummyAPIService{
    override suspend fun getUsers(): Response<DummyAPIResponse> {
        return Response.success(
            DummyAPIResponse(
                20,
                10,
                100,
                listOf(
                    User("Marcos", 25, "m","marcos@gmail.com"),
                    User("Maria", 53, "f","maria@gmail.com"),
                    User("Ana", 12, "f","ana@gmail.com"),
                )
            )
        )
    }
}