package com.iak.testing.iak_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NavigationHeader extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_header);

//        TextView userAccount = (TextView)findViewById(R.id.userNavigationBar);
//        Bundle bundle = getIntent().getExtras();
//        String data = bundle.getString("username");
//        userAccount.setText(data);
    }
}
