package com.ramanhmr.tmsandroid.homework17

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ramanhmr.tmsandroid.databinding.ItemCurrencyBinding

class CurrenciesAdapter(private var currencies: MutableList<Currency>) :
    RecyclerView.Adapter<CurrenciesAdapter.CurrencyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder =
        CurrencyViewHolder(
            ItemCurrencyBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        holder.bind(currencies[position])
    }

    override fun getItemCount(): Int = currencies.size

    fun update(newList: List<Currency>) {
        currencies.clear()
        currencies.addAll(newList)
        notifyDataSetChanged()
    }

    class CurrencyViewHolder(private val binding: ItemCurrencyBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(currency: Currency) {
            binding.tvId.text = currency.id.toString()
            binding.tvName.text = currency.name
        }
    }
}