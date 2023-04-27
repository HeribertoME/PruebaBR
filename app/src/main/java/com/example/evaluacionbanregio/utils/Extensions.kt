package com.example.evaluacionbanregio.utils

import com.example.evaluacionbanregio.data.MovementsResponse
import com.example.evaluacionbanregio.ui.Movement

fun ArrayList<MovementsResponse>.toMovementUI(): List<Movement> {
    val list = mutableListOf<Movement>()
    this.forEach {
        list.add(Movement(
            id = it.pkMovimientosID?.toInt() ?: 0,
            description = it.Descripcion ?: "",
            date = it.Fecha ?: "",
            amount = it.Monto?.toDouble() ?: 0.0
        ))
    }

    return list
}

fun String.toFormatCard(position: Int): String {
    val digits = this.split("-")
    return digits[position]
}