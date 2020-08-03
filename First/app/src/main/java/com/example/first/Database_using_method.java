package com.example.first;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.EditText;
import android.database.sqlite.SQLiteDatabase;

public class Database_using_method extends AppCompatActivity {

    EditText editText_database_display_percentage, editText_database_display_name,
            editText_database_display_branch, editText_database_display_roll_no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_using_method);

        editText_database_display_name = findViewById(R.id.editText_database_display_name);
        editText_database_display_roll_no = findViewById(R.id.editText_database_display_roll_no);
        editText_database_display_branch = findViewById(R.id.editText_database_display_branch);
        editText_database_display_percentage = findViewById(R.id.editText_database_display_percentage);


        String database_name = "database_using_method";
        int database_mode = MODE_PRIVATE;

        SQLiteDatabase database = openOrCreateDatabase(database_name,database_mode,null);

        database.execSQL("create table if not exists table_student(student_name text,student_roll_no" +
                " numeric(4),student_branch text(2), student_percentage double(4))");

        database.execSQL("insert into table_student values('wilfred',1924,'CO',92.67)");

        Cursor cursor = database.rawQuery("select * from table_student",null);

        cursor.moveToFirst();

        while(cursor.moveToNext())
        {
            editText_database_display_name.append("\n"+cursor.getString(0));
            editText_database_display_roll_no.append("\n"+cursor.getInt(1));
            editText_database_display_branch.append("\n"+cursor.getString(2));
            editText_database_display_percentage.append("\n"+cursor.getDouble(3));
        }

        editText_database_display_name.setEnabled(false);
        editText_database_display_roll_no.setEnabled(false);
        editText_database_display_branch.setEnabled(false);
        editText_database_display_percentage.setEnabled(false);
    }
}
