package com.jalper.heroesyheroinas.lessonapp.model

import com.jalper.heroesyheroinas.lessonapp.model.Language.Android

data class Lesson(
    var name: String,
    val language: Language = Android
)
