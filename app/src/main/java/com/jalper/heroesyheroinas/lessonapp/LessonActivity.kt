package com.jalper.heroesyheroinas.lessonapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jalper.heroesyheroinas.R
import com.jalper.heroesyheroinas.databinding.ActivityLessonBinding
import com.jalper.heroesyheroinas.lessonapp.model.Language
import com.jalper.heroesyheroinas.lessonapp.model.Language.Android
import com.jalper.heroesyheroinas.lessonapp.model.Language.Flutter
import com.jalper.heroesyheroinas.lessonapp.model.Language.IOS
import com.jalper.heroesyheroinas.lessonapp.model.Lesson

class LessonActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLessonBinding
    private val languagesList = listOf(Android, Flutter, IOS)
    private val lessonsList = mutableListOf<Lesson>(
        Lesson("Arquitectura", IOS),
        Lesson("UX", Android),
        Lesson("Variables", Flutter),
        Lesson("Estilos")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLessonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()
    }

    private fun initUI(){
        //Creamos la lista de lenguajes de programacion
        binding.rvLessonLanguages.adapter = LanguagesAdapter(languagesList)

        //Creamos la lista de lecciones
        binding.rvLessonLessons.adapter = LessonsAdapter(lessonsList)
    }
}