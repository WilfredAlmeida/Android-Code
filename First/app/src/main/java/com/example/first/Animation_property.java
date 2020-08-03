//Property animation is embedded in the view.
//Also do read the downloaded book pdf(Terminator Image
package com.example.first;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Animation_property extends AppCompatActivity {

    TextView textView_animation_property;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_property);

        Toast.makeText(this,"Property Animation",Toast.LENGTH_LONG).show();

        textView_animation_property = findViewById(R.id.textView_animation_property);
        findViewById(R.id.button_animation_property_animate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //textView_animation_property.animate().scaleX(5f).scaleY(5f);
                //Will increase the size of the textview.
            }
        });
    }
}
