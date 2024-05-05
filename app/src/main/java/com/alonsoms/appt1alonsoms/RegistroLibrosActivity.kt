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

class RegistroLibrosActivity : AppCompatActivity() {

    private lateinit var txtTitulo:EditText
    private lateinit var txtEstado:EditText
    private lateinit var txtSinopsis:EditText
    private lateinit var txtPrecioBase:EditText
    private lateinit var btnRegistrarLibro:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registro_libros)

        asignarReferencias()
    }
    fun asignarReferencias() {

        txtTitulo = findViewById(R.id.txtTitulo)
        txtEstado = findViewById(R.id.txtEstado)
        txtSinopsis = findViewById(R.id.txtSinopsis)
        txtPrecioBase = findViewById(R.id.txtPreciobase)
        btnRegistrarLibro= findViewById(R.id.btnRegistrarLibro)
        btnRegistrarLibro.setOnClickListener {
            capturarDatos()
        }
    }

    fun capturarDatos() {
        val titulo = txtTitulo.text.toString()
        val estado = txtEstado.text.toString()
        val sinopsis = txtSinopsis.text.toString()
        var preciobase = txtPrecioBase.text.toString()
        var valida = true

        if (titulo.isEmpty()) {
            valida = false
            txtTitulo.setError("titulo es obligatorio")
        }
        if (estado.isEmpty()) {
            valida = false
            txtEstado.setError("estado son obligatorios")
        }
        if (sinopsis.isEmpty()) {
            valida = false
            txtSinopsis.setError("sinopsis es obligatorio")
        }
        if (preciobase.isEmpty()) {
            valida = false
            txtPrecioBase.setError("preciobase es obligatorio")
        }

        if (valida) {
            val libro = clasemodelos.Libro()
            libro.titulo = titulo
            libro.estado = estado
            libro.sinopsis = sinopsis
            libro.preciobase = preciobase.toInt().toFloat()
            registrar(libro)

        }
    }
        fun registrar(libro: clasemodelos.Libro){
            val personaDAO = PersonaDAO(this)
            val mensaje = personaDAO.registrarLibro(libro)
            mostrarMensaje(mensaje)
        }
        fun mostrarMensaje(mensaje:String){
            val ventana = AlertDialog.Builder(this)
            ventana.setTitle("Mensaje Informativo")
            ventana.setMessage(mensaje)
            ventana.setPositiveButton("Aceptar",null)

            ventana.create().show()
        }

}

