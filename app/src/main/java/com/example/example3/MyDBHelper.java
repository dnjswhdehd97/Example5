package com.example.example3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.example3.MainActivity.KEY_NAME;
import static com.example.example3.MainActivity.TABLE_NAME;

class MyDBHelper extends SQLiteOpenHelper {
    public MyDBHelper(Context context) {
        super(context, "MyData.db", null, 2);
    }
    public void onCreate(SQLiteDatabase db) {
        String query = String.format( "CREATE TABLE %s (" + "_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "%s TEXT);", TABLE_NAME, KEY_NAME);
        db.execSQL( query );
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = String.format( "DROP TABLE IF EXISTS %s", TABLE_NAME );
        db.execSQL( query ); onCreate( db ); }
}

