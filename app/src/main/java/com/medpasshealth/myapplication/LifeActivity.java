package com.medpasshealth.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class LifeActivity extends Activity {
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    int lastExpandedPosition = -1;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LifeActivity.this.startActivity(new Intent(LifeActivity.this, AccountSignIn.class));
            }
        });

        // Main Menu Navigation/Expandable List View
        expListView = (ExpandableListView) findViewById(R.id.navexp);
        prepareListData();
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
        // set list adapter
        expListView.setAdapter(listAdapter);

        // Listview Group click listener
        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                if (lastExpandedPosition != -1
                        && groupPosition != lastExpandedPosition) {
                    expListView.collapseGroup(lastExpandedPosition);
                }
                lastExpandedPosition = groupPosition;
            }
        });

/*        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Collapsed", //TODO
                        Toast.LENGTH_SHORT).show();
            }
        });*/

        // Menu Activity Tree
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                if (groupPosition == 0) { //Account
                switch (childPosition) {
                    case 0:
                        LifeActivity.this.startActivity(new Intent(LifeActivity.this, CreatePassword.class));
                        break;
                }}
                if (groupPosition == 1) { //Profile
                    switch (childPosition) {
                        case 0:
                            LifeActivity.this.startActivity(new Intent(LifeActivity.this, ContactPersonal.class));
                            break;
                        case 1:
                            LifeActivity.this.startActivity(new Intent(LifeActivity.this, ContactEmergency.class));
                            break;
                    }
                }
                if (groupPosition == 2) { //Medical
                    switch (childPosition) {
                        case 0:
                            LifeActivity.this.startActivity(new Intent(LifeActivity.this, MedHistory.class));
                            break;
                        case 1:
                            LifeActivity.this.startActivity(new Intent(LifeActivity.this, MedHistory.class));
                            break;
                    }
                }
                if (groupPosition == 3) { //Insurance
                    switch (childPosition) {
                        case 0:
                            LifeActivity.this.startActivity(new Intent(LifeActivity.this, Register.class));
                            break;
                        case 1:
                            LifeActivity.this.startActivity(new Intent(LifeActivity.this, RecoverPassword.class));
                            break;
                    }
                }
                if (groupPosition == 4) { //Immunization
                    switch (childPosition) {
                        case 0:
                            LifeActivity.this.startActivity(new Intent(LifeActivity.this, AccountManage.class));
                            break;
                        case 1:
                            LifeActivity.this.startActivity(new Intent(LifeActivity.this, AccountSignIn.class));
                            break;
                    }
                }
                return false;
            }
        });
    }
    //Menu Text
    private void prepareListData() {
        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();

        // Header data
        listDataHeader.add("Account");
        listDataHeader.add("Profile");
        listDataHeader.add("Medical");
        listDataHeader.add("Insurance");
        listDataHeader.add("Immunizations");

        // Child data
        List<String> account = new ArrayList<>();
        account.add("Create Password");

        List<String> profile = new ArrayList<>();
        profile.add("Personal Contact Information");
        profile.add("Emergency Contact Information");
        profile.add("Entering Semester");

        List<String> medical = new ArrayList<>();
        medical.add("Medical ID - Personal Basics");
        medical.add("Medical History");
        medical.add("Medications");

        List<String> insurance = new ArrayList<>();
        insurance.add("Insurance Questionaire");
        insurance.add("Primary Insurance Policy");
        insurance.add("Primary Insurance Policy - Holder");
        insurance.add("Primary Insurance Policy - Benefits");
        insurance.add("Secondary Insurance Policy");
        insurance.add("Secondary Insurance Policy - Holder");
        insurance.add("Secondary Insurance Policy - Benefits");
        insurance.add("Insurance Cards - Image Upload");
        insurance.add("Self-Pay Billing");

        List<String> immunizations = new ArrayList<>();
        immunizations.add("Tuberculosis Questionaire");
        immunizations.add("Immunizations Form Download");
        immunizations.add("Immunization Form - Upload");
        
        listDataChild.put(listDataHeader.get(0), account);
        listDataChild.put(listDataHeader.get(1), profile);
        listDataChild.put(listDataHeader.get(2), medical);
        listDataChild.put(listDataHeader.get(3), insurance);
        listDataChild.put(listDataHeader.get(4), immunizations);
    }
    
}
