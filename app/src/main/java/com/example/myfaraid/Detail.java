package com.example.myfaraid;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Detail extends AppCompatActivity {
    String sNama, sJK, sHarta, sHutang, sPengurusan, sWasiat, sTotal,
            sAnakLakilaki, sAnakPerempuan, sSuami, sIstri, sAyah,
            sIbu, sKakek, sNenek, sSaudaraKandung, sSaudariKandung;

    protected Cursor cursor;
    DataSql dbSql;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        dbSql = new DataSql(this);

        SQLiteDatabase db = dbSql.getReadableDatabase();
        cursor = db.rawQuery("select * from data_pewaris, data_ahli_waris where data_pewaris.nama_pewaris = data_ahli_waris.nama_pewaris AND data_pewaris.nama_pewaris = '"+getIntent().getStringExtra("nama_pewaris")+"'", null);
        cursor.moveToFirst();
        if(cursor.getCount()>0){
            cursor.moveToPosition(0);
            sNama = cursor.getString(0);
            sJK = cursor.getString(1);
            sHarta = cursor.getString(2);
            sHutang = cursor.getString(3);
            sPengurusan = cursor.getString(4);
            sWasiat = cursor.getString(5);
            sTotal = cursor.getString(6);
            sAnakLakilaki = cursor.getString(8);
            sAnakPerempuan = cursor.getString(9);
            sSuami = cursor.getString(10);
            sIstri = cursor.getString(11);
            sAyah = cursor.getString(12);
            sIbu = cursor.getString(13);
            sKakek = cursor.getString(14);
            sNenek = cursor.getString(15);
            sSaudaraKandung = cursor.getString(16);
            sSaudariKandung = cursor.getString(17);
        }

        //default jika data ahli waris bernilai 0, maka tidak ditampilkan
        //awal state
        if (sAnakLakilaki.equals("Rp. 0")) {
            LinearLayout GAnakLakilaki =  findViewById(R.id.GAnakLakilaki);
            GAnakLakilaki.setVisibility(View.GONE);
        }

        if (sAnakPerempuan.equals("Rp. 0")) {
            LinearLayout GAnakPerempuan =  findViewById(R.id.GAnakPerempuan);
            GAnakPerempuan.setVisibility(View.GONE);
        }

        if (sSuami.equals("Rp. 0")) {
            LinearLayout GSuami =  findViewById(R.id.GSuami);
            GSuami.setVisibility(View.GONE);
        }

        if (sIstri.equals("Rp. 0")) {
            LinearLayout GIstri =  findViewById(R.id.GIstri);
            GIstri.setVisibility(View.GONE);
        }

        if (sAyah.equals("Rp. 0")) {
            LinearLayout GAyah =  findViewById(R.id.GAyah);
            GAyah.setVisibility(View.GONE);
        }

        if (sIbu.equals("Rp. 0")) {
            LinearLayout GIbu =  findViewById(R.id.GIbu);
            GIbu.setVisibility(View.GONE);
        }

        if (sKakek.equals("Rp. 0")) {
            LinearLayout GKakek =  findViewById(R.id.GKakek);
            GKakek.setVisibility(View.GONE);
        }

        if (sNenek.equals("Rp. 0")) {
            LinearLayout GNenek =  findViewById(R.id.GNenek);
            GNenek.setVisibility(View.GONE);
        }

        if (sSaudaraKandung.equals("Rp. 0")) {
            LinearLayout GSaudaraKandung = findViewById(R.id.GSaudaraKandung);
            GSaudaraKandung.setVisibility(View.GONE);
        }

        if (sSaudariKandung.equals("Rp. 0")) {
            LinearLayout GSaudariKandung = findViewById(R.id.GSaudariKandung);
            GSaudariKandung.setVisibility(View.GONE);
        }

        //akhir state

        // ---------------------------
        TextView tvNama =  findViewById(R.id.showNama);
        TextView tvJK =  findViewById(R.id.showJK);
        TextView tvHarta =  findViewById(R.id.RpJumlah);
        TextView tvHutang =  findViewById(R.id.RpHutang);
        TextView tvPengurusanJenazah =  findViewById(R.id.RpPengurusanJenazah);
        TextView tvWasiat =  findViewById(R.id.RpWasiat);
        TextView tvJumlah =  findViewById(R.id.RpTotal);

        TextView AnakLakilaki1 =  findViewById(R.id.AnakLakilaki1);
        TextView AnakPerempuan1 =  findViewById(R.id.AnakPerempuan1);

        TextView Suami1 =  findViewById(R.id.Suami1);
        TextView Istri1 =  findViewById(R.id.Istri1);

        TextView Ayah1 =  findViewById(R.id.Ayah1);
        TextView Ibu1 =  findViewById(R.id.Ibu1);

        TextView Kakek1 =  findViewById(R.id.Kakek1);
        TextView Nenek1 =  findViewById(R.id.Nenek1);

        TextView SaudaraKandung1 =  findViewById(R.id.SaudaraKandung1);
        TextView SaudariKandung1 =  findViewById(R.id.SaudariKandung1);

        //memasukkan nilai ke textview
        tvNama.setText(sNama);
        tvJK.setText(sJK);
        tvHarta.setText(sHarta);
        tvHutang.setText(sHutang);
        tvPengurusanJenazah.setText(sPengurusan);
        tvWasiat.setText(sWasiat);
        tvJumlah.setText(sTotal);

        AnakLakilaki1.setText(sAnakLakilaki);
        AnakPerempuan1.setText(sAnakPerempuan);

        Suami1.setText(sSuami);
        Istri1.setText(sIstri);

        Ayah1.setText(sAyah);
        Ibu1.setText(sIbu);

        Kakek1.setText(sKakek);
        Nenek1.setText(sNenek);

        SaudaraKandung1.setText(sSaudaraKandung);
        SaudariKandung1.setText(sSaudariKandung);

        ImageButton btnback =  findViewById(R.id.back);
        btnback.setOnClickListener(v -> finish());
    }

    private int harta(int i) {
        // TODO Auto-generated method stub
        return 0;
    }
    }
