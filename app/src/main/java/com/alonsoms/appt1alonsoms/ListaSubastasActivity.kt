package com.alonsoms.appt1alonsoms

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.alonsoms.appt1alonsoms.databinding.ActivityInicioBinding
import com.alonsoms.appt1alonsoms.databinding.ActivityListaSubastasBinding
import com.alonsoms.appt1alonsoms.util.DrawerBaseActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListaSubastasActivity : DrawerBaseActivity() {

    private lateinit var activityListaSubastasBinding: ActivityListaSubastasBinding
    private lateinit var btnOfertar:FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        activityListaSubastasBinding = ActivityListaSubastasBinding.inflate(layoutInflater)
        setContentView(activityListaSubastasBinding.root)

        asignarReferencias()
    }
    fun asignarReferencias(){
        btnOfertar = findViewById(R.id.btnofertar)
        btnOfertar.setOnClickListener {
            val intent = Intent(this,ListarOfertasActivity::class.java)
            startActivity(intent)
        }
    }
}