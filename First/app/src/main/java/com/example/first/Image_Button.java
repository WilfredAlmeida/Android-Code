package com.example.first;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.ImageButton;

public class Image_Button extends AppCompatActivity {

    ImageButton imageButton_imageButton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image__button);

        Toast.makeText(this, "Image Button", Toast.LENGTH_SHORT).show();

        imageButton_imageButton1 = findViewById(R.id.imageButton_imageButton1);

        imageButton_imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Toggle_Button_Wifi_On_Off.class));
                Toast.makeText(Image_Button.this, "Click", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
