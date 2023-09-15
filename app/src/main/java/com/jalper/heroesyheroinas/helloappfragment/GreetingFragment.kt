package com.jalper.heroesyheroinas.helloappfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jalper.heroesyheroinas.R
import com.jalper.heroesyheroinas.databinding.FragmentGreetingBinding


class GreetingFragment : Fragment() {

    private val binding: FragmentGreetingBinding by lazy{
        FragmentGreetingBinding.inflate(layoutInflater)
    }
    private lateinit var name: String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /*Recogemos las variables de los argumentos o ponemos "Anónim@ como valor por defecto*/
        name = arguments?.getString(HelloFragment.NAME)?: getString(R.string.greeting_name_anonymous)

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /**Esta es la manera de incluir variables dentro de cadenas de strinngs.xml*/
        binding.tvGreetingName.text = getString(R.string.greeting_name, name)
    }

}