package br.com.appforge.kotlinunittesting.domain

import br.com.appforge.kotlinunittesting.data.remote.dto.User
import br.com.appforge.kotlinunittesting.data.remote.repository.IUserRepository

open class UserUseCase(
    private val iUserRepository: IUserRepository
) {
    open suspend operator fun invoke(): List<User> { //getListUserUseCase
        val listUser = iUserRepository.listUsers()
        return listUser.filter { it.age >= 40 }
    }
}