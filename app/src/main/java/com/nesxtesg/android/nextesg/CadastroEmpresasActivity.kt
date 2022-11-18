package com.nesxtesg.android.nextesg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.animation.AnimationUtils
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView

class CadastroEmpresasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_empresas)

        val db = DatabaseManager(this, "db_next_esg");
        val curEmpresas = db.listaEmpresas()

        var arrayEmpresas = arrayOfNulls<String>(curEmpresas.count)

        var i: Int = 0
        if (curEmpresas.moveToFirst()) {
            do {
                val columnIndex = curEmpresas.getColumnIndex("nome")
                val uname = curEmpresas.getString(columnIndex);
                arrayEmpresas[i] = uname;
                i++;
            } while (curEmpresas.moveToNext());
        }

        val lv: ListView = findViewById(R.id.lv_empresas)
        lv.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayEmpresas)

        lv.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            Log.i("LISTVIEW DATA => ", arrayEmpresas[position].toString())
            val nomeEmpresa = arrayEmpresas[position].toString()
            val test = db.obterEmpresaPorNome(nomeEmpresa)
            Log.i("LISTVIEW TEST => ", test)
        }

        val btnCadastrarEmpresa = findViewById<Button>(R.id.btn_cadastrar_empresa)
        btnCadastrarEmpresa.setOnClickListener {
            val intent = Intent(this, CadastrarEmpresa::class.java)
            startActivity(intent);
        }

        val btnVoltar = findViewById<Button>(R.id.btn_voltar_menu_cadastro_empresa)
        btnVoltar.setOnClickListener {
            val intent = Intent(this, AdminActivity::class.java)
            startActivity(intent);
        }
    }
}