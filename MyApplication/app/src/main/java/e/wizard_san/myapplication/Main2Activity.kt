package e.wizard_san.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        val listView = findViewById<ListView>(R.id.listview) as ListView

        val cars = arrayOf("Honda","Volkswagem","Fiat","Chevrolet")

        val asp : ArrayAdapter<String> = ArrayAdapter(this@Main2Activity,android.R.layout.simple_list_item_1,cars)

        listView.adapter = asp

        listView.setOnItemClickListener{parent,view,position,id ->
            Toast.makeText(this@Main2Activity,"Item Clicado:- $id", Toast.LENGTH_SHORT).show()
        }
      }
    }
