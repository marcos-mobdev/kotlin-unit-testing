package br.com.appforge.kotlinunittesting.data.remote.dto

data class DummyAPIResponse(
    val limit: Int,
    val skip: Int,
    val total: Int,
    val users: List<User>
)