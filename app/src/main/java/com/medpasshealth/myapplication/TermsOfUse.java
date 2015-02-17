package com.medpasshealth.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class TermsOfUse extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_of_use);

        TextView terms = (TextView) findViewById(R.id.terms);
        terms.setText(Html.fromHtml(getString(R.string.nice_html)));
    }
}
