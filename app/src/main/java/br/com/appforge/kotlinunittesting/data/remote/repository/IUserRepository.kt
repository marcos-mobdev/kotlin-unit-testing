package br.com.appforge.kotlinunittesting.data.remote.repository

import br.com.appforge.kotlinunittesting.data.remote.dto.User

interface IUserRepository {

    suspend fun listUsers():List<User>
}