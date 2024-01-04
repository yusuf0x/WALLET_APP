package com.test.walletapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.test.walletapp.databinding.ActivityLoginBinding
import com.test.walletapp.network.ApiHelperImpl
import com.test.walletapp.network.viewmodels.LoginViewModel
import com.test.walletapp.network.RetrofitBuilder
import com.test.walletapp.network.UiState
import com.test.walletapp.network.ViewModelFactory
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {
    private var _binding : ActivityLoginBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: LoginViewModel

    private lateinit  var  sharedPreferencesManager:SharedPreferencesManager



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViewModel()
        setupUI()
        setupObserver()

    }
    private  fun setupUI(){
        binding.button.setOnClickListener {
            viewModel.login(binding.editText.text.toString(),binding.editText2.text.toString())
        }
    }
    private fun setupObserver() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect {
                    when (it) {
                        is UiState.Success -> {
                            sharedPreferencesManager = SharedPreferencesManager.getInstance(application.baseContext)
                            sharedPreferencesManager.saveInt("id",it.data.id)
                            sharedPreferencesManager.saveString("token",it.data.token)
                            Toast.makeText(
                                this@LoginActivity,
                                "Welcome",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        is UiState.Loading -> {
                            Toast.makeText(
                                this@LoginActivity,
                                "Loading ...",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        is UiState.Error -> {
                            println("TAG111 ${it.message}")
                            Toast.makeText(
                                this@LoginActivity,
                                it.message,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            }
        }
    }
    private fun setupViewModel() {
        viewModel = ViewModelProvider(
            this,
            ViewModelFactory(
                ApiHelperImpl(RetrofitBuilder.apiService),
            )
        )[LoginViewModel::class.java]
    }
}