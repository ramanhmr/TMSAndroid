package com.ramanhmr.tmsandroid.homework10

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ramanhmr.tmsandroid.R
import com.ramanhmr.tmsandroid.databinding.ActivityCandiesBinding

class CandiesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCandiesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCandiesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvCandies.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvCandies.adapter = CandiesAdapter(CandyMaker.createCandies(CANDIES_AMOUNT))
    }

    companion object {
        private const val CANDIES_AMOUNT = 300
    }
}