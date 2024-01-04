package com.test.walletapp.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.test.walletapp.R
import com.test.walletapp.model.SpinnerModel

class SpinnerAdapter(context: Context, resource: Int, private val spinnerList: List<SpinnerModel>) :
    ArrayAdapter<SpinnerModel>(context, resource, spinnerList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return createView(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return createView(position, convertView, parent)
    }

    @SuppressLint("SetTextI18n")
    private fun createView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = LayoutInflater.from(context)
        val view = convertView ?: inflater.inflate(R.layout.spinner_item_layout, parent, false)

        val item = getItem(position)
        val textView = view.findViewById<TextView>(R.id.spinnerItemTextView)
        textView.text = "${item?.firstName} ${item?.lastName}"

        return view
    }
}
