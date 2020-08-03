package com.example.maps;

import androidx.appcompat.app.AppCompatActivity;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class Reverse_Geocoding extends AppCompatActivity {

    EditText edittext_latitide,edittext_longitude;
    TextView textview_result;
    Button button_reverse_geocode;

    List<Address> address_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reverse__geocoding);

        edittext_latitide = findViewById(R.id.editText_latitude);
        edittext_longitude = findViewById(R.id.editText_longitude);
        textview_result = findViewById(R.id.button_reverse_geocode);
        button_reverse_geocode = findViewById(R.id.button_reverse_geocode);
        button_reverse_geocode.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view)
            {
                try
                {
                    method_reverse_geocode();
                }
                catch (NullPointerException i)
                {
                    System.out.println(i);
                }
            }
        });

    }

    public void method_reverse_geocode() {
        double latitude = Double.parseDouble(edittext_latitide.getText().toString());
        double longitude = Double.parseDouble(edittext_longitude.getText().toString());


        Geocoder geocoder = new Geocoder(this, Locale.getDefault());

        try {
            address_list = geocoder.getFromLocation(latitude, longitude, 1);
        } catch (IOException i) {
            System.out.println(i);
        }

        if(address_list.size()>0)
        {

            Address result_address = address_list.get(0);

            String final_result_address = result_address.getAddressLine(0);

            textview_result.setText(final_result_address);
        }
        else
        {
            Toast.makeText(Reverse_Geocoding.this,"Nothing Found",Toast.LENGTH_LONG).show();
        }
    }
}
