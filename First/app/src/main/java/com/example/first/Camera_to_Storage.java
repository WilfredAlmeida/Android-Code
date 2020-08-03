//Code is alright but wont work on devices with sdk 24+/Nougat.
package com.example.first;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.content.Intent;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Camera_to_Storage extends AppCompatActivity {

    Button button_camera_to_storage_capture_image;
    ImageView imageView_camera_to_storage_display_image;
    File file_image;//file to store image captured.
    final int IMAGE_CAPTURE_CODE = 2;
    String string_image_save_path;
    File temp_file;//needed below

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_to__storage);
        Toast.makeText(this,"Camera to Storage",Toast.LENGTH_LONG).show();

        button_camera_to_storage_capture_image = findViewById(R.id.button_camera_to_storage_capture_image);
        imageView_camera_to_storage_display_image = findViewById(R.id.imageView_camera_to_storage_display_image);

        button_camera_to_storage_capture_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                file_image = method_createImageFile();//programmer defined method
                //that will return a file suitable to store image, having file name, saving path,extension.

                Intent intent_capture_image = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                intent_capture_image.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file_image));
                //telling the intent to save the image in the specified file.

                startActivityForResult(intent_capture_image,IMAGE_CAPTURE_CODE);
            }
        });

    }

    public File method_createImageFile()
    {
        String time = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        //Gets the date and time to add it to image name.

        String string_image_name = "JPEG_"+time+"_";//image name

        File file_storage_directory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        //directory to store image

        try {
            temp_file = File.createTempFile(
                    string_image_name,//prefix
                    ".jpg",//suffix
                    file_storage_directory//storage directory
            );
        }
        catch (IOException e){System.out.println(e);}

        string_image_save_path = "file:"+temp_file.getAbsolutePath();
        //path to be given to intent to tell it where to save the file.

        return temp_file;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(requestCode == IMAGE_CAPTURE_CODE && resultCode == RESULT_OK)
        {
            Bitmap bitmap_image;

            try {
                bitmap_image = MediaStore.Images.Media.getBitmap(this.getContentResolver(), Uri.parse(string_image_save_path));
                //getting image from storage to set it to imageview.

                imageView_camera_to_storage_display_image.setImageBitmap(bitmap_image);
                //setting the image to imageview.
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
