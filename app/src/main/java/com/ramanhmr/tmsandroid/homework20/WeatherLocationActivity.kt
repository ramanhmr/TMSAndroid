package com.ramanhmr.tmsandroid.homework20

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ramanhmr.tmsandroid.R
import com.ramanhmr.tmsandroid.databinding.ActivityWeatherLocationBinding
import org.koin.android.viewmodel.ext.android.viewModel

class WeatherLocationActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityWeatherLocationBinding
    private val viewModel: WeatherViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityWeatherLocationBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.btnConfirmLocation.setOnClickListener {
            val city = viewBinding.etLocation.text.toString()
            if (viewModel.hasCity(city)) {
                viewModel.saveCity(city)
                this.finish()
            } else {
                Toast.makeText(this, getString(R.string.no_such_city), Toast.LENGTH_SHORT).show()
                viewBinding.etLocation.text.clear()
            }
        }
    }
}