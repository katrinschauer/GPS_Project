package com.example.kscha.gps_project;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by antoniahartl on 26.02.18.
 */

public class MySQLHelper extends SQLiteOpenHelper{

    private final static String DB_NAME="daten.db";
    private final static int DB_VERSION=1;
    public MySQLHelper(Context context, String name, int version) {
        super(context, name, null, version);
    }
    public MySQLHelper(Context context){
        super(context, DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DatenTbl.SQL_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DatenTbl.SQL_DROP);
        sqLiteDatabase.execSQL(DatenTbl.SQL_CREATE);

    }


}
