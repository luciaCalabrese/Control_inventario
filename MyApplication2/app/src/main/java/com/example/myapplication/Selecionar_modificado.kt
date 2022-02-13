package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject

class Selecionar_modificado : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selecionar_modificado)

        val tv1 = findViewById<TextView>(R.id.textView3)
        val list1 = findViewById<ListView>(R.id.lista)
        val url = "http://172.23.176.1/Android/mostrarproductos.php?nombre=\"+name_product.text.toString()"
    verproductos(url)

    }
    private fun verproductos(url2: String) {
        var productos_nombre = mutableListOf<String>()
        val tv1 = findViewById<TextView>(R.id.textView3)
        val list1 = findViewById<ListView>(R.id.lista)

        val queue = Volley.newRequestQueue(this)
        val stringRequest = StringRequest(Request.Method.GET, url2, { response ->
            val jsonArray = JSONArray(response)
            for (num in 0..jsonArray.length()-1) {
                val jsonObject = JSONObject(jsonArray.getString(num))
                var auxnombre = jsonObject.get("Nombre")
                var precio = jsonObject.get("precio")
                productos_nombre.add("Nombre "+auxnombre.toString() +" /Precio: "+ precio.toString())
            }
            val adaptador1 = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, productos_nombre)
            list1.adapter = adaptador1

            list1.setOnItemClickListener { adapterView, view, i, l ->
                val jsonObject = JSONObject(jsonArray.getString(i))
                var id_prod =jsonObject.get("Id_prod").toString()
                var precio =jsonObject.get("precio").toString()
                var nombre =jsonObject.get("Nombre").toString()

                val cambiando = Intent(this, Modificar::class.java)
                cambiando.putExtra("id_prod", id_prod)
                cambiando.putExtra("precio",precio)
                cambiando.putExtra("Nombre",nombre)
                startActivity(cambiando)
            }
        }, { error ->
            tv1.text = "No conectado"
        })
        queue.add(stringRequest)
    }

}