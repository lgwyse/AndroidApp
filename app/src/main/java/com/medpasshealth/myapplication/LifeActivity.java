package com.medpasshealth.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class LifeActivity extends Activity {
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LifeActivity.this.startActivity(new Intent(LifeActivity.this, LoginActivity.class));
            }
        });

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.navexp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
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
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();

            }
        });

        // Listview on child click listener
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(
                        getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Account");
        listDataHeader.add("Profile");
        listDataHeader.add("Medical");
        listDataHeader.add("Insurance");
        listDataHeader.add("Immunizations");

        // Adding child data
        List<String> account = new ArrayList<String>();
        account.add("Create Password");

        List<String> profile = new ArrayList<String>();
        profile.add("Personal Contact Information");
        profile.add("Emergency Contact Information");
        profile.add("Entering Semester");

        List<String> medical = new ArrayList<String>();
        medical.add("Medical ID - Personal Basics");
        medical.add("Medical History");
        medical.add("Medications");

        List<String> insurance = new ArrayList<String>();
        insurance.add("Insurance Questionaire");
        insurance.add("Primary Insurance Policy");
        insurance.add("Primary Insurance Policy - Holder");
        insurance.add("Primary Insurance Policy - Benefits");
        insurance.add("Secondary Insurance Policy");
        insurance.add("Secondary Insurance Policy - Holder");
        insurance.add("Secondary Insurance Policy - Benefits");
        insurance.add("Insurance Cards - Image Upload");
        insurance.add("Self-Pay Billing");

        List<String> immunizations = new ArrayList<String>();
        immunizations.add("Tuberculosis Questionaire");
        immunizations.add("Immunizations Form Download");
        immunizations.add("Immunization Form - Upload");
        
        listDataChild.put(listDataHeader.get(0), account); // Header, Child data
        listDataChild.put(listDataHeader.get(1), profile);
        listDataChild.put(listDataHeader.get(2), medical);
        listDataChild.put(listDataHeader.get(3), insurance);
        listDataChild.put(listDataHeader.get(4), immunizations);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_life, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    
    
    
}
