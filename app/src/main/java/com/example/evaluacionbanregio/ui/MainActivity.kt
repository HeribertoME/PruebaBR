package com.example.evaluacionbanregio.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.evaluacionbanregio.R
import com.example.evaluacionbanregio.data.NetworkResult
import com.example.evaluacionbanregio.databinding.ActivityMainBinding
import com.example.evaluacionbanregio.utils.toFormatCard
import com.example.evaluacionbanregio.utils.toMovementUI
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MovementsAdapter

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(root)
            adapter = MovementsAdapter()
            rvMain.adapter = adapter

            viewModel.responseCard.observe(this@MainActivity) {
                when(it) {
                    is NetworkResult.Loading -> {}
                    is NetworkResult.Error -> {
                        Toast.makeText(this@MainActivity, "Error", Toast.LENGTH_LONG).show()
                    }
                    is NetworkResult.Success -> {
                        tvCardFistNumbers.text = it.data?.NumeroTarjeta?.toFormatCard(0)
                        tvCardSecondNumbers.text = it.data?.NumeroTarjeta?.toFormatCard(1)
                        tvCardThirdNumbers.text = it.data?.NumeroTarjeta?.toFormatCard(2)
                        tvCardFourthNumbers.text = it.data?.NumeroTarjeta?.toFormatCard(3)
                        tvOwnerCardValue.text = it.data?.TitularTarjeta
                        tvExpirationDateValue.text = it.data?.FechaExp
                    }
                }
            }

            viewModel.responseMovements.observe(this@MainActivity) {
                when(it) {
                    is NetworkResult.Loading -> {}
                    is NetworkResult.Error -> {
                        Toast.makeText(this@MainActivity, "Error", Toast.LENGTH_LONG).show()
                    }
                    is NetworkResult.Success -> {
                        val result = it.data
                        adapter.submitList(result?.toMovementUI())
                    }
                }
            }

        }
    }
}