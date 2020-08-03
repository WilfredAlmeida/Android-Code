/*
* Drawable animations are animations performed using images.
* AnimationDrawable is the class used for performing drawable animations. It provides
* methods to schedule animations.
* All the required image files are added into res/drawable folder as a vector asset
* and then an xml file is created for making those images available for animation.
* for_animation_drawable.xml in this case. Also do read the downloaded book pdf(Terminator Image).
* */

package com.example.first;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class Animation_Drawable extends AppCompatActivity {

    ImageView imageView_animation_drawable;
    Button button_animate;
    AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_drawable);


        imageView_animation_drawable = findViewById(R.id.imageview_animation_drawable);
        imageView_animation_drawable.setBackgroundResource(R.drawable.for_animation_drawable);

        animationDrawable = (AnimationDrawable) imageView_animation_drawable.getBackground();

        button_animate = findViewById(R.id.button_animate);
        button_animate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animationDrawable.start();//Starts the animation. Cannot be called in onCreate() bcz
                //some loading stuff is not done at that point.
            }
        });



    }
}
