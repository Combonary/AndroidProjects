package com.lab49.taptosnap.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.lab49.taptosnap.repository.GameRepository

@Suppress("UNCHECKED_CAST")
class MainViewModelFactory (private val gameRepository: GameRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            MainViewModel(this.gameRepository) as T
        }else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}