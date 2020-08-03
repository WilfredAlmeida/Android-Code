package com.example.first;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Telusko_Login_Intent extends AppCompatActivity {

    TextView name;
    TextView gender;
    TextView email;
    TextView password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telusko__login__intent);


        name = findViewById(R.id.textview_name);
        gender = findViewById(R.id.textview_gender);
        email = findViewById(R.id.textview_email);
        password = findViewById(R.id.textview_password);

        Intent intent = getIntent();
        String sname = intent.getStringExtra("name");
        String sgender = intent.getStringExtra("gender");
        String semail = intent.getStringExtra("email");
        String spassword = intent.getStringExtra("password");

        System.out.println(sname+sgender+semail+spassword);

        name.setText(sname);
        gender.setText(sgender);
        email.setText(semail);
        password.setText(spassword);

    }
}
