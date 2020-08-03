//Read downloaded pdf book 2 for understanding receiving sms. Its best
package com.example.first;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class sms_telephony extends AppCompatActivity {

    EditText number, message;
    Button send;
    static ListView listView_received_sms;
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS =0;
    static SmsMessage[] smsMessage;
    static ArrayList<String> messages = new ArrayList<>();
    static ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms_telephony);

        Toast.makeText(this,"SMS Telephony",Toast.LENGTH_SHORT);

        number = findViewById(R.id.edittext_number);
        message = findViewById(R.id.edittext_message);
        listView_received_sms = findViewById(R.id.listView_received_sms);
        send = findViewById(R.id.button_send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String msg = message.getText().toString();
                String num = number.getText().toString();

                if (ContextCompat.checkSelfPermission(sms_telephony.this,
                        Manifest.permission.SEND_SMS)
                        != PackageManager.PERMISSION_GRANTED) {
                    if (!ActivityCompat.shouldShowRequestPermissionRationale(sms_telephony.this,
                            Manifest.permission.SEND_SMS)) {
                                ActivityCompat.requestPermissions(sms_telephony.this,
                                        new String[]{Manifest.permission.SEND_SMS},
                                        MY_PERMISSIONS_REQUEST_SEND_SMS);
                            }
                }
                SmsManager sms = SmsManager.getDefault();
                sms.sendTextMessage(num,null,msg,null,null);
            }
        });
    }

    public static class class_smsreceived extends BroadcastReceiver
    {
        @Override
        public void onReceive(Context context, Intent intent)
        {
            Bundle extras = intent.getExtras();
            Object[] pdus = (Object[]) extras.get("pdus");
            smsMessage = new SmsMessage[pdus.length];

            for(int i=0;i<smsMessage.length;i++)
            {
                smsMessage[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
            }

            for(SmsMessage msg:smsMessage)
            {
                 messages.add("From: "+msg.getOriginatingAddress()+"\nMessage: "+msg.getMessageBody());
            }

            adapter = new ArrayAdapter<>(context,android.R.layout.simple_list_item_1,messages);
            listView_received_sms.setAdapter(adapter);
        }
    }
}
