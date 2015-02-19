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
import android.widget.Toast;


public class Register extends Activity {


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
                if (((Switch) findViewById(R.id.agreementswitch)).isChecked()) {
                    Register.this.startActivity(new Intent(Register.this, CreatePassword.class));
                    }
                }
        });
    }


}
