package com.test.walletapp.model

import android.widget.TextView


class PaymentModel {
    var id: String
    var name: String
    var payment: String
    var res: TextView? = null

    constructor(id: String, name: String, payment: String) {
        this.id = id
        this.name = name
        this.payment = payment
    }

    constructor(id: String, name: String, payment: String, res: TextView?) {
        this.id = id
        this.name = name
        this.payment = payment
        this.res = res
    }
}
