package com.ramanhmr.tmsandroid.homework13

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ramanhmr.tmsandroid.databinding.ActivityCandyFragmentBinding
import com.ramanhmr.tmsandroid.homework10.Candy

class CandyFragmentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCandyFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCandyFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .add(binding.fcCandyFragments.id, CandyListFragment::class.java, null)
            .commit()
    }

    fun replaceByDescription(candy: Candy) {
        supportFragmentManager.beginTransaction()
            .replace(binding.fcCandyFragments.id, CandyDescriptionFragment.newInstance(candy), null)
            .addToBackStack(null)
            .commit()
    }
}