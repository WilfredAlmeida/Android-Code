package com.example.first;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Content_Provider_Read_Contacts extends AppCompatActivity {

    ListView listView_contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content__provider__read__contacts);

        Toast.makeText(this,"Content Provider, Read Contacts",Toast.LENGTH_SHORT).show();

        listView_contacts = findViewById(R.id.listView_contacts);

        Cursor cursor = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI,null,null,null,null);
        cursor.moveToFirst();

        ArrayList<String> arrayList_contacts = new ArrayList<>();

        do {
            String name = cursor.getString(
                    cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
            String id = cursor.getString(
                    cursor.getColumnIndex(ContactsContract.Contacts.NAME_RAW_CONTACT_ID));

            Cursor phones = getContentResolver()
                    .query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                            null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = " + id,
                            null,
                            null);
            if (phones != null) {
                while (phones.moveToNext()) {
                    String phoneNumber = phones.getString(
                            phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                    arrayList_contacts.add("Name: "+name+"\nNumber: "+phoneNumber);
                    System.out.println("Name: "+name+"\nNumber: "+phoneNumber);
                }
                phones.close();
            }

        } while (cursor.moveToNext());

        cursor.close();
        listView_contacts.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,arrayList_contacts));

    }
}
