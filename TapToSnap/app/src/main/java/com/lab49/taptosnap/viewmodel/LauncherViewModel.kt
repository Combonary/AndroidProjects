package com.lab49.taptosnap.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lab49.taptosnap.repository.GameRepository
import kotlinx.coroutines.*

class LauncherViewModel(private val gameRepository: GameRepository): ViewModel() {

    val errorMessage = MutableLiveData<String>()
    var job: Job? = null
    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError("Exception handled: ${throwable.localizedMessage}")
    }
    val loading = MutableLiveData<Boolean>()
    var working = false

    fun loadInitialData() {
        loading.value = true
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response = gameRepository.getData()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    loading.value = false
                    working = true
                } else {
                    onError("Error : ${response.message()} ")
                }
            }
        }

    }

    private fun onError(message: String) {
        errorMessage.value = message
        loading.value = false
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

}