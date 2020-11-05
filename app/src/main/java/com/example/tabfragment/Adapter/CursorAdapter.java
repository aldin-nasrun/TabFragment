package com.example.tabfragment.Adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tabfragment.R;

public class CursorAdapter extends android.widget.CursorAdapter {
    public CursorAdapter(Context context, Cursor c) {
        super(context, c, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.row_layout, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView tv_produk = (TextView) view.findViewById(R.id.tv_produk);

        String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
        String description = cursor.getString(cursor.getColumnIndexOrThrow("description"));


        tv_produk.setText(name);
    }
}
