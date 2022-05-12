package com.lab49.taptosnap.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lab49.taptosnap.model.GameModel
import com.lab49.taptosnap.model.GameModelItem
import com.lab49.taptosnap.repository.GameRepository
import kotlinx.coroutines.*
import java.util.concurrent.TimeUnit

class MainViewModel(private val gameRepository: GameRepository) : ViewModel() {

    private val errorMessage = MutableLiveData<String>()
    val body = mutableListOf<GameModelItem>()
    var topLeftCard = GameModelItem(0,"")
    var topRightCard= GameModelItem(0,"")
    var job: Job? = null
    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError("Exception handled: ${throwable.localizedMessage}")
    }
    val loading = MutableLiveData<Boolean>()
    var timeKeeper = MutableLiveData<String>()

    fun loadInitialData() {
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response = gameRepository.getData()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    response.body()?.let { body.addAll(it) }
                    initGameModelItem(topLeftCard, body[0])
                    initGameModelItem(topRightCard, body[1])
                    loading.value = false
                } else {
                    onError("Error : ${response.message()} ")
                }
            }
        }

    }

    fun initGameModelItem(initValue: GameModelItem, copyValue:GameModelItem ){
        initValue.copy(id = copyValue.id, name = copyValue.name)
    }

    suspend fun startTimer() {

        val totalSeconds = TimeUnit.MINUTES.toSeconds(2)
        val tickSeconds = 1
        for (second in totalSeconds downTo tickSeconds) {
            val time: String = String.format(
                "%02d:%02d",
                TimeUnit.SECONDS.toMinutes(second),
                second - TimeUnit.MINUTES.toSeconds(TimeUnit.SECONDS.toMinutes(second))
            )
            //timeKeeper = time
            delay(1000)
        }

    }

    fun resetTimer() {

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