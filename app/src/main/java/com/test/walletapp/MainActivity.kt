package com.test.walletapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.test.walletapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private var _binding : ActivityMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var  sharedPreferencesManager : SharedPreferencesManager



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


//        setupViewModel()
        setupUI()
//        setupObserver()

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
//            finish()
        }
        binding.Historique.setOnClickListener {
            val intent = Intent(this, HistoryActivity::class.java)
            startActivity(intent)
//            finish()

        }
        binding.restitution.setOnClickListener {
            val intent = Intent(this, RestoreActivity::class.java)
            startActivity(intent)
//            finish()
        }

    }

//    private fun setupObserver() {
//
//    }

//    private fun setupViewModel() {
//        viewModel = ViewModelProvider(
//            this,
//            ViewModelFactory(
//                ApiHelperImpl(RetrofitBuilder.apiService),
//            )
//        )[LoginViewModel::class.java]
//    }
}