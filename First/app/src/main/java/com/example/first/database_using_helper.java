package com.example.first;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class database_using_helper extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_using_helper);

        helper helper = new helper(this);
        SQLiteDatabase database = helper.getWritableDatabase();


        //--------------Start: Database Insertion-----------------------
//        ContentValues values = new ContentValues();
//        values.put("sid","2");
//        values.put("sname","Joy");
//        values.put("marks","94");
//
//        long result = database_using_helper.insert("students",null,values);
//        System.out.println("Inserted "+result);
        //--------------End: Database Insertion-----------------------


        //-------------Start: Database Select query-------------------

        helper helper1 = new helper(this);
        SQLiteDatabase database1 = helper1.getReadableDatabase();

        String[] requires_columns = {"sid", "sname", "marks"};

        Cursor cursor = database1.query("students",requires_columns,null,null,null,null,null);

        System.out.println("ID Name Marks");

        while(cursor.moveToNext())
        {
            System.out.println(cursor.getString(0)+" "+cursor.getString(1)+" "+cursor.getString(2));
        }

        //-------------End: Database Select query-------------------
    }
}