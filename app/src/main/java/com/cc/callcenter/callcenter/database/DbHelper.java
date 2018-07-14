package com.cc.callcenter.callcenter.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {

    private static final String dbName = "callcenter";
    private static final int dbVersion = 1;

    private static final String TBL_KISI = "kisi";
    private static final String TBL_KISI_ID = "id";
    private static final String TBL_KISI_AD = "ad";
    private static final String TBL_KISI_SOYAD = "soyad";
    private static final String TBL_KISI_DOGUM_TARIHI = "dogum_tarihi";

    private static final String CREATE_TABLE_KISI = "CREATE TABLE " + TBL_KISI + " (" +
            TBL_KISI_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            TBL_KISI_AD + " TEXT," +
            TBL_KISI_SOYAD + " TEXT," +
            TBL_KISI_DOGUM_TARIHI + " DATETIME ) ";


    public DbHelper(Context ctx) {
        super(ctx, dbName, null, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_KISI);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void save(Kisi k) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(TBL_KISI_AD, k.getAd());
        contentValues.put(TBL_KISI_SOYAD, k.getSoyad());
        //contentValues.put(TBL_KISI_DOGUM_TARIHI, k.getDogumTarihi().toString());
        this.getWritableDatabase().insert(TBL_KISI, null, contentValues);
    }

    public void update(Kisi k) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(TBL_KISI_AD, k.getAd());
        contentValues.put(TBL_KISI_SOYAD, k.getSoyad());
        //contentValues.put(TBL_KISI_DOGUM_TARIHI, k.getDogumTarihi().toString());
        this.getWritableDatabase().update(TBL_KISI, contentValues, TBL_KISI_ID + " = ?", new String[]{String.valueOf(k.getId())});
    }

    public void delete(Kisi k) {
        this.getWritableDatabase().delete(TBL_KISI, TBL_KISI_ID + " = ?", new String[]{String.valueOf(k.getId())});
    }

    public List<Kisi> getAll() {
        List<Kisi> kisis = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TBL_KISI;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        if (c.moveToFirst()) {
            do {
                Kisi k = new Kisi();
                k.setId(c.getInt((c.getColumnIndex(TBL_KISI_ID))));
                k.setAd((c.getString(c.getColumnIndex(TBL_KISI_AD))));
                k.setSoyad(c.getString(c.getColumnIndex(TBL_KISI_SOYAD)));
                kisis.add(k);
            } while (c.moveToNext());
        }
        return kisis;
    }

    public Kisi getById(int id) {
        String selectQuery = "SELECT  * FROM " + TBL_KISI + " where " + TBL_KISI_ID + " = " + id;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        if (c.moveToFirst()) {
            Kisi k = new Kisi();
            k.setId(c.getInt((c.getColumnIndex(TBL_KISI_ID))));
            k.setAd((c.getString(c.getColumnIndex(TBL_KISI_AD))));
            k.setSoyad(c.getString(c.getColumnIndex(TBL_KISI_SOYAD)));
            return k;
        }
        return null;
    }
}
