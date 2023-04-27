package com.example.evaluacionbanregio.domain

import com.example.evaluacionbanregio.data.MovementsRepository
import com.example.evaluacionbanregio.data.MovementsResponse
import com.example.evaluacionbanregio.data.NetworkResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMovements @Inject constructor(
    private val movementsRepository: MovementsRepository
) {

    suspend operator fun invoke(): Flow<NetworkResult<ArrayList<MovementsResponse>>> =
        movementsRepository.getMovements()

}
