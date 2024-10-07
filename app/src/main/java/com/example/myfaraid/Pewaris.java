package com.example.myfaraid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Pewaris extends AppCompatActivity {
    EditText nama, jumlahHarta, jumlahUtang, jumlahUrus, jumlahWasiat;
    int harta, utang, urus, wasiat;
    String jk;
    RadioGroup jenisKelamin;
    RadioButton perempuan, laki;
    protected Cursor cursor;
    DataSql dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pewaris);
        nama = findViewById(R.id.eTNama);
        jenisKelamin =  findViewById(R.id.jkGroup);
        perempuan =  findViewById(R.id.rbPerempuan);
        laki =  findViewById(R.id.rbLakiLaki);

        jumlahHarta =  findViewById(R.id.eTJumlahHarta);
        jumlahUtang =  findViewById(R.id.eTJumlahHutang);
        jumlahUrus =  findViewById(R.id.eTJumlahPengurusuanJenazah);
        jumlahWasiat =  findViewById(R.id.eTJumlahWasiat);
        Button selesai =  findViewById(R.id.selesaiHitung);

        selesai.setOnClickListener(v -> {

            //convert nama ke string
            String sNama = nama.getText().toString();

            //memilih jenis kelamin pewaris
            if (laki.isChecked()) {
                jk = "Laki-laki";
            }
            else if (perempuan.isChecked()) {
                jk = "Perempuan";
            }

            //default jika harta tidak diisi
            if (nama.getText().toString().equals("") || jumlahHarta.getText().toString().equals("")) {
                nama.setHint("Wajib diisi !");
                jumlahHarta.setHint("Wajib diisi !");
                nama.setText("");
                jumlahHarta.setText("");
                nama.setHintTextColor(Color.RED);
                jumlahHarta.setHintTextColor(Color.RED);
            }
            //jika harta diisi
            else {
                String sHarta = jumlahHarta.getText().toString();
                if (sHarta.equals("")) {
                    sHarta = "0";
                }

                String sUtang = jumlahUtang.getText().toString();
                if (sUtang.equals("")) {
                    sUtang = "0";
                }

                String sUrus = jumlahUrus.getText().toString();
                if (sUrus.equals("")) {
                    sUrus= "0";
                }

                String sWasiat = jumlahWasiat.getText().toString();
                if (sWasiat.equals("")) {
                    sWasiat = "0";
                }

                //merubah nilai menjadi integer (parsing)
                harta = Integer.parseInt(sHarta);
                utang = Integer.parseInt(sUtang);
                urus = Integer.parseInt(sUrus);
                wasiat = Integer.parseInt(sWasiat);

                if ((wasiat < (harta / 3)) && (harta<=2000000000)) {
                    Intent i = new Intent(Pewaris.this, AhliWaris.class);

                    //mengirim data ke kelas ahli waris (mempersiapkan)
                    i.putExtra("terima0", (sNama));
                    i.putExtra("terima1", jk);
                    i.putExtra("terima2", (sHarta));
                    i.putExtra("terima3", (sUtang));
                    i.putExtra("terima4", (sUrus));
                    i.putExtra("terima5", (sWasiat));

                    startActivity(i);
                    finish();
                }
                else if (wasiat > (harta / 3)) {
                    jumlahWasiat.setHintTextColor(Color.RED);
                    jumlahWasiat.setHint("Wasiat lebih besar dari 1/3 harta");

                }
                else if (harta > 2000000000) {
                    jumlahHarta.setHintTextColor(Color.RED);
                    jumlahHarta.setHint("Harta lebih dari 10 digit");

                }
            }

        });

        ImageButton btnback =  findViewById(R.id.back);
        btnback.setOnClickListener(v -> finish());


    }
}