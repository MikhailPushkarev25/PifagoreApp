package com.example.pifagoreapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.pifagoreapp.databinding.ActivityMainBinding
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun onClickResult(view : View) {

        if (!isFildEmpty()) {
            val result = getString(R.string.resultInfo) + getResult()
            binding.tvResult.text = result
        }
    }

    private fun isFildEmpty() : Boolean {
        binding.apply {
            if (edA.text.isNullOrEmpty()) edA.error = "Поле не заполнено!"
            if (edB.text.isNullOrEmpty()) edB.error = "Поле не заполнено!"
            return edA.text.isNullOrEmpty() || edB.text.isNullOrEmpty()
        }
    }

    private fun getResult() : String {
        val a: Double
        val b: Double
        binding.apply {
            a = edA.text.toString().toDouble()
            b = edB.text.toString().toDouble()
        }
        return kotlin.math.sqrt((a.pow(2) + b.pow(2))).toString()
    }
}