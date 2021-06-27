package com.ramanhmr.tmsandroid.homework12

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.ramanhmr.tmsandroid.R
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
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            when (fragmentCode) {
                0 -> add<BlackFragment>(R.id.fc_fragments)
                1 -> add<GreenFragment>(R.id.fc_fragments)
                2 -> add<PurpleFragment>(R.id.fc_fragments)
                3 -> add<RedFragment>(R.id.fc_fragments)
                4 -> add<YellowFragment>(R.id.fc_fragments)
            }
        }
    }

    private fun replaceFragment(fragmentCode: Int) {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            when (fragmentCode) {
                0 -> replace<BlackFragment>(R.id.fc_fragments)
                1 -> replace<GreenFragment>(R.id.fc_fragments)
                2 -> replace<PurpleFragment>(R.id.fc_fragments)
                3 -> replace<RedFragment>(R.id.fc_fragments)
                4 -> replace<YellowFragment>(R.id.fc_fragments)
            }
        }
    }
}