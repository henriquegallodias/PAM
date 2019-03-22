package e.wizard_san.loginkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

           btnlo.setOnClickListener{
               var status: String = if(txtlo.text.toString().equals("henrique")&& txtse.text.toString().equals("123456")) "Login aceito" else "Login errado"
               Toast.makeText(this, status,Toast.LENGTH_LONG).show()
           }
    }
}
