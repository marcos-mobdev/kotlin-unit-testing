package br.com.appforge.kotlinunittesting.view.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.appforge.kotlinunittesting.data.remote.dto.User
import br.com.appforge.kotlinunittesting.domain.UserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(
    private val userUseCase: UserUseCase
) :ViewModel(){

    private val _listUsers = MutableLiveData<List<User>>()

    val listUsers : LiveData<List<User>>
        get() = _listUsers

    fun getListUsers(){
        viewModelScope.launch(Dispatchers.IO) {
            val listUsers = userUseCase()
            _listUsers.postValue(listUsers)
        }

    }
}