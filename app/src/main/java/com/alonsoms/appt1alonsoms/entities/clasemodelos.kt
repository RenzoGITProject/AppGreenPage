package com.alonsoms.appt1alonsoms.entities

class clasemodelos {
    class Usuario {
        lateinit var nombres: String
        lateinit var correo: String
        lateinit var username: String
        lateinit var contrasena: String
    }

    class PerfilUsuario {
        lateinit var nombrePerfil: String
    }

    class Editorial {
        lateinit var nombre: String
    }

    class Genero {
        lateinit var nombre: String
    }

    class Libro {
        var preciobase: Float = 0F
        lateinit var titulo: String
        var estado: String? = null
        lateinit var isbn: String
        var idEditorial: Long = 0
        var idGenero: Long = 0
        lateinit var sinopsis: String
    }

    class Subasta {
        var idLibro: Long = 0
        lateinit var fechaInicio: String
        lateinit var fechaFinal: String
        var precioBase: Float = 0f
    }

    class Calificacion {
        var puntaje: Int = 0
        lateinit var comentario: String
        var idLibro: Long = 0
    }

    class Oferta {
        var idSubasta: Long = 0
        var precioOferta: Float = 0f
    }

    class Resena {
        var idLibro: Long = 0
        var idUsuario: Long = 0
    }

}