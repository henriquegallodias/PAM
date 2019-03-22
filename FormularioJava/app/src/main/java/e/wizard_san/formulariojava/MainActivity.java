package e.wizard_san.formulariojava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText USER;
    private EditText PASS;
    private Button BTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        USER = (EditText) findViewById(R.id.login);
        PASS = (EditText) findViewById(R.id.senha);
        BTN = (Button) findViewById(R.id.btn);

        BTN.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String txt = USER.getText().toString();
               String pass = PASS.getText().toString();
               String henrique = "henrique";
               String senhaa = "123456";

               if(txt.equals(henrique)&& pass.equals(senhaa)) {
                   Toast.makeText(MainActivity.this, "Login aceito", Toast.LENGTH_LONG).show();
               }
               else {
                   Toast.makeText(MainActivity.this,"Usuário ou senha incorretos",Toast.LENGTH_LONG).show();
               }
           }
        });

    }
}
