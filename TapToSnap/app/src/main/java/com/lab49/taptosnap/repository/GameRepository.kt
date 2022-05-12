package com.lab49.taptosnap.repository

import com.lab49.taptosnap.repository.service.GameApi

class GameRepository (private val service: GameApi) {
    suspend fun getData() = service.getInitialList()

    //postData
}