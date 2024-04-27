package com.example.interaccionconimagenesv2

import android.app.Activity
import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Spinner
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity

const val KEY_SELECT = "clave"
const val REQUEST_CODE = 123

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner = findViewById<Spinner>(R.id.spn_opciones)
        val opciones = listOf("imagen1", "imagen2", "imagen3", "imagen4")
        val adapter = ArrayAdapter(this, com.google.android.material.R.layout.mtrl_auto_complete_simple_item, opciones)
        spinner.adapter = adapter



        val button = findViewById<Button>(R.id.btn_siguiente)
        button.setOnClickListener(){
            val seleccionado = spinner.selectedItemPosition //preparando la informacion para el casmbio de actividad

            val intent = Intent(this, MainActivity2::class.java) // para sdaber a donde estoy yendo
            intent.putExtra(KEY_SELECT, seleccionado)

            startActivityForResult(intent, REQUEST_CODE)
        }

    }
    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                // Recuperamos la posicion del seleccionado antes de cambiar de actividad
                val seleccionado = data?.getIntExtra(KEY_SELECT, 0).toString().toInt()
                val spinner = findViewById<Spinner>(R.id.spn_opciones)
                spinner.setSelection(seleccionado)

            }
        }
    }
}