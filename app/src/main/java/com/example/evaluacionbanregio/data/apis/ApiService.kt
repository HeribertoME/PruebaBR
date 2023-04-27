package com.example.evaluacionbanregio.data.apis

import com.example.evaluacionbanregio.data.MovementsResponse
import com.example.evaluacionbanregio.ui.CardResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("rest/tarjetacredito.php/1")
    suspend fun getCardInfo(): Response<CardResponse>

    @GET("rest/tarjetacredito-movimientos.php/3")
    suspend fun getMovements(): Response<ArrayList<MovementsResponse>>
}
