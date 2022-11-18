package com.nesxtesg.android.nextesg

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSalvar = findViewById<Button>(R.id.btn_login)

        btnSalvar.setOnClickListener {

            val edtEmail = findViewById<EditText>(R.id.edt_email).getText().toString()
            val edtSenha = findViewById<EditText>(R.id.edt_senha).getText().toString()

            Log.i("LOGIN:EMAIL", edtEmail)
            Log.i("LOGIN:SENHA", edtSenha)

            if (edtEmail.equals("admin") && edtSenha.equals("admin")) {
                Toast.makeText(this, "ADMIN LOGOU", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, AdminActivity::class.java)
                startActivity(intent);
            }

            /*  val db = DatabaseManager(this, "saudacoes")
              db.removeSaudacao()
              db.insereSaudacao(1, "Meu testao", "Senhor")
              Toast.makeText(this, "Funfou !!!!!", Toast.LENGTH_SHORT) */
        }
    }

}