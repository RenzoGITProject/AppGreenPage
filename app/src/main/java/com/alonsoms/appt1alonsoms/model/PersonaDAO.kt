package com.alonsoms.appt1alonsoms.model

import android.content.Context
import android.database.Cursor
import android.util.Log
import com.alonsoms.appt1alonsoms.entities.Persona
import com.alonsoms.appt1alonsoms.util.SQLiteHelper


class PersonaDAO(context: Context)  {
    private var sqLiteHelper: SQLiteHelper = SQLiteHelper(context)

    fun cargarOferta():ArrayList<Persona>{
        val listaPersona:ArrayList<Persona> = ArrayList()
        val query = "SELECT * FROM ofertas"
        val db = sqLiteHelper.readableDatabase
        val cursor:Cursor

        try {
            cursor = db.rawQuery(query,null)
            cursor.moveToFirst()
            do {
                val IdOferta:Int = cursor.getInt(cursor.getColumnIndexOrThrow("IdOferta"))
                val IdSubasta:Int =cursor.getInt(cursor.getColumnIndexOrThrow("IdSubasta"))
                val PrecioOferta:Float = cursor.getFloat(cursor.getColumnIndexOrThrow("IdSubasta"))

                val persona = Persona()
                persona.IdOferta = IdOferta
                persona.IdSubasta = IdSubasta
                persona.PrecioOferta = PrecioOferta

                listaPersona.add(persona)


            }while (cursor.moveToNext())
        }catch (e:Exception){
            Log.d("===", e.message.toString())

        }finally {
            db.close()
        }
        return listaPersona;
    }
}