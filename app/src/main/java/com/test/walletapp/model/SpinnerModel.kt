package com.test.walletapp.model


class SpinnerModel {
    var id: String? = null
    var phoneNumber: String? = null
    var firstName: String? = null
    var lastName: String
    var account_number: String

    constructor(
        phoneNumber: String?,
        firstName: String?,
        lastName: String,
        account_number: String
    ) {
        this.phoneNumber = phoneNumber
        this.firstName = firstName
        this.lastName = lastName
        this.account_number = account_number
    }

    constructor(lastName: String, account_number: String) {
        this.lastName = lastName
        this.account_number = account_number
    }

    constructor(account_number: String, firstName: String?, lastName: String) {
        this.account_number = account_number
        this.firstName = firstName
        this.lastName = lastName
    }

    var arrayList = ArrayList<SpinnerModel>()
}

