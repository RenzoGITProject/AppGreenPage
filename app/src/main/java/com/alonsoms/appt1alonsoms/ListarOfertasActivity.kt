package com.alonsoms.appt1alonsoms

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.alonsoms.appt1alonsoms.model.PersonaDAO
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListarOfertasActivity : AppCompatActivity() {

    private lateinit var btnAgregarMonto:FloatingActionButton
    private lateinit var personaDAO: PersonaDAO


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_listar_ofertas)

        asignarReferencias()
        mostrarOfertas()
    }

    fun mostrarOfertas(){
        val listaOferta = personaDAO.cargarOferta()

    }
    fun asignarReferencias(){
        btnAgregarMonto =findViewById(R.id.btnAgregarMonto)
        btnAgregarMonto.setOnClickListener {
            val intent = Intent(this,registrarOfertasActivity::class.java)
            startActivity(intent)
        }
        personaDAO = PersonaDAO(this)
    }
}