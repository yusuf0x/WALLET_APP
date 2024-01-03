package com.test.walletapp.model

import java.util.Date


class Transfer {
    constructor(transfer_reference: String?, receiver_lname: String, transfer_amount: Float) {
        this.transfer_reference = transfer_reference
        this.receiver_lname = receiver_lname
        this.transfer_amount = transfer_amount
    }

    var transfer_amount: Float
    var transfer_reference: String? = null
    var transfer_status = 0
    var received_at: Date? = null
    var receiver_fname: String? = null
    var receiver_lname: String
    var receiver_phnumber: String? = null
    var id_multitransfer: String? = null
    var motif = ""
    var id_transfer: Int? = null

    constructor(
        parseInt: Float,
        i: Int,
        firstName: String?,
        lastName: String,
        phoneNumber: String?
    ) {
        transfer_amount = parseInt
        transfer_status = i
        receiver_fname = firstName
        receiver_lname = lastName
        receiver_phnumber = phoneNumber
    }
}
