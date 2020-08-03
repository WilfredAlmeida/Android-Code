package com.example.services;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.media.MediaPlayer;
import android.provider.Settings;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(getApplicationContext(),"Main Activity",Toast.LENGTH_LONG).show();
    }
}
