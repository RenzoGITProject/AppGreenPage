package com.alonsoms.appt1alonsoms.model

import com.alonsoms.appt1alonsoms.entities.clasemodelos.usuario
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.util.Log
import com.alonsoms.appt1alonsoms.util.SQLiteHelper

class UsuarioModel(context: Context) {
    private val sqLiteHelper: SQLiteHelper = SQLiteHelper(context)

    fun saveUsuario(Usuario: usuario): String {
        var respuesta = ""
        val db = sqLiteHelper.writableDatabase

        try {
            val valores = ContentValues()

            valores.put("nombres", Usuario.nombres)
            valores.put("correo", Usuario.correo)
            valores.put("username", Usuario.username)
            valores.put("contrasena", Usuario.contrasena)

            val rpta = db.insert("usuario", null, valores)

            respuesta = if(rpta == -1L) {
                "Error al insertar usuario"
            } else {
                "Se registró correctamente"
            }

        } catch (e: Exception) {
            Log.d("===", e.message.toString())
            respuesta = "Ocurrió un error"
        } finally {
            db.close()
        }
        return respuesta
    }

    fun getUsuarios(): ArrayList<usuario> {

        val listUsuarios: ArrayList<usuario> = ArrayList()
        val query = "SELECT * FROM usuario"
        val db = sqLiteHelper.readableDatabase

        val cursor: Cursor
        try {
            cursor = db.rawQuery(query, null)
            cursor.moveToFirst()

            do {
                val id: Int = cursor.getInt(cursor.getColumnIndexOrThrow("id"))
                val nombres: String = cursor.getString(cursor.getColumnIndexOrThrow("nombres"))
                val correo: String = cursor.getString(cursor.getColumnIndexOrThrow("correo"))
                val username: String = cursor.getString(cursor.getColumnIndexOrThrow("username"))
                val contrasena: String = cursor.getString(cursor.getColumnIndexOrThrow("contrasena"))

                val usuario = usuario()
                usuario.nombres = nombres
                usuario.correo = correo
                usuario.username = username
                usuario.contrasena = contrasena
                listUsuarios.add(usuario)

            } while (cursor.moveToNext())

        } catch (e: Exception) {
            Log.d("===", e.message.toString())
        } finally {
            db.close()
        }
        return listUsuarios
    }
    fun existeUsuario(username: String, contrasena: String): Boolean {
        var existeUsuario = false
        val db = sqLiteHelper.readableDatabase

        val query = "SELECT COUNT(*) FROM Usuario WHERE Login = ? AND Password = ?"
        val selectionArgs = arrayOf(username, contrasena)

        val cursor: Cursor = db.rawQuery(query, selectionArgs)
        try {
            if (cursor.moveToFirst()) {
                val count: Int = cursor.getInt(0)
                existeUsuario = count > 0
            }
        } catch (e: Exception) {
            Log.d("===", e.message.toString())
        } finally {
            cursor?.close()
            db.close()
        }
        return existeUsuario
    }


}