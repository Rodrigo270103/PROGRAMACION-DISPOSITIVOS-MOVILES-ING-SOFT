package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Obtener una referencia al botón playButton
        val playButton: Button = findViewById(R.id.playButton)

        // Configurar el OnClickListener para el botón playButton
        playButton.setOnClickListener {
            // Crear un Intent para iniciar MainActivity2
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }
}
