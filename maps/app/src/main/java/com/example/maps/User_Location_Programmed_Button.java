package com.example.maps;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

import android.view.View;
import android.widget.Toast;

public class User_Location_Programmed_Button extends AppCompatActivity implements OnMapReadyCallback, LocationListener {

    GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__location__programmed__button);

        Toast.makeText(this, "User Location, Programmed Button", Toast.LENGTH_LONG).show();

        SupportMapFragment mapFragment = SupportMapFragment.newInstance();
        getSupportFragmentManager().beginTransaction().add(R.id.container_user_location_programmed_button, mapFragment).commit();

        findViewById(R.id.button_get_my_location).setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                method_goto_my_location();
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    void method_goto_my_location() {
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    Activity#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for Activity#requestPermissions for more details.
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        if(map!=null)
        {
            Toast.makeText(getApplicationContext(),"Map Ready",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onLocationChanged(Location location)
    {
        System.out.println("Reached onLocationChanged");
        LatLng coordinates = new LatLng(location.getLatitude(),location.getLongitude());

        map.animateCamera(CameraUpdateFactory.newLatLngZoom(coordinates,13));
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}