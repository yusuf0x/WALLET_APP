package com.test.walletapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.test.walletapp.adapter.SpinnerAdapter
import com.test.walletapp.databinding.ActivityTransferBinding
import com.test.walletapp.model.SpinnerModel
import com.test.walletapp.network.ApiHelperImpl
import com.test.walletapp.network.RetrofitBuilder
import com.test.walletapp.network.UiState
import com.test.walletapp.network.ViewModelFactory
import com.test.walletapp.network.viewmodels.AddBeneficiaryViewModel
import com.test.walletapp.network.viewmodels.TransferViewModel
import kotlinx.coroutines.launch


class TransferActivity : AppCompatActivity() {

    private var _binding : ActivityTransferBinding? = null
    private val binding get() = _binding!!

    private lateinit var  sharedPreferencesManager : SharedPreferencesManager

    private lateinit var viewModel: TransferViewModel
    private  lateinit var  spinnerAdapter : SpinnerAdapter




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferencesManager = SharedPreferencesManager.getInstance(applicationContext)
        _binding = ActivityTransferBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViewModel()
        setupUI()
        setupObserver()


    }
    private  fun setupUI(){
        spinnerAdapter = SpinnerAdapter(this, R.layout.spinner_item_layout, mutableListOf())
        viewModel.getListOfBeneficiaries(sharedPreferencesManager.getInt("id",1))

        binding.deletbenef.setOnClickListener {

            it.visibility = View.VISIBLE
        }
        binding.spinner.onItemSelectedListener  =  object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val myModel = p0!!.getSelectedItem() as SpinnerModel
//                binding.ajouterbenef.setOnClickListener {
//                }
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }
        binding.ajouterbenef.setOnClickListener {
            val intent = Intent(this, AddBeneficiaryActivity::class.java)
            startActivity(intent)
        }
        binding.envoyertransfer.setOnClickListener {

        }
    }
    private fun setupObserver() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect {
                    when (it) {
                        is UiState.Success -> {
                            val arrayList1 = mutableListOf<SpinnerModel>()
                            for (benefmodel in it.data!!) {
                                arrayList1.add(
                                    SpinnerModel(
                                        benefmodel!!.account_number,
                                        benefmodel.firstName,
                                        benefmodel.lastName,
                                        benefmodel.phoneNumber!!
                                    )
                                )

                            }
                            spinnerAdapter.addAll(arrayList1)
                            binding.spinner.adapter  = spinnerAdapter

                            Toast.makeText(
                                this@TransferActivity,
                                "Welcome",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        is UiState.Loading -> {
                            Toast.makeText(
                                this@TransferActivity,
                                "Loading ...",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        is UiState.Error -> {
                            println("TAG111 ${it.message}")
                            Toast.makeText(
                                this@TransferActivity,
                                it.message,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }

            }
        }
    }
    private  fun setupViewModel(){
        viewModel = ViewModelProvider(
            this,
            ViewModelFactory(
                ApiHelperImpl(RetrofitBuilder.apiService),
            )
        )[TransferViewModel::class.java]
    }
}