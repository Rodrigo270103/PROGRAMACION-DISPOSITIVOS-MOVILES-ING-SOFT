package com.example.interaccionconimagenesv2

import android.media.Image
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val texto_personalizado = findViewById<EditText>(R.id.txt_personalizado)

        val boton_imagen = findViewById<ImageButton>(R.id.btn_imagen)
        boton_imagen.setOnClickListener(){
            val mensaje = texto_personalizado.text
            Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
        }


    }
}