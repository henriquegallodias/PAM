package e.wizard_san.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.app.Activity
import android.widget.Button
import android.view.View
import android.widget.TextView
import e.wizard_san.myapplication.AppStaticService
import kotlinx.android.synthetic.main.activity_main3.*
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import org.jetbrains.anko.*

class Main3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)


        val btn1 = findViewById<Button>(R.id.btnincluir) as Button
        btn1.setOnClickListener(View.OnClickListener {
            var u: Usuario = Usuario(
                edNome.text.toString(),
                edEmail.text.toString(),
                edPass.text.toString()
            )
            UsuaryRepository(getApplicationContext()).create(u)

            alert(
                "Usuario Cadastrado com Sucesso",
                "Vc ja conhecia o toast com maior duracao?"
            ) {
                yesButton { longToast("Esse toast dura mais tempo…") }
                noButton {}
            }.show()

            toast("toast normal: Usuario Incluido com sucesso")
        })

        val btn2 = findViewById<Button>(R.id.btnlistar) as Button
            btn2.setOnClickListener({
                toast("Listar Usuarios...")
                var listU: List<Usuario> = UsuaryRepository(getApplicationContext()).findAll()
                for (u: Usuario in listU) {
                    toast(u.nome)
                }
            })

        val btn3 = findViewById<Button>(R.id.btnlimpar) as Button
            btn3.setOnClickListener(View.OnClickListener {
                val epSenha = edPass.text.clear()
                val etUserName = edNome.text.clear()
                val etNome = edCreate.text.clear()
                val etEmail = edEmail.text.clear()
                val etApelido = edId.text.clear()

            })
        }
    }


