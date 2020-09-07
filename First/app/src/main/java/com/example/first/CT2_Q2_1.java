package com.example.first;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class CT2_Q2_1 extends AppCompatActivity {

    EditText editText_Q2_1_student_name,editText_Q2_1_student_age,
            editText_Q2_1_student_rank,editText_Q2_1_student_roll_no,
            editText_Q2_1_student_percentage;

    TableRow tableRow_data_display;
    TableLayout tableLayout;
    SQLiteDatabase database_student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ct2__q2_1);

        Toast.makeText(this, "CT2-Q2-1", Toast.LENGTH_SHORT).show();

        editText_Q2_1_student_name = findViewById(R.id.editText_Q2_1_student_name);
        editText_Q2_1_student_age = findViewById(R.id.editText_Q2_1_student_age);
        editText_Q2_1_student_roll_no = findViewById(R.id.editText_Q2_1_student_roll_no);
        editText_Q2_1_student_percentage = findViewById(R.id.editText_Q2_1_student_percentage);
        editText_Q2_1_student_rank = findViewById(R.id.editText_Q2_1_student_rank);

        tableLayout = findViewById(R.id.tableLayout);

        findViewById(R.id.button_Q2_1_submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                method_do_operations();
            }
        });
    }

    void method_do_operations()
    {

        tableRow_data_display = new TableRow(this);

        String s1 = editText_Q2_1_student_name.getText().toString();
        String s2 = editText_Q2_1_student_age.getText().toString();
        String s3 = editText_Q2_1_student_roll_no.getText().toString();
        String s4 = editText_Q2_1_student_percentage.getText().toString();
        String s5 = editText_Q2_1_student_rank.getText().toString();

        database_student = openOrCreateDatabase("database_student",MODE_PRIVATE,null);

        database_student.execSQL("create table if not exists table_student(student_name text," +
                "student_age text,student_roll_no text,student_percentage text,student_rank text)");

        String insert_query = "insert into table_student values('"+s1+"','"+s2+"'," +
                "'"+s3+"','"+s4+"','"+s5+"')";

        database_student.execSQL(insert_query);


        Cursor cursor = database_student.rawQuery("select * from table_student",null);

        while(cursor.moveToNext())
        {
            String s11 = cursor.getString(0);
            String s22 = cursor.getString(1);
            String s33 = cursor.getString(2);
            String s44 = cursor.getString(3);
            String s55 = cursor.getString(4);

            TextView tv1 = new TextView(getApplicationContext());
            tv1.setText(s11);

            TextView tv2 = new TextView(getApplicationContext());
            tv2.setText(s22);

            TextView tv3 = new TextView(getApplicationContext());
            tv3.setText(s33);

            TextView tv4 = new TextView(getApplicationContext());
            tv4.setText(s44);

            TextView tv5 = new TextView(getApplicationContext());
            tv5.setText(s55);

            tableRow_data_display.addView(tv1,0);
            tableRow_data_display.addView(tv2,1);
            tableRow_data_display.addView(tv3,2);
            tableRow_data_display.addView(tv4,3);
            tableRow_data_display.addView(tv5,4);

            tableLayout.removeView(tableRow_data_display);
            tableLayout.addView(tableRow_data_display);
        }
    }

}
