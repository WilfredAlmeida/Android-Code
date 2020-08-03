//Read Chapter 45 of downloaded pdf book.
/*
 * Steps to make Bound Service:
 *
 * 1. Create Separate class file which extends Service. Lets call it class A.
 *
 * 2. Create class that extends Binder class inside class A. Binder Class internally implements
 *    IBinder interface. Lets call it class B.
 *
 * 3. Create global variable IBinder binder = new B().
 *
 * 4. Create method in class B with return type = A and from this method return a reference
 *     to class A using A.this. Lets call this method as getService().
 *
 * 5. Return the variable 'binder' created in step 3 from overridden onBind() method of class A.
 * //Note: The onBind() method should contain the work to be done by the service.
 *
 * 6. Define onDestroy() of class A. Write the work to done when service is gonna be unbinded.
 *
 //* Now in Application Activity/Fragment that wants to bind to the service.
 * 7. Look at the ServiceConnection object defined below. Methods defined in it are
 *    callback methods which are called when service is binded using bindService() method.
 *    Lets call it D.
 *
 * 8. Now bind/unbind the service wherever, however you want using methods
 *    bindService(intent of service, ServiceConnection object D, flag) and
 *    unBindService(ServiceConnection object D)
 */

package com.example.services;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Bound_Service_Start_Stop_Button extends AppCompatActivity implements View.OnClickListener{

    private boolean isBound = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bound__service__start__stop__button);

        Toast.makeText(getApplicationContext(), "Bound_Service_Start_Stop_Button", Toast.LENGTH_SHORT).show();

        findViewById(R.id.button_start_service).setOnClickListener(this);
        findViewById(R.id.button_stop_service).setOnClickListener(this);

    }

    public void onClick(View view)
    {
        if(view == findViewById(R.id.button_start_service))
        {

            bindService(new Intent(getApplicationContext(),
                    Service__Bound_Service_Start_Stop_Button.class),
                    serviceConnection, Context.BIND_AUTO_CREATE);

            System.out.println("Service Started");
        }
        else if(view == findViewById(R.id.button_stop_service))
        {
            unbindService(serviceConnection);
            System.out.println("Service Stopped");
        }
    }

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service)
        {
            Service__Bound_Service_Start_Stop_Button.MyBinder binder
                    = (Service__Bound_Service_Start_Stop_Button.MyBinder) service;

            Service__Bound_Service_Start_Stop_Button created_service
                    = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name)
        {
            System.out.println("Something happened and couldn't maintain connection with" +
                    "service");
        }
    };

}
