package com.test.walletapp.model


class RestituModel {
    var id: String
    var name: String
    var payment: String
    var res: String? = null

    constructor(id: String, name: String, payment: String) {
        this.id = id
        this.name = name
        this.payment = payment
    }

    constructor(id: String, name: String, payment: String, res: String?) {
        this.id = id
        this.name = name
        this.payment = payment
        this.res = res
    }
}


