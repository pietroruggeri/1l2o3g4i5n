package com.example.pietro.loginsql;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText e1,e2;
    Button b1;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db=new DatabaseHelper(this);
        e1=(EditText)findViewById(R.id.editText);
        e2=(EditText)findViewById(R.id.editText2);
        b1=(Button)findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail = e1.getText().toString();
                String password = e2.getText().toString();
                Boolean chkmailpass = db.emailpassword(mail,password);
                if (chkmailpass==true)
                    Toast.makeText(getApplicationContext(),"Acceso exitoso",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(),"Email o contraseña incorrecto",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
