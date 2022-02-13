package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class producto_eliminado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_producto_eliminado)
        var ObjetoIntnent: Intent = intent
        var id = ObjetoIntnent.getStringExtra("id_prod")
        var nombre = ObjetoIntnent.getStringExtra("nombre")
        var precio = ObjetoIntnent.getStringExtra("precio")

        var nombre_prod = findViewById<TextView>(R.id.nombre_prod_e)
        var precio_prod = findViewById<TextView>(R.id.precio_prod_e)
        var eliminado = findViewById<Button>(R.id.eliminar)

        nombre_prod.text = nombre
        precio_prod.text = precio

        eliminado.setOnClickListener {
            var funciona = findViewById<TextView>(R.id.textView11)
            //aquí escribimos el código para invocar php
            val url = "http://172.23.176.1/Android/eliminarproducto.php?id="+id+"&quot;"
            val queue = Volley.newRequestQueue(this)
            val stringRequest = StringRequest(Request.Method.GET,url, Response.Listener { response ->
                funciona.text ="Se ha eliminado correctamente"

                Handler(Looper.getMainLooper()).postDelayed({
                    val cambiando = Intent(this, MainActivity::class.java)

                    startActivity(cambiando)

                }, 3000)

            }, Response.ErrorListener {
                funciona.text = "Algo ha fallado"
            })
            queue.add(stringRequest)
        }

    }
    }
