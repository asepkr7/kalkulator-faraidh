package com.example.myfaraid;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataSql extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "kalkulatorfaroidh.db";
    private static final int DATABASE_VERSION = 1;
    public DataSql(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL("PRAGMA foreign_keys=ON");
        db.execSQL("create table data_pewaris('nama_pewaris text primary key," +
                " jenis_kelamin text null," +
                " jumlah_harta text null," +
                " jumlah_utang text null," +
                " jumlah_urus text null," +
                " jumlah_wasiat text null," +
                " total text null')");
        db.execSQL("create table data_ahli_waris('nama_pewaris text, " +
                "anak_lk text null, anak_pr text null, " +
                "suami text null, istri text null, " +
                "ayah text null, ibu text null, " +
                "kakek text null, nenek text null, " +
                "sdra_kandung text null, sdri_kandung text null," +
                "foreign key(nama_pewaris) references data_pewaris')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub

    }
}
