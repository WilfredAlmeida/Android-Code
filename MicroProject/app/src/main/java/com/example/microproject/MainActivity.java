package com.example.microproject;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private final int REQ_CODE = 100; //Used as a status code. will be returned if things go right below somewhere
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text);

        Button speak = findViewById(R.id.speak);
        speak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH); //Starts an activity that will
                // prompt the user for speech and send it through a speech recognizer. The results will be returned via activity results

                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                        RecognizerIntent.LANGUAGE_MODEL_FREE_FORM); //Extra Language model is required.
                //EXTRA_LANGUAGE_MODEL Informs the recognizer which speech model to prefer when performing speech recognition

                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
                //EXTRA_LANGUAGE informs the recognizer to perform speech recognition in a language different than the default
                //getDefault() gets the default language of running device

                intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak");//Optional text prompt to show to the user when asking them to speak.

                //-------------Start: Exception if device is not supported----------------------
                try {
                    startActivityForResult(intent, REQ_CODE); //starts the intent for getting some
                    //result from it. REQ_CODE will be passed on to onActivityResult() method which is below as
                    //requestcode to help it identify which intent sent the result.
                }
                catch (ActivityNotFoundException a) {
                    System.out.println("Device not Supported");
                }
                //-------------End: Exception if device is not supported----------------------
            }
        });
    }

    //----------------Start: Putting text on TextView---------------------------
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data); //Sends data somewhere where it is needed
        switch (requestCode) { // Sends results for many things and each thing is assigned a request code for reference purpose

            case REQ_CODE: { //if the request code is same as the one we sent in startActivityForResult() method do the following
                if (resultCode == RESULT_OK && data!=null) {
                    ArrayList result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    textView.setText((CharSequence) result.get(0));
                }
                break;
            }
        }
    }
    //----------------End: Putting text on TextView---------------------------
}