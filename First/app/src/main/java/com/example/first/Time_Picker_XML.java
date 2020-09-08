/*

Refer: 'Beginning Android® Programming with Android Studio'
book pdf pg 193

Time Picker can be of 2 types, spinner and clock. It can be displayed using

*/

package com.example.first;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

public class Time_Picker extends AppCompatActivity {

    TimePicker timePicker;
    Button button_time_picker_time_selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time__picker);

        timePicker = findViewById(R.id.timepicker_1);
        button_time_picker_time_selected =
                findViewById(R.id.button_time_picker_time_selected);

        button_time_picker_time_selected.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Toast.makeText(getApplicationContext(),
                        "Time: "+timePicker.getCurrentHour() +":"
                                +timePicker.getCurrentMinute(),Toast.LENGTH_LONG).show();
            }
        });

    }
}
