package com.example.first;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.media.MediaPlayer;

public class Play_Music extends AppCompatActivity implements View.OnClickListener{

    Button button_start_music,button_pause_music,button_stop_music;
    MediaPlayer music_player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play__music);

        button_start_music = findViewById(R.id.button_start_music);
        button_start_music.setOnClickListener(this);

        button_pause_music = findViewById(R.id.button_pause_music);
        button_pause_music.setOnClickListener(this);

        button_stop_music = findViewById(R.id.button_stop_music);
        button_stop_music.setOnClickListener(this);

        music_player = MediaPlayer.create(this,R.raw.alone_part_2);
        music_player.setLooping(true);
    }

    @Override
    public void onClick(View view)
    {
        if(view == button_start_music)
        {
                music_player.start();
        }
        else if(view == button_pause_music)
        {
            music_player.pause();
        }
        else if(view == button_stop_music)
        {
            music_player.pause();
            music_player.seekTo(0);
        }
    }
}
