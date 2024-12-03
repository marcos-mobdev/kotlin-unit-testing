package br.com.appforge.kotlinunittesting.domain

import br.com.appforge.kotlinunittesting.data.remote.dto.User
import br.com.appforge.kotlinunittesting.data.remote.repository.IUserRepository

class UserRepositoryFake:IUserRepository {
    override suspend fun listUsers(): List<User> {
        return listOf(
            User("Marcos", 25, "m","marcos@gmail.com"),
            User("Maria", 53, "f","maria@gmail.com"),
            User("Ana", 12, "f","ana@gmail.com"),
        )
    }
}