package com.example.first;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.EditText;

import java.util.Locale;

public class Text_to_Speech extends AppCompatActivity {

    EditText editText_text_for_speech;
    TextToSpeech mtts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_to__speech);

        editText_text_for_speech = findViewById(R.id.edittext_text_to_speech);

        mtts = new TextToSpeech(this, new TextToSpeech.OnInitListener(){
            @Override
            public  void onInit(int status)
            {
                mtts.setLanguage(Locale.getDefault());
            }
        });

        findViewById(R.id.button_convert_text_to_speech).setOnClickListener(new View.OnClickListener(){
            public void onClick(View view)
            {

                String text = editText_text_for_speech.getText().toString();

                mtts.speak(text,TextToSpeech.QUEUE_ADD,null);
            }
        });

    }
}
