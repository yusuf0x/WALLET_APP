package com.test.walletapp.model


data class Client(
    var title: String,
    var firstName: String,
    var username: String,
    var lastName: String,
    var email: String,
    var password: String,
    var birthday: String,
    var idCard: String,
    var validity_of_IDCard: Boolean,
    var phoneNumber: String,
    var role: String,
    var address: String,
    var city: String,
    var zipCode: String,
    var country: String
)
