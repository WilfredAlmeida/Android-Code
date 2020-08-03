package com.example.first;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.net.wifi.WifiManager;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;

public class Toggle_Button_Wifi_On_Off extends AppCompatActivity {

    ToggleButton toggleButton_wifi;
    WifiManager wifiManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle_button_wifi_on_off);

        Toast.makeText(this, "Toggle Button, Wifi", Toast.LENGTH_SHORT).show();

        toggleButton_wifi = findViewById(R.id.toggleButton_wifi);

        wifiManager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);

        toggleButton_wifi.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(toggleButton_wifi.isChecked())
                {
                    wifiManager.setWifiEnabled(true);
                    Toast.makeText(Toggle_Button_Wifi_On_Off.this, "Wifi On", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    wifiManager.setWifiEnabled(false);
                    Toast.makeText(Toggle_Button_Wifi_On_Off.this, "Wifi Off", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
