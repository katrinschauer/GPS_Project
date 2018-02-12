package com.example.kscha.gps_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    ListView listView;
    ArrayList<Data> arr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listView=(ListView)findViewById(R.id.listView);
        setContentView(R.layout.newlayout2);
        Intent intent=getIntent();
        Bundle params=intent.getExtras();
        if (params!=null)
        {
            arr= (ArrayList<Data>) params.get("Liste");
        }


    }

    public void displayItems()
    {
    }
}
