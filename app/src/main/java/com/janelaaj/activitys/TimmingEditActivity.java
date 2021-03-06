package com.janelaaj.activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;

import com.janelaaj.R;
import com.janelaaj.adapter.TimeEditExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TimmingEditActivity extends AppCompatActivity {
    TimeEditExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    Button btn_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edittimelocation_screen);
        expListView = this.findViewById(R.id.lvExp);
        btn_home = this.findViewById(R.id.btn_home);
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TimmingEditActivity.this, UploadDocumentActivity.class);
                startActivity(intent);
            }
        });
        prepareListData();
        listAdapter = new TimeEditExpandableListAdapter(this, listDataHeader, listDataChild);
        expListView.setAdapter(listAdapter);
        expListView.setOnGroupClickListener(new OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                return false;
            }
        });

        expListView.setOnGroupExpandListener(new OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });

        expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();

            }
        });

        // Listview on child click listener
        expListView.setOnChildClickListener(new OnChildClickListener() {

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

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("13:30-15:52");
        listDataHeader.add("10:55-04:01");
        listDataHeader.add("9:30-15:52");
        listDataHeader.add("6:55-04:01");

        // Adding child data
        List<String> top250 = new ArrayList<String>();
        top250.add("The Shawshank Redemption");

        List<String> nowShowing = new ArrayList<String>();
        nowShowing.add("The Conjuring");
        List<String> item = new ArrayList<String>();
        item.add("The Conjuring");
        List<String> item2 = new ArrayList<String>();
        item2.add("The Conjuring");


        listDataChild.put(listDataHeader.get(0), top250); // Header, Child data
        listDataChild.put(listDataHeader.get(1), nowShowing);
        listDataChild.put(listDataHeader.get(2), item);
        listDataChild.put(listDataHeader.get(3), item2);
    }
}
