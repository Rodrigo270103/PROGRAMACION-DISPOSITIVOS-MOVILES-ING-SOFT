package com.example.interaccionconimagenes

import android.media.Image
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val boton_imagen = findViewById<ImageButton>(R.id.btn_imagen)
        boton_imagen.setOnClickListener(){
            val mensaje = "hola usuario"
            Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
        }

    }
}