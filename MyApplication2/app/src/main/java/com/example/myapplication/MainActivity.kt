package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      //  val url = "https://www.google.com"
        val Saludos =  findViewById<Button>(R.id.button3)

        Saludos.setOnClickListener {

            val cambiando = Intent(this, MainActivity2::class.java)

            startActivity(cambiando)

        }
        val Insertara =  findViewById<Button>(R.id.button4)

        Insertara.setOnClickListener {

            val cambiando = Intent(this, Insertar::class.java)

            startActivity(cambiando)

        }
        val Modifica =  findViewById<Button>(R.id.button5)

        Modifica.setOnClickListener {

            val cambiando = Intent(this, Selecionar_modificado::class.java)

            startActivity(cambiando)

        }

        val Eliminar =  findViewById<Button>(R.id.button7)

        Eliminar.setOnClickListener {

            val cambiando = Intent(this, Eliminar_producto::class.java)

            startActivity(cambiando)

        }
    }
}