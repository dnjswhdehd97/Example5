package com.example.example3;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static com.example.example3.MainActivity.KEY_NAME;

class MyCursorAdapter extends CursorAdapter {
    @SuppressWarnings("deprecation")
    public MyCursorAdapter(Context context, Cursor c) {
        super(context, c); }
        @Override
        public void bindView(View view, Context context, Cursor cursor) {
            TextView tvName = (TextView) view.findViewById( R.id.tv_name );
            String name = cursor.getString( cursor.getColumnIndex( KEY_NAME ) );
            Log.d("스트링 확인", name );
            tvName.setText( name ); }
            @Override
            public View newView(Context context, Cursor cursor, ViewGroup parent) {
                LayoutInflater inflater = LayoutInflater.from( context );
                View v = inflater.inflate( R.layout.list_item, parent, false );
                return v; }
}
