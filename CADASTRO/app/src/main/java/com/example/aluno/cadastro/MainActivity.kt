package com.example.aluno.cadastro

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnincluir: Button = findViewById<Button>(R.id.btnincluir)

        btnincluir.setOnClickListener(View.OnClickListener{
            val Viewname: TextView = findViewById<TextView>(R.id.nome) as TextView
            val Viewemail: TextView = findViewById<TextView>(R.id.email) as TextView
            val Viewlogin: TextView = findViewById<TextView>(R.id.login) as TextView
            val Viewsenha: TextView = findViewById<TextView>(R.id.senha) as TextView

            val Resposta: Boolean = AppStaticServices.cadastro(
                    Viewname.text.toString(),
                    Viewemail.text.toString(),
                    Viewlogin.text.toString(),
                    Viewsenha.text.toString()

            )

        })

    }
}
