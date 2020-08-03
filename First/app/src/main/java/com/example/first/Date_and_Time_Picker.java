package com.example.first;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class Date_and_Time_Picker extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener
{
    TextView textView_show_date,textView_show_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_and_time_picker);

        textView_show_date = findViewById(R.id.textView_show_date);
        textView_show_time = findViewById(R.id.textView_show_time);

        findViewById(R.id.button_open_date_picker_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        Date_and_Time_Picker.this,//context
                        Date_and_Time_Picker.this,//listener
                        Calendar.getInstance().get(Calendar.YEAR),
                        Calendar.getInstance().get(Calendar.MONTH),
                        Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
                );
                datePickerDialog.show();
            }
        });

        findViewById(R.id.button_open_time_picker).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        Date_and_Time_Picker.this,
                        Date_and_Time_Picker.this,
                        Calendar.getInstance().get(Calendar.HOUR_OF_DAY),
                        Calendar.getInstance().get(Calendar.MINUTE),
                        false
                );
                timePickerDialog.show();
            }
        });
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        textView_show_date.setText(dayOfMonth+"/"+month+"/"+year);
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute)
    {
        textView_show_time.setText(hourOfDay+":"+minute);
    }
}
