package com.ramanhmr.tmsandroid.homework10

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ramanhmr.tmsandroid.R

class CandiesActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_candies)

        recyclerView = this.findViewById(R.id.rv_candies)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = CandiesAdapter(CandyMaker.createCandies(300))
    }
}