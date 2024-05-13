package com.alonsoms.appt1alonsoms

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.alonsoms.appt1alonsoms.entities.Persona
import com.alonsoms.appt1alonsoms.model.PersonaModel

class personalDetails : AppCompatActivity() {

    // Declarar cada control de la UI
    private lateinit var txtDNI: EditText
    private lateinit var txtNombres: EditText
    private lateinit var txtCorreo: EditText
    private lateinit var btnRegistrar: Button
    private lateinit var btnRegresar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_personal_details)

        setReferencias()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun setReferencias(){
        txtDNI = findViewById(R.id.txtMontoSoles)
        txtNombres = findViewById(R.id.txtEstado)
        txtCorreo = findViewById(R.id.txtPreciobase)
        btnRegistrar = findViewById(R.id.btnRegistrarLibro)
        btnRegresar = findViewById(R.id.btnRegresar)

        btnRegistrar.setOnClickListener {
            getDatos()
        }

        btnRegresar.setOnClickListener {
            val intent = Intent(this,InicioActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getDatos(){
        val dni = txtDNI.text.toString()
        val nombres = txtNombres.text.toString()
        val correo = txtCorreo.text.toString()
        var isValid:Boolean=true

        if (dni.isEmpty()){
            txtDNI.error = "DNI es obligatorio"
            isValid=false
        }
        if (nombres.isEmpty()){
            txtNombres.error = "Nombre es obligatorio"
            isValid=false
        }
        if (correo.isEmpty()){
            txtCorreo.error = "Correo es obligatorio"
            isValid=false
        }

        if(isValid){
            val persona  = Persona()
            persona.dni= dni.toInt()
            persona.nombres = nombres
            persona.correo = correo

            var personaModel = PersonaModel(this)

            //Configurar alerta para mensaje
            val mensaje = personaModel.savePersona(persona)
            val alertDialog = AlertDialog.Builder(this)
            alertDialog.setTitle("Mensaje Informativo")
            alertDialog.setMessage(mensaje)
            alertDialog.setPositiveButton("OK") { dialog, _ ->

                // Aquí puedes manejar la acción al hacer clic en el botón OK
                txtCorreo.text.clear()
                txtDNI.text.clear()
                txtNombres.text.clear()

                dialog.dismiss() // Cierra el diálogo

                // Abrir otro formulario
                val intent = Intent(this,personaList::class.java)
                startActivity(intent)
            }
            alertDialog.create().show()

        }
    }
}