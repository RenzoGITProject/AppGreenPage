package com.alonsoms.appt1alonsoms

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.alonsoms.appt1alonsoms.entities.clasemodelos
import com.alonsoms.appt1alonsoms.model.PersonaDAO

class registrarOfertasActivity : AppCompatActivity() {

    private lateinit var txtMontoSoles: EditText
    private lateinit var btnRegistrarOferta: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registrar_ofertas)
        asignarReferencias()
    }
    fun asignarReferencias() {

        txtMontoSoles = findViewById(R.id.txtMontoSoles)
        btnRegistrarOferta= findViewById(R.id.btnRegistrarOferta)
        btnRegistrarOferta.setOnClickListener {
            capturarDatos()
        }
    }

    fun capturarDatos() {
        val precioOferta = txtMontoSoles.text.toString()

        var valida = true

        if (precioOferta.isEmpty()) {
            valida = false
            txtMontoSoles.setError("MontoSoles es obligatorio")
        }

        if (valida) {
            val ofertas = clasemodelos.Oferta()
            ofertas.precioOferta = precioOferta.toFloat()

            registrar(ofertas)

        }
    }
    fun registrar(oferta: clasemodelos.Oferta){
        val personaDAO = PersonaDAO(this)
        val mensaje = personaDAO.registrarOferta(oferta)
        mostrarMensaje(mensaje)
    }

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
