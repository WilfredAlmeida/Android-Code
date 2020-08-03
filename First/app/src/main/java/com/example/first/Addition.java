package com.example.first;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.*;

public class Addition extends AppCompatActivity {

    //Variables for representing GUI fields
    EditText num1;
    EditText num2;
    Button button_add;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition);

        //instantiating variables
        num1 = (EditText) findViewById(R.id.edittext_num1); //returns of type View, needs to be converted into EditText
        //method parameters Resource.id.actual_id
        num2 = (EditText) findViewById(R.id.edittext_num2);
        button_add = (Button) findViewById(R.id.button_add);
        result = (TextView) findViewById(R.id.textview_result);


        //For Registering listeners to buttons there are 2 ways:

        //1. Registering Listener using object
        //While using this method there should not be any method specified in GUI attribute onclick
        //Should be inside this method onCreate or something. I dont know, doesnt work outside it

        button_add.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                int n1 = Integer.parseInt(num1.getText().toString());
                int n2 = Integer.parseInt(num2.getText().toString());

                int res = n1+n2;

                result.setText("Addition is: "+res);
            }
        });

        //End of way 1

        }


    // 2. Specifying onclick event in GUI attributes window and defining the method in java code}
       //Should be outside the above method doesnt work inside.
//    public void addition(View v)
//    {
//        int n1 = Integer.parseInt(num1.getText().toString());
//        int n2 = Integer.parseInt(num2.getText().toString());
//
//        int res = n1+n2;
//
//        result.setText("Addition is: "+res);
//    }

    //End of way 2

}
