package com.alonsoms.appt1alonsoms.model

import android.content.Context
import android.database.Cursor
import android.util.Log
import com.alonsoms.appt1alonsoms.entities.Persona
import com.alonsoms.appt1alonsoms.entities.clasemodelos
import com.alonsoms.appt1alonsoms.util.SQLiteHelper


class PersonaDAO(context: Context)  {
    private var sqLiteHelper: SQLiteHelper = SQLiteHelper(context)

    fun cargarOferta():ArrayList<clasemodelos.Oferta>{
        val listaOferta:ArrayList<clasemodelos.Oferta> = ArrayList()
        val query = "SELECT * FROM ofertas"
        val db = sqLiteHelper.readableDatabase
        val cursor:Cursor

        try {
            cursor = db.rawQuery(query,null)
            cursor.moveToFirst()
            do {
                //val IdOferta:Int = cursor.getInt(cursor.getColumnIndexOrThrow("IdOferta"))
                val idSubasta:Int =cursor.getInt(cursor.getColumnIndexOrThrow("idSubasta"))
                val precioOferta:Float = cursor.getFloat(cursor.getColumnIndexOrThrow("precioOferta"))

                val  clasemodelos=clasemodelos.Oferta ()
             //   persona.IdOferta = IdOferta
                clasemodelos.idSubasta = idSubasta.toLong()
                clasemodelos.precioOferta = precioOferta.toFloat()

                listaOferta.add(clasemodelos)


            }while (cursor.moveToNext())
        }catch (e:Exception){
            Log.d("===", e.message.toString())

        }finally {
            db.close()
        }
        return listaOferta;
    }
}