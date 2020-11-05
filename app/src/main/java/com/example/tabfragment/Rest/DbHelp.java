package com.example.tabfragment.Rest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DbHelp extends SQLiteOpenHelper {
    String mQuery;
   public DbHelp(Context context){
       super(context,"db_message", null, 1 );
   }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String produk ="produk";
        mQuery = "CREATE TABLE IF NOT EXISTS tb_" + produk + " (" +
                "_id INTEGER PRIMARY KEY," +
                "name TEXT," +
                "description TEXT" +
                ")";
        db.execSQL(mQuery);
    }

    public void insertData(ContentValues values) {
        SQLiteDatabase db = this.getWritableDatabase();
        Log.d("Values", "" + values.toString());
        db.insert("tb_produk", null, values);
    }

    public Cursor select() {
        SQLiteDatabase db = this.getWritableDatabase();
        mQuery = "SELECT * FROM tb_produk";
        Cursor c = db.rawQuery(mQuery, null);
        return c;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
