package com.iak.testing.iak_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        final EditText username = (EditText)findViewById(R.id.username);
        final EditText password = (EditText)findViewById(R.id.password);
        TextView SignUp = (TextView)findViewById(R.id.SignUp);
        final Button login = (Button)findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username.getText().toString().equals("")&&password.getText().toString().equals("")){
                    Toast.makeText(loginActivity.this, "isi username dan isi password", Toast.LENGTH_SHORT).show();
                }else if(password.getText().toString().equals("")){
                    Toast.makeText(loginActivity.this, "isi password", Toast.LENGTH_SHORT).show();
                }else if(!password.getText().toString().equals("admin")){
                    Toast.makeText(loginActivity.this, "password salah", Toast.LENGTH_SHORT).show();
                }else if(username.getText().toString().equals("")){
                    Toast.makeText(loginActivity.this, "isi username", Toast.LENGTH_SHORT).show();
                }else if(password.getText().toString().equals("admin")){
                    Intent b = new Intent(loginActivity.this, MainActivity.class);
                    startActivity(b);
                }
            }
        });

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b = new Intent(loginActivity.this, SignUp.class);
                startActivity(b);
            }
        });
    }
}
