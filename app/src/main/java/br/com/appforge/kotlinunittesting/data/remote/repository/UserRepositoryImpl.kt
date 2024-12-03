package br.com.appforge.kotlinunittesting.data.remote.repository

import br.com.appforge.kotlinunittesting.data.remote.api.DummyAPIService
import br.com.appforge.kotlinunittesting.data.remote.dto.User

class UserRepositoryImpl(private val dummyAPIService: DummyAPIService):IUserRepository {
    override suspend fun listUsers(): List<User> {
        val response = dummyAPIService.getUsers()
        if(response.isSuccessful && response.body() != null){
            val userList = response.body()?.users
            if(userList != null){
                return userList
            }
        }
        return emptyList()

    }
}