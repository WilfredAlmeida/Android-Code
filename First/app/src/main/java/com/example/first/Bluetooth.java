package com.example.first;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

public class Bluetooth extends AppCompatActivity {

    final private int BLUETOOTH_REQUEST_CODE=2;
    final private int BLUETOOTH_DISCOVERY_CODE = 4;

    Button button_enable_bluetooth,button_disable_bluetooth,
            button_turn_on_discovery,button_list_paired_devices;
    ListView listview_paired_devices;

    BluetoothAdapter bluetoothAdapter;
    Set<BluetoothDevice> set_paired_devices;
    ArrayList<String> arrayList_paired_devices = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        listview_paired_devices = findViewById(R.id.listview_paired_devices);

        button_enable_bluetooth = findViewById(R.id.button_enable_bluetooth);
        button_enable_bluetooth.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                method_enable_bluetooth();
            }
        });

        button_disable_bluetooth = findViewById(R.id.button_disable_bluetooth);
        button_disable_bluetooth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                method_disable_bluetooth();
            }
        });

        button_turn_on_discovery = findViewById(R.id.button_turn_on_discoverable);
        button_turn_on_discovery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                method_turn_on_discovery();
            }
        });

        button_list_paired_devices = findViewById(R.id.button_list_paired_devices);
        button_list_paired_devices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                method_list_paired_devices();
            }
        });
    }

    void method_enable_bluetooth()
    {
        if(!bluetoothAdapter.isEnabled())
        {
            Intent intent_enable_bluetooth = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);

            startActivityForResult(intent_enable_bluetooth,BLUETOOTH_REQUEST_CODE);
        }
    }

    void method_disable_bluetooth()
    {
        bluetoothAdapter.disable();
        Toast.makeText(this,"Bluetooth Disabled",Toast.LENGTH_SHORT);
    }

    void method_turn_on_discovery()
    {
        Intent intent_turn_on_discovery = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);

        startActivityForResult(intent_turn_on_discovery,BLUETOOTH_DISCOVERY_CODE);
    }

    void method_list_paired_devices()
    {
        set_paired_devices = bluetoothAdapter.getBondedDevices();

        for(BluetoothDevice bluetoothDevice:set_paired_devices)
        {
            arrayList_paired_devices.add(bluetoothDevice.getName());
            Log.d("BLUETOOTH NAME: ",bluetoothDevice.getName());
        }


        final ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, arrayList_paired_devices);
        listview_paired_devices.setAdapter(adapter);

        Toast.makeText(this,"Paired Devices",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent)
    {
        switch(requestCode)
        {
            case BLUETOOTH_REQUEST_CODE:
            {
                if(resultCode == RESULT_CANCELED)
                {
                    Toast.makeText(this, "Bluetooth not Enabled", Toast.LENGTH_LONG).show();

                    Log.d("BLUETOOTH NAME: ",bluetoothAdapter.getName());
                }
                else if(resultCode == RESULT_OK)
                {
                    Toast.makeText(this,"Bluetooth Enabled",Toast.LENGTH_LONG).show();
                    Log.d("BLUETOOTH NAME: ",bluetoothAdapter.getName());
                }
                break;
            }

            case BLUETOOTH_DISCOVERY_CODE:
                if(resultCode == RESULT_OK)
                {
                    Toast.makeText(getApplicationContext(),"Discovery Enabled",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
