package com.jalper.heroesyheroinas.lessonapp

import androidx.recyclerview.widget.RecyclerView
import com.jalper.heroesyheroinas.R
import com.jalper.heroesyheroinas.databinding.ItemLessonBinding
import com.jalper.heroesyheroinas.lessonapp.model.Language
import com.jalper.heroesyheroinas.lessonapp.model.Lesson

class LessonsViewHolder(private val binding: ItemLessonBinding):RecyclerView.ViewHolder(binding.root) {

    fun render(lesson: Lesson){
        val language = binding.root.context.getString(when (lesson.language){
            Language.Android -> R.string.language_android
            Language.IOS -> R.string.language_ios
            Language.Flutter -> R.string.language_flutter
        })

        binding.tvItemLesson.text = ("${lesson.name} - $language")
    }
}