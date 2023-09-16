package com.jalper.heroesyheroinas.lessonapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jalper.heroesyheroinas.databinding.ItemLanguageBinding
import com.jalper.heroesyheroinas.lessonapp.model.Language

class LanguagesAdapter(private val languages: List<Language>, val onItemClicked: (Int) -> Unit) : RecyclerView.Adapter<LanguagesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguagesViewHolder {
        val binding = ItemLanguageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return  LanguagesViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return languages.size
    }

    override fun onBindViewHolder(holder: LanguagesViewHolder, position: Int) {
        holder.render(languages[position])

        holder.itemView.setOnClickListener{
            onItemClicked(position)
        }
    }
}