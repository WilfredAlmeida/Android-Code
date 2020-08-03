package com.example.maps;

import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

public class User_Location_Built_in_Button extends AppCompatActivity implements OnMapReadyCallback
{

    GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__location_built_in_button);

        if(isGpsEnabled())
        {
            GoogleMapOptions options = new GoogleMapOptions().zoomControlsEnabled(true);
            SupportMapFragment mapFragment = SupportMapFragment.newInstance(options);
            getSupportFragmentManager().beginTransaction().add(R.id.container_user_location, mapFragment).commit();
            mapFragment.getMapAsync(this);



        }
        else
            Toast.makeText(User_Location_Built_in_Button.this, "GPS must be enabled", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onMapReady(GoogleMap googleMap)
    {
        Toast.makeText(User_Location_Built_in_Button.this,"User Location",Toast.LENGTH_LONG).show();

        map = googleMap;

        map.setMyLocationEnabled(true);
    }

    public boolean isGpsEnabled()
    {

        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        boolean isenabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);

        return isenabled;
    }
}
