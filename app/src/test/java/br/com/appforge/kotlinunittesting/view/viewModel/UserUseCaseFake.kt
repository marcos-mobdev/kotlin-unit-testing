package br.com.appforge.kotlinunittesting.view.viewModel

import br.com.appforge.kotlinunittesting.data.remote.dto.User
import br.com.appforge.kotlinunittesting.data.remote.repository.IUserRepository
import br.com.appforge.kotlinunittesting.domain.UserRepositoryFake
import br.com.appforge.kotlinunittesting.domain.UserUseCase


class UserUseCaseFake(iUserRepository: IUserRepository) : UserUseCase(iUserRepository) {
    override suspend operator fun invoke():List<User>{ //getListUserUseCase
        return listOf(
            User("Marcos", 44, "m","marcos@gmail.com"),
            User("Maria", 53, "f","maria@gmail.com"),
            User("Ana", 12, "f","ana@gmail.com"),
        )
    }
}