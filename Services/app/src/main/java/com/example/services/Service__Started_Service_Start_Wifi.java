package com.example.services;

import android.app.Service;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class Service__Started_Service_Start_Wifi extends Service
{

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        Intent wifi = new Intent(String.valueOf(WifiManager.WIFI_STATE_ENABLED));
        startActivity(wifi);
        return START_REDELIVER_INTENT;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
