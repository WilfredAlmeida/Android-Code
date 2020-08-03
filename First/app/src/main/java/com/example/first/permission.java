package com.example.first;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static android.Manifest.permission.CAMERA;

public class permission extends AppCompatActivity {

    Button button_request_permission;
    private int request_code = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);

        button_request_permission = findViewById(R.id.button_request_permission);
        button_request_permission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(ContextCompat.checkSelfPermission(permission.this, CAMERA)!=PackageManager.PERMISSION_GRANTED)
                {
                    ActivityCompat.requestPermissions(permission.this,new String[]{
                    Manifest.permission.CAMERA},request_code);
                }

            }
        });
}
}