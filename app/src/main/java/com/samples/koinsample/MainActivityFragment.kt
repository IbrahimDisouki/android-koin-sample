package com.samples.koinsample

import android.content.SharedPreferences
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_main.*
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject

/**
 * A placeholder fragment containing a simple view.
 */
class MainActivityFragment : Fragment() {

    private val parent: Parent by inject("Parent2")

    private val myPreference: SharedPreferences by inject()
//    private val singletonValue: String by inject("SingletonValue")
//    private val factoryValue: String by inject("FactoryValue")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        parent.logFullName()

        button.setOnClickListener {
            myPreference.edit().putString("name", editText.text.toString()).apply()
        }

        button2.setOnClickListener {
            textView.setText(get<String>("SingletonValue"))
        }

        button3.setOnClickListener {
            textView.setText(get<String>("FactoryValue"))
        }

    }
}
