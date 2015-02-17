package com.medpasshealth.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;


public class Register extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        findViewById(R.id.agreementtext).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Register.this.startActivity(new Intent(Register.this, TermsOfUse.class));
            }
        });
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        int gun = 1;
        boolean checked = ((CheckBox) view).isChecked();

        switch(view.getId()) {
            case R.id.agreecheckbox:
                if (checked)
                    gun++;
                else
                    gun--;
                break;
        }
    }
}
