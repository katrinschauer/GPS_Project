package com.example.kscha.gps_project;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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
//        Bundle params=intent.getExtras();
//        if (params!=null)
//        {
//            arr= (ArrayList<Data>) params.get("Liste");
//        }
//        displayItems();


    }

    public void displayItems()
    {
        ArrayAdapter<Data> adapter=new ArrayAdapter<Data>(this,android.R.layout.simple_list_item_1,arr);
        listView.setAdapter(adapter);
    }

    private void loadData(){
        MySQLHelper dbHelper = new MySQLHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String daten="";
        Cursor rows = db.rawQuery("select * from Daten",new String[]{});

        while(rows.moveToNext())
        {
            Double longitude = rows.getDouble(0);
            Double latitude = rows.getDouble(1);
            String date = rows.getString(2);
            Data data = new Data(longitude,latitude,date);
            arr.add(data);
        }

        rows.close();
        db.close();
        displayItems();

    }
}
