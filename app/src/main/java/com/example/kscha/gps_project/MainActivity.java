package com.example.kscha.gps_project;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements LocationListener {

    Button buttonAnzeigen;
    private static LocationManager locMan = null;
    TextView latitude;
    TextView longitude;
    TextView myDate;
    private final static String DB_NAME="daten.db";
    SQLiteDatabase dbl;
    private final static int DB_VERSION=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newlayout);
        buttonAnzeigen = (Button) findViewById(R.id.buttonAnzeigen);
        latitude=(TextView) findViewById(R.id.latitude);
        longitude=(TextView) findViewById(R.id.longitude);
        myDate=(TextView) findViewById(R.id.myDate);
        buttonAnzeigen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Anzeige();
            }
        });

        locMan = (LocationManager) getSystemService(LOCATION_SERVICE);
        MySQLHelper helper=new MySQLHelper(this,DB_NAME,null,DB_VERSION);
        helper.getReadableDatabase();
    }

    public void Anzeige() {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locMan.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 5, this);
    }
    @Override
    protected void onPause()
    {
        super.onPause();
        locMan.removeUpdates(this);
    }


    @Override
    public void onLocationChanged(Location location) {
        if (locMan==null)
        {
            return;
        }
        displayLocation(location);

    }

    private void displayLocation(Location loc)
    {
        double wertLatitude=loc.getLatitude();
        double wertLongitude=loc.getLongitude();
        latitude.setText(String.format("%.4f",wertLatitude));
        longitude.setText(String.format("%.4f",wertLongitude));
        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        myDate.setText(df.format(new Date()));
        Data d=new Data(longitude.getText().toString(),latitude.getText().toString(),myDate.getText().toString());


    }

    private void einschreiben(Data d)
    {
        dbl.execSQL(DatenTbl.STMT_INSERT,new String []{d.getLatitude(),d.getLongitude(),d.getMyDate()});
    }



    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }





}
