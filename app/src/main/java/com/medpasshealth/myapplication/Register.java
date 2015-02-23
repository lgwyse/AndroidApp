package com.medpasshealth.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Switch;

import android.util.Log;


import org.json.JSONException;
import org.json.JSONObject;

import com.medpasshealth.myapplication.APICalls.RegisterUser;


public class Register extends Activity {

    private static final String TAG = "Register";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        findViewById(R.id.agreecbtext).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Register.this.startActivity(new Intent(Register.this, TermsOfUse.class));
            }
        });

        findViewById(R.id.registerbutton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if ((((Switch) findViewById(R.id.agreementswitch)).isChecked())&& (findViewById(R.id.newpassword)== findViewById(R.id.confirmpassword))) {
                    //Register.this.startActivity(new Intent(Register.this, CreatePassword.class));

                    Log.d(TAG,"Register On click event" );
                    String emailAddress = findViewById(R.id.autoCompleteTextView).toString();
                    String password=findViewById(R.id.newpassword).toString();



                    JSONObject user = new JSONObject();

                    try {

                        user.put("email", emailAddress);
                        user.put("password", password);
                        Log.d(TAG,"Converting user info to JSON successful" );
                        RegisterUser call = new RegisterUser(user);

                        call.execute();



                    } catch (JSONException e) {
                        Log.d(TAG,"Converting user info to JSON failed" );
                        e.printStackTrace();

                    }


                    }
                //}
        });
    }


}
