package com.nesxtesg.android.nextesg

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DatabaseManager(context: Context, name: String) : SQLiteOpenHelper(context, name, null, 5) {

    override fun onCreate(db: SQLiteDatabase?) {
        criarTabelaEmpresas(db)
        criarTabelaEquipes(db)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS tbl_empresas")
        db!!.execSQL("DROP TABLE IF EXISTS tbl_equipes")
        onCreate(db)
    }

    //region EMPRESAS
    fun criarTabelaEmpresas(db: SQLiteDatabase?){
        val query = "CREATE TABLE tbl_empresas (" +
                "id_empresa INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "nome VARCHAR(50) NOT NULL" +
                ");"

        db!!.execSQL(query)
    }

    fun insereEmpresa(nome: String) {
        var db = this.writableDatabase

        var cv = ContentValues()
        cv.put("nome", nome)

        db.insert("tbl_empresas", null, cv)
    }
    fun obterEmpresaPorNome(nome: String) : String {
        var db = this.readableDatabase

        var cur = db.rawQuery("SELECT nome FROM tbl_empresas WHERE nome = ?", Array<String>(1){nome})
        cur.moveToFirst()
        return cur.getString(0)
    }
    fun listaEmpresas() : Cursor {
        var db = this.readableDatabase

        var cur = db.rawQuery("SELECT nome FROM tbl_empresas", null)
        return cur
    }

    //endregion

    //region EQUIPES

    fun criarTabelaEquipes(db: SQLiteDatabase?){
        val query = "CREATE TABLE tbl_equipes (" +
                "id_equipe INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "id_empresa INTEGER NOT NULL," +
                "nome VARCHAR(50) NOT NULL" +
                ");"

        db!!.execSQL(query)
    }

    fun insereEquipe(idEmpresa : String, nome: String) {
        var db = this.writableDatabase

        var cv = ContentValues()
        cv.put("id_empresa", idEmpresa)
        cv.put("nome", nome)

        db.insert("tbl_equipes", null, cv)
    }

    fun listaEquipes() : Cursor {
        var db = this.readableDatabase

        var cur = db.rawQuery("SELECT nome FROM tbl_equipes", null)
        return cur
    }

    //endregion

    fun removeSaudacao() {
        val db = this.writableDatabase
        db.delete("tbl_saudacao", "id_saudacao=1", null)
    }

}