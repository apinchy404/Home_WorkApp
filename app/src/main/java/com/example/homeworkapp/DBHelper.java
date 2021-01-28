package com.example.homeworkapp;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

public class DBHelper extends SQLiteOpenHelper {

    private  static final int DB_VERSION=1;
    private static final String DB_NAME="MY_DATABASE.DB";
    private static final String COLUMN1="id";
    private static final String COLUMN2="name";
    private static final String COLUMN3="phone";



    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME,null,DB_VERSION);
    }

//    for create table

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query="CREATE TABLE demo (id integer primary key,name text,phone integer)";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS demo");
        onCreate(db);

    }
//    for insert data
    public boolean insertData(String id,String name,String phone) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN1, id);
        values.put(COLUMN2, name);
        values.put(COLUMN3, phone);

        long check = db.insert("demo", null, values);

        if (check == -1) {
            return false;
        } else {
            return true;
        }
    }

        public Cursor getAllData()
        {
            SQLiteDatabase db=getReadableDatabase();
            Cursor result;
            result=db.rawQuery("SELECT * FROM demo",null);
            return result;
        }


        public ArrayList<HashMap<String,String>> getData() {
        ArrayList<HashMap<String, String>> data = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor result = db.rawQuery("SELECT * FROM demo", null);

        if (result.moveToFirst()) {
            do {
                HashMap<String, String> map = new HashMap<>();

                map.put("name", result.getString(1));
                map.put("phone", result.getString(2));

                data.add(map);

            } while (result.moveToNext());
        }

        db.close();
        return data;

    }




    }



