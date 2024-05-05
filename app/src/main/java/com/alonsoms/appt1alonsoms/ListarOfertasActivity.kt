package com.alonsoms.appt1alonsoms

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alonsoms.appt1alonsoms.model.PersonaDAO
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListarOfertasActivity : AppCompatActivity() {

    private lateinit var btnAgregarMonto:FloatingActionButton
    private  lateinit var rvOfertas:RecyclerView
    private lateinit var personaDAO: PersonaDAO
    private var adaptador:AdaptadorPersonalizado = AdaptadorPersonalizado()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_listar_ofertas)

        asignarReferencias()
        mostrarOfertas()
    }

    fun mostrarOfertas(){
     val listaOfertas = personaDAO.cargarOferta()
      adaptador.agregarDatos(listaOfertas)

    }
    fun asignarReferencias(){
        btnAgregarMonto =findViewById(R.id.btnAgregarMonto)
        btnAgregarMonto.setOnClickListener {
            val intent = Intent(this,registrarOfertasActivity::class.java)
            startActivity(intent)
        }
        personaDAO = PersonaDAO(this)

        rvOfertas = findViewById(R.id.rvOfertas)
        rvOfertas.layoutManager=LinearLayoutManager(this)
        rvOfertas.adapter = adaptador
    }
}