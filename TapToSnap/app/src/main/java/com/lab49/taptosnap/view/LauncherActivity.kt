package com.lab49.taptosnap.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.lab49.taptosnap.databinding.LauncherScreenBinding
import com.lab49.taptosnap.repository.GameRepository
import com.lab49.taptosnap.repository.service.GameApi
import com.lab49.taptosnap.viewmodel.LauncherViewModel
import com.lab49.taptosnap.viewmodel.LauncherViewModelFactory

class LauncherActivity : AppCompatActivity() {

    private val tag = "LauncherActivity"
    private lateinit var viewModel: LauncherViewModel
    private lateinit var binding: LauncherScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LauncherScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val service = GameApi.getInstance()
        val gameRepository = GameRepository(service)

        viewModel = ViewModelProvider(
            this,
            LauncherViewModelFactory(gameRepository)
        ).get(LauncherViewModel::class.java)

        viewModel.loading.observe(this) {
            if (it) {
                binding.progressBar.visibility = View.VISIBLE
            } else {
                binding.progressBar.visibility = View.GONE
            }
        }

        binding.startButton.setOnClickListener {
            Log.d(tag, "game initialization")
            viewModel.loadInitialData()
            if(viewModel.working){
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }

        viewModel.errorMessage.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }

    }
}