package com.example.services;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Service;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiNetworkSpecifier;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Started_Srevice_Start_Wifi extends AppCompatActivity {

    WifiManager wifiManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_started__srevice__start__wifi);

        wifiManager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);

        findViewById(R.id.button_enable_wifi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent wifi = new Intent(String.valueOf(WifiManager.WIFI_STATE_ENABLED));
                startActivityForResult(wifi,4);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == 4 && resultCode == RESULT_OK)
        {
            Toast.makeText(getApplicationContext(),"Wifi Enabled",Toast.LENGTH_SHORT).show();
        }
    }
}
