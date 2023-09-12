package com.jalper.heroesyheroinas.lessonapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jalper.heroesyheroinas.R
import com.jalper.heroesyheroinas.databinding.ActivityLessonBinding
import com.jalper.heroesyheroinas.lessonapp.model.Language
import com.jalper.heroesyheroinas.lessonapp.model.Language.Android
import com.jalper.heroesyheroinas.lessonapp.model.Language.Flutter
import com.jalper.heroesyheroinas.lessonapp.model.Language.IOS

class LessonActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLessonBinding
    private val languagesList = listOf(Android, Flutter, IOS)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLessonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()
    }

    private fun initUI(){
        binding.rvLessonLanguages.adapter = LanguagesAdapter(languagesList)
    }
}