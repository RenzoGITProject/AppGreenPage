package com.alonsoms.appt1alonsoms

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class registrarOfertasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registrar_ofertas)

        fun mostrarMensaje(mensaje:String){
            val ventana = AlertDialog.Builder(this)
            ventana.setTitle("Mensaje Informativo")
            ventana.setMessage(mensaje)
            ventana.setPositiveButton("Aceptar", {dialogInterface:DialogInterface, i:Int->
                val intent = Intent(this,ListarOfertasActivity::class.java)
                startActivity(intent)
            })
            ventana.create().show()
        }

    }
}