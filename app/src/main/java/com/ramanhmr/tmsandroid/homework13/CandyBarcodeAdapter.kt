package com.ramanhmr.tmsandroid.homework13

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ramanhmr.tmsandroid.databinding.ItemCandyBarcodeBinding
import com.ramanhmr.tmsandroid.homework10.Candy

class CandyBarcodeAdapter(
    private val candies: MutableList<Candy>,
    private val onClickAction: (Candy) -> Unit
) :
    RecyclerView.Adapter<CandyBarcodeAdapter.CandyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CandyViewHolder(
        ItemCandyBarcodeBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ), onClickAction
    )

    override fun onBindViewHolder(holder: CandyViewHolder, position: Int) {
        holder.bind(candies[position])
    }

    override fun getItemCount(): Int = candies.size

    fun update(newList: List<Candy>) {
        candies.clear()
        candies.addAll(newList)
        notifyDataSetChanged()
    }

    class CandyViewHolder(
        private val binding: ItemCandyBarcodeBinding,
        private val onClickAction: (Candy) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Candy) {
            binding.tvBarcode.text = item.code.toString()
            binding.tvBarcode.setOnClickListener {
                onClickAction(item)
            }
        }
    }
}