package com.henrique.firebaseapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import org.jetbrains.anko.toast
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    var logTAG: String = "info";

    //Variaveis de instância que serão definidas depois
    lateinit var btnCadastrar: Button
    lateinit var btnLogin: Button
    lateinit var btnLogoff: Button
    lateinit var btnVerifyEmailUser: Button
    lateinit var btnAlteraSenha: Button


    lateinit var lbEmailDoUsuarioLogado : TextView
    lateinit var lbEmailValidoSera : TextView

    lateinit var fbAuth : FirebaseAuth
    lateinit var txtEmail: EditText
    lateinit var txtPass: EditText
    lateinit var txtNewPass: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.lbEmailDoUsuarioLogado = findViewById<TextView>(R.id.lbEmailDoUsuarioLogado);
        this.lbEmailValidoSera = findViewById<TextView>(R.id.lbEmailValidoSera);

        this.fbAuth = FirebaseAuth.getInstance()
        this.txtEmail = findViewById<EditText>(R.id.edEmail);
        this.txtPass = findViewById<EditText>(R.id.edPass);
        this.txtNewPass = findViewById<EditText>(R.id.txtNovaSenha);


        this.btnCadastrar = findViewById<Button>(R.id.btnSingUp);
        this.btnLogin = findViewById<Button>(R.id.btnLogin);
        this.btnLogoff = findViewById<Button>(R.id.btnLoggof)
        this.btnVerifyEmailUser = findViewById<Button>(R.id.btnVerifyEmailUser)
        this.btnAlteraSenha = findViewById<Button>(R.id.btnAlteraSenha)

        this.btnCadastrar.setOnClickListener(View.OnClickListener {
            toast("Cadastrando...")
            this.signUp()
        })

        this.btnLogoff.setOnClickListener(View.OnClickListener {
            toast("Saindo...")
            this.logoff()
        })

        this.btnLogin.setOnClickListener(View.OnClickListener {
            toast("Entrando...")
            this.login();
        })

        this.btnVerifyEmailUser.setOnClickListener(View.OnClickListener {
            toast("Verificando...")
            this.verifyEmailUser();
        })

        this.btnAlteraSenha.setOnClickListener(View.OnClickListener {
            toast("Altere sua senha abaixo")
            this.alteraSenha();
        })

    }
    //criando as funções ao iniciar o app: Cadastrar.
    public override fun onStart() {
        super.onStart()
        this.signUp()
        updateUI(null)
    }
    //Verificando se há login ativo
    public fun updateUI(user: FirebaseUser?) {
        if (user != null) {
            this.lbEmailDoUsuarioLogado.text = user.email
        } else {
            this.lbEmailDoUsuarioLogado.text = "Nenhum Usuário Logado"
        }
    }
    //encerra login
    private fun logoff() {
        this.fbAuth.signOut()
        updateUI(null)
    }
    //realiza login
    private fun login() {
        if(!this.formIsValid()){
            return
        }
        this.fbAuth.signInWithEmailAndPassword(this.txtEmail.text.toString(), this.txtPass.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    updateUI(this.fbAuth.currentUser)
                } else {
                    toast("Usuário Logado com sucesso")
                    updateUI(null)
                }
                if (!task.isSuccessful) {
                    toast("Falha no login")
                }
            }
    }

    private fun signUp(){
        if(!this.formIsValid()) return

        this.fbAuth.createUserWithEmailAndPassword(this.txtEmail.text.toString(), this.txtPass.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    toast("takswassucessfull")
                    toast(this.fbAuth.currentUser.toString())
                    updateUI(this.fbAuth.currentUser)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(logTAG, "createUserWithEmail:failure", task.exception)
                    toast("Falhou.")
                    updateUI(null)
                }
            }
    }

    private fun verifyEmailUser() {
        var usuario = this.fbAuth.currentUser
        usuario?.sendEmailVerification()
            ?.addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    toast("Verificacao de email enviada COM SUCESSO para ${usuario.email} ");
                    this.lbEmailValidoSera.text = "email valido: ${usuario.email}"
                } else {
                    toast("Falha no envio de email de verificacao")
                    this.lbEmailValidoSera.text = "email INvalido: ${usuario.email}"
                }
            }
    }

    private fun alteraSenha(){
        var strNewPass: String = this.txtNewPass.text.toString();
        if(strNewPass.length < 6 ){
            toast("Senha tem que ter pelo menos 6 caracteres...")
            return
        }

        var usuario = this.fbAuth.currentUser
        usuario?.updatePassword(strNewPass)?.addOnCompleteListener {
            try {
                toast("Senha alterada com sucesso")
            }catch (e: Exception){
                toast("Erro durante o processo de alteracao de senha")
            }
        }
    }


    private fun formIsValid() : Boolean {
        toast("private fun formIsValid() : Boolean {...")
        var ret = true
        val email: String = this.txtEmail.text.toString()
        val pass: String = this.txtPass.text.toString()

        if (email.equals("") || pass.equals("")) {
            toast("ou email ou senha estao em branco e nao pode...")
            ret = false
        } else if (pass.length < 6) {
            toast("A senha precisa ter pelo menos 6 caracteres...")
            ret = false
        }

        return ret
    }
}
