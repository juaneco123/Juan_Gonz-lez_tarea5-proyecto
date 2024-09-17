package com.example.juan_gonzlez_herramientas_de_programacin_mvils5

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class ListaVendedoresActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_vendedores)
    }
}

class GraficoVentasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grafico_ventas)
    }
}

class MainActivity : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonListaVendedores = findViewById<Button>(R.id.button_lista_vendedores)
        val buttonGraficoVentas = findViewById<Button>(R.id.button_grafico_ventas)

        buttonListaVendedores.setOnClickListener {
            // Navegandoo a la lista de vendedores
            val intent = Intent(this, ListaVendedoresActivity::class.java)
            startActivity(intent)
        }

        buttonGraficoVentas.setOnClickListener {
            // ir a la actividad del gráfico de ventas
            val intent = Intent(this, GraficoVentasActivity::class.java)
            startActivity(intent)
        }
        val animacionView = findViewById<ImageView>(R.id.animacion_view)
        animacionView.setBackgroundResource(R.drawable.animacion_imagen)
        val animationDrawable = animacionView.background as AnimationDrawable
        animationDrawable.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        if (::mediaPlayer.isInitialized) {
            mediaPlayer.release()
        }
    }
}
