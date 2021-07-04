package com.ramanhmr.tmsandroid.homework13

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ramanhmr.tmsandroid.R
import com.ramanhmr.tmsandroid.databinding.ActivityCandyFragmentBinding
import com.ramanhmr.tmsandroid.homework10.Candy
import com.ramanhmr.tmsandroid.homework14.SharedPrefsCandyUtils

class CandyFragmentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCandyFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCandyFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .add(
                binding.fcCandyFragments.id,
                CandyListFragment::class.java,
                null,
                LIST_FRAGMENT_TAG
            )
            .commit()

        val toastText = if (SharedPrefsCandyUtils.hasBrandAndCode()) {
            String.format(
                getString(R.string.toast_last_candy),
                SharedPrefsCandyUtils.getBrand(),
                SharedPrefsCandyUtils.getCode()
            )
        } else {
            getString(R.string.toast_no_candy)
        }
        Toast.makeText(applicationContext, toastText, Toast.LENGTH_LONG).show()
    }

    fun replaceByDescription(candy: Candy) {
        supportFragmentManager.beginTransaction()
            .replace(
                binding.fcCandyFragments.id,
                CandyDescriptionFragment.newInstance(candy),
                DESCRIPTION_FRAGMENT_TAG
            )
            .addToBackStack(null)
            .commit()
    }

    companion object {
        private const val LIST_FRAGMENT_TAG = "LIST_FRAGMENT"
        private const val DESCRIPTION_FRAGMENT_TAG = "DESCRIPTION_FRAGMENT"
    }
}