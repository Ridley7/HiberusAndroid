package com.jalper.heroesyheroinas.helloapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jalper.heroesyheroinas.R
import com.jalper.heroesyheroinas.databinding.ActivityGreetingBinding

class GreetingActivity : AppCompatActivity() {
    private lateinit var binding : ActivityGreetingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGreetingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.extras?.getString("NOMBRE", "Chico anónimo") ?: "Chica anónima"

        binding.tvGreetingName.text = "Bienvenido, Mr.$name"
    }
}