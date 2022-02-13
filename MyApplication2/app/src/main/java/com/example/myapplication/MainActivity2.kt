package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject

class MainActivity2 : AppCompatActivity() {
    lateinit var listado: TextView
    lateinit var listado2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        listado = findViewById<TextView>(R.id.listado)
        listado2 = findViewById<TextView>(R.id.nombre)

        //ipconfig - ipv4
        val url = "http://172.23.176.1/Android/mostrarproductos.php"
        val Saludos = findViewById<Button>(R.id.button)

        Saludos.setOnClickListener {
            verproductos(url)
        }


    }

    private fun verproductos(url2: String) {
        val queue = Volley.newRequestQueue(this)
        val stringRequest = StringRequest(Request.Method.GET, url2, Response.Listener { response ->
            val jsonArray = JSONArray(response)
            print(jsonArray)
            val jsonObject = JSONObject(jsonArray.getString(0))
            var auxnombre = jsonObject.get("Nombre")
            listado.text = jsonObject.toString()
            listado2.text = auxnombre.toString()
        }, Response.ErrorListener { error ->
            listado.text = "No conectado"
        })
        queue.add(stringRequest)
    }

}