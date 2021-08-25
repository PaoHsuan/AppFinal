package com.example.loginsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name, password;
    Button register, signin;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        password = findViewById(R.id.pwd);
        register = findViewById(R.id.register);
        signin = findViewById(R.id.signin);
        DB = new DBHelper(this);

        register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });
        signin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String user = name.getText().toString();
                String pass = password.getText().toString();
                if(user.equals("")||pass.equals(""))
                    Toast.makeText(MainActivity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = DB.checkusernamepassword(user, pass);
                    if(checkuserpass == true) {
                        Log.d("Debuggfff", "true");
                        String message = name.getText().toString();
                        Toast.makeText(MainActivity.this, "Sign in successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("MESSAGE",message);
                        Log.d("1: ",message);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }else{
                        Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
