package com.example.evaluacionbanregio.domain

import com.example.evaluacionbanregio.data.CardRepository
import com.example.evaluacionbanregio.data.NetworkResult
import com.example.evaluacionbanregio.ui.CardResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCardInfo @Inject constructor(
    private val cardRepository: CardRepository
) {

    suspend operator fun invoke(): Flow<NetworkResult<CardResponse>> = cardRepository.getCardInfo()

}
