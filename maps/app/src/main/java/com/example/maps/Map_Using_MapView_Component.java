package com.example.maps;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;

public class Map_Using_MapView_Component extends AppCompatActivity implements OnMapReadyCallback
{
    int PERMISSION_REQUEST_CODE = 9001;
    MapView mapview;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map__using__map_view__component);

        //Checking and asking permission below if condition
        //OnMapReadyCallback interface is Callback interface for when the map is ready to be used.
        //Once an instance of this interface is set on a MapFragment or MapView object,
        // the onMapReady(GoogleMap) method is triggered when the map is ready
        // to be used and provides a non-null instance of GoogleMap.
        //request code for location permission
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED)
            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_REQUEST_CODE);

        mapview = findViewById(R.id.mapview_component);
        mapview.getMapAsync(this);// Gets map from server against api key
        mapview.onCreate(savedInstanceState);//Whenever MapView is used, its lifecycle methods are needed to be called
        //in sync with lifecycle methods of MainActivity. Passes parameter here makes it stay in sync with main activity.
        //Below all lifecycle methods of main activity are overwritten and corresponding lifecycle methods of mapview are called.

    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode==PERMISSION_REQUEST_CODE&&grantResults[0]==PackageManager.PERMISSION_GRANTED)
        {
            Toast.makeText(Map_Using_MapView_Component.this,"Permission Granted",Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(Map_Using_MapView_Component.this,"Permission Denied",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mapview.onStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapview.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapview.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapview.onDestroy();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapview.onStop();
    }

    @Override
    public void onMapReady(GoogleMap googleMap)
    {
        Toast.makeText(Map_Using_MapView_Component.this,"Fragment Tag, MapView Component",Toast.LENGTH_LONG).show();
    }



}
