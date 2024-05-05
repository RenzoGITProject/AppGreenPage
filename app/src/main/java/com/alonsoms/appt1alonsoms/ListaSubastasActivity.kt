package com.alonsoms.appt1alonsoms

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListaSubastasActivity : AppCompatActivity() {

    private lateinit var btnOfertar:FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lista_subastas)

        asignarReferencias()
    }
    fun asignarReferencias(){
        btnOfertar = findViewById(R.id.btnOfertar)
        btnOfertar.setOnClickListener {
            val intent = Intent(this,ListarOfertasActivity::class.java)
            startActivity(intent)
        }
    }
}