package com.example.evaluacionbanregio.data

import com.example.evaluacionbanregio.data.apis.ApiService
import com.example.evaluacionbanregio.ui.CardResponse
import retrofit2.Response
import javax.inject.Inject

interface CardDataSource {

    suspend fun getCardInfo(): Response<CardResponse>

}

class CardRemoteSource @Inject constructor(
    private val service: ApiService,
) : CardDataSource {

    override suspend fun getCardInfo() = service.getCardInfo()

}