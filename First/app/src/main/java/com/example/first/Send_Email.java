package com.example.first;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Send_Email extends AppCompatActivity {

    EditText editText_email_id,editText_subject,editText_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send__email);

        editText_email_id = findViewById(R.id.edittext_email);
        editText_subject = findViewById(R.id.editText_subject);
        editText_message = findViewById(R.id.editText_message);

    findViewById(R.id.button_send_email).setOnClickListener(new View.OnClickListener(){

        @Override
        public void onClick(View view)
        {
            String string_email_id = editText_email_id.getText().toString();
            String[] email_ids = string_email_id.split(",");
            String string_subject = editText_subject.getText().toString();
            String string_message = editText_message.getText().toString();

            //To send email we make a intent and give data to it and than system displays
            //email client selector and we select client and data is automatically there
            //and we just click send.

            Intent intent_email = new Intent(Intent.ACTION_SEND);
            intent_email.putExtra(Intent.EXTRA_EMAIL,email_ids);
            intent_email.putExtra(Intent.EXTRA_SUBJECT,string_subject);
            intent_email.putExtra(Intent.EXTRA_TEXT,string_message);

            intent_email.setType("message/rfc822");
            startActivity(Intent.createChooser(intent_email,"Choose an Email Client"));
        }
    });

    }
}
