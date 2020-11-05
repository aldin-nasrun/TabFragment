package com.example.tabfragment.Fragmnet;

import android.content.ContentValues;
import android.database.SQLException;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.tabfragment.Adapter.CursorAdapter;
import com.example.tabfragment.R;
import com.example.tabfragment.Rest.DbHelp;

public class AddFragment extends Fragment {
    DbHelp helper;
    String mQuery;
    GridView listProduk;
    CursorAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_add, container, false);
        listProduk = v.findViewById(R.id.list_produk);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        helper = new DbHelp(getContext());
        insertDB();
        mAdapter = new CursorAdapter(getContext(),helper.select());
        listProduk.setAdapter(mAdapter);
        listProduk.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("TAG", "onItemClick: "+position);
                Toast.makeText(getContext(), "item Clicked : "+position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void insertDB() {
        try {
            ContentValues values = new ContentValues();
            values.put("name", "TRAKTOR QUICK");
            values.put("description", "deskripsi traktor quick");
            Log.d("VALUES", values.toString());
            helper.insertData(values);
            try {
                ContentValues value2 = new ContentValues();
                values.put("name", "TRAKTOR QUICK 2");
                values.put("description", "deskripsi traktor quick 2");
                Log.d("VALUES", value2.toString());
                helper.insertData(values);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}