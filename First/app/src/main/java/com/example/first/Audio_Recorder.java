package com.example.first;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaRecorder;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;

public class Audio_Recorder extends AppCompatActivity {

    MediaRecorder media_recorder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio__recorder);

        Toast.makeText(this,"Audio Recorder",Toast.LENGTH_LONG).show();

        media_recorder = new MediaRecorder();

        findViewById(R.id.button_start_recording).setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                method_start_recording();
            }
        });
        findViewById(R.id.button_stop_recording).setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                method_stop_recording();
            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void method_start_recording()
    {

        media_recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        media_recorder.setOutputFormat(MediaRecorder.OutputFormat.DEFAULT);

        String file_save_path = Environment.getExternalStorageDirectory().getAbsolutePath()+"/recording.3gp";

        media_recorder.setOutputFile(file_save_path);
        media_recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);


        try{
        media_recorder.prepare();
        media_recorder.start();
        }
        catch (IllegalStateException ie){
            ie.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void method_stop_recording()
    {
        media_recorder.stop();
        media_recorder.release();
    }

}
