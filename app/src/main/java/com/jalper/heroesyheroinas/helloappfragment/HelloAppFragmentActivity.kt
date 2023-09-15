package com.jalper.heroesyheroinas.helloappfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.jalper.heroesyheroinas.R
import com.jalper.heroesyheroinas.databinding.ActivityHelloAppFragmentBinding

class HelloAppFragmentActivity : AppCompatActivity() {

    private val binding: ActivityHelloAppFragmentBinding by lazy{
        ActivityHelloAppFragmentBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //Cargamos fragmentos
        loadFragment(HelloFragment())
    }

    private fun loadFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.fcv_hello2_container, fragment).commit()
    }

    fun navigateToGreetingFragment(nameKey: String, nameValue: String){
        val fragment = GreetingFragment()
        val bundle = Bundle()
        bundle.putString(nameKey, nameValue)
        fragment.arguments = bundle

        loadFragment(fragment)
    }
}