package com.example.example3;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {
    MyDBHelper mHelper;
    SQLiteDatabase db;
    Cursor cursor;
    MyCursorAdapter myAdapter;
    final static String KEY_ID = "_id";
    final static String KEY_NAME = "name";
    final static String TABLE_NAME = "mytable";
    final static String querySelectAll = String.format("SELECT * FROM %s", TABLE_NAME);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView list = (ListView) findViewById(R.id.listview);
        mHelper = new MyDBHelper(this);
        db = mHelper.getWritableDatabase();
        cursor = db.rawQuery(querySelectAll, null);
        final ArrayList<String> items = new ArrayList<String>() ;
        // ArrayAdapter 생성. 아이템 View를 선택(single choice)가능하도록 만듦.
        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, items) ;
        list.setAdapter(adapter);
        myAdapter = new MyCursorAdapter(this, cursor);
        list.setAdapter(myAdapter);

    }

    public void mOnClick( View v ) {
        EditText eName = (EditText) findViewById( R.id.et_name );
        String name = eName.getText().toString();
        String query = String.format( "INSERT INTO %s VALUES ( null, '%s');",
                    TABLE_NAME, name);
        db.execSQL( query );
        cursor = db.rawQuery( querySelectAll, null );
        myAdapter.changeCursor( cursor );

        eName.setText("");
        InputMethodManager imm = (InputMethodManager) getSystemService( Context.INPUT_METHOD_SERVICE );

    }
}



