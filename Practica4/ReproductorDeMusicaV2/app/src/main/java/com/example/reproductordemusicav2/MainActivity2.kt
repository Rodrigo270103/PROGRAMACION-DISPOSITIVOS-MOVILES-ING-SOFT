package com.example.reproductordemusicav2

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        lateinit var musica : MediaPlayer
        val seleccionado = intent.getIntExtra(KEY_SELECT, 0)


        when(seleccionado){
            0 -> musica = MediaPlayer.create(this, R.raw.pista1)
            1 -> musica = MediaPlayer.create(this, R.raw.pista2)
            2 -> musica = MediaPlayer.create(this, R.raw.pista3)
            3 -> musica = MediaPlayer.create(this, R.raw.pista4)
            4 -> musica = MediaPlayer.create(this, R.raw.pista5)
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