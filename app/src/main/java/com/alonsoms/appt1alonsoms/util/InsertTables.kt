package com.alonsoms.appt1alonsoms.util


import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

@Suppress("UNREACHABLE_CODE")
class InsertTables(context: Context) :SQLiteOpenHelper(context,DATABASE_NAME,null,DATABASE_VERSION) {

    companion object{
        private const val DATABASE_NAME = "GreenPage.db"
        private const val  DATABASE_VERSION= 1
    }

    override fun onCreate(db: SQLiteDatabase) {
        val sqlInsertUsuario = "INSERT INTO usuario (Nombres, Login, Password) VALUES " +
                "('Usuario1', 'login1', 'password1'), " +
                "('Usuario2', 'login2', 'password2'), " +
                "('Usuario3', 'login3', 'password3'), " +
                "('Usuario4', 'login4', 'password4'), " +
                "('Usuario5', 'login5', 'password5');"

        val sqlInsertPerfilUsuario = "INSERT INTO perfilUsuario (NombrePerfil) VALUES " +
                "('Perfil1'), " +
                "('Perfil2'), " +
                "('Perfil3'), " +
                "('Perfil4'), " +
                "('Perfil5');"

        val sqlInsertEditorial = "INSERT INTO editorial (Nombre) VALUES " +
                "('Editorial1'), " +
                "('Editorial2'), " +
                "('Editorial3'), " +
                "('Editorial4'), " +
                "('Editorial5');"

        val sqlInsertGenero = "INSERT INTO genero (Nombre) VALUES " +
                "('Genero1'), " +
                "('Genero2'), " +
                "('Genero3'), " +
                "('Genero4'), " +
                "('Genero5');"

        val sqlInsertLibros = "INSERT INTO libros (Titulo, Estado, ISBN, IdEditorial, IdGenero, Sinopsis) VALUES " +
                "('Libro1', 'Estado1', 'ISBN1', 1, 1, 'Sinopsis1'), " +
                "('Libro2', 'Estado2', 'ISBN2', 2, 2, 'Sinopsis2'), " +
                "('Libro3', 'Estado3', 'ISBN3', 3, 3, 'Sinopsis3'), " +
                "('Libro4', 'Estado4', 'ISBN4', 4, 4, 'Sinopsis4'), " +
                "('Libro5', 'Estado5', 'ISBN5', 5, 5, 'Sinopsis5');"

        val sqlInsertSubasta = "INSERT INTO subasta (IdLibro, FechaInicio, FechaFinal, PrecioBase) VALUES " +
                "(1, '2024-01-01', '2024-01-05', 10.0), " +
                "(2, '2024-01-02', '2024-01-06', 20.0), " +
                "(3, '2024-01-03', '2024-01-07', 30.0), " +
                "(4, '2024-01-04', '2024-01-08', 40.0), " +
                "(5, '2024-01-05', '2024-01-09', 50.0);"

        val sqlInsertCalificacion = "INSERT INTO calificacion (Puntaje, Comentario, IdLibro) VALUES " +
                "(1, 'Comentario1', 1), " +
                "(2, 'Comentario2', 2), " +
                "(3, 'Comentario3', 3), " +
                "(4, 'Comentario4', 4), " +
                "(5, 'Comentario5', 5);"

        val sqlInsertOfertas = "INSERT INTO ofertas (IdSubasta, PrecioOferta) VALUES " +
                "(1, 15.0), " +
                "(2, 25.0), " +
                "(3, 35.0), " +
                "(4, 45.0), " +
                "(5, 55.0);"

        val sqlInsertResena = "INSERT INTO resena (IdLibro, IdUsuario) VALUES " +
                "(1, 1), " +
                "(2, 2), " +
                "(3, 3), " +
                "(4, 4), " +
                "(5, 5);"


    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }


}

