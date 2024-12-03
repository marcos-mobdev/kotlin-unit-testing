package br.com.appforge.kotlinunittesting.view.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.appforge.kotlinunittesting.R
import br.com.appforge.kotlinunittesting.data.remote.api.RetrofitCustom
import br.com.appforge.kotlinunittesting.data.remote.repository.UserRepositoryImpl
import br.com.appforge.kotlinunittesting.databinding.ActivityMainBinding
import br.com.appforge.kotlinunittesting.domain.UserUseCase
import br.com.appforge.kotlinunittesting.view.viewModel.UserViewModel
import br.com.appforge.kotlinunittesting.view.viewModel.UserViewModelFactory

class MainActivity : AppCompatActivity() {

    private val binding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var userViewModel: UserViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initialize()
    }

    override fun onStart() {
        super.onStart()
        userViewModel.getListUsers()
    }

    private fun initialize() {
        initializeViews()
        initializeObservables()
    }

    private fun initializeObservables() {
        userViewModel.listUsers.observe(this){ listUsers ->
            var usersData = ""
            listUsers.forEach { user->
                usersData += "${user.firstName} - ${user.age}\n"
            }
            binding.listText.text = usersData

        }
    }

    private fun initializeViews(){
        val dummyAPIService = RetrofitCustom.getDummyAPI()
        val userRepository = UserRepositoryImpl(dummyAPIService)
        val userUseCase = UserUseCase(userRepository)
        userViewModel = ViewModelProvider(this, UserViewModelFactory(userUseCase))[UserViewModel::class.java]

    }

}