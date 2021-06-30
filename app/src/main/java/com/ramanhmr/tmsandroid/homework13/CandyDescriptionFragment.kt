package com.ramanhmr.tmsandroid.homework13

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.ramanhmr.tmsandroid.databinding.FragmentCandyDescriptionBinding
import com.ramanhmr.tmsandroid.homework10.Candy

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
            binding?.tvBarcode?.text = this.code.toString()
            binding?.tvBrand?.text = this.brand
            Glide.with(binding!!.root).load(this.imageURL).into(binding!!.ivCandyLogo)
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