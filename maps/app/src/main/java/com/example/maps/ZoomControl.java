//Zoom Control is a type of option in google maps. It is accessible as a GoogleOptions Object.
//Below the object is created and passed as an parameter while creating the SupportMapFragment
//object.
package com.example.maps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

public class ZoomControl extends AppCompatActivity implements OnMapReadyCallback
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoom_control);

        GoogleMapOptions options = new GoogleMapOptions()
                .zoomGesturesEnabled(false).zoomControlsEnabled(true);
        //The below newInstance() method takes only one GoogleMapOptions as a parameter
        //and thus the above done thing works and do it that way:)(:


        SupportMapFragment mapFragment = SupportMapFragment.newInstance(options);
        //passing options as parameter means that now this support fragment will
        //show the specified options on whichever map component it is binded to.

        getSupportFragmentManager().beginTransaction()
                .add(R.id.framelayout_container_zoom_control,mapFragment).commit();

        mapFragment.getMapAsync(this);


    }

    @Override
    public void onMapReady(GoogleMap googleMap)
    {
        Toast.makeText(ZoomControl.this,"Zoom Control",Toast.LENGTH_LONG).show();
    }
}
