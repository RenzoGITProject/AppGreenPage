package com.alonsoms.appt1alonsoms

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.alonsoms.appt1alonsoms.entities.clasemodelos.Usuario
import com.alonsoms.appt1alonsoms.model.UsuarioModel

class RegistroUsuarioActivity : AppCompatActivity() {
    private lateinit var btnRegistro: Button
    private lateinit var btnGuardar:Button
    private lateinit var txtUsuario: EditText
    private lateinit var txtusername: EditText
    private lateinit var txtCorreo: EditText
    private lateinit var txtPassword: EditText
    private lateinit var txtPasswordConfirm: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registro)
        setReferencias()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }

    fun setReferencias(){

        btnGuardar = findViewById(R.id.btnregistrar)
        txtPassword = findViewById(R.id.txtclaveregistro)
        txtUsuario = findViewById(R.id.txtusuarioregistro)
        txtCorreo = findViewById(R.id.txtemail)
        txtusername = findViewById(R.id.txtusuarioregistro)
        txtPasswordConfirm = findViewById(R.id.txtclaveregistro)

        btnGuardar.setOnClickListener {
            var usuarioModel = UsuarioModel(this)
            var user = Usuario();
            user.correo = txtCorreo.text.toString();
            user.contrasena = txtPassword.text.toString();
            user.username = txtUsuario.text.toString();
            user.nombres = txtusername.text.toString();

            if(user.contrasena != txtPasswordConfirm.text.toString())
            {
                txtPasswordConfirm.error = "La contraseña no coincide"
            }
            else{
                var mensaje = usuarioModel.saveUsuario(user);

                if(mensaje.contains("correctamente"))
                {
                    Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
                    val intent = Intent(this,InicioSesionActivity::class.java)
                    startActivity(intent)
                }
                else
                {
                    val alertDialogBuilder = AlertDialog.Builder(this)
                    alertDialogBuilder.setTitle(title)
                    alertDialogBuilder.setMessage(mensaje)
                    alertDialogBuilder.setPositiveButton("OK") { dialog, _ ->
                        // Aquí puedes añadir código para manejar el botón OK, si es necesario
                        dialog.dismiss()
                    }
                    val alertDialog = alertDialogBuilder.create()
                    alertDialog.show()
                }

            }

        }
    }
}