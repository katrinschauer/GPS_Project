package com.example.kscha.gps_project;

/**
 * Created by antoniahartl on 26.02.18.
 */

public class DatenTbl {
    public static final String TABLE_NAME="Daten";

    public final static String longitude="longitude";
    public final static String latitude="latitude";
    public final static String dateandtime="dateandtime";
    public static final String [] ALL_COLUMNS=new String [] {longitude,latitude,dateandtime};

    public static final String SQL_DROP="DROP TABLE IF EXISTS"+TABLE_NAME;
    public static final String SQL_CREATE=
            "CREATE TABLE "+TABLE_NAME+
                    "("+
                    longitude+" REAL,"+
                    latitude+" REAL,"+
                    dateandtime+" TEXT PRIMARY KEY"+
                    ");";

    public static final String STMT_DELETE="DELETE FROM"+TABLE_NAME;
    public static final String STMT_INSERT=
            "INSERT INTO "+TABLE_NAME+
                    "("+longitude+","+latitude+","+dateandtime+")"+
                    " VALUES (?,?,?)";


}
