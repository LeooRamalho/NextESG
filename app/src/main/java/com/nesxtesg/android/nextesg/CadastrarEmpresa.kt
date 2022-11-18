package com.nesxtesg.android.nextesg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class CadastrarEmpresa : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastrar_empresa)

        val btnCadastrarNovaEmpresa = findViewById<Button>(R.id.btn_cadastrar_nova_empresa)
        btnCadastrarNovaEmpresa.setOnClickListener {
            val strNovaEmpresa = findViewById<EditText>(R.id.edt_nova_empresa).getText().toString()
            criarEmpresa(strNovaEmpresa)
        }

        val btnVoltar = findViewById<Button>(R.id.btn_voltar_cadastro_empresas)
        btnVoltar.setOnClickListener {
            val intent = Intent(this, CadastroEmpresasActivity::class.java)
            startActivity(intent);
        }
    }

    fun criarEmpresa(nome: String){
        val db = DatabaseManager(this, "db_next_esg")
        db.insereEmpresa(nome)
        Toast.makeText(this, "Empresa criada com sucesso", Toast.LENGTH_LONG).show()

        val intent = Intent(this, CadastroEmpresasActivity::class.java)
        startActivity(intent);
    }
}

