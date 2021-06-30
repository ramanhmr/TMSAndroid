package com.ramanhmr.tmsandroid.homework13

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.ramanhmr.tmsandroid.databinding.FragmentCandyListBinding
import com.ramanhmr.tmsandroid.homework10.Candy

class CandyListFragment : Fragment() {
    private var binding: FragmentCandyListBinding? = null
    private val viewModel by viewModels<CandyListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCandyListBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val itemOnClickAction: (candy: Candy) -> Unit =
            { (activity as? CandyFragmentActivity)?.replaceByDescription(it) }
        val adapter = CandyBarcodeAdapter(mutableListOf(), itemOnClickAction)
        binding?.rvCandyList?.layoutManager =
            LinearLayoutManager(binding?.root?.context, LinearLayoutManager.VERTICAL, false)
        binding?.rvCandyList?.adapter = adapter
        viewModel.candiesLiveData.observe(viewLifecycleOwner, { adapter.update(it) })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}