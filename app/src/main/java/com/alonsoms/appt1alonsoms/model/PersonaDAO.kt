package com.alonsoms.appt1alonsoms.model

import android.content.Context
import android.database.Cursor
import android.util.Log
import com.alonsoms.appt1alonsoms.entities.Persona
import com.alonsoms.appt1alonsoms.util.SQLiteHelper


class PersonaDAO(context: Context)  {
    private var sqLiteHelper: SQLiteHelper = SQLiteHelper(context)

    fun cargarSubasta():ArrayList<Persona>{
        val listaPersona:ArrayList<Persona> = ArrayList()
        val query = "SELECT * FROM ofertas"
        val db = sqLiteHelper.readableDatabase
        val cursor:Cursor

        try {

        }catch (e:Exception){
            Log.d("===", e.message.toString())

        }finally {
            db.close()
        }
        return listaPersona;
    }
}