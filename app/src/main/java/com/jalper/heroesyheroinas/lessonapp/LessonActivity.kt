package com.jalper.heroesyheroinas.lessonapp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import androidx.core.widget.addTextChangedListener
import com.jalper.heroesyheroinas.R
import com.jalper.heroesyheroinas.databinding.ActivityLessonBinding
import com.jalper.heroesyheroinas.databinding.DialogAddLessonBinding
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
        initListeners()
    }

    private fun initListeners(){
        binding.fabLessonsAddButton.setOnClickListener{
            showDialog()
        }
    }

    private fun showDialog(){
        val dialog = Dialog(this)

        val dialogBinding = DialogAddLessonBinding.inflate(layoutInflater)
        dialog.setContentView(dialogBinding.root)

        //Desactivamos el boton de añadir nueva leccion si la caja de texto esta vacia
        dialogBinding.etDialogAddLessonName.addTextChangedListener{ editText ->
            dialogBinding.btnDialogAddLesson.isEnabled = editText?.isNotBlank() ?: false
        }

        dialogBinding.btnDialogAddLesson.setOnClickListener{
            //Obtenemos nombre de la leccion del EditText
            val name = dialogBinding.etDialogAddLessonName.text.toString()
            //Obtenemos el id del radio button seleccionada
            val selectedId = dialogBinding.rgDialogAddLessonLanguage.checkedRadioButtonId
            val radioButtonSelected = dialogBinding.root.findViewById<RadioButton>(selectedId)
            val languageSelected = when(radioButtonSelected.text){
                "Android" -> Android
                "iOS" -> IOS
                "Flutter" -> Flutter
                else -> Android
            }

            lessonsList.add(Lesson(name, languageSelected))
            dialog.dismiss()
        }
        dialog.show()
    }

    private fun removeItem(position: Int){
        //Da fallos por culpa del índice si se han realizado filtros primero
        //Se deja por motivos de avance académico
        lessonsList.removeAt(position)
        updateLessonsListView() //Aqui esta el problema
    }

    private fun updateLessonsListView(){
        val selectedLanguage: List<Language> = languagesList.filter { it.isSelected }
        val showableLessons = lessonsList.filter { it.language in selectedLanguage }

        (binding.rvLessonLessons.adapter as LessonsAdapter).lessons = showableLessons

        binding.rvLessonLessons.adapter?.notifyDataSetChanged();
    }

    private fun updateLanguagesListView(){
        binding.rvLessonLanguages.adapter?.notifyDataSetChanged()
    }

    private fun selectLanguage(position: Int){
        languagesList[position].isSelected = !languagesList[position].isSelected
        updateLanguagesListView()
        updateLessonsListView()
    }

    private fun initUI(){
        //Creamos la lista de lenguajes de programacion
        binding.rvLessonLanguages.adapter = LanguagesAdapter(languagesList){position: Int -> selectLanguage(position)}

        //Creamos la lista de lecciones
        binding.rvLessonLessons.adapter = LessonsAdapter(lessonsList) {position: Int -> removeItem(position)}
    }
}