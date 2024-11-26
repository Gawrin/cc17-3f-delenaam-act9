package com.example.cc17_3f_delenaam_act9.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.cc17_3f_delenaam_act9.data.Airport
import com.example.cc17_3f_delenaam_act9.databinding.ItemAirportSuggestionBinding

class   AirportSuggestionAdapter(
    private val onAirportSelected: (Airport) -> Unit
) : ListAdapter<Airport, AirportSuggestionAdapter.AirportViewHolder>(AirportDiffCallback()) {

    inner class AirportViewHolder(private val binding: ItemAirportSuggestionBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(airport: Airport) {
            binding.airportCode.text = airport.iataCode
            binding.airportName.text = airport.name
            itemView.setOnClickListener { onAirportSelected(airport) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AirportViewHolder {
        return AirportViewHolder(
            ItemAirportSuggestionBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: AirportViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class AirportDiffCallback : DiffUtil.ItemCallback<Airport>() {
        override fun areItemsTheSame(oldItem: Airport, newItem: Airport) =
            oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Airport, newItem: Airport) =
            oldItem == newItem
    }
}