package com.example.reproductordemusicav2

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        lateinit var musica : MediaPlayer
        val seleccionado = intent.getIntExtra(KEY_SELECT, 0)

        val txt_musica = findViewById<TextView>(R.id.txt_musica)
        when(seleccionado){

            0 -> {musica = MediaPlayer.create(this, R.raw.pista1)
            txt_musica.text = "Emperadors new clothes"
            }
            1 -> {musica = MediaPlayer.create(this, R.raw.pista2)
                txt_musica.text = "Miss Jackson"
            }
            2 -> {musica = MediaPlayer.create(this, R.raw.pista3)
                txt_musica.text = "bettersweet"
            }
            3 -> {musica = MediaPlayer.create(this, R.raw.pista4)
                txt_musica.text = "One of the drunks"
            }
            4 -> {musica = MediaPlayer.create(this, R.raw.pista5)
                txt_musica.text = "Death of the barchelor"
            }
        }


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