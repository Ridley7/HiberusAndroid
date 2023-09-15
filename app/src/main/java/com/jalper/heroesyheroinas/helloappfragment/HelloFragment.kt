package com.jalper.heroesyheroinas.helloappfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jalper.heroesyheroinas.R
import com.jalper.heroesyheroinas.databinding.FragmentHelloBinding


class HelloFragment : Fragment() {

    private val binding: FragmentHelloBinding by lazy{
        FragmentHelloBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.moduleSendName.btnButton.setOnClickListener{
            val nameEditText = binding.moduleSendName.etMainName.text
            if(!nameEditText.isNullOrBlank()){
               // (activity as Hello2mainActivity).navigateToGreetingFragment(NAME, nameEditText.toString())
                (activity as HelloAppFragmentActivity).navigateToGreetingFragment(NAME, nameEditText.toString())
            }
        }
    }

    /** Tod o lo que se incluye en un companion object puede ser accedido
     * desde otra clase invocando esta sin instanciarla. Para obtener la
     * constante NAME podemos acceder a ella desde cualquier lugar
     * utilizando Fragment.NAME
     */
    companion object {
        const val NAME = "clave_nombre"
    }
}