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
import com.alonsoms.appt1alonsoms.entities.clasemodelos.Usuario
import com.alonsoms.appt1alonsoms.model.PersonaModel
import com.alonsoms.appt1alonsoms.model.UsuarioModel

class InicioSesionActivity : AppCompatActivity() {

    private lateinit var btnIniciarSesion: Button
    private lateinit var btnRegistrarUsuario: Button
    private lateinit var txtUsuario: EditText
    private lateinit var txtPassword: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_loginpage)
        setReferencias()

    }

    fun setReferencias(){

        btnIniciarSesion = findViewById(R.id.btningresar)
        btnRegistrarUsuario = findViewById(R.id.lblregistrar)
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

        btnRegistrarUsuario.setOnClickListener {
            val intent = Intent(this,RegistroUsuarioActivity::class.java)
            startActivity(intent)
        }

    }
}