package com.ramanhmr.tmsandroid.homework17

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ramanhmr.tmsandroid.R
import com.ramanhmr.tmsandroid.databinding.ActivityCurrencyBinding
import com.ramanhmr.tmsandroid.homework17.restApi.FiatCurrencyService
import org.koin.androidx.viewmodel.ext.android.viewModel

class CurrencyActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCurrencyBinding
    private val viewModel: CurrencyViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCurrencyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.spSorting.adapter = ArrayAdapter.createFromResource(
            this,
            R.array.spinner_sorting,
            android.R.layout.simple_spinner_dropdown_item
        )

        binding.rvCurrencies.layoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        val recyclerAdapter = CurrenciesAdapter()
        binding.rvCurrencies.adapter = recyclerAdapter
        viewModel.currenciesLiveData.observe(this, {
            recyclerAdapter.submitList(it)
        })

        with(binding.etNumberOfItems) {
            this.setOnClickListener {
                this.setText("")
            }
            this.setOnEditorActionListener(TextView.OnEditorActionListener { v, actionId, event ->
                if (actionId == EditorInfo.IME_ACTION_NEXT) {
                    viewModel.getCurrencies(
                        getSort(),
                        this.text.toString().toInt()
                    )
                    (getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
                        .hideSoftInputFromWindow(currentFocus?.windowToken, 0)
                    true
                } else {
                    false
                }
            })
        }

        binding.spSorting.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                with(binding.etNumberOfItems.text.toString()) {
                    if (this == "") {
                        viewModel.getCurrencies(
                            getSort()
                        )
                    } else {
                        viewModel.getCurrencies(
                            getSort(),
                            this.toInt()
                        )
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    private fun getSort(): String {
        return when {
            binding.spSorting.selectedItem.toString() == "ID" -> FiatCurrencyService.ID
            binding.spSorting.selectedItem.toString() == "Имя" -> FiatCurrencyService.NAME
            else -> ""
        }
    }
}