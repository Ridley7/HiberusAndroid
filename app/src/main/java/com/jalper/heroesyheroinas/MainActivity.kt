package com.jalper.heroesyheroinas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jalper.heroesyheroinas.databinding.ActivityMainBinding
import com.jalper.heroesyheroinas.helloapp.HelloActivity
import com.jalper.heroesyheroinas.lessonapp.LessonActivity

class MainActivity : AppCompatActivity() {

    private  lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListeners()
    }

    private fun initListeners(){
        binding.btnMenuHelloButton.setOnClickListener{
            startActivity(Intent(this, HelloActivity::class.java))
        }

        binding.btnMenuLessonButton.setOnClickListener{
            startActivity(Intent(this, LessonActivity::class.java))
        }
    }
}