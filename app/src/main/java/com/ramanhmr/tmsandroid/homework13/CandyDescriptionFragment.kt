package com.ramanhmr.tmsandroid.homework13

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.ramanhmr.tmsandroid.R
import com.ramanhmr.tmsandroid.databinding.FragmentCandyDescriptionBinding
import com.ramanhmr.tmsandroid.homework10.Candy
import com.ramanhmr.tmsandroid.homework14.SharedPrefsCandyUtils

class CandyDescriptionFragment : Fragment() {
    private var binding: FragmentCandyDescriptionBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCandyDescriptionBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(arguments?.getSerializable(CANDY_BUNDLE_KEY) as Candy) {
            SharedPrefsCandyUtils.putBrand(this.brand)
            SharedPrefsCandyUtils.putCode(this.code)
            binding?.let {
                it.tvBarcode.text = this.code.toString()
                it.tvBrand.text = this.brand
                Glide.with(it.root).load(this.imageURL).into(it.ivCandyLogo)
                val anim = AnimationUtils.loadAnimation(context, R.anim.anim_alpha_scale)
                it.ivCandyLogo.startAnimation(anim)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        private const val CANDY_BUNDLE_KEY = "CANDY_BUNDLE_KEY"

        fun newInstance(candy: Candy) = CandyDescriptionFragment().apply {
            val bundle = Bundle()
            bundle.putSerializable(CANDY_BUNDLE_KEY, candy)
            this.arguments = bundle
        }
    }
}