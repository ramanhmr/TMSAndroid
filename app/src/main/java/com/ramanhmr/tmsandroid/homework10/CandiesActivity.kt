package com.ramanhmr.tmsandroid.homework10

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ramanhmr.tmsandroid.databinding.ActivityCandiesBinding

class CandiesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCandiesBinding
    private val viewModel by viewModels<CandiesViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCandiesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvCandies.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val candiesAdapter = CandiesAdapter(mutableListOf())
        binding.rvCandies.adapter = candiesAdapter
        viewModel.candyListLiveData.observe(
            this,
            { candiesAdapter.update(it) })
    }
}