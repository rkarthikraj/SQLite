package com.example.rkarthikraj.sqltest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by R KARTHIK RAJ on 20-12-2016.
 */

public class MyDBHandler  extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="products.db";
    public static final String TABLE_PRODUCTS="products";
    public static final String COLUMN_ID="id";
    public static final String COLUMN_PRODUCTNAME="productname";
    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="CREATE TABLE products (id INTEGER PRIMARY KEY AUTOINCREMENT, " + "productname text)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query1="DROP TABLE IF EXISTS "+TABLE_PRODUCTS;
        db.execSQL(query1);
        this.onCreate(db);
    }

    public void addProduct(Products product){
        ContentValues values=new ContentValues();
        values.put(COLUMN_PRODUCTNAME, product.get_productname());
        SQLiteDatabase db=getWritableDatabase();
        db.insert(TABLE_PRODUCTS,null,values);
        db.close();
    }
    public void deleteProduct(String productName) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_PRODUCTS + " WHERE " + COLUMN_PRODUCTNAME + "=\" " + productName + " \";");
    }

    public String databaseToString(){
        String dbString="";
        SQLiteDatabase db=getWritableDatabase();
        /*String query3="SELECT * FROM " + TABLE_PRODUCTS;
        Cursor c=db.rawQuery(query3,null);
        if(c.moveToFirst()) {
            while (!c.isAfterLast()) {
                if (c.getString(c.getColumnIndex("productname")) != null) {
                    dbString += c.getString(c.getColumnIndex("productname"));
                    dbString += "\n";
                }
            }
        }*/
        db.close();
        return dbString;
    }
}
