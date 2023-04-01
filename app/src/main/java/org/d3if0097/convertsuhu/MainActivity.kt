package org.d3if0097.convertsuhu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import org.d3if0097.convertsuhu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener { hitung() }
    }
    private fun hitung() {
        Log.d("MainActivity", "Tombol diklik!")

        val celcius = binding.txtCelcius.text.toString()
        if (TextUtils.isEmpty(celcius)) {
            Toast.makeText(this, R.string.Celcius_Invalid, Toast.LENGTH_LONG).show()
            return
        }
        val farenheit = (celcius.toDouble() * 9/5) + 32
        val kelvin = celcius.toDouble() + 273.15
        val rearmur = celcius.toDouble() * 4/5

        binding.kelvin.text = getString(R.string.kelvinCNV, kelvin)
        binding.farenheit.text = getString(R.string.farenheitCNV, farenheit)
        binding.rearmur.text = getString(R.string.rearmurCNV, rearmur)

    }
}