package br.com.appforge.kotlinunittesting.view.viewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import br.com.appforge.kotlinunittesting.data.remote.dto.User
import br.com.appforge.kotlinunittesting.domain.UserRepositoryFake
import br.com.appforge.kotlinunittesting.domain.UserUseCase
import br.com.appforge.kotlinunittesting.util.getOrAwaitValue
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner


//Fake vs Mock
@RunWith(MockitoJUnitRunner::class)
class UserViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var userUseCase:UserUseCase

    //Fake
    private lateinit var userUseCaseFake: UserUseCaseFake


    private lateinit var userViewModel:UserViewModel


    @Before
    fun setUp() {
        //Mock
        MockitoAnnotations.openMocks(this)
        userViewModel = UserViewModel(userUseCase)

        //Fake
        val userRepositoryFake = UserRepositoryFake()
        userUseCaseFake = UserUseCaseFake(userRepositoryFake)
        userViewModel = UserViewModel(userUseCaseFake)
    }

    /*
    @Test
    fun getUserList_mock_checkLiveDataIsNotEmpty_returnLiveData() = runTest{
        Mockito.`when`(userUseCase()).thenReturn(
            listOf(
                User("Marcos", 44, "m","marcos@gmail.com"),
                User("Maria", 53, "f","maria@gmail.com"),
                User("Ana", 12, "f","ana@gmail.com"),
            )
        )

        userViewModel.getListUsers()
        val liveData = userViewModel.listUsers.getOrAwaitValue ()

        assertThat(liveData).isNotEmpty()
    }

     */

    @Test
    fun getUserList_fake_checkLiveDataIsNotEmpty_returnLiveData() = runTest{
        userViewModel.getListUsers()
        val liveData = userViewModel.listUsers.getOrAwaitValue ()
        assertThat(liveData).isNotEmpty()
    }





    @After
    fun tearDown() {
    }
}