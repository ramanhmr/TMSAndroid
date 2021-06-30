package com.ramanhmr.tmsandroid.homework12

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ramanhmr.tmsandroid.databinding.ActivityFragmetnsBinding
import kotlin.random.Random

class FragmentsActivity : AppCompatActivity() {
    private var currentFragmentCode: Int = Random.nextInt(5)
    private lateinit var binding: ActivityFragmetnsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmetnsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addFragment(currentFragmentCode)

        binding.btnChangeFragment.setOnClickListener {
            currentFragmentCode = (currentFragmentCode + Random.nextInt(1, 5)) % 5
            replaceFragment(currentFragmentCode)
        }
    }

    private fun addFragment(fragmentCode: Int) {
        chooseFragment(fragmentCode)?.let {
            supportFragmentManager.beginTransaction()
                .add(binding.fcFragments.id, it, null)
                .commit()
        }
    }

    private fun replaceFragment(fragmentCode: Int) {
        chooseFragment(fragmentCode)?.let {
            supportFragmentManager.beginTransaction()
                .replace(binding.fcFragments.id, it, null)
                .commit()
        }
    }

    private fun chooseFragment(fragmentCode: Int) = when (fragmentCode) {
        0 -> BlackFragment::class.java
        1 -> GreenFragment::class.java
        2 -> PurpleFragment::class.java
        3 -> RedFragment::class.java
        4 -> YellowFragment::class.java
        else -> null
    }
}