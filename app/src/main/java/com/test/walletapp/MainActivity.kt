package com.test.walletapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.test.walletapp.databinding.ActivityMainBinding
import com.test.walletapp.network.ApiHelperImpl
import com.test.walletapp.network.RetrofitBuilder
import com.test.walletapp.network.UiState
import com.test.walletapp.network.ViewModelFactory
import com.test.walletapp.network.viewmodels.LoginViewModel
import com.test.walletapp.network.viewmodels.MainViewModel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {


    private var _binding : ActivityMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var  sharedPreferencesManager : SharedPreferencesManager

    private lateinit var viewModel: MainViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        sharedPreferencesManager = SharedPreferencesManager.getInstance(applicationContext)
//        if (sharedPreferencesManager.getString("token") != "" && sharedPreferencesManager.getInt("id") != -1) {
//            setContentView(R.layout.activity_main)
            _binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)
//
//        } else {
//            navigateToLogin()
//        }


        setupViewModel()
        setupUI()
        setupObserver()

    }
    private fun navigateToLogin() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
    private  fun setupUI(){
        binding.Transfert.setOnClickListener {
            val intent = Intent(this, TransferActivity::class.java)
            startActivity(intent)
        }
        binding.Historique.setOnClickListener {
            val intent = Intent(this, HistoryActivity::class.java)
            startActivity(intent)

        }
        binding.restitution.setOnClickListener {
            val intent = Intent(this, RestoreActivity::class.java)
            startActivity(intent)
        }
        viewModel.getClient(1)


    }

    private fun setupObserver() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect {
                    when (it) {
                        is UiState.Success -> {
                            binding.firstname.text = it.data.firstName
                            binding.lastname.text = it.data.lastName
                            binding.adress.text = it.data.address
                            binding.phone.text = it.data.phoneNumber
                            binding.title.text = it.data.title
                            binding.cardid.text = it.data.idCard

                            Toast.makeText(
                                this@MainActivity,
                                "Welcome",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        is UiState.Loading -> {
                            Toast.makeText(
                                this@MainActivity,
                                "Loading ...",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        is UiState.Error -> {
                            println("TAG111 ${it.message}")
                            Toast.makeText(
                                this@MainActivity,
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
        )[MainViewModel::class.java]
    }
}