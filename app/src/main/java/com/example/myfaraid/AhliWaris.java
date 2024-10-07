package com.example.myfaraid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class AhliWaris extends AppCompatActivity {
    private static final String gIstri = null;
    String nama, jk, harta, utang, urus, wasiat;
    protected Cursor cursor;
    DataSql dbSql;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ahli_waris);

        Button selesai = findViewById(R.id.selesaiAhliWaris);

        Bundle terima = getIntent().getExtras();

        //menerima data dari kelas pewaris
        nama = terima.getString("terima0");
        jk = terima.getString("terima1");
        harta = terima.getString("terima2");
        utang = terima.getString("terima3");
        urus = terima.getString("terima4");
        wasiat = terima.getString("terima5");

        if (jk.equals("Laki-laki")) {
            LinearLayout gSuami =  findViewById(R.id.GSuami);
            gSuami.setVisibility(View.GONE);
        } else {
            LinearLayout gIstri =  findViewById(R.id.GIstri);
            gIstri.setVisibility(View.GONE);
        }

        selesai.setOnClickListener(v -> {

            Intent i = new Intent(AhliWaris.this, Hasil.class);

            EditText eTAnakLakilaki =  findViewById(R.id.eTAnakLakilaki);
            EditText eTAnakPerempuan =  findViewById(R.id.eTAnakPerempuan);

            EditText eTSuami =  findViewById(R.id.eTSuami);
            EditText eTIstri =  findViewById(R.id.eTIstri);

            EditText eTAyah =  findViewById(R.id.eTAyah);
            EditText eTIbu =  findViewById(R.id.eTIbu);

            EditText eTKakek =  findViewById(R.id.eTKakek);
            EditText eTNenek =  findViewById(R.id.eTNenek);

            EditText eTSaudaraKandung =  findViewById(R.id.eTSaudaraKandung);
            EditText eTSaudariKandung =  findViewById(R.id.eTSaudariKandung);

            //default jika data ahli waris tidak diisi
            //awal state
            String sAnakLakilaki = eTAnakLakilaki.getText().toString();
            if (sAnakLakilaki.equals("")) {
                sAnakLakilaki = "0";
            }

            String sAnakPerempuan = eTAnakPerempuan.getText().toString();
            if (sAnakPerempuan.equals("")) {
                sAnakPerempuan = "0";
            }

            String sSuami = eTSuami.getText().toString();
            if (sSuami.equals("")) {
                sSuami = "0";
            }

            String sIstri = eTIstri.getText().toString();
            if (sIstri.equals("")) {
                sIstri = "0";
            }

            String sAyah = eTAyah.getText().toString();
            if (sAyah.equals("")) {
                sAyah = "0";
            }

            String sIbu = eTIbu.getText().toString();
            if (sIbu.equals("")) {
                sIbu = "0";
            }

            String sKakek = eTKakek.getText().toString();
            if (sKakek.equals("")) {
                sKakek = "0";
            }

            String sNenek = eTNenek.getText().toString();
            if (sNenek.equals("")) {
                sNenek = "0";
            }

            String sSaudaraKandung = eTSaudaraKandung.getText().toString();
            if (sSaudaraKandung.equals("")) {
                sSaudaraKandung = "0";
            }

            String sSaudariKandung = eTSaudariKandung.getText().toString();
            if (sSaudariKandung.equals("")) {
                sSaudariKandung = "0";
            }
            //akhir state

            //mengirim data ke kelas hasil (mempersiapkan)
            i.putExtra("AnakLakilaki", sAnakLakilaki);
            i.putExtra("AnakPerempuan", sAnakPerempuan);

            i.putExtra("Suami", sSuami);
            i.putExtra("Istri", sIstri);

            i.putExtra("Ayah", sAyah);
            i.putExtra("Ibu", sIbu);

            i.putExtra("Kakek", sKakek);
            i.putExtra("Nenek", sNenek);

            i.putExtra("SaudaraKandung", sSaudaraKandung);
            i.putExtra("SaudariKandung", sSaudariKandung);

            i.putExtra("nama", nama);
            i.putExtra("jk", jk);
            i.putExtra("harta", harta);
            i.putExtra("utang", utang);
            i.putExtra("urus", urus);
            i.putExtra("wasiat", wasiat);

            startActivity(i);
            finish();

        });

        ImageButton btnback = findViewById(R.id.back);
        btnback.setOnClickListener(v -> finish());
    }
}