package e.wizard_san.arraykotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.list_view.*
import org.jetbrains.anko.appcompat.v7.buttonBarLayout
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnincluir: Button = findViewById<Button>(R.id.btnincluir) as Button
        val btnlimpar: Button = findViewById<Button>(R.id.btnlimpar) as Button
        var btnarray: Button = findViewById<Button>(R.id.btnarray) as Button



        val Viewname: TextView = findViewById<TextView>(R.id.nome) as TextView
        val Viewemail: TextView = findViewById<TextView>(R.id.email) as TextView
        val Viewlogin: TextView = findViewById<TextView>(R.id.login) as TextView
        val Viewsenha: TextView = findViewById<TextView>(R.id.senha) as TextView


        btnincluir.setOnClickListener(View.OnClickListener{
            val Resposta: Boolean = AppStaticService.cadastro(
                Viewname.text.toString(),
                Viewemail.text.toString(),
                Viewlogin.text.toString(),
                Viewsenha.text.toString()
            )

        })

        btnlimpar.setOnClickListener(View.OnClickListener {
            Viewname.text = ""
            Viewemail.text = ""
            Viewlogin.text = ""
            Viewsenha.text = ""

        })

                btnarray.setOnClickListener({
                    toast("botao listar clicado")
                    startActivity<ListViewArray>()



        })



    }
}
