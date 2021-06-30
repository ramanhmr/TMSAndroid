package com.ramanhmr.tmsandroid.homework10

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ramanhmr.tmsandroid.databinding.ItemCandyBinding

class CandiesAdapter(private val candies: MutableList<Candy>) :
    RecyclerView.Adapter<CandiesAdapter.CandyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CandyViewHolder(
        ItemCandyBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
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

    class CandyViewHolder(private val binding: ItemCandyBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Candy) {
            binding.tvBrand.text = item.brand
            binding.tvCode.text = item.code.toString()
            Glide.with(binding.root).load(item.imageURL).into(binding.ivLogo)
        }
    }
}