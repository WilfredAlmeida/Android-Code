/*
Geocoding is translation of text address to longitude and latitude.
Longitude and latitude is used to navigate map to a specific location.
*/
package com.example.maps;

import androidx.appcompat.app.AppCompatActivity;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;
import java.util.Locale;

public class Markers_Geocoding_or_Navigating_to_specific_location extends AppCompatActivity implements OnMapReadyCallback
{

    GoogleMap map;
    EditText edittext_location;
    Button button_search_location;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_markers__geocoding_or__navigating_to_specific_location);

        button_search_location = findViewById(R.id.button_search_location);
        edittext_location = findViewById(R.id.edittext_location);

        button_search_location.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view)
            {
                try
                {
                search_location();
                }

                catch(Exception e)
                {
                    System.out.println("Exception:(");
                }
            }
        });

        //---------------Start: Initializing Map-------------------------------

        GoogleMapOptions options = new GoogleMapOptions().zoomControlsEnabled(true);

        SupportMapFragment supportMapFragment = SupportMapFragment.newInstance(options);//Factory Method

        getSupportFragmentManager().beginTransaction().add(R.id.container_marker_and_geocoding,supportMapFragment).commit();

        supportMapFragment.getMapAsync(this);
        //---------------End: Initializing Map-------------------------------
    }


    public void search_location() throws Exception
    {
        String search_query = edittext_location.getText().toString();

        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        //Geocoder is the class that does translation of address to longitude and
        //latitude.

        List<Address> address_list = geocoder.getFromLocationName(search_query,1);
                //Thing to be searched and number of maximum results to be returned.
        Address result_address = address_list.get(0);

        double latutude = result_address.getLatitude();
        double longitude = result_address.getLongitude();

        LatLng coordinates = new LatLng(latutude,longitude);

    //-------Start: Moves map to entered location and adds marker and zooms a bit on it
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(coordinates,13));
        map.addMarker(new MarkerOptions().position(coordinates));
    //-------End: Moves map to entered location and adds marker and zooms a bit on it

    }

    @Override
    public void onMapReady(GoogleMap googleMap)//GoogleMap here is reference to the map that is created
            //we can perform all operations of map here using this.
    {
        Toast.makeText(Markers_Geocoding_or_Navigating_to_specific_location.this
        ,"Markers, Geocoding, Navigating to a specific location",Toast.LENGTH_LONG).show();

        map = googleMap;//To access the map anywhere


    }
}
