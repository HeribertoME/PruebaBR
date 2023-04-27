package com.example.evaluacionbanregio.data

import com.example.evaluacionbanregio.data.apis.ApiService
import retrofit2.Response
import javax.inject.Inject

interface MovementDataSource {

    suspend fun getMovements(): Response<ArrayList<MovementsResponse>>

}

class MovementsRemoteSource @Inject constructor(
    private val service: ApiService,
) : MovementDataSource {
    override suspend fun getMovements() = service.getMovements()

}
