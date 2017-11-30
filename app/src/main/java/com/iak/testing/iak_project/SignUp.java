package com.iak.testing.iak_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        TextView loginSignUp = (TextView)findViewById(R.id.loginSignUp);
        final EditText usernameSignUp = (EditText)findViewById(R.id.usernameSignUp);
        final EditText passwordSignUp = (EditText)findViewById(R.id.passwordSignUp);
        final EditText confirmPassword = (EditText)findViewById(R.id.confirmPassword);
        Button daftar = (Button)findViewById(R.id.daftar);

        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (usernameSignUp.getText().toString().equals("")) {
                    Toast.makeText(SignUp.this, "Isi username", Toast.LENGTH_SHORT).show();
                }else if(passwordSignUp.getText().toString().equals("")){
                    Toast.makeText(SignUp.this, "Isi password", Toast.LENGTH_SHORT).show();
                }else if(confirmPassword.getText().toString().equals(passwordSignUp.getText().toString()) && passwordSignUp.getText().toString().equals(confirmPassword.getText().toString())){
                    Intent c = new Intent(SignUp.this, MainActivity.class);
                    startActivity(c);
                }else {
                    Toast.makeText(SignUp.this, "Password Tidak sesuai", Toast.LENGTH_SHORT).show();
                }
            }
        });

        loginSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();

            }
        });

    }
}
