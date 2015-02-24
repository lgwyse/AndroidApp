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


public class ContactPersonal extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_personal);

        final EditText firstname = (EditText) findViewById(R.id.firstname);
        final EditText midname = (EditText) findViewById(R.id.midname);
        final EditText lastname = (EditText) findViewById(R.id.lastname);
        final EditText dateofbirth = (EditText) findViewById(R.id.dateofbirth);
        final TextView gendertext = (TextView) findViewById(R.id.gendertext);
        final TextView uscitizentext = (TextView) findViewById(R.id.uscitizentext);
        final EditText address = (EditText) findViewById(R.id.address);
        final EditText address2 = (EditText) findViewById(R.id.address2);
        final EditText city = (EditText) findViewById(R.id.city);
        final TextView statetext = (TextView) findViewById(R.id.statetext);
        final EditText zip = (EditText) findViewById(R.id.zip);
        final EditText prefphone = (EditText) findViewById(R.id.prefphone);
        final EditText backupemail = (EditText) findViewById(R.id.backupemail);
        
        final Spinner gender = (Spinner) findViewById(R.id.gender);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.genders, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gender.setAdapter(adapter1);

        final Spinner uscitizen = (Spinner) findViewById(R.id.uscitizen);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.yesno_array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        uscitizen.setAdapter(adapter2);

        final Spinner state = (Spinner) findViewById(R.id.state);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,
                R.array.state_array, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        state.setAdapter(adapter3);  

        findViewById(R.id.contnu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gendertext.setError(null);
                uscitizentext.setError(null);
                statetext.setError(null);
                
                if( firstname.getText().toString().trim().length() == 0 ) {
                    firstname.setError("Required");
                }
                else if( lastname.getText().toString().trim().length() == 0 ) {
                    lastname.setError("Required");
                }
                else if( dateofbirth.getText().toString().trim().length() == 0 ) {
                    dateofbirth.setError("Required");
                }
                else if(gender.getSelectedItemPosition()==0) {
                    gendertext.setError("Required");
                }
                else if( uscitizen.getSelectedItemPosition()==0) {
                    uscitizentext.setError("Required");
                }
                else if( address.getText().toString().trim().length() == 0 ) {
                    address.setError("Required");
                }
                else if( city.getText().toString().trim().length() == 0 ) {
                    city.setError("Required");
                }
                else if( state.getSelectedItemPosition()==0) {
                    statetext.setError("Required");
                }
                else if( zip.getText().toString().trim().length() == 0 ) {
                    zip.setError("Required");
                }
                else if( prefphone.getText().toString().trim().length() == 0 ) {
                    prefphone.setError("Required");
                }
                else if( backupemail.getText().toString().trim().length() == 0 ) {
                    backupemail.setError("Required");
                }
                else ContactPersonal.this.startActivity(new Intent(ContactPersonal.this, ContactEmergency.class));
            }
        });
    }

}
