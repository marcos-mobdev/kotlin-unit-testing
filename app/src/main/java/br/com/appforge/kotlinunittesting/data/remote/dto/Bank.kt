package br.com.appforge.kotlinunittesting.data.remote.dto

data class Bank(
    val cardExpire: String,
    val cardNumber: String,
    val cardType: String,
    val currency: String,
    val iban: String
)