package com.example.first;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;

public class listview extends AppCompatActivity {

    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        lv = findViewById(R.id.listview_languages);

        final String[] languages = new String[]{"C", "C++","Java","Python","Ruby","Scala"};
        

        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, Arrays.asList(languages));
        //ListView cannot directly take values to be displayed.
        //It can be done with the help of ArrayAdapter.
        //ArrayAdapter takes values in ArrayList format.
        //So we make an array of values, then using method Arrays.asList() which converts
        //array into list we pass it into array adapters 3rd parameter.
        //The R.layout.simple_list_item_1 stays like that.

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(listview.this,languages[position],Toast.LENGTH_SHORT).show();
            }
        });

    }
}
