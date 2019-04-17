package e.wizard_san.arraykotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
//import android.support.design.widget.Snackbar
import android.widget.ArrayAdapter
import android.widget.ListView

class ListViewArray : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_view)
        //setSupportActionBar(toolbar)

       // fab.setOnClickListener {
          // Snackbar.make().setAction()
      //  }

        var listView = findViewById<ListView>(R.id.listview2)
        val arraydeLinhas:ArrayList<String> = ArrayList<String>()
        arraydeLinhas.add("oi")
        arraydeLinhas.add("oi")
        arraydeLinhas.add("oi")
        arraydeLinhas.add("oi")
        arraydeLinhas.add("oi")
        listView.adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,arraydeLinhas)

    }
}