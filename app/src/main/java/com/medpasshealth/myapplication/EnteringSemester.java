package com.medpasshealth.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;


public class EnteringSemester extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entering_semester);

        final TextView periodtext = (TextView) findViewById(R.id.periodtext);
        final TextView classtext = (TextView) findViewById(R.id.classtext);
        final TextView campusrestext = (TextView) findViewById(R.id.campusrestext);
        
        final Spinner spinner1 = (Spinner) findViewById(R.id.period);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.period_array, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);

        final Spinner spinner2 = (Spinner) findViewById(R.id.classspin);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.class_array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        final Spinner spinner3 = (Spinner) findViewById(R.id.campusres);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,
                R.array.campusres_array, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);

        findViewById(R.id.contnu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                periodtext.setError(null);
                classtext.setError(null);
                campusrestext.setError(null);
                
                if( spinner1.getSelectedItemPosition()==0) {
                    periodtext.setError("Required.");
                }
                else if( spinner2.getSelectedItemPosition()==0) {
                    classtext.setError("Required.");
                }
                else if( spinner3.getSelectedItemPosition()==0) {
                    campusrestext.setError("Required.");
                } 
                else EnteringSemester.this.startActivity(new Intent(EnteringSemester.this, LifeActivity.class));
            }
        });
    }
}