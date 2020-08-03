//Performing Addition by sending request to PHP code on localhost server
package com.example.first;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class AsyncTask extends AppCompatActivity {

    EditText num1,num2;
    Button add;
    public String str_url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);

        num1 = findViewById(R.id.edittext_num1);
        num2 = findViewById(R.id.edittext_num2);
        add = findViewById(R.id.button_add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                int n1 = Integer.parseInt(num1.getText().toString());
                int n2 = Integer.parseInt(num2.getText().toString());

                str_url = "https://www.google.com/search?q=add+"+n1+"+and+"+n2;

                new MyAsyncTask().execute();
            }
        });
    }

    public class MyAsyncTask extends android.os.AsyncTask<String,String,String>
    {
        String result;
        @Override
        protected String doInBackground(String... strings)
        {
            try
            {
                URL url = new URL(str_url);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.connect();

                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                result = reader.readLine();
                System.out.println("Result: "+result);
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            Toast.makeText(AsyncTask.this,"Addition is: "+result,Toast.LENGTH_LONG).show();
        }
    }
}
