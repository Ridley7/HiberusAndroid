package com.jalper.heroesyheroinas.helloapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jalper.heroesyheroinas.R
import com.jalper.heroesyheroinas.databinding.ActivityHelloBinding

class HelloActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHelloBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHelloBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnButton.setOnClickListener{
            //Preparamos intent
            val intent = Intent(this, GreetingActivity::class.java)

            if(binding.etMainName.text?.isNotBlank() == true){
                intent.putExtra("NOMBRE", binding.etMainName.text.toString())
            }

            startActivity(intent)
        }

    }
}