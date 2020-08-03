package com.example.first;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class A1 extends AppCompatActivity implements View.OnClickListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a1);

    }

    @Override
    public  void onClick(View v)
    {
        Toast.makeText(this, "A1", Toast.LENGTH_SHORT).show();
    }
}
