package com.example.interaccionconimagenesv2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

import androidx.appcompat.app.AppCompatActivity


class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main2)

        val seleccionado = intent.getIntExtra(KEY_SELECT, 0)

        val boton_imagen = findViewById<ImageButton>(R.id.btn_imagen)
        when(seleccionado){
            0 -> boton_imagen.setImageResource(R.drawable.imagen1)
            1 -> boton_imagen.setImageResource(R.drawable.imagen2)
            2 -> boton_imagen.setImageResource(R.drawable.imagen3)
            3 -> boton_imagen.setImageResource(R.drawable.imagen4)
        }

        val btn_volver = findViewById<Button>(R.id.btn_volver)

        btn_volver.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(KEY_SELECT, seleccionado)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

    }
}