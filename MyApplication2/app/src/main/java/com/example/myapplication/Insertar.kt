package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject

class Insertar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insertar)

        var insertar = findViewById<Button>(R.id.insertar)
      var name_product =findViewById<EditText>(R.id.Nombre_prod)
        var precio2 =findViewById<TextView>(R.id.precio2)
        var precio =findViewById<EditText>(R.id.Precio)



        insertar.setOnClickListener {
            //aquí escribimos el código para invocar php
            val url = "http://172.23.176.1/Android/insertar.php?nombre="+name_product.text.toString()+"&precio="+precio.text.toString()+"&quot;"
            val queue = Volley.newRequestQueue(this)
            val stringRequest = StringRequest(Request.Method.GET,url, Response.Listener { response ->
                precio2.text = "Registro guardado"

                Handler(Looper.getMainLooper()).postDelayed({
                    val cambiando = Intent(this, MainActivity::class.java)

                    startActivity(cambiando)

                }, 3000)

            }, Response.ErrorListener {
                precio2.text = "Algo ha fallado"
            })
            queue.add(stringRequest)
        }

    }

}