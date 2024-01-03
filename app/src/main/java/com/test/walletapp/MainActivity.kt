package com.test.walletapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.test.walletapp.databinding.ActivityMainBinding
import com.test.walletapp.network.ApiHelperImpl
import com.test.walletapp.network.NetworkCallViewModel
import com.test.walletapp.network.RetrofitBuilder
import com.test.walletapp.network.ViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: NetworkCallViewModel

    private var _binding : ActivityMainBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViewModel()
        setupUI()
        setupObserver()

    }

    private  fun setupUI(){

    }

    private fun setupObserver() {

    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(
            this,
            ViewModelFactory(
                ApiHelperImpl(RetrofitBuilder.apiService),
            )
        )[NetworkCallViewModel::class.java]
    }
}