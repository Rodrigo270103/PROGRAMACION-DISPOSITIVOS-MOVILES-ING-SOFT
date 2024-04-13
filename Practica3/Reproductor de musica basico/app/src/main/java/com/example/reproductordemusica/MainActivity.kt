package com.example.reproductordemusica

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var musica = MediaPlayer.create(this, R.raw.pista1)
        val btn_reproducir = findViewById<Button>(R.id.btn_reproducir)
        btn_reproducir.setOnClickListener() {
            musica.start()
        }

        val btn_pausar = findViewById<Button>(R.id.btn_pausar)
        btn_pausar.setOnClickListener() {
            musica.pause()
        }

        val btn_detener = findViewById<Button>(R.id.btn_detener)
        btn_detener.setOnClickListener() {
            if (musica.isPlaying) {
                musica.stop()
                musica.prepare()
            }
        }

    }
}