package com.example.rinaattieh.sports_app_project;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

/**
 * Created by Lucas on 09/04/2017.
 */

public class DataBase extends SQLiteOpenHelper {

    public DataBase(Context context, String name, SQLiteDatabase.CursorFactory factory,
                        int version) {
        super(context, name, factory, version);
    }

    public static class Constants implements BaseColumns{
        // The database name
        public static final String DATABASE_NAME = "sport_android.db";

        // The database version
        public static final int DATABASE_VERSION = 1;

        // The table Name
        public static final String MY_TABLE = "Matchs";

        public static final String COL_ID = "id_matchs";

        public static final String COL_Team1 = "equipe_1";
        public static final String COL_Team2 = "équipe_2";
        public static final String COL_Lat = "latitude";
        public static final String COL_Long = "longitude";

        public static final int IND_ID = 1;
        public static final int IND_Team1 = 2;
        public static final int IND_Ieam2 = 3;
        public static final int IND_Lat = 4;
        public static final int IND_Long = 5;

        public static final String MY_TABLE2 = "Services";

        public static final String COL_Team = "equipe";
        public static final String COL_Classic = "classique";
        public static final String COL_Ace = "ace";
        public static final String COL_Filet = "filet";
        public static final String COL_Time_out = "time_out";
        public static final String COL_Limit = "Limit";
        public static final String COL_Out = "Out";

        public static final int IND_Equipe = 2;
        public static final int IND_Classic = 3;
        public static final int IND_Ace = 4;
        public static final int IND_Filet = 5;
        public static final int IND_Time_out = 6;
        public static final int IND_Limit = 7;
        public static final int IND_Out = 8;

        public static final String MY_TABLE3 = "Echanges";

        public static final String COL_Smash = "smash";
        public static final String COL_Faute = "faute";

        public  static final int IND_Smash = 3;
        public  static final int IND_Faute = 5;

        public static final String MY_TABLE4 = "Photos";

        public static final String COL_Date = "datetime";
        public static final String COL_Photo = "photo";

        public static final int IND_Date = 1;
        public static final int IND_Photo = 3;
    }

    private static final String DATABASE_CREATE = "create table "
            + Constants.MY_TABLE + "(" + Constants.COL_ID
            + " integer primary key autoincrement, " + Constants.COL_Team1
            + " TEXT, " + Constants.COL_Team2 + " TEXT, "
            + Constants.COL_Lat + " INTEGER, "
            + Constants.COL_Long + " INTEGER) create table "
            + Constants.MY_TABLE2 + "(" + Constants.COL_ID
            + " integer primary key autoincrement, "
            + Constants.COL_Team + " TEXT primary key, "
            + Constants.COL_Classic + " TEXT, "
            + Constants.COL_Ace + " TEXT, "
            + Constants.COL_Filet + " TEXT, "
            + Constants.COL_Time_out + " TEXT, "
            + Constants.COL_Limit + " TEXT, "
            + Constants.COL_Out + " TEXT) create table "
            + Constants.MY_TABLE3 + "(" + Constants.COL_ID
            + " integer primary key autoincrement, "
            + Constants.COL_Team + " TEXT primary key, "
            + Constants.COL_Smash + " TEXT, "
            + Constants.COL_Classic + " TEXT, "
            + Constants.COL_Faute + " TEXT) create table "
            + Constants.MY_TABLE4 + "(" + Constants.COL_Date
            + " DATE primary key, "
            + Constants.COL_Team + " TEXT, "
            + Constants.COL_Photo + " TEXT)";


    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create the new database using the SQL string Database_create
        db.execSQL(DATABASE_CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w("DataBase", "Mise à jour de la version " + oldVersion
                + " vers la version " + newVersion
                + ", les anciennes données seront détruites ");
        // Drop the old database
        db.execSQL("DROP TABLE IF EXISTS " + Constants.MY_TABLE
                + " DROP TABLE IF EXISTS " + Constants.MY_TABLE2
                + " DROP TABLE IF EXISTS " + Constants.MY_TABLE3
                + " DROP TABLE IF EXISTS " + Constants.MY_TABLE4);
        // Create the new one
        onCreate(db);
        // or do a smartest stuff
    }
}
