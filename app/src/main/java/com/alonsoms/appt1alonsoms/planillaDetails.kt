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

class planillaDetails : AppCompatActivity() {

    private lateinit var txtNombre: EditText
    private lateinit var txtSueldo: EditText
    private lateinit var txtEdad: EditText
    private lateinit var txtNumHijos: EditText
    private lateinit var btnCalcular: Button
    private lateinit var btnRegresar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_planilla_details)

        setReferencias()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun setReferencias(){
        txtNombre = findViewById(R.id.txtNombre)
        txtSueldo = findViewById(R.id.txtSueldo)
        txtEdad = findViewById(R.id.txtEdad )
        txtNumHijos = findViewById(R.id.txtHijos)
        btnCalcular = findViewById(R.id.btnPlanilla)
        btnRegresar = findViewById(R.id.btnRegresar)

        btnCalcular.setOnClickListener {
            getDatos()
        }

        btnRegresar.setOnClickListener {
            val intent = Intent(this,InicioActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getDatos(){
        val nombre = txtNombre.text.toString()
        val sueldo = txtSueldo.text.toString()
        val edad = txtEdad.text.toString()
        val hijos = txtNumHijos.text.toString()

        var valida:Boolean=true

        if (nombre.isEmpty()){
            txtNombre.error = "Nombre es obligatorio"
            valida=false
        }
        if (sueldo.isEmpty()){
            txtSueldo.error = "Sueldo es obligatorio"
            valida=false
        }

        if (edad.isEmpty()){
            txtEdad.error = "Edad es obligatorio"
            valida=false
        }

        if (hijos.isEmpty()){
            txtNumHijos.error = "Hijos es obligatorio"
            valida=false
        }

        if (valida){
            viewResultado(nombre,sueldo, edad, hijos)
        }
    }

    fun viewResultado(nombre:String, sueldo:String, edad:String, hijos:String){
        val ventana = AlertDialog.Builder(this)
        var bono:Double=0.0

        // Calcular Bono
        if (edad.toInt() >= 20 && edad.toInt()<=30 ){
            bono = sueldo.toInt() * 0.20
        }
        if (edad.toInt() >= 31 && edad.toInt()<=50 ){
            bono = sueldo.toInt() * 0.30
        }
        if (edad.toInt() > 50  ){
            bono = sueldo.toInt() * 0.50
        }

        var aguinaldo = hijos.toInt() * 50

        var sueldoPagar = sueldo.toInt() + bono  + aguinaldo

        var mensaje ="Nombre " + nombre + "\n Sueldo Base " + sueldo + " Bono % " + bono + " Sueldo + Bono " + (sueldo.toInt() + bono) + " Aguinaldo hijos " + aguinaldo + " SUELDO A PAGAR " + sueldoPagar

        ventana.setTitle("Mensaje")
        ventana.setMessage(mensaje)
        ventana.setPositiveButton("Aceptar",null)
        ventana.create().show()
    }
}