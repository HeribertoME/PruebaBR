package com.example.evaluacionbanregio.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.evaluacionbanregio.data.MovementsResponse
import com.example.evaluacionbanregio.data.NetworkResult
import com.example.evaluacionbanregio.domain.GetCardInfo
import com.example.evaluacionbanregio.domain.GetMovements
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getCardInfo: GetCardInfo,
    private val getMovements: GetMovements,
) : ViewModel() {

    private var _responseCard = MutableLiveData<NetworkResult<CardResponse>>()
    val responseCard: LiveData<NetworkResult<CardResponse>> = _responseCard

    private var _responseMovements = MutableLiveData<NetworkResult<ArrayList<MovementsResponse>>>()
    val responseMovements: LiveData<NetworkResult<ArrayList<MovementsResponse>>> = _responseMovements

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            getCardInfo().collect {
                _responseCard.value = it
            }
            getMovements().collect {
                _responseMovements.value = it
            }
        }
    }

}
