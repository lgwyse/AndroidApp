package com.medpasshealth.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class AccountManage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_manage);

        findViewById(R.id.changepassbutton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AccountManage.this.startActivity(new Intent(AccountManage.this, LifeActivity.class));
            }
        });
    }
}
