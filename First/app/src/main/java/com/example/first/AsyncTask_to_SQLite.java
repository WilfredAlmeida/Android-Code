package com.example.first;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class AsyncTask_to_SQLite extends AppCompatActivity {

    EditText editText_asynctask_to_sqlite_name,editText_asynctask_to_sqlite_age;
    ListView listView_asynctask_to_sqlite_display_data;
    ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task_to__sqlite);

        Toast.makeText(AsyncTask_to_SQLite.this, "AsyncTask to SQLite", Toast.LENGTH_SHORT).show();

        editText_asynctask_to_sqlite_age = findViewById(R.id.editText_asynctask_to_sqlite_age);
        editText_asynctask_to_sqlite_name = findViewById(R.id.editText_asynctask_to_sqlite_name);
        listView_asynctask_to_sqlite_display_data = findViewById(R.id.listView_asynctask_to_sqlite_display_data);

        arrayList = new ArrayList<>();
        arrayList.add(0,"Name\tAge");

        findViewById(R.id.button_asynctask_to_sqlite_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MyAsyncTask_to_SQLite().execute();
                arrayList.clear();
            }
        });
    }

    class MyAsyncTask_to_SQLite extends android.os.AsyncTask<String,String,String>
    {

        @Override
        protected String doInBackground(String... strings) {

            SQLiteDatabase sqLiteDatabase = openOrCreateDatabase("MyDb",MODE_PRIVATE,null);

            sqLiteDatabase.execSQL("create table if not exists student(student_name text, stuednt_age text)");

            String string_name = editText_asynctask_to_sqlite_name.getText().toString();
            String string_age = editText_asynctask_to_sqlite_age.getText().toString();

            String insert_query = "insert into student values( '"+string_name+"','"+string_age+"')";

            sqLiteDatabase.execSQL(insert_query);

            Cursor cursor = sqLiteDatabase.rawQuery("select * from student",null);

            while(cursor.moveToNext())
            {
                arrayList.add(cursor.getString(0)+"\t"+cursor.getString(1));
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,arrayList);

            listView_asynctask_to_sqlite_display_data.setAdapter(adapter);
        }
    }
}
