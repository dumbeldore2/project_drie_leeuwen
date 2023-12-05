package com.example.project_drie_leeuwen;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    //db naam
    public static String DATABASE_NAME = "database_lions";

    //tabel1
    public static final String DATABASE_TABLE_1 = "main";

    //coloms
    public static final String T1C0 = "id";
    public static final String T1C1 = "main";
    public static final String T1C2 = "next";
    public static final String T1C3 = "idfoto";

    //controler
    public Database(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    //on create functie
    //eenmalig als geen database aanwezig is op het toestel
    @Override public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + DATABASE_TABLE_1 + "(" + T1C0 + " INTEGER DEFAULT 0 primary " +
                "key autoincrement ," + T1C1 + " TEXT ," + T1C2 + " TEXT ," + T1C3 + " TEXT " +
                "default null )");
    }

    //on update functie
    //dropt aude versie en zet nieuwe in de plaats
    @Override public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_1);
    }

    //add function
    public void addToTable1(String main, String next) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(T1C1, main);
        contentValues.put(T1C2, next);

        sqLiteDatabase.insert(DATABASE_TABLE_1, null, contentValues);
    }
    //add function2 met image path
    public void addToTable1(String main, String next,String path) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(T1C1, main);
        contentValues.put(T1C2, next);
        contentValues.put(T1C3, path);

        sqLiteDatabase.insert(DATABASE_TABLE_1, null, contentValues);
    }

    //get t0c1 with id
    public String getT1c1(String id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select " + T1C1 + " from " + DATABASE_TABLE_1 +
                " where " + T1C0 + " == " + id + "", null);

        String out = "";

        //deze for loop is nodig om niet de meta data te krijgen maar de echte sql data denk ik,
        // de if lijn is ook mega belangrijk en in combo met for loop is dit gemakkelijker denk ik
        for (int i = 0; i <= cursor.getCount(); i++){
            if (cursor.moveToPosition(i)){

                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(cursor.getString(0));
                out = stringBuffer.toString();
            }
        }

        return out;
    }
    //get t0c2 with id
    public String getT1c2(String id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select " + T1C2 + " from " + DATABASE_TABLE_1 +
                " where " + T1C0 + " == " + id + "", null);

        String out = "";
        //deze for loop is nodig om niet de meta data te krijgen maar de echte sql data denk ik,
        // de if lijn is ook mega belangrijk en in combo met for loop is dit gemakkelijker denk ik
        for (int i = 0; i <= cursor.getCount(); i++){
            if (cursor.moveToPosition(i)){

                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(cursor.getString(0));
                out = stringBuffer.toString();
            }
        }

        return out;
    }

    //get ids
    public String [] t1c0(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select "+ T1C0 + " from " + DATABASE_TABLE_1,
                null);

        String[] outs = new String[cursor.getCount()];
        for (int i = 0; i <= cursor.getCount(); i++){
            if (cursor.moveToPosition(i)){
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(cursor.getString(0));
                outs[i] = stringBuffer.toString();
            }
        }
        return outs;
    }
    //get mains
    public String [] t1c1(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select "+ T1C1 + " from " + DATABASE_TABLE_1,
                null);

        String[] outs = new String[cursor.getCount()];
        for (int i = 0; i <= cursor.getCount(); i++){
            if (cursor.moveToPosition(i)){
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(cursor.getString(0));
                outs[i] = stringBuffer.toString();
            }
        }
        return outs;
    }

    //get mains
    public String [] t1c3(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select "+ T1C3 + " from " + DATABASE_TABLE_1,
                null);

        String[] outs = new String[cursor.getCount()];
        for (int i = 0; i <= cursor.getCount(); i++){
            if (cursor.moveToPosition(i)){
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(cursor.getString(0));
                outs[i] = stringBuffer.toString();
            }
        }
        return outs;
    }
}
