package com.example.first;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Arrays;

public class Gridview extends AppCompatActivity {

    GridView gridView_languages,gridView_images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview);

        Toast.makeText(this, "GridView", Toast.LENGTH_SHORT).show();

        gridView_languages = findViewById(R.id.gridView_languages);
        gridView_images = findViewById(R.id.gridView_images);

        String[] languages = {"C","C++","Java","Python","Go","JavaScript","Husk","Visual Basic",
        "Assembly","C#","Cobol","Cow","Swift","Scala","Ruby","B","C","C++","Java","Python","Go","JavaScript","Husk","Visual Basic",
                "Assembly","C#","Cobol","Cow","Swift","Scala","Ruby","B","C","C++","Java","Python","Go","JavaScript","Husk","Visual Basic",
                "Assembly","C#","Cobol","Cow","Swift","Scala","Ruby","B","C","C++","Java","Python","Go","JavaScript","Husk","Visual Basic",
                "Assembly","C#","Cobol","Cow","Swift","Scala","Ruby","B","C","C++","Java","Python","Go","JavaScript","Husk","Visual Basic",
                "Assembly","C#","Cobol","Cow","Swift","Scala","Ruby","B","C","C++","Java","Python","Go","JavaScript","Husk","Visual Basic",
                "Assembly","C#","Cobol","Cow","Swift","Scala","Ruby","B","C","C++","Java","Python","Go","JavaScript","Husk","Visual Basic",
                "Assembly","C#","Cobol","Cow","Swift","Scala","Ruby","B","C","C++","Java","Python","Go","JavaScript","Husk","Visual Basic",
                "Assembly","C#","Cobol","Cow","Swift","Scala","Ruby","B","C","C++","Java","Python","Go","JavaScript","Husk","Visual Basic",
                "Assembly","C#","Cobol","Cow","Swift","Scala","Ruby","B","C","C++","Java","Python","Go","JavaScript","Husk","Visual Basic",
                "Assembly","C#","Cobol","Cow","Swift","Scala","Ruby","B","C","C++","Java","Python","Go","JavaScript","Husk","Visual Basic",
                "Assembly","C#","Cobol","Cow","Swift","Scala","Ruby","B","C","C++","Java","Python","Go","JavaScript","Husk","Visual Basic",
                "Assembly","C#","Cobol","Cow","Swift","Scala","Ruby","B","C","C++","Java","Python","Go","JavaScript","Husk","Visual Basic",
                "Assembly","C#","Cobol","Cow","Swift","Scala","Ruby","B","C"};

        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_gallery_item,Arrays.asList(languages));

        gridView_languages.setAdapter(adapter);//set this to display languages
        gridView_images.setAdapter(new ImageAdapter(this));//set this to display images

    }

    public class ImageAdapter extends BaseAdapter {
        private Context mContext;

        // Constructor
        public ImageAdapter(Context c) {
            mContext = c;
        }

        public int getCount() {
            return mThumbIds.length;
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        // create a new ImageView for each item referenced by the Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;

            if (convertView == null) {
                imageView = new ImageView(mContext);
                imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(8, 8, 8, 8);
            }
            else
            {
                imageView = (ImageView) convertView;
            }
            imageView.setImageResource(mThumbIds[position]);
            return imageView;
        }

        // Keep all Images in array
        public Integer[] mThumbIds = {
                R.drawable.ic_signal_wifi_signal_0,R.drawable.ic_signal_wifi_signal_1,
                R.drawable.ic_signal_wifi_signal_2,R.drawable.ic_signal_wifi_signal_3,
                R.drawable.ic_signal_wifi_signal_4
        };
    }
}
