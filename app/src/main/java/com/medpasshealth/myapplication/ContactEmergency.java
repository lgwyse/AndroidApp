package com.medpasshealth.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class ContactEmergency extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_emergency);

        findViewById(R.id.contnu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContactEmergency.this.startActivity(new Intent(ContactEmergency.this, EnteringSemester.class));
            }
        });

        Spinner spinner = (Spinner) findViewById(R.id.relationship);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.relation_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
}
