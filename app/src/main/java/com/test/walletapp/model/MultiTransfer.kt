package com.test.walletapp.model


class MultiTransfer {
    constructor(transfers: List<Transfer>) {
        this.transfers = transfers
    }

    constructor(
        idName: Int,
        fn: String?,
        ln: String?,
        pn: String?,
        toString: Float,
        v: Float,
        i: Int,
        test_client: String?,
        b: Boolean,
        l1: List<Transfer>
    ) {
        id_client = idName
        sender_fname = fn
        sender_lname = ln
        sender_phnumber = pn
        total_amount = toString
        total_expense_amount = v
        expense_id = i
        motif = test_client
        isNotify_transfer = b
        transfers = l1
    }

    /*  public MultiTransfer(int idName, String fn, String ln, String pn, int i, double v, int i1, String test_client, boolean b, Transfer transfer) {
          this.sender_fname=fn;
          this.sender_lname=ln;
          this.sender_phnumber=pn;

          this.transfers=transfer;
      }*/
    var created_at: String? = null
    var ended_at: String? = null
    var id_client: Int? = null
    var sender_fname: String? = null
    var sender_lname: String? = null
    var sender_phnumber: String? = null
    var total_amount: Float? = null
    var total_expense_amount: Float? = null
    var expense_id = 0
    var isTransfer_by_cash = false
    var isNotify_transfer = false
    var client_id = 0
    var isRequest_by_prospect_client = false
    var sended_by_agent = 0
    var motif: String? = null
    var transfers: List<Transfer>
    var id_multitransfer = 0
}

