package br.com.appforge.kotlinunittesting.domain

import br.com.appforge.kotlinunittesting.data.remote.dto.User
import br.com.appforge.kotlinunittesting.data.remote.repository.UserRepositoryImpl
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.test.runTest

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

//Mock vs Fake
@RunWith(MockitoJUnitRunner::class)
class UserUseCaseTest {
    //Mock
    @Mock
    private lateinit var userRepositoryImpl: UserRepositoryImpl
    //Fake
    private lateinit var userRepositoryFake: UserRepositoryFake

    private lateinit var userUseCase: UserUseCase

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        //Mock - UseCase Initialization
        //userUseCase = UserUseCase(userRepositoryImpl)
        //Fake - UseCase Initialization
        userRepositoryFake = UserRepositoryFake()
        userUseCase = UserUseCase(userRepositoryFake)
    }

    /*
    @Test
    fun invoke_getFilteredUsers_returnList() = runTest{
        Mockito.`when`(userRepositoryImpl.listUsers()).thenReturn(
            listOf(
                User("Marcos", 44, "m","marcos@gmail.com"),
                User("Maria", 53, "f","maria@gmail.com"),
                User("Ana", 12, "f","ana@gmail.com"),
            )
        )

        val filteredListUsers = userUseCase()
        assertThat(filteredListUsers).isNotEmpty()
    }

     */

    @Test
    fun invoke_fake_getFilteredUsers_returnList() = runTest{


        val filteredListUsers = userUseCase()
        assertThat(filteredListUsers).isNotEmpty()
    }

    @After
    fun tearDown() {
    }
}