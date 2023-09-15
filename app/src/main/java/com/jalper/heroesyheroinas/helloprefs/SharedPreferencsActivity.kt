package com.jalper.heroesyheroinas.helloprefs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jalper.heroesyheroinas.R
import com.jalper.heroesyheroinas.databinding.ActivitySharedPreferencsBinding

class SharedPreferencsActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySharedPreferencsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySharedPreferencsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}