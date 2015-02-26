package com.medpasshealth.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;

import android.util.Log;
import android.widget.Toast;


import org.json.JSONException;
import org.json.JSONObject;

import com.medpasshealth.myapplication.APICalls.RegisterUser;


public class Register extends Activity {

    private static final String TAG = "Register";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText username = (EditText) findViewById(R.id.email);
        final EditText newpassword = (EditText) findViewById(R.id.newpassword);
        final EditText confirmnewpass = (EditText) findViewById(R.id.confirmpassword);
        final Switch agreementswitch = (Switch) findViewById(R.id.agreementswitch);

        findViewById(R.id.agreecbtext).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                Register.this.startActivity(new Intent(Register.this, TermsOfUse.class));
            }
        });

        findViewById(R.id.registerbutton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Log.d(TAG, "Register On click event");

                if (username.getText().toString().trim().length() == 0) {
                    username.setError("Email address is required");
                } else if (newpassword.getText().toString().trim().length() == 0) {
                    newpassword.setError("Password is required");
                } else if (confirmnewpass.getText().toString().trim().length() == 0) {
                    confirmnewpass.setError("Confirm your password");
                } else if (!newpassword.getText().toString().equals(confirmnewpass.getText().toString())) {
                    confirmnewpass.setError("Password fields must match");
                } else if (!agreementswitch.isChecked()) {
                    agreementswitch.setError("Must accept agreement to register");
                } else{
                    JSONObject user = new JSONObject();
                    try {
                        user.put("email", username.getText());
                        user.put("password", newpassword.getText());
                        Log.d(TAG, "Converting user info to JSON successful");
                        RegisterUser call = new RegisterUser(user);
                        call.execute();
                        try {
                            int errornum = call.Erroor;
                            Toast toast = Toast.makeText(getApplicationContext(), "Error " + errornum, Toast.LENGTH_LONG);
                            toast.show();
                        /*Register.this.startActivity(new Intent(Register.this, ContactPersonal.class));*/
                        }
                        catch (Exception e) {
                            call.Erroor = 11111;
                        }
                        
                    } catch (JSONException e) {
                        Log.d(TAG, "Converting user info to JSON failed");
                        e.printStackTrace();

                    }
                }
            }
        });
    }
}
