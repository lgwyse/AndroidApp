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


<<<<<<< HEAD
import org.json.JSONException;
import org.json.JSONObject;

import com.medpasshealth.myapplication.APICalls.RegisterUser;


public class Register extends Activity {

    private static final String TAG = "Register";
=======
>>>>>>> origin/master
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
<<<<<<< HEAD
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
=======

                if( username.getText().toString().trim().length() == 0 ) {
                    username.setError("An email address is required.");
                }
                else if( newpassword.getText().toString().trim().length() == 0 ) {
                    newpassword.setError("A password is required.");
                }
                else if( confirmnewpass.getText().toString().trim().length() == 0 ) {
                    confirmnewpass.setError("Please confirm your password.");
                }
                else if (!newpassword.getText().toString().equals(confirmnewpass.getText().toString())) {
                    confirmnewpass.setError("Password fields must match.");
                }
                else if (!agreementswitch.isChecked()) {
                    agreementswitch.setError("Must accept agreement to register.");
                }
                else Register.this.startActivity(new Intent(Register.this, ContactPersonal.class));
            }
>>>>>>> origin/master
        });
    }


}
