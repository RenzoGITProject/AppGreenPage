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
        val sql=    "CREATE TABLE IF NOT EXISTS persona " +
                    "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    " dni INTEGER NOT NULL, " +
                    " nombres TEXT NOT NULL, " +
                    " correo TEXT NOT NULL );"
        db.execSQL(sql)

    }

    /* Se ejecuta una sola vez*/
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS persona")
        onCreate(db)
    }

}