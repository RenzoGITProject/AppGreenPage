package com.alonsoms.appt1alonsoms

import android.content.Intent
import android.icu.text.AlphabeticIndex.Bucket.LabelType
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.alonsoms.appt1alonsoms.entities.Persona
import com.alonsoms.appt1alonsoms.entities.clasemodelos.Usuario
import com.alonsoms.appt1alonsoms.model.PersonaModel
import com.alonsoms.appt1alonsoms.model.UsuarioModel

class InicioSesionActivity : AppCompatActivity() {

    private lateinit var btnIniciarSesion: Button
    private lateinit var lblRegistrarUsuario: TextView
    private lateinit var txtUsuario: EditText
    private lateinit var txtPassword: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_loginpage)
        setReferencias()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }

    fun setReferencias(){

        btnIniciarSesion = findViewById(R.id.btningresar)
        //btnRegistrarUsuario = findViewById(R.id.lblregistrar)
        lblRegistrarUsuario = findViewById(R.id.lblregistrar)
        txtPassword = findViewById(R.id.txtclave)
        txtUsuario = findViewById(R.id.txtusuario)

        btnIniciarSesion.setOnClickListener {
            var usuarioModel = UsuarioModel(this)

            var existe = usuarioModel.existeUsuario(txtUsuario.text.toString(), txtPassword.text.toString());

            if(existe){
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
            }
            else{
                val alertDialogBuilder = AlertDialog.Builder(this)
                alertDialogBuilder.setTitle(title)
                alertDialogBuilder.setMessage("Usuario no encontrado")
                alertDialogBuilder.setPositiveButton("OK") { dialog, _ ->
                    // Aquí puedes añadir código para manejar el botón OK, si es necesario
                    dialog.dismiss()
                }
                val alertDialog = alertDialogBuilder.create()
                alertDialog.show()
            }
        }

        lblRegistrarUsuario.setOnClickListener {
            val intent = Intent(this,RegistroUsuarioActivity::class.java)
            startActivity(intent)
        }

    }
}