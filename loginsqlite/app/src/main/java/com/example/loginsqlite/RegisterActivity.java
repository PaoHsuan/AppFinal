package com.example.loginsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText name, password,sex, birthday, nickname, type;
    Button register, signin;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name = findViewById(R.id.name);
        password = findViewById(R.id.pwd);
        sex = findViewById(R.id.sex);
        birthday = findViewById(R.id.birth);
        nickname = findViewById(R.id.nickname);
        type = findViewById(R.id.type);
        register = findViewById(R.id.register);
        signin = findViewById(R.id.signin);
        DB = new DBHelper(this);

        register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String nametext = name.getText().toString();
                String pwdtext = password.getText().toString();
                String sextxt = sex.getText().toString();
                String birthtxt = birthday.getText().toString();
                String nicktxt = nickname.getText().toString();
                String typetxt = type.getText().toString();
                Boolean checkinsertdata = DB.insertData(nametext, pwdtext, sextxt, birthtxt, nicktxt, typetxt);

                if(checkinsertdata == true) {
                    Toast.makeText(RegisterActivity.this, "Registered success", Toast.LENGTH_SHORT).show();
                    Log.d("Debug", "Success register");
                }
                else{
                    Toast.makeText(RegisterActivity.this, "Registered failed", Toast.LENGTH_SHORT).show();
                    Log.d("Debug", sextxt);
                }
            }
        });
        signin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);;
            }
        });
    }
}