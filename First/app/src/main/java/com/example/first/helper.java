package com.example.first;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class helper extends SQLiteOpenHelper {
    public helper(@Nullable Context context)
    {
        super(context, "student.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table students (sid text, sname text, marks text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("drop table if exists student");//delete table if it exists and create new one
    }
}
