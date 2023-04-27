package com.example.evaluacionbanregio.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.evaluacionbanregio.R
import com.example.evaluacionbanregio.databinding.MovementItemBinding

class MovementsAdapter : ListAdapter<Movement, MovementsAdapter.MovementViewHolder>(MovementDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovementViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.movement_item, parent, false)
        return MovementViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovementViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class MovementViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = MovementItemBinding.bind(view)


        fun bind(movement: Movement) {
            binding.tvDescription.text = movement.description
            binding.tvDate.text = movement.date
            binding.tvAmount.text ="-${movement.amount}"
        }

    }
}

class MovementDiffCallback : DiffUtil.ItemCallback<Movement>() {
    override fun areItemsTheSame(oldItem: Movement, newItem: Movement): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Movement, newItem: Movement): Boolean {
        return oldItem == newItem
    }

}
