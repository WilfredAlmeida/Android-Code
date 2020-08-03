package com.example.first;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;//read below
import android.widget.VideoView;

public class Play_Video extends AppCompatActivity {

    VideoView videoView_video_player;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play__video);

        videoView_video_player = findViewById(R.id.videoView_video_player);
        mediaController = new MediaController(this);

        String video_path = "android.resource://com.example.first/"+R.raw.sample_video;

        Uri video_uri = Uri.parse(video_path);

        videoView_video_player.setVideoURI(video_uri);
        videoView_video_player.setMediaController(mediaController);//Setting play/pause button,
        //progress bar, forwards&backwards button for videoview.

        mediaController.setAnchorView(videoView_video_player);// setting a parent view to the
        //MediaController so that it will be attached to the specified view.

        videoView_video_player.start();
        

    }
}
