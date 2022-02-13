package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.android.volley.Request
import com.android.volley.Response


class Modificar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modificar)

        var textview_id = findViewById<TextView>(R.id.textView4)

        var ObjetoIntnent: Intent = intent
        var id = ObjetoIntnent.getStringExtra("id_prod")
        var precio = ObjetoIntnent.getStringExtra("precio")
        var nombre = ObjetoIntnent.getStringExtra("Nombre")


        var nombreprod = findViewById<EditText>(R.id.nombreprod)
        var precioprod = findViewById<EditText>(R.id.precioprod)
        var modifica = findViewById<Button>(R.id.button6)


        textview_id.text = id;
        nombreprod.setText(nombre)
        precioprod.setText(precio)


        modifica.setOnClickListener {
            var funciona = findViewById<TextView>(R.id.textView8)
            //aquí escribimos el código para invocar php
            val url = "http://172.23.176.1/Android/modificarproductos.php?nombre="+nombreprod.text.toString()+"&precio="+precioprod.text.toString()+"&id="+id+"&quot;"
            val queue = Volley.newRequestQueue(this)
            val stringRequest = StringRequest(Request.Method.GET,url, Response.Listener { response ->
                funciona.text ="Se ha modificado correctamente"
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