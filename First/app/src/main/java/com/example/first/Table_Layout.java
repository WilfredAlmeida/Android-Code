package com.example.first;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Table_Layout extends AppCompatActivity {

    EditText editText_number1,editText_number2;
    double double_number_1,double_number_2;
    TextView textView_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table__layout);

        Toast.makeText(this, "Table Layout, Calculator", Toast.LENGTH_SHORT).show();

        textView_result = findViewById(R.id.textView_table_layout_result);

        editText_number1 = findViewById(R.id.editText_table_layout_number_1);
        editText_number2 = findViewById(R.id.editText_table_layout_number_2);

        findViewById(R.id.button_table_layout_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double_number_1 = Integer.parseInt(editText_number1.getText().toString());
                double_number_2 = Integer.parseInt(editText_number2.getText().toString());

                textView_result.setText("Adddition = "+(double_number_1+double_number_2));
            }
        });

        findViewById(R.id.button_table_layout_subtract).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double_number_1 = Integer.parseInt(editText_number1.getText().toString());
                double_number_2 = Integer.parseInt(editText_number2.getText().toString());

                textView_result.setText("Subtraction = "+(double_number_1-double_number_2));
            }
        });

        findViewById(R.id.button_table_layout_multiply).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double_number_1 = Integer.parseInt(editText_number1.getText().toString());
                double_number_2 = Integer.parseInt(editText_number2.getText().toString());

                textView_result.setText("Multiplication = "+(double_number_1*double_number_2));
            }
        });

        findViewById(R.id.button_table_layout_divide).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double_number_1 = Integer.parseInt(editText_number1.getText().toString());
                double_number_2 = Integer.parseInt(editText_number2.getText().toString());

                textView_result.setText("Division = "+(double_number_1/double_number_2));
            }
        });
    }
}
