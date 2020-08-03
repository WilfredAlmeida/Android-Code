package com.example.first;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class Progress_Bar extends AppCompatActivity {

    ProgressBar progressBar_indeterminate,progressBar_non_indeterminate,
    progressBar_determinate_horizontal,progressBar_indeterminate_horizontal;

    Button button_start_progress_bar;

    int progress_counter = 0;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress__bar);

        Toast.makeText(this,"Progress Bar",Toast.LENGTH_SHORT).show();

        button_start_progress_bar = findViewById(R.id.button_start_progress_bar);

        progressBar_indeterminate = findViewById(R.id.progressBar_circular_indeterminate);
        progressBar_non_indeterminate = findViewById(R.id.progressBar_circular_non_indeterminate);


        progressBar_determinate_horizontal = findViewById(R.id.progressBar_determinate_horizontal);
        progressBar_indeterminate_horizontal = findViewById(R.id.progressBar_indeterminate_horizontal);

        progressBar_indeterminate.setProgress(20);//Doesnt work just tried
        progressBar_non_indeterminate.setProgress(20);//Doesnt work just tried

        button_start_progress_bar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while(progress_counter<=100) {
                            progress_counter++;

                                    new Runnable() {
                                        @Override
                                        public void run() {
                                            progressBar_determinate_horizontal.setProgress(progress_counter);
                                        }
                                    }.run();
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();
            }
        });

    }
}
