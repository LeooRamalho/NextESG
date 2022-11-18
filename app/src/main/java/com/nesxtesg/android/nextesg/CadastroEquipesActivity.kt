package com.nesxtesg.android.nextesg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView

class CadastroEquipesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_equipes)

        val db = DatabaseManager(this, "db_next_esg");
        val curEquipes = db.listaEquipes()

        var arrayEquipes = arrayOfNulls<String>(curEquipes.count)

        var i: Int = 0
        if (curEquipes.moveToFirst()) {
            do {
                val columnIndex = curEquipes.getColumnIndex("nome")
                val uname = curEquipes.getString(columnIndex);
                arrayEquipes[i] = uname;
                i++;
            } while (curEquipes.moveToNext());
        }

        val lv: ListView = findViewById(R.id.lv_equipes)
        lv.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayEquipes)

        val btnCadastrarEquipe = findViewById<Button>(R.id.btn_cadastrar_equipe)
        btnCadastrarEquipe.setOnClickListener {
            val intent = Intent(this, CadastrarEquipe::class.java)
            startActivity(intent);
        }

        val btnVoltar = findViewById<Button>(R.id.btn_voltar_menu_cadastro_equipe)
        btnVoltar.setOnClickListener {
            val intent = Intent(this, AdminActivity::class.java)
            startActivity(intent);
        }
    }
}