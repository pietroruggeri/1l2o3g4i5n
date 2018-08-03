package com.example.pietro.loginsql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{
    public DatabaseHelper(Context context) {
        super(context, "Login.db", null, 1 );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table user(mail text primary key,passweord text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists user");

    }
    // insertar en base de datos;
    public  boolean insert(String mail,String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues ContentValues = new ContentValues();
        ContentValues.put("mail", mail);
        ContentValues.put("password",password);
        long ins = db.insert("user",null,ContentValues);
        if (ins==-1) return false;
        else return true;
    }
    // chequea si existe el mail;
    public boolean chkmail(String mail){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user where mail=?",new String[]{mail} );
        if (cursor.getCount()>0) return  false;
        else return true;
    }
}



