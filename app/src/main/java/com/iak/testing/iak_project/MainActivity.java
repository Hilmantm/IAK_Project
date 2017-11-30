package com.iak.testing.iak_project;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);
        toggle = new ActionBarDrawerToggle(MainActivity.this, drawerLayout, R.string.open, R.string.close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigationView = (NavigationView)findViewById(R.id.navigation_menu);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navLogOut:
                        finish();
                        break;
                }
                return false;
            }
        });

        final Button submit = (Button)findViewById(R.id.submit);
        final EditText nama = (EditText)findViewById(R.id.nama);
        final EditText IQ = (EditText)findViewById(R.id.IQ);
        final Button reset = (Button)findViewById(R.id.reset);
        final EditText hasilNama = (EditText)findViewById(R.id.hasilNama);
        final EditText hasilIq = (EditText)findViewById(R.id.hasilIQ);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nama.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Isi nama", Toast.LENGTH_SHORT).show();
                }else if(IQ.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Isi IQ anda", Toast.LENGTH_SHORT).show();
                }else{
                    hasilNama.setText(nama.getText().toString());
                    hasilIq.setText(IQ.getText().toString());
                    int a = Integer.parseInt(IQ.getText().toString());
                    if (a >= 130){
                        hasilIq.setText("Sangat Superior");
                    }else if (a >= 120 && a <= 129 ){
                        hasilIq.setText("Superior");
                    }else if (a >= 110 && a <= 119 ){
                        hasilIq.setText("Rata-rata plus");
                    }else if (a >= 90 && a <= 109 ){
                        hasilIq.setText("Rata-rata");
                    }else if (a >= 80 && a <= 89 ){
                        hasilIq.setText("Rata-rata minus");
                    }else if (a >= 70 && a <= 79 ){
                        hasilIq.setText("Garis Batas");
                    }else {
                        hasilIq.setText("Anda dibawah rata-rata :(");
                    }

                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nama.setText("");
                IQ.setText("");
                hasilNama.setText("");
                hasilIq.setText("");
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(toggle.onOptionsItemSelected(item)){
        }
        return super.onOptionsItemSelected(item);
    }
}
