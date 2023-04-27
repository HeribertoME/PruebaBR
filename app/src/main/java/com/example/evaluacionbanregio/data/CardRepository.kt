package com.example.evaluacionbanregio.data

import com.example.evaluacionbanregio.ui.CardResponse
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@ActivityRetainedScoped
class CardRepository @Inject constructor(
    private val cardDataSource: CardDataSource
) : BaseApiResponse() {

    suspend fun getCardInfo(): Flow<NetworkResult<CardResponse>> {
        return flow {
            emit(safeApiCall { cardDataSource.getCardInfo() })
        }.flowOn(Dispatchers.IO)
    }

}
