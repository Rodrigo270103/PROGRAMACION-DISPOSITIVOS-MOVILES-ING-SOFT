package com.example.interaccionconimagenesv3

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton


class InteraccionFragment : Fragment(R.layout.fragment_interaccion) {
    private var seleccion: Int? = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        seleccion = requireArguments().getInt(KEY_SELECT)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val boton_imagen = view.findViewById<ImageButton>(R.id.btn_imagen)
        when(seleccion){
            0 -> boton_imagen.setImageResource(R.drawable.imagen1)
            1 -> boton_imagen.setImageResource(R.drawable.imagen2)
            2 -> boton_imagen.setImageResource(R.drawable.imagen3)
            3 -> boton_imagen.setImageResource(R.drawable.imagen4)
        }

        val btn_volver = view.findViewById<Button>(R.id.btn_volver)

        btn_volver.setOnClickListener(){
            //requireActivity().supportFragmentManager.setFragmentResult(REQUEST_CODE, bundleOf(
                //KEY_MSG to getString(R.string.txt_volvimos)))
            requireActivity().supportFragmentManager.popBackStack()
        }




    }
    companion object {

        // Fun para pasar información
        fun newInstance(seleccionado: Int) = InteraccionFragment().apply {
            // 1ra forma
            val datos = Bundle()
            datos.putInt(KEY_SELECT, seleccionado)
            arguments = datos

            // 2da forma
            //arguments.bundleOf(KEY_TEXT to nombre, KEY_IMG to edad)

        }
    }
}