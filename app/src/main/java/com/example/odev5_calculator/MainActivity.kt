package com.example.odev5_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.odev5_calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button0.setOnClickListener {
            binding.editTextCalculator.append("0")
        }
        binding.button1.setOnClickListener {
            binding.editTextCalculator.append("1")
        }
        binding.button2.setOnClickListener {
            binding.editTextCalculator.append("2")
        }
        binding.button3.setOnClickListener {
            binding.editTextCalculator.append("3")
        }
        binding.button4.setOnClickListener {
            binding.editTextCalculator.append("4")
        }
        binding.button5.setOnClickListener {
            binding.editTextCalculator.append("5")
        }
        binding.button6.setOnClickListener {
            binding.editTextCalculator.append("6")
        }
        binding.button7.setOnClickListener {
            binding.editTextCalculator.append("7")
        }
        binding.button8.setOnClickListener {
            binding.editTextCalculator.append("8")
        }
        binding.button9.setOnClickListener {
            binding.editTextCalculator.append("9")
        }
        binding.buttonTopla.setOnClickListener {
            binding.editTextCalculator.append("+")
        }
        binding.buttonSil.setOnClickListener {
            hesapMakinesiniTemzile()
        }
        binding.buttonVirgul.setOnClickListener {
            binding.editTextCalculator.append(".")
        }
        binding.buttonEsittir.setOnClickListener {
            toplamSonuc()
        }
    }

    private fun hesapMakinesiniTemzile() {
        binding.editTextCalculator.text.clear()
        binding.textViewSonuc.visibility = View.INVISIBLE
    }

    private fun toplamSonuc() {
        val girilenDeğer = binding.editTextCalculator.text.toString()
        try {
            val sonuc = toplamHesapla(girilenDeğer)
            binding.textViewSonuc.text = "Sonuç: $sonuc"
            binding.textViewSonuc.visibility = View.VISIBLE
        } catch (e: Exception) {
            binding.textViewSonuc.text = "Hata!"
            binding.textViewSonuc.visibility = View.VISIBLE
        }
    }

    private fun toplamHesapla(expression: String): Double {
        val numbers = expression.split("+")
        return numbers.sumByDouble { it.toDouble() }
    }
}