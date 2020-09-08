package com.example.services;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.provider.Settings;

import androidx.annotation.Nullable;

public class Service__Bound_Service_Start_Stop_Button extends Service
{

    IBinder mBinder = new MyBinder();

    MediaPlayer player;

    @Nullable
    @Override
    public IBinder onBind(Intent intent)
    {
        startMedia();
        return mBinder;
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        System.out.println("Reached Destroy");
        player.stop();
    }

    public class MyBinder extends Binder
    {
        public Service__Bound_Service_Start_Stop_Button getService()
        {
            return Service__Bound_Service_Start_Stop_Button.this;
        }
    }

    void startMedia()
    {
        player = MediaPlayer.create(getApplicationContext(), Settings.System.DEFAULT_NOTIFICATION_URI);
        player.setLooping(true);
        player.start();

    }

}
