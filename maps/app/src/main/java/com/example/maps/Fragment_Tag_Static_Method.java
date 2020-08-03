package com.example.maps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

public class Fragment_Tag_Static_Method extends AppCompatActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment__tag__static__method);

        SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.support_map_fragment_tag); //Read comment in XML first.
        //we get reference to fragment in xml by using findFragmentById() method of
        //FragmentManager. Now we can perform operations on it just like MapView component.
        //Only thing is now we don't need to call any lifecycle methods just like we did
        //in case of MapView Component

        supportMapFragment.getMapAsync(this); //getting the map

    }

    @Override
    public void onMapReady(GoogleMap googleMap)
    {
        Toast.makeText(Fragment_Tag_Static_Method.this,"Fragment Tag, Static Method",Toast.LENGTH_SHORT).show();
    }
}
