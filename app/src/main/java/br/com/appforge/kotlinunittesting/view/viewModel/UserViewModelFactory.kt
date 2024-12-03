package br.com.appforge.kotlinunittesting.view.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.appforge.kotlinunittesting.domain.UserUseCase

class UserViewModelFactory(
    private val userUseCase: UserUseCase
):ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserViewModel(userUseCase) as T
    }
}