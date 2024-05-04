package com.alonsoms.appt1alonsoms.model


import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.util.Log

import com.alonsoms.appt1alonsoms.entities.Persona
import com.alonsoms.appt1alonsoms.util.SQLiteHelper

class PersonaModel(context: Context) {
    private val sqLiteHelper: SQLiteHelper = SQLiteHelper(context)

    fun savePersona(persona: Persona): String {
        var respuesta = ""
        val db = sqLiteHelper.writableDatabase

        try {
            val valores = ContentValues()

            valores.put("dni", persona.dni)
            valores.put("nombres", persona.nombres)
            valores.put("correo", persona.correo)

            val rpta = db.insert("persona", null, valores)

            if(rpta == -1L) {
                respuesta = "Error al insertar persona"
            } else {
                respuesta = "Se registro correctamente"
            }

        } catch (e: Exception) {
            Log.d("===", e.message.toString())
            respuesta = "Ocurrio un error"
        } finally {
            db.close()
        }
        return respuesta
    }

    fun getPersonas(): ArrayList<Persona> {

        val listPersonas: ArrayList<Persona> = ArrayList()
        val query = "SELECT * FROM personas"
        val db = sqLiteHelper.readableDatabase

        val cursor: Cursor
        try {
            cursor = db.rawQuery(query, null)
            cursor.moveToFirst()

            do {
                val id: Int = cursor.getInt(cursor.getColumnIndexOrThrow("id"))
                val dni: Int = cursor.getInt(cursor.getColumnIndexOrThrow("dni"))
                val nombres: String = cursor.getString(cursor.getColumnIndexOrThrow("nombres"))
                val correo: String = cursor.getString(cursor.getColumnIndexOrThrow("correo"))

                val persona = Persona()
                persona.id = id
                persona.dni = dni
                persona.nombres = nombres
                persona.correo = correo
                listPersonas.add(persona)

            } while (cursor.moveToNext())

        } catch (e: Exception) {
            Log.d("===", e.message.toString())
        } finally {
            db.close()
        }
        return listPersonas
    }

}