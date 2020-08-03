package com.example.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.media.MediaPlayer;
import android.provider.Settings;

import androidx.annotation.Nullable;

public class Service__Started_Service_Play_Music_Start_Stop_Buttons extends Service
{

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    MediaPlayer player;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        player = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
        player.setLooping(true);
        player.start();

        return START_REDELIVER_INTENT;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        player.stop();
    }
}
