package com.test.walletapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.test.walletapp.adapter.SpinnerAdapter
import com.test.walletapp.databinding.ActivityAddBeneficiaryBinding
import com.test.walletapp.model.SpinnerModel
import com.test.walletapp.network.ApiHelperImpl
import com.test.walletapp.network.RetrofitBuilder
import com.test.walletapp.network.UiState
import com.test.walletapp.network.ViewModelFactory
import com.test.walletapp.network.viewmodels.AddBeneficiaryViewModel
import com.test.walletapp.network.viewmodels.TransferViewModel
import kotlinx.coroutines.launch

class AddBeneficiaryActivity : AppCompatActivity() {

    private var _binding : ActivityAddBeneficiaryBinding? = null
    private val binding get() = _binding!!

    private lateinit var  sharedPreferencesManager : SharedPreferencesManager

    private lateinit var viewModel: AddBeneficiaryViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferencesManager = SharedPreferencesManager.getInstance(applicationContext)

        _binding = ActivityAddBeneficiaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViewModel()
        setupUI()
        setupObserver()


    }
    private  fun setupUI(){

    }
    private fun setupObserver() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect {
                    when (it) {
                        is UiState.Success -> {
                            Toast.makeText(
                                this@AddBeneficiaryActivity,
                                "Welcome",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        is UiState.Loading -> {
                            Toast.makeText(
                                this@AddBeneficiaryActivity,
                                "Loading ...",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        is UiState.Error -> {
                            println("TAG111 ${it.message}")
                            Toast.makeText(
                                this@AddBeneficiaryActivity,
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
        )[AddBeneficiaryViewModel::class.java]
    }
}