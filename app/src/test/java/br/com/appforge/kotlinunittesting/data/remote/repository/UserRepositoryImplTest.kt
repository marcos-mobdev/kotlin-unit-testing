package br.com.appforge.kotlinunittesting.data.remote.repository

import br.com.appforge.kotlinunittesting.data.remote.api.DummyAPIService
import br.com.appforge.kotlinunittesting.data.remote.dto.DummyAPIResponse
import br.com.appforge.kotlinunittesting.data.remote.dto.User
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
import retrofit2.Response


//Mock vs Fake (dummyAPIService)
@RunWith(MockitoJUnitRunner::class)
class UserRepositoryImplTest {

    @Mock
    private lateinit var dummyAPIService: DummyAPIService

    private lateinit var dummyAPIServiceFake: DummyApiServiceFake

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        dummyAPIServiceFake = DummyApiServiceFake()
    }


    //Mock
    @Test
    fun listUsers_Mock_getUserList_returnList()= runTest{

        Mockito.`when`(dummyAPIService.getUsers()).thenReturn(
            Response.success(
                DummyAPIResponse(
                    20,
                    10,
                    100,
                    listOf(
                        User("Marcos", 25, "m","marcos@gmail.com"),
                        User("Maria", 53, "f","maria@gmail.com"),
                        User("Ana", 12, "f","ana@gmail.com"),
                    )
                    )
            )
        )
        val userRepositoryImpl = UserRepositoryImpl(dummyAPIService)
        val list = userRepositoryImpl.listUsers()
        assertThat(list).isNotEmpty()
    }

    //Fake
    @Test
    fun listUsers_Fake_getUserList_returnList()= runTest{
        val userRepositoryImpl = UserRepositoryImpl(dummyAPIServiceFake)
        val list = userRepositoryImpl.listUsers()
        assertThat(list).isNotEmpty()
    }


    @After
    fun tearDown() {
    }


}