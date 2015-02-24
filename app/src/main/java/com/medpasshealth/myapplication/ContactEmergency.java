package com.medpasshealth.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class ContactEmergency extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_emergency);

        final EditText firstname = (EditText) findViewById(R.id.firstname);
        final EditText lastname = (EditText) findViewById(R.id.lastname);
        final TextView relationtext = (TextView) findViewById(R.id.relationtext);
        final EditText primaryphone = (EditText) findViewById(R.id.primaryphone);
        final EditText secphone = (EditText) findViewById(R.id.secphone);

        final Spinner relationship = (Spinner) findViewById(R.id.relationship);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.relation_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        relationship.setAdapter(adapter);
        
        findViewById(R.id.contnu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                relationtext.setError(null);
                
                if( firstname.getText().toString().trim().length() == 0 ) {
                    firstname.setError("Required");
                }
                else if( lastname.getText().toString().trim().length() == 0 ) {
                    lastname.setError("Required");
                }
                else if( relationship.getSelectedItemPosition()==0) {
                    relationtext.setError("Required");
                }
                else if( primaryphone.getText().toString().trim().length() == 0 ) {
                    primaryphone.setError("Required");
                }
                else if( secphone.getText().toString().trim().length() == 0 ) {
                    secphone.setError("Required");
                }
                else ContactEmergency.this.startActivity(new Intent(ContactEmergency.this, EnteringSemester.class));
            }
        });

        
    }
}
