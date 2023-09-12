package com.jalper.heroesyheroinas.lessonapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jalper.heroesyheroinas.databinding.ItemLessonBinding
import com.jalper.heroesyheroinas.lessonapp.model.Lesson

class LessonsAdapter (
    var lessons: List<Lesson>
): RecyclerView.Adapter<LessonsViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonsViewHolder {
        val binding = ItemLessonBinding.inflate(LayoutInflater.from(parent.context), parent, false);
        return  LessonsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return lessons.size
    }

    override fun onBindViewHolder(holder: LessonsViewHolder, position: Int) {
        holder.render(lessons[position])
    }
}