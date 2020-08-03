package com.example.maps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

public class Fragment_Dynamic_Method extends AppCompatActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment__dynamic__method);

        SupportMapFragment supportMapFragment = SupportMapFragment.newInstance();//Factory Method

        getSupportFragmentManager().beginTransaction().add(R.id.framelayout_map_container,supportMapFragment).commit();

        supportMapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap)
    {
        Toast.makeText(Fragment_Dynamic_Method.this,"Fragment, Dynamic Method",Toast.LENGTH_LONG).show();
    }
}
