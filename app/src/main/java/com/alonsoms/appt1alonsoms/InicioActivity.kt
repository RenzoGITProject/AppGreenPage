package com.alonsoms.appt1alonsoms

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.alonsoms.appt1alonsoms.databinding.ActivityInicioBinding
import com.alonsoms.appt1alonsoms.util.DrawerBaseActivity
//import com.alonsoms.databinding.ActivityInicioBinding

class InicioActivity : DrawerBaseActivity() {

    private lateinit var activityInicioBinding: ActivityInicioBinding

    private lateinit var btnPlanilla: Button
    private lateinit var btnPersona: Button
    private lateinit var btnInterface: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // enableEdgeToEdge()
        activityInicioBinding = ActivityInicioBinding.inflate(layoutInflater)
        setContentView(activityInicioBinding.root)
       // setContentView(R.layout.activity_inicio)

        setReferencias()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun setReferencias(){

        btnPlanilla = findViewById(R.id.btnPlanilla)
        btnPersona = findViewById(R.id.btnPersona)
        btnInterface = findViewById(R.id.btnInterface)

        btnPlanilla.setOnClickListener {
            val intent = Intent(this,planillaDetails::class.java)
            startActivity(intent)
        }

        btnPersona.setOnClickListener {
            val intent = Intent(this,RegistroLibrosActivity::class.java)
            startActivity(intent)
        }

        btnInterface.setOnClickListener {
            val intent = Intent(this,ListarOfertasActivity::class.java)
            startActivity(intent)
        }

    }
}