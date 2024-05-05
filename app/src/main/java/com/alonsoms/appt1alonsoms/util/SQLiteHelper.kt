package com.alonsoms.appt1alonsoms.util

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

@Suppress("UNREACHABLE_CODE")
class SQLiteHelper(context: Context) :SQLiteOpenHelper(context,DATABASE_NAME,null,DATABASE_VERSION) {

    companion object{
        private const val DATABASE_NAME = "planillas.db"
        private const val  DATABASE_VERSION= 1
   }

    /* Se crea la base de datos*/
        override fun onCreate(db: SQLiteDatabase) {
            val sqlUsuario = "CREATE TABLE IF NOT EXISTS usuario " +
                    "(IdUsuario INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "Nombres VARCHAR(255) NOT NULL, " +
                    "Login VARCHAR(255) NOT NULL, " +
                    "Password VARCHAR(255) NOT NULL, " +
                    "FechaCreacion DATETIME DEFAULT CURRENT_TIMESTAMP);"
            db.execSQL(sqlUsuario)

            val sqlPerfilUsuario = "CREATE TABLE IF NOT EXISTS perfilUsuario " +
                    "(IdPerfilUsuario INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "NombrePerfil VARCHAR(255) NOT NULL);"
            db.execSQL(sqlPerfilUsuario)

            val sqlEditorial = "CREATE TABLE IF NOT EXISTS editorial " +
                    "(IdEditorial INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "Nombre VARCHAR(255) NOT NULL);"
            db.execSQL(sqlEditorial)

            val sqlGenero = "CREATE TABLE IF NOT EXISTS genero " +
                    "(IdGenero INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "Nombre VARCHAR(255) NOT NULL);"
            db.execSQL(sqlGenero)

            val sqlLibros = "CREATE TABLE IF NOT EXISTS libros " +
                    "(IdLibro INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "Titulo VARCHAR(255) NOT NULL, " +
                    "Estado VARCHAR(255), " +
                    "ISBN VARCHAR(255) UNIQUE NOT NULL, " +
                    "IdEditorial INTEGER, " +
                    "IdGenero INTEGER, " +
                    "Sinopsis VARCHAR(255), " +
                    "FOREIGN KEY (IdEditorial) REFERENCES editorial(IdEditorial), " +
                    "FOREIGN KEY (IdGenero) REFERENCES genero(IdGenero));"
            db.execSQL(sqlLibros)

            val sqlSubasta = "CREATE TABLE IF NOT EXISTS subasta " +
                    "(IdSubasta INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "IdLibro INTEGER, " +
                    "FechaInicio DATETIME, " +
                    "FechaFinal DATETIME, " +
                    "PrecioBase FLOAT, " +
                    "FOREIGN KEY (IdLibro) REFERENCES libros(IdLibro));"
            db.execSQL(sqlSubasta)

            val sqlCalificacion = "CREATE TABLE IF NOT EXISTS calificacion " +
                    "(IdCalificacion INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "Puntaje INTEGER, " +
                    "Comentario VARCHAR(255), " +
                    "IdLibro INTEGER, " +
                    "FOREIGN KEY (IdLibro) REFERENCES libros(IdLibro));"
            db.execSQL(sqlCalificacion)

            val sqlOfertas = "CREATE TABLE IF NOT EXISTS ofertas " +
                    "(IdOferta INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "IdSubasta INTEGER, " +
                    "PrecioOferta FLOAT, " +
                    "FOREIGN KEY (IdSubasta) REFERENCES subasta(IdSubasta));"
            db.execSQL(sqlOfertas)

            val sqlResena = "CREATE TABLE IF NOT EXISTS resena " +
                    "(IdResena INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "IdLibro INTEGER, " +
                    "IdUsuario INTEGER, " +
                    "FOREIGN KEY (IdLibro) REFERENCES libros(IdLibro), " +
                    "FOREIGN KEY (IdUsuario) REFERENCES usuario(IdUsuario));"
            db.execSQL(sqlResena)
        }




    /* Se ejecuta una sola vez*/
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS persona")
        onCreate(db)
    }

}