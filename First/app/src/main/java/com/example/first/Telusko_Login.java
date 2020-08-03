package com.example.first;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Telusko_Login extends AppCompatActivity {

    EditText name;
    EditText email;
    EditText password;
    Button login;
    RadioGroup gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telusko__login);

        name = findViewById(R.id.edittext_name);
        email = findViewById(R.id.edittext_email);
        password = findViewById(R.id.edittext_password);
        login = findViewById(R.id.button_login);
        gender = findViewById(R.id.radiogroup_gender);



        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                int id = gender.getCheckedRadioButtonId();
                final RadioButton gen = findViewById(id);

                Intent intent = new Intent(Telusko_Login.this,Telusko_Login_Intent.class);
                intent.putExtra("name",name.getText().toString());
                intent.putExtra("gender",gen.getText().toString());
                intent.putExtra("email",email.getText().toString());
                intent.putExtra("password",password.getText().toString());

                startActivity(intent);

                try{
                Toast.makeText(Telusko_Login.this,"Name: "+name.getText().toString()+"\nGender: "+gen.getText().toString()+"\nemail: "+email.getText().toString()+"\nPassword: "+password.getText().toString(),Toast.LENGTH_SHORT).show();
                }catch(NullPointerException e){System.out.println(e);}
            }
        });


    }
}
