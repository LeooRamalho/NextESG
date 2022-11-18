package com.nesxtesg.android.nextesg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AdminActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)

        val btnCadastroEmpresas = findViewById<Button>(R.id.btn_cadastro_empresas)
        val btnCadastroEquipes = findViewById<Button>(R.id.btn_cadastro_equipes)
        val btnCadastroUsuarios = findViewById<Button>(R.id.btn_cadastro_usuarios)
        val btnCadastroFatores = findViewById<Button>(R.id.btn_cadastro_fatores)

        btnCadastroEmpresas.setOnClickListener {
            val intent = Intent(this, CadastroEmpresasActivity::class.java)
            startActivity(intent);
        }

        btnCadastroEquipes.setOnClickListener {
            val intent = Intent(this, CadastroEquipesActivity::class.java)
            startActivity(intent);
        }
    }
}