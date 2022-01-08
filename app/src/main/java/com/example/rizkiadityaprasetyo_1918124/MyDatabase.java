package com.example.rizkiadityaprasetyo_1918124;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static String DATABASE_NAME = "db_tni";

    private static final String tb_tni = "tb_tni";
    private static final String tb_tni_id = "id";
    private static final String tb_tni_nama = "nama";
    private static final String tb_tni_umur = "umur";
    private static final String tb_tni_pangkat = "pangkat";
    private static final String tb_tni_satuan = "satuan";

    private static final String CREATE_TABLE_tni = "CREATE TABLE " + tb_tni +"("
            + tb_tni_id + " INTEGER PRIMARY KEY ,"
            + tb_tni_nama + " TEXT ,"
            + tb_tni_umur + " TEXT ,"
            + tb_tni_pangkat + " TEXT ,"
            + tb_tni_satuan + " TEXT " + ")";

    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_tni);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void Createtni(tni data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_tni_id, data.get_id());
        values.put(tb_tni_nama, data.get_nama());
        values.put(tb_tni_umur, data.get_umur());
        values.put(tb_tni_pangkat, data.get_pangkat());
        values.put(tb_tni_satuan, data.get_satuan());
        db.insert(tb_tni, null, values);
        db.close();
    }

    public List<tni> Readtni() {
        List<tni> listtni = new ArrayList<tni>();
        String selectQuery = "SELECT  * FROM " + tb_tni;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                tni data = new tni();
                data.set_id(cursor.getString(0));
                data.set_nama(cursor.getString(1));
                data.set_umur(cursor.getString(2));
                data.set_pangkat(cursor.getString(3));
                data.set_satuan(cursor.getString(4));
                listtni.add(data);
            } while (cursor.moveToNext());
        }
        db.close();
        return listtni;
    }

    public int Updatetni (tni data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_tni_nama, data.get_nama());
        values.put(tb_tni_umur, data.get_umur());
        values.put(tb_tni_pangkat, data.get_pangkat());
        values.put(tb_tni_satuan, data.get_satuan());

        return db.update(tb_tni, values, tb_tni_id + " = ?",
                new String[]{String.valueOf((data.get_id()))});
    }

    public void Deletetni(tni data){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_tni,tb_tni_id+ " = ?",
                new String[]{String.valueOf(data.get_id())});
        db.close();
    }
}
