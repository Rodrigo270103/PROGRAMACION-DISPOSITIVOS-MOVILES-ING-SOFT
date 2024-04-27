package com.example.interaccionconimagenesv3

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner

const val KEY_SELECT = "clave"
const val REQUEST_CODE = "123"

class MenuFragments : Fragment(R.layout.fragment_menu_fragments) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val spinner = view.findViewById<Spinner>(R.id.spn_opciones)
        val opciones = listOf("imagen1", "imagen2", "imagen3", "imagen4")
        val adapter = ArrayAdapter(
            requireContext(),
            com.google.android.material.R.layout.mtrl_auto_complete_simple_item,
            opciones
        )
        spinner.adapter = adapter


        val button = view.findViewById<Button>(R.id.btn_siguiente)
        button.setOnClickListener() {
            val seleccionado = spinner.selectedItemPosition

            requireActivity().supportFragmentManager.beginTransaction().apply {
                replace(R.id.FragmentMenu, InteraccionFragment.newInstance(seleccionado))
                addToBackStack(REQUEST_CODE)
                commit()
            }


        }
    }
}