package com.example.first;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

public class Camera extends AppCompatActivity {

    ImageView imageview;

    private int IDENTIFIER_TAKE_PHOTO = 23;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        imageview = findViewById(R.id.imageView_camera_taken_image);

        findViewById(R.id.button_take_photo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent_take_photo = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                startActivityForResult(intent_take_photo,IDENTIFIER_TAKE_PHOTO);

            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent)
    {
        if(requestCode == IDENTIFIER_TAKE_PHOTO && resultCode == RESULT_OK)
        {
            Bundle extras = intent.getExtras();

            Bitmap image = (Bitmap) extras.get("data");

            imageview.setImageBitmap(image);
        }
    }
}
