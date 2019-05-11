package e.wizard_san.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn1 = findViewById<Button>(R.id.login) as Button
        btn1.setOnClickListener {
            val intent1 = Intent(this@MainActivity,Main2Activity::class.java)
            startActivity(intent1)
        }

        val btn2 = findViewById<Button>(R.id.cadastrar) as Button
        btn2.setOnClickListener {
            val intent2 = Intent(this@MainActivity,Main3Activity::class.java)
            startActivity(intent2)
        }
    }
}
