package com.alonsoms.appt1alonsoms.model

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.util.Log
import com.alonsoms.appt1alonsoms.entities.Persona
import com.alonsoms.appt1alonsoms.entities.clasemodelos
import com.alonsoms.appt1alonsoms.util.SQLiteHelper


class PersonaDAO(context: Context) {
    private var sqLiteHelper: SQLiteHelper = SQLiteHelper(context)

    fun registrarLibro(libro: clasemodelos.Libro): String {
        var respuesta = "";
        val db = sqLiteHelper.writableDatabase
        try {
            val valores = ContentValues()
            valores.put("titulo", libro.titulo)
            valores.put("estado", libro.estado)
            valores.put("sinopsis", libro.sinopsis)
            valores.put("preciobase", libro.preciobase)

            val rpta = db.insert("libros", null, valores)
            if (rpta == -1L) {
                respuesta = "Error al insertar libro"
            } else {
                respuesta = "Se registró correctamente"
            }
        } catch (e: Exception) {
            Log.d("===", e.message.toString())
            respuesta = "Ocurrio un error"
        } finally {
            db.close()
        }
        return respuesta
    }


    fun registrarOferta(oferta: clasemodelos.Oferta): String {
        var respuesta = "";
        val db = sqLiteHelper.writableDatabase
        try {
            val valores = ContentValues()
            valores.put("PrecioOferta", oferta.precioOferta)

            val rpta = db.insert("ofertas", null, valores)
            if (rpta == -1L) {
                respuesta = "Error al insertar oferta"
            } else {
                respuesta = "Se registró oferta , mucha suerte"
            }
        } catch (e: Exception) {
            Log.d("===", e.message.toString())
            respuesta = "Ocurrio un error"
        } finally {
            db.close()
        }
        return respuesta
    }

    fun cargarOferta(): ArrayList<clasemodelos.Oferta> {
        val listaOferta: ArrayList<clasemodelos.Oferta> = ArrayList()
        val query = "SELECT * FROM ofertas"
        val db = sqLiteHelper.readableDatabase
        val cursor: Cursor

        try {
            cursor = db.rawQuery(query, null)
            cursor.moveToFirst()
            do {
                val IdOferta:Int = cursor.getInt(cursor.getColumnIndexOrThrow("IdOferta"))
                val IdSubasta: Int = cursor.getInt(cursor.getColumnIndexOrThrow("IdSubasta"))
                val PrecioOferta: Float =cursor.getFloat(cursor.getColumnIndexOrThrow("PrecioOferta"))

                val oferta = clasemodelos.Oferta()
                oferta.IdOferta = IdOferta
                oferta.idSubasta = IdSubasta.toLong()
                oferta.precioOferta = PrecioOferta

                listaOferta.add(oferta)


            } while (cursor.moveToNext())
        } catch (e: Exception) {
            Log.d("===", e.message.toString())

        } finally {
            db.close()
        }
        return listaOferta;
    }

}