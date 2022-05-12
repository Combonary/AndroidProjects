package com.lab49.taptosnap.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.lab49.taptosnap.R
import com.lab49.taptosnap.databinding.ActivityMainBinding
import com.lab49.taptosnap.databinding.LauncherScreenBinding
import com.lab49.taptosnap.repository.GameRepository
import com.lab49.taptosnap.repository.service.GameApi
import com.lab49.taptosnap.viewmodel.LauncherViewModel
import com.lab49.taptosnap.viewmodel.LauncherViewModelFactory
import com.lab49.taptosnap.viewmodel.MainViewModel
import com.lab49.taptosnap.viewmodel.MainViewModelFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    private val tag = "MainActivity"
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val service = GameApi.getInstance()
        val gameRepository = GameRepository(service)

        viewModel = ViewModelProvider(
            this,
            MainViewModelFactory(gameRepository)
        ).get(MainViewModel::class.java)

        //trying out a count down timer
        GlobalScope.launch(Dispatchers.Main) {
            val totalSeconds = TimeUnit.MINUTES.toSeconds(2)
            val tickSeconds = 1
            for (second in totalSeconds downTo tickSeconds) {
                val time = String.format(
                    "%02d:%02d",
                    TimeUnit.SECONDS.toMinutes(second),
                    second - TimeUnit.MINUTES.toSeconds(TimeUnit.SECONDS.toMinutes(second))
                )
                binding.timerTextView.text = time
                delay(1000)
            }
            binding.timerTextView.text = "Done!"
        }

        //("lots and lots to do here unfortunately")
        //("initialize variables, add two more tiles, edit the gradient around each tile, intents for launching the default camera and getting the result")
        //("check picture, change tile color gradient, reset game if time is elapsed")

    }
}