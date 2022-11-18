package com.nesxtesg.android.nextesg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.NumberPicker
import android.widget.Toast

class CadastrarEquipe : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastrar_equipe)

        val btnCadastrarNovaEquipe = findViewById<Button>(R.id.btn_cadastrar_nova_equipe)
        btnCadastrarNovaEquipe.setOnClickListener {
            val strNovaEquipe = findViewById<EditText>(R.id.edt_nova_equipe).getText().toString()
            val idEmpresa = findViewById<NumberPicker>(R.id.edt_id_empresa).getValue().toString()
            criarEquipe(idEmpresa, strNovaEquipe)
        }

        val btnVoltar = findViewById<Button>(R.id.btn_voltar_cadastro_equipe)
        btnVoltar.setOnClickListener {
            val intent = Intent(this, CadastroEquipesActivity::class.java)
            startActivity(intent);
        }
    }

    fun criarEquipe(idEquipe: String, nome: String){
        val db = DatabaseManager(this, "db_next_esg")
        db.insereEquipe(idEquipe, nome)
        Toast.makeText(this, "Equipe criada com sucesso", Toast.LENGTH_LONG).show()

        val intent = Intent(this, CadastroEquipesActivity::class.java)
        startActivity(intent);
    }
}