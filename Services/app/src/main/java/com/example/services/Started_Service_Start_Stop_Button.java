//read chapter 45 of the pdf book 'Android Notes for Professionals'
package com.example.services;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Started_Service_Start_Stop_Button extends AppCompatActivity implements View.OnClickListener{

    Button button_start_service,button_stop_service;

    Intent service_intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_started__service__start__stop__button);

        Toast.makeText(getApplicationContext(),"Started_Service_Start_Stop_Button",Toast.LENGTH_LONG).show();

        button_start_service = findViewById(R.id.button_start_service);
        button_start_service.setOnClickListener(this);

        button_stop_service = findViewById(R.id.button_stop_service);
        button_stop_service.setOnClickListener(this);

        service_intent = new Intent(this,Service__Started_Service_Play_Music_Start_Stop_Buttons.class);

    }

    public void onClick(View view)
    {
        if(view==button_start_service)
        {
            startService(service_intent);
            System.out.println("Service Started");
        }
        else if(view==button_stop_service)
        {
            stopService(service_intent);
            System.out.println("Service Stopped");
        }
    }

}
